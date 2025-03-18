"""
Escribe unha función raiz_cadrada(numero: float/int) -> float nun script que calcule a raíz cadrada dun número. 
Se o parámetro non é un número ou é negativo, lanza unha excepción chamada ValueError. 
O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creada anteriormente. 
Captura a excepción que lanza a función
"""
__author__="Aitor Novoa Alonso"

def raiz_cuadrada(numero):
    """
    Esta función calcula la raiz cuadrada de un numero
    Args:
        numero (int/float): el numero del cual se va a calcular la raiz cuadrada
    Returns:
        float:  el resultado de la raíz cuadrada
    Raises:
        ValuerError: si el parámetro numero no es un número o no es positivo
    """
    if not(type(numero) is int or type(numero) is float):
        raise ValueError("El parámetro debe ser un número")
    if numero < 0:
        raise ValueError("El parametro debe ser positivo")
    return numero ** (1/2)

try:
    numero = float(input("Introduce un número: "))
    resultado = raiz_cuadrada(numero)
    print(f"La raíz cuadrada de {numero} es {resultado}")
except ValueError as e:
    print(f"Error: {e}")

