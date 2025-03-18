"""
Desenvolva un script para determinar se unha cadea de caracteres (palabra/frase) é palíndromo, é dicir, se se pode ler igual de esquerda a 
dereita que de dereita a esquerda. Un exemplo de palíndromo é a palabra “radar”.

Desenvolva a seguinte función recursiva:

Función palindromo: cos parámetros de entrada que considere preciso para resolver de forma recursiva se unha palabra/frase é palíndromo. 
O valor de retorno será True ou False en función do caso. (Exemplo:“radar” é palíndromo, polo tanto, a función devolverá True).
Nese mesmo script proba a función obtendo unha palabra ou frase por teclado e mostra por pantalla Palídromo se é un palñindromo e
Non palíndromo en caso contrario.
"""

__author__ = "Aitor Novoa Alonso"


def palindromo(texto):
    """
    Función recursiva para comprobar se unha cadea de caracteres é un palíndromo.

    Args:
        texto (str): El texto que se comprueba

    Returns:
        bool: True si la cadena es un palíndromo, False si no lo es.
    """
    nuevo_texto=""
    
    for letra in texto:
        if letra != " ":
            nuevo_texto += letra
    nuevo_texto=nuevo_texto.lower()

    if len(nuevo_texto) <= 1: 
        return True

    if nuevo_texto[0] != nuevo_texto[-1]: 
        return False

    return palindromo(nuevo_texto[1:-1])


cadea_usuario = input("Introduce el texto: ")

if palindromo(cadea_usuario):
    print("Palíndromo")
else:
    print("No palíndromo")
