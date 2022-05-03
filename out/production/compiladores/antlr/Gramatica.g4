grammar Gramatica;

@header{
    package antlr;
}

inicio: (declaracao)? programa EOF #NInicio;
declaracao: ':DECLARACAO' (decl)* #BlocoDeclaracao;
decl: TIPO ID #NDeclaracao;
programa: ':ALGORITMO' (instr)* #BlocoPrograma;
instr: 'ATRIBUIR' (ID|NUM|STRING|operacao|comparacao) 'A' ID #NAtribuicao;
operacao: operando OPERADOR (operando|operacao) #NOperacao;
comparacao: operando COMPARADOR operando #NComparacao;
operando: ID|NUM #NOperando;


TIPO: ('int'|'float'|'string'|'Bool');
ID:([a-z]|[A-Z])+([a-z]|[A-Z]|[0-9])*;
WS: [ \r\t\n]* ->skip;
NUM: [0-9]+(','[0-9]+)?;
STRING: '"'~["]*'"';
OPERADOR: '+'|'-'|'*'|'/';
COMPARADOR: '>'|'>='|'<'|'<='|'=='|'!=';