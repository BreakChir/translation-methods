grammar Code;
//TODO перед else убрать ;
@header {
    package ru.breakchir;
}

start returns [String v]
    :   set_expr[""] { $v = "begin\n" + $set_expr.v + "end."; }
    ;

set_expr [String space] returns [String v]
    :   expr[space + "  ", 0] { $v = $expr.v; }
        ( expr[space + "  ", 0]  { $v += $expr.v; }
        )*
    ;

expr [String space, int els] returns [String v]
    :   BEGIN set_expr[els == 1 ? space + "  " : space]
                { $v = els == 1 ? "\n  " : ""; }
                { $v += space + "begin\n" + $set_expr.v + space + (els == 1 ? "  " : "") + (els == 2 ? "end\n" : "end;\n"); }
    |   PRINT arg
                { $v = els == 1 ? "\n  " : ""; }
                { $v += space + "writeln(" + $arg.v + ")" + (els == 2 ? "\n" : ";\n"); }
    |   ASGN VAR arg
                { $v = els == 1 ? "\n  " : ""; }
                { $v += space + $VAR.text + " = " + $arg.v + (els == 2 ? "\n" : ";\n"); }
    |   IF b1 = bool_cond e1 = expr[space + "  ", 2] e2 = expr[space, 1]
                { $v = els == 1 ? " " : space; }
                { $v += "if " + $b1.v + " then\n" + $e1.v; }
                { $v += space + "else" + $e2.v; }
    |   IF b1 = bool_cond e1 = expr[space + "  ", 0]
                { $v = els == 1 ? " " : space; }
                { $v += "if " + $b1.v + " then\n" + $e1.v; }
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
TRUE   : 'true';
FALSE  : 'false';
PRINT  : 'print';

BEGIN  : 'begin';
END    : 'end';

NUM    : ('-'? ('1'..'9') ('0'..'9')*) | '0';
VAR    : ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;

WS     : [ \t\r\n] -> skip;