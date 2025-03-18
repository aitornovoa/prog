"""
Escribe unha función recursiva `suma_dixitos(n)` en Python que calcule a suma dos díxitos dun número enteiro positivo. 
Crea nun *script* unha función recursiva `suma_dixitos(n: int) -> int` en Python que calcule a suma dos díxitos dun número enteiro positivo. 
A suma de díxitos é o resultado de sumar todos os díxitos individuais dun número. Por exemplo, para o número `1234`, a suma dos díxitos é `1 + 2 + 3 + 4 = 10`.

- A función debe incluír unha condición base para o caso cando `n` é menor que 10 e polo tanto ten só un díxito.
- A función debe chamarse a si mesma para sumar o último díxito e a suma dos díxitos restantes do número.

Nese mesmo *script* proba a función obtendo por teclado un número e mostra por pantalla o resultado.
"""

__author__ = "Aitor Novoa Alonso"


def suma_dixitos(n):
    """
    Funcion recursiva que suma os dixitos dun número

    Args:
        n (int): o numero do que queremos sumar os dixitos

    Returns:
        int: a suma dos díxitos
    """

    # Caso base: o número e menor que 10 e polo tanto só ten un díxito
    if n < 10:
        return n
    else:
        # Pasamos o numero a cadea de texto
        n_str = str(n)
        # Collemos o último díxito
        ultimo_dixito = int(n_str[-1])
        # Collemos o resto de díxitos
        resto_dixitos = int(n_str[:-1])
        # realizamos a suma
        return suma_dixitos(resto_dixitos) + ultimo_dixito
    
print(suma_dixitos(12345))