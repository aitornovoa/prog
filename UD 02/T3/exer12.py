"""
 Escribe un script que elixirá no seu comezo un número ao azar entre 1 e 25. 
 A continuación o usuario introducirá números por teclado ata que acerte o número seleccionado ao azar. 
 Cada vez que se introduza un número incorrecto, o script proporcionaralle pistas ao usuario: “o número e maior” ou “o número é menor”. 
 Unha vez que o usuario acerte o número, indicaráselle por pantalla se gañou o xogo ou non.
 Para gañar, o usuario deberá acertar o número en menos de 5 intentos. Se o fai en 5 ou máis de 5 perderá.
 Para obter o número ao azar utiliza o seguinte código: 
 import random
 numero_aleatorio = random.randint(1, 5)
 
"""
__author__="Aitor Novoa Alonso"

import random

numero_aleatorio = random.randint(1, 25)

numIntentos = 0
numMaximoIntentos = 5

while True:
    numIntentos+=1
    
    intento = int(input("Introduce el numero a acertar: "))
    
    if intento == numero_aleatorio:
        if intento<numMaximoIntentos:
            print("Has ganado el juego")
            break
        else:
            print("Has acertado, pero superado el límite de intentos")
    elif intento < numero_aleatorio:
        print("El numero es mayor")
    else:
        print("El numero es menor")
    
