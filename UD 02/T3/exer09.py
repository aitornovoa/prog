"""
Escribe un script que permita obter o factorial dun número enteiro positivo introducido por teclado
"""
__author__="Aitor Novoa Alonso"

numero = int(input("Introduce un numero: "))

while numero<=0:
    print("El numero deber ser positivo")
    numero = int(input("Introduce un numero: "))

factorial = 1
i = 1

while i<=numero:
    factorial *= i
    i += 1
    
print(f"El factorial de {numero} es {factorial}")