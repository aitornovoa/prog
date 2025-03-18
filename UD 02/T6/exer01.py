"""
Escribe un *script* que en Python que conte o número de vogais nunha cadea de texto introducida por teclado. 
Por último imprimirá por pantalla o número de vogais. Recorda contar tanto as maiúsculas como as minúsculas.

"""

__author__ = "Aitor Novoa Alonso"

texto = input("Introduce un texto: ").lower()

vocales = 0 

# Recorremos as letras do texto
for letra in texto:
    if letra == 'a':
        vocales += 1
    elif letra == 'e':
        vocales += 1
    elif letra == 'i':
        vocales += 1
    elif letra == 'o':
        vocales += 1
    elif letra == 'u':
        vocales += 1

print(vocales)