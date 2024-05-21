grammar Turtle;

command
    : forward
    | backward
    | left
    | right
    | penUp
    | penDown
    | color
    | resetTurtle
    | clear
    | repeat
    ;

block
    : (commands+=command)*
    ;

forward
    : 'forward' distance=NUMBER nl
    ;

backward
    : 'backward' distance=NUMBER nl
    ;

left
    : 'left' angle=NUMBER nl
    ;

right
    : 'right' angle=NUMBER nl
    ;

penUp
    : 'pen' 'up' nl
    ;

penDown
    : 'pen' 'down' nl
    ;

color
    : 'color' colorName=COLOR_NAME nl
    | 'color' colorHex=COLOR_HEX nl
    ;

resetTurtle
    : 'reset' nl
    ;

clear
    : 'clear' nl
    ;

repeat
    : 'repeat' count=NUMBER '{' nl? block '}' nl
    ;

nl
    : EOF
    | NL
    | ';'
    ;

NUMBER
    : '-'? [0-9]+ ('.' [0-9]*)?
    | '-'? [0-9]* '.' [0-9]+
    ;

COLOR_NAME
    : 'black' | 'red' | 'green' | 'blue' | 'yellow' | 'magenta' | 'cyan' | 'white'
    ;

COLOR_HEX
    : '#' [0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]
    ;

NL
    : '\n'
    ;

WS
    : [ \t]+ -> skip
    ;