"""
Escribe un script que informe se un número introducido por teclado é par ou impar. 
Imprimirá por pantalla Par ou Impar segundo corresponda.
"""
__author__="Aitor Novoa Alonso"

numero = float(input("Introduce un numero: "))

print("Par") if numero%2==0 else print("Impar")