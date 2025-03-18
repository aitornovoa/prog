"""
Escribe un script que reciba un enteiro (n) maior ou igual a 1 e ofreza o resultado da seguinte suma: 1 + 1/2 + 1/3 + … 1/n

Utiliza o tipo de datos float para calcular o resultado da suma
"""
__author__="Aitor Novoa Alonso"

n = 0

while n<1:
    n = int(input("Introduce el numero entero: "))

suma = 0.0
i=1
    
while i<=n:
    suma = suma + 1.0/i
    i += 1

print(f"La suma de la serie es {suma:.2f}")
