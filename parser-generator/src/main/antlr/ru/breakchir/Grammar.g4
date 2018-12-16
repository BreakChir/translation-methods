grammar Grammar;

@header {
    package ru.breakchir;
}

start returns [ParsedGrammar v]
        : NTERM              { $v = new ParsedGrammar($NTERM.text); }
          (choose_roole[$v] ';')+
        ;

choose_roole[ParsedGrammar gr]
        : TERM '=' STRING    { $gr.addTermRule(new TermRule(false, $TERM.text, $STRING.text)); }
        | TERM ':' STRING    { $gr.addTermRule(new TermRule(true, $TERM.text, $STRING.text)); }
        | 'WS' '->' STRING   { $gr.addWS($STRING.text); }
        | prule              { $gr.addNTermRule($prule.v); }
        ;

prule returns [NTermRule v]
        : NTERM args? rets? '=' { $v = new NTermRule($NTERM.text, $args.v, $rets.v); }
          pattern               { $v.addRule($pattern.v); }
          ('|' pattern          { $v.addRule($pattern.v); })*
        ;

args returns [List<Argument> v]
        : '(' arg           { $v = new ArrayList(); }
                            { $v.add($arg.v); }
          (',' arg          { $v.add($arg.v); })*
          ')'
        |                   { $v = null; }
        ;

rets returns [List<Argument> v]
        : '[returns' arg    { $v = new ArrayList(); }
                            { $v.add($arg.v); }
          (',' arg          { $v.add($arg.v); })*
          ']'
        |                   { $v = null; }
        ;

arg returns [Argument v]
        : NTERM ':' type    { $v = new Argument($type.v, $NTERM.text); }
        ;

type returns [String v]
        : NTERM { $v = $NTERM.text; }
        | TERM  { $v = $TERM.text; }
        ;

pattern returns [List<Production> v]
        :               { $v = new ArrayList<>(); }
        (partpat        { $v.add($partpat.v); })+
        ;

partpat returns [Production v]
        : TERM          { $v = new Term($TERM.text); }
        | NTERM         { NTerm t = new NTerm($NTERM.text); }
          ('(' param    { t.addParameter($param.v); }
          (',' param    { t.addParameter($param.v); })*
          ')')?         { $v = t; }
        | CODE          { $v = new Code($CODE.text); }
        ;

param returns [String v]
        : NTERM { $v = $NTERM.text; }
        | TERM  { $v = $TERM.text; }
        | CODE  { $v = $CODE.text.substring(1, $CODE.text.length() - 1); }
        ;

TERM   : [A-Z][a-zA-Z0-9_]*;
NTERM  : [a-z][a-zA-Z0-9_]*;

STRING : '"' (~('"'))* '"';
CODE   : '{' (~[{}]+ CODE?)* '}';

WS     : [ \t\r\n] -> skip ;