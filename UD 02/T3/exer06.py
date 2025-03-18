"""
 Escribe un script que reciba por teclado un número enteiro positivo N. O programa mostrará por pantalla nesta orde:
 
O número de pares entre 1 e N incluídos.
O número de impares entre 1 e N incluídos.
A suma total de todos os números entre 1 e N incluídos.
A media só dos números pares entre 1 e N incluídos.
"""
__author__="Aitor Novoa Alonso"

n = int(input("Introduce el valor de N: "))
i=1
numeros_pares = 0
numeros_impares = 0
suma_pares = 0

if n<0:
    print("El numero N no es positivo.")
else:
    while i<=n:
        if i%2==0:
            numeros_pares+=1
            suma_pares += i
        else:
            numeros_impares+=1
        i+=1    
        
    
    print(f"El numero de pares entre 1 y {n} son {numeros_pares}")
    print(f"El numero de impares entre 1 y {n} son {numeros_impares}")
    