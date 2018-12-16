# Выражения в префиксной записи

Трансляция выражения из префиксной записи в язык высокого уровня.  
На входе — выражение в префиксной записи, должны  
поддерживаться арифметические и логические операции, операции  
сравнения чисел, ветвление, присваивание, вывод.  
На выходе программа на императивном языке высокого уровня.  

Пример: 
>       if > 2 3 print 3 if > 4 - 7 2 print + 3 4` 

Вывод: 
>       begin  
>         if (2 > 3) then  
>           writeln(3)  
>         else if (4 > (7 - 2)) then  
>           writeln(3 + 4);  
>       end.  

## Tokens 

String | Token | String | Token | String | Token
--- | --- | --- | --- | --- | ---
*+*  | ***ADD***  | <  | ***LT***   | *if* | ***IF***
*-*  | ***SUB***  |*>* | ***GT***   | *true* | ***TRUE***
\*  | ***MUL***  | <= | ***LTEQ*** | *false* | ***FALSE***
/  | ***DIV***  | >= | ***GTEQ*** | *print* | ***PRINT***
%  | ***MOD***  | == | ***EQ***   | *begin* | ***BEGIN***
** | ***POW***  | != | ***NQ***   | *end* | ***END***
&& | ***AND***  | !  | ***NOT***  | *=* | ***ASGN***
&#124;&#124; | ***OR*** | ^ | ***XOR*** | *[ \t\r\n]* | ***WS***

String | Token
--- | ---
*('-'? ('1'..'9') ('0'..'9')**) &#124; *'0'* | ***NUM***
*('a'..'z' &#124; 'A'..'Z') ('a'..'z' &#124; 'A'..'Z' &#124; '0'..'9' &#124; '_')** | ***VAR***

## Описание правил:

Правило | Описание
--- | ---
**start**    | старт парсера
**set_expr** | множество выражений  
**expr**     | Операция ветвления, присваивания, вывода или begin
**arg**      | аргумент операций присваивания или вывода
**bool_cond**| выражение типа boolean
**bool_cmp** | логическая операция
**int_cmp**  | операция сравнения чисел
**num**      | арифметическое выражение с переменными
**int_op**   | арифметическая операция  

## Грамматика
>     start     = set_exrp
>
>     set_expr  = expr (expr)*
>
>     expr      = BEGIN set_expr
>                 | PRINT arg
>                 | ASGN VAR arg
>                 | IF bool_cond expr exprElse
>
>     exprElse  = expr
>                 |
>
>     arg       = bool_cond | num | VAR
>
>     bool_cond = bool_cmp bool_cond bool_cond
>                 | NOT bool_cond
>                 | TRUE
>                 | FALSE
>                 | VAR
>                 | int_cmp num num
>
>     bool_cmp  = AND | XOR | OR
>
>     int_cmp   = LT | GT | LTEQ | GTEQ | EQ | NQ
>
>     num       = int_op num num | NUM | VAR
>
>     int_op    = ADD | SUB | MUL | DIV | MOD | POW 
