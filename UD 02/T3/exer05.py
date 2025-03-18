"""
Escribe un script que imprima os números pares comprendidos nun intervalo (a,b), un en cada liña. 
Os valores a e b serán introducidos por teclado polo usuario. 
Unha vez introducido o intervalo, verificar se a é menor que b. Senón é así, invertede os valores. Se os números son iguais imprime Erro
"""
__author__="Aitor Novoa Alonso"

a = int(input("Introduce el valor de a: "))
b = int(input("Introduce el valor de b: "))

if a < b:
    menor=a
    mayor=b
elif b < a:
    menor=b
    mayor=a
else: 
    print("Error")
    
if menor%2!=0:
    menor+=1

while menor<mayor:
    print(menor)
    menor+=2
    
    