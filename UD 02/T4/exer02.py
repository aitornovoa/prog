"""
Implantar unha aplicación que calcule o menor de tres números introducidos por teclado polo usuario e o mostre por pantalla. 
Comproba antes de nada que ningún par de números é igual. Se isto é así, indícallo mostra por pantalla Erro e non calcules cal é o menor dos 3. 
Define dúas e utiliza estas dúas funcións:

comprobar_valores_iguais(numero1: int, numero2: int, numero3: int) -> boolean: indica se algún dos números é igual.
calcular_menor_numero(numero1: int, numero2: int, numero3: int) -> int: indica cal é o menor dos números.

"""
__author__="Aitor Novoa Alonso"

def valores_iguales(numero1, numero2, numero3):
    """
        Esta función comprueba si dos números son iguales. 
        Args:
            numero1 (int): Primer número a comparar.
            numero2 (int): Segundo número a comparar.
            numero3 (int): Tercer número a comparar.
        Returns:
            bool: True si algún par de números es igual, False en caso contrario.
    """
    if numero1 == numero2 or numero2 == numero3 or numero1 == numero3:
        return True
    return False
    

def calcular_menor_numero(numero1, numero2, numero3):
    """
        Esta función comprueba cuál es el número pequeño. 
        Args:
            numero1 (int): Primer número a comparar.
            numero2 (int): Segundo número a comparar.
            numero3 (int): Tercer número a comparar.
        Returns:
            int: El número pequeño.
    """
    if numero1 < numero2 and numero1 < numero3:
        return numero1
    elif numero2 < numero1 and numero2 < numero3:
        return numero2
    else:  
        return numero3
    

numero1 = int(input("Introduce el primer número:"))
numero2 = int(input("Introduce el segundo número:"))
numero3 = int(input("Introduce el tercer número:"))

son_iguales = valores_iguales(numero1, numero2, numero3)

if son_iguales:
    print("Error")
else:
    menor = calcular_menor_numero(numero1, numero2, numero3)
    print(f"El número más pequeño es {menor}")