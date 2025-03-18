"""
Escribe un script que calcule a suma dos N primeiros números.
O valor de N e introducido por teclado. Mostra o resultado por pantalla.
"""
__author__="Aitor Novoa Alonso"

n = int(input("Introduce el valor de n: "))

i=0
suma=0
while(i<n):
    i+=1
    suma+=i
    
print(suma)