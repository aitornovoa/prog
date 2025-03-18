"""
Escribe unha función nun script que informe se un número é par ou impar. Esta algoritmo debe ir dentro dunha función definida como:

comprobar_par(numero: int) -> boolean
En dito script, utiliza dita función para comprobar se un número que introduce un usuario é par ou impar. Se é par, imprime Par e senón Impar. 
"""
__author__="Aitor Novoa Alonso"

def comprobar_par(numero):
    """
        Esta función comprueba si un número es par o impar. 
        Args:
            numero (int): El número a comprobar.
        Returns:
            bool: True si el número es par, False si es impar.
    """
    if numero % 2 == 0:
        return True
    else:
        return False
    
numero = int(input("Introduce un número: "))

esPar = comprobar_par(numero)
if esPar:
    print("Par")
else:
    print("Impar")