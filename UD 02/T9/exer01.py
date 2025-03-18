"""
Crea nun *script* unha función recursiva `decimal_to_binario(numero: int) -> str` que obteña o número binario dun número N decimal. 
Axuda: https://ed.team/blog/sistemas-binarios-y-decimales. 

Nese mesmo *script* proba a función obtendo por teclado un número e mostra por pantalla o resultado."""

__author__ = "Aitor Novoa Alonso"


def decimal_to_binario(numero):
    """
    Función recursiva que pasa un numero decimal a binario

    Args:
        numero (int): numero decimal

    Returns:
        str: devolve un numero binario

    """

    # Caso base: o número e menor que 2
    if numero < 2:
        # Devolvemos o numero en formato texto
        return str(numero)
    
    # Caso recursivo
    else:
        # Collemos a division de entre 2 enteira
        division = numero // 2
        # Collemos o resto
        resto = numero % 2

        # Facemos a chamada recursiva
        return decimal_to_binario(division) + str(resto)
    
print(decimal_to_binario(10))