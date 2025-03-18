"""
Crea nun script unha función recursiva: anagrama(palabra1: str, palabra2: str) -> boolean que indique se unha das palabras é ou non un anagrama 
da outra, é dicir, que se pode obter a partir das letras da outra sen máis que reordenalas.

Considerarase que as palabras están escritas en minúsculas, sen til nin outros signos diacríticos e sen espazos en branco ou outros caracteres 
distintos dos alfabéticos da “A” á “Z”.

Se as dúas palabras son iguais tamén se considera que son anagrama.

Nese mesmo script proba a función obtendo unha palabra por teclado e mostra por pantalla Anagrama se é un anagrama e Non anagrama en caso contrario.
"""

__author__ = "Aitor Novoa Alonso"


def anagrama(palabra1, palabra2):
    """
    Función recursiva para comprobar si una palabra es anagrama de otra.

    Args:
        palabra1 (str): Primera palabra
        palabra2 (str): Segunda palabra

    Returns:
        bool: True si son anagramas, False si no lo son.
    """
    if not palabra1 and not palabra2:
        return True
    
    if len(palabra1)!=len(palabra2):
        return False
    
    if palabra1[0] in palabra2:
        indice = palabra2.index(palabra1[0])
        palabra2_nueva = palabra2[:indice] + palabra2[indice+1:]
        return anagrama(palabra1[1:], palabra2_nueva)
    else:
        return False
    
palabra1 = input("Introduce la primera palabra: ").lower()
palabra2 = input("Introduce la segunda palabra: ").lower()

if anagrama(palabra1, palabra2):
    print("Anagrama")
else:
    print("No anagrama")
