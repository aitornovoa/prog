"""
Escribe un script que imprima os números pares (un en cada liña) ata un numero introducido polo usuario, este número incluído.
"""
__author__="Aitor Novoa Alonso"

n = int(input("Introduce el valor maximo: "))

i=0
while i<=n:
    if i%2==0:
        print(i)
    i+=1
    