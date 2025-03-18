"""
Escribe un *script* que elimine todas as consoantes dunha cadea de texto introducida por teclado e devolva unha nova cadea só coas vocais 
e outros caracteres. Mostra este texto por pantalla.
"""

__author__ = "Aitor Novoa Alonso"

texto = input("Introduce unha palabra: ")

nova_palabra = "" # A nova palabra son co vogais

# Recorremos as letras do texto
for letra in texto:
    # Collemos o código ASCII
    codigo = ord(letra)
    # Estas son as letras minusculas
    if codigo >= 65 and codigo <= 90:
        # Se e unha vogal maiuscula metemola na nova palabra
        if letra in "AEIOU":
            nova_palabra += letra
    # Estas son as letras maiúsculas
    elif codigo >= 97 and codigo <= 122:
        # Se e unha vogal minuscula metemola na nova palabra
        if letra in "aeiuo":
            nova_palabra += letra
    # Calquera outro caracter vai na nova palabras
    else:
        nova_palabra += letra

print(nova_palabra)