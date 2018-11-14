grammar Code;

@header {
    package ru.breakchir;
}

start returns [Program v]
    :   set_expr { $v = new Program($set_expr.v); }
    ;

set_expr returns [ExpressionList v]
    :   expr    { List<Expression> list = new ArrayList<>(); }
                { list.add($expr.v); }
        (expr   { list.add($expr.v); }
        )*
                { $v = new ExpressionList(list); }
    ;

expr returns [Expression v]
    :   BEGIN set_expr
                { $v = new BeginStatement($set_expr.v); }
    |   PRINT arg
                { $v = new Print($arg.v); }
    |   ASGN VAR arg
                { $v = new Assignment($VAR.text, $arg.v); }
    |   IF b1 = bool_cond e1 = expr e2 = exprElse
                { $v = $e2.v == null ? new StatementIf($b1.v, $e1.v)
                : new StatementIfElse($b1.v, $e1.v, $e2.v); }
    ;

exprElse returns [Expression v]
    : expr  { $v = $expr.v; }
    |       { $v = null; }
    ;

arg returns [Argument v]
    :   bool_cond { $v = $bool_cond.v; }
    |   num       { $v = $num.v; }
    ;

bool_cond returns [BooleanExpression v]
    :   bool_cmp b1 = bool_cond b2 = bool_cond { $v = new TwoBoolExpression($bool_cmp.v, $b1.v, $b2.v); }
    |   NOT bool_cond                          { $v = new Negate($bool_cond.v); }
    |   TRUE                                   { $v = new BoolValue("true"); }
    |   FALSE                                  { $v = new BoolValue("false"); }
    |   VAR                                    { $v = new Variable($VAR.text); }
    |   int_cmp n1 = num n2 = num              { $v = new TwoCmpArExpression($int_cmp.v, $n1.v, $n2.v); }
    ;

num returns [ArithmeticExpression v]
    : int_op m1 = num m2 = num { $v = new TwoArExpression($int_op.v, $m1.v, $m2.v); }
    | NUM                      { $v = new Number($NUM.text); }
    | VAR                      { $v = new Variable($VAR.text); }
    ;

bool_cmp returns [ExprToken v]
    :   AND { $v = ExprToken.AND; }
    |   XOR { $v = ExprToken.XOR; }
    |   OR  { $v = ExprToken.OR;  }
    ;

int_cmp returns [ExprToken v]
    :   LT   { $v = ExprToken.LT;   }
    |   GT   { $v = ExprToken.GT;   }
    |   LTEQ { $v = ExprToken.LTEQ; }
    |   GTEQ { $v = ExprToken.GTEQ; }
    |   EQ   { $v = ExprToken.EQ;   }
    |   NQ   { $v = ExprToken.NQ;   }
    ;

int_op returns [ExprToken v]
    : ADD { $v = ExprToken.ADD; }
    | SUB { $v = ExprToken.SUB; }
    | MUL { $v = ExprToken.MUL; }
    | DIV { $v = ExprToken.DIV; }
    | MOD { $v = ExprToken.MOD; }
    | POW { $v = ExprToken.POW; }
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