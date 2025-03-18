"""
Crea nun *script* unha función recursiva `potencia(base: int, exponente: int) -> int` en Python que calcule a potencia dun número.
A potencia de un número `base` elevado a `exponente` (`base^exponente`) pódese definir de forma recursiva. 
Por exemplo, para calcular 2^3, multiplicamos 2 por si mesmo 3 veces.

- A función debe incluír condicións base para os casos cando o `exponente` é 0 ou 1.
- A función debe chamarse a si mesma para calcular a potencia cando `exponente` é maior que 1.

Nese mesmo *script* proba a función obtendo por teclado a base e expoñente nesta orde e mostra por pantalla o resultado.
"""

__author__ = "Manuel Ramón Varela López"


def potencia(base, exponente):

    # Condicion base 1: o exponente e 0
    if exponente == 0:
        # Devolvemos o valor 1
        return 1 
    # Condicion base 2: o exponente e 1
    elif exponente == 1:
        # Devolvemos o valor da base
        return base
    else:
        # Multiplicamos a base pola potencia desa base co expoñente menos 1
        return base * potencia(base, exponente-1)