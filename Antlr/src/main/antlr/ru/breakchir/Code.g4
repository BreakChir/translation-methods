grammar Code;

@header {
    package ru.breakchir;
}

start returns [String v]
    :   set_expr[""] { $v = "begin\n" + $set_expr.v + "end."; }
    ;

set_expr [String space] returns [String v]
    :   expr[space + "  ", false] { $v = $expr.v; }
        ( expr[space + "  ", false]  { $v += $expr.v; }
        )*
    ;

expr [String space, boolean isElse] returns [String v]
    :   BEGIN set_expr[isElse ? space + "  " : space]
                { $v = isElse ? "\n  " : ""; }
                { $v += space + "begin\n" + $set_expr.v + space + (isElse ? "  " : "") + "end;\n"; }
    |   PRINT arg
                { $v = isElse ? "\n  " : ""; }
                { $v += space + "writeln(" + $arg.v + ");\n"; }
    |   ASGN VAR arg
                { $v = isElse ? "\n  " : ""; }
                { $v += space + $VAR.text + " = " + $arg.v + ";\n"; }
    |   IF b1 = bool_cond e1 = expr[space + "  ", false]
                { $v = isElse ? " " : space; }
                { $v += "if " + $b1.v + " then\n" + $e1.v; }
        (e2 = expr[space, true]
                { $v += space + "else" + $e2.v; }
        )?
    ;

arg returns [String v]
    :   bool_cond { $v = $bool_cond.v; }
    |   num       { $v = $num.v; }
    |   VAR       { $v = $VAR.text; }
    ;

bool_cond returns [String v]
    :   bool_cmp b1 = bool_cond b2 = bool_cond { $v = "(" + $b1.v + $bool_cmp.v + $b2.v + ")"; }
    |   NOT bool_cond                          { $v = "!" + $bool_cond.v; }
    |   TRUE                                   { $v = "true"; }
    |   FALSE                                  { $v = "false"; }
    |   VAR                                    { $v = $VAR.text; }
    |   int_cmp n1 = num n2 = num              { $v = "(" + $n1.v + $int_cmp.v + $n2.v + ")"; }
    ;

num returns [String v]
    : int_op m1 = num m2 = num { $v = "(" + $m1.v + $int_op.v + $m2.v + ")"; }
    | NUM                      { $v = $NUM.text; }
    | VAR                      { $v = $VAR.text; }
    ;

bool_cmp returns [String v]
    :   AND { $v = " && "; }
    |   XOR { $v = " ^ "; }
    |   OR  { $v = " || "; }
    ;

int_cmp returns [String v]
    :   LT   { $v = " < "; }
    |   GT   { $v = " > "; }
    |   LTEQ { $v = " <= "; }
    |   GTEQ { $v = " >= "; }
    |   EQ   { $v = " == "; }
    |   NQ   { $v = " != "; }
    ;

int_op returns [String v]
    : ADD { $v = " + "; }
    | SUB { $v = " - "; }
    | MUL { $v = " * "; }
    | DIV { $v = " / "; }
    | MOD { $v = " % "; }
    | POW { $v = " ** "; }
    ;

ADD    : '+';
SUB    : '-';
MUL    : '*';
DIV    : '/';
MOD    : '%';
POW    : '**';

AND    : '&&';
OR     : '||';
XOR    : '^';
NOT    : '!';

LT     : '<';
GT     : '>';
LTEQ   : '<=';
GTEQ   : '>=';
EQ     : '==';
NQ     : '!=';

ASGN   : '=';

IF     : 'if';
ELSE   : 'else';
TRUE   : 'true';
FALSE  : 'false';
PRINT  : 'print';

OPEN   : '(';
CLOSE  : ')';
BEGIN  : 'begin';
END    : 'end';

NUM    : '-'? ('1'..'9') ('0'..'9')* | '0';
VAR    : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*;

WS     : [ \t\r\n] -> skip;