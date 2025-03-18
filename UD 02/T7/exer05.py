"""
 Escribe unha función en Python coller_comúns(lista1: List, lista2: List) -> List que reciba dúas listas 
 e devolva unha lista cos elementos comúns.
"""

__author__ = "Aitor Novoa Alonso"

def so_pares(lista1, lista2):
    nueva_lista = []
    for elemento in lista1:
        if elemento in lista2 and elemento not in nueva_lista:
            nueva_lista.append(elemento)
    return nueva_lista

print(so_pares(['casa',1,2], [1,2,3]))