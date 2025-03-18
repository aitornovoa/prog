"""
Escribe un script que pida ao usuario dous números por teclado. 
Se a suma é maior que 10 mostrase por pantalla A suma é maior que 10 e en caso contrario A suma non é maior que 10
"""
__author__="Aitor Novoa Alonso"

num1 = float(input("Introduce el primer numero: "))
num2 = float(input("Introduce el segundo numero: "))

suma=num1+num2

print("La suma es mayor que 10") if suma>10 else print("La suma no es mayor que 10")