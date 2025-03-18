import random

"""
Vaise realizar un sorteo no que pode haber un número diferente de gañadores a partir dunhas rifas numeradas entre 0001 e 9999. 
Escribe un script que reciba por teclado o número de premios dispoñibles e imprima os números premiados co formato de 4 díxitos.

Para obter un número número ao azar utiliza o seguinte código:

import random

...

numero_aleatorio = random.randint(1, 9999)
"""

__author__ = "Aitor Novoa Alonso"


lista_premios = []

num_premios = int(input("Introduce el número de premios: "))

while(len(lista_premios)<num_premios):
    numero_aleatorio = random.randint(1, 9999)
    if numero_aleatorio not in lista_premios:
        lista_premios.append(numero_aleatorio)
        
print("Numeros premiados: ")
for premio in lista_premios:
    print(f"{premio:04}")