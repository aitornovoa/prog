"""
 Escribe unha función en Python contar_lonxitudes(lista: List) -> List que reciba unha 
 lista de palabras e devolva unha lista coa lonxitude de cada palabra.
"""

__author__ = "Aitor Novoa Alonso"

def so_pares(lista):
    nueva_lista = []
    for elemento in lista:
            nueva_lista.append(len(elemento))
    return nueva_lista

print(so_pares(['casa','casa']))