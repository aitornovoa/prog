"""
Os números 17, 341 y 62 teñen en común que a suma dos seus díxitos dan o mesmo valor, 8. 
Hai moitos outros números así; de todos eles, o 17 é o máis pequeno.

Implanta un programa que recibirá por teclado un número entre 1 e 1000 e a continuación se mostre o número decimal 
máis pequeno que as súas cifras sumen a mesma cantidade que a suma das cifras do número introducido por teclado.

Por exemplo, se o usuario introduce o número 92, deberase imprimir o número 29.
"""

__author__ = "Aitor Novoa Alonso"


def suma_digitos(numero):
    """
    Función que calcula la suma de los dígitos del número.
    
    Args:
        numero (int): El número cuya suma de digitos se quiere hacer
        
    Returns:
        int: La suma de los dígitos del número.
    """
    suma=0.00
    while numero>0:
        suma+=numero%10
        numero//=10
    return suma

def buscar_numero_equivalente(suma_digitos_resultante):
    """
    Busca el número más pequeño entre 1 e 1000 que tiene la misma suma de dígitos que el número dado.
    
    Args:
        suma_digitos (int): A suma dos díxitos do número introducido.
        
    Returns:
        int: O número máis pequeno cunha suma de díxitos igual á entrada.
    """
    for num in range(1, 1001):
        if suma_digitos(num) == suma_digitos_resultante:
            return float(num)
    return None  


#Asumo que de entrada, tiene que ser un entero, ya que no se espececifica
while True:
    try:
        numero_usuario = input("Introduce un número entre 1 e 1000: ")
        if numero_usuario.isdigit():
            numero_usuario = int(numero_usuario)
            if 1 <= numero_usuario <= 1000:
                break  
            else:
                raise ValueError("Introduce un número entre 1 y 1000")
        else:
            raise ValueError("Introduce un número válido ")
    except ValueError as e:
        print(f"Error: {e}")

suma_usuario = suma_digitos(numero_usuario)

numero_equivalente = buscar_numero_equivalente(suma_usuario)

print(f"El número más pequeño cuya suma de dígitos es la misma que la de {numero_usuario} : {numero_equivalente}")
