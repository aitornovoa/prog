"""
Escribe unha función en Python eliminar_duplicados(lista: List) -> List que reciba unha lista con elementos duplicados 
e devolva unha nova lista sen duplicados, mantendo a orde orixinal.
"""

__author__ = "Aitor Novoa Alonso"

def eliminar_duplicados(lista):
    nueva_lista = []
    for elemento in lista:
        if elemento not in nueva_lista:
            nueva_lista.append(elemento)
    return nueva_lista

print(eliminar_duplicados([1,2,3,4,5,6,7,8,9,10,12,12,'casa','casa']))