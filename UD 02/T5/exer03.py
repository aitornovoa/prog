"""
Escribe unha función celsius_to_farenheit(celsius: float/int) -> float nun script que converta unha temperatura de graos Celsius a Farenheit. 
Se o parámetro que se lle pasa a función non é un número ou non é un número positivo, debe lanzar unha excepción ValueError
"""
__author__="Aitor Novoa Alonso"

def celsius_to_farenheit(celsius):
    """
    Esta función convierte una temperatura de grados Celsius a Farenheit
    Args:
        celsius (float):  los grados Celsius que se van a transforma, un número no entero
    Returns:
        float:  los grados Farenheit equivalentes a los grados Celsius
    Raises:
        ValuerError: si el parámetro Celsius no es un número o no es positivo
    """
    if not(type(celsius)) is int or type(celsius) is float:
        raise ValueError("La temperatura debe ser un número")
    if celsius < 0:
        raise ValueError("La temperatura no puede ser negativa")
    return (celsius*(9/5)+32)

print(celsius_to_farenheit(0))
print(celsius_to_farenheit(5))