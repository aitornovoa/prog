"""
Escribe unha función en Python so_pares(lista: List) -> List que reciba unha lista de números e devolva unha nova lista que conteña só os 
números pares da lista orixinal.
"""

__author__ = "Aitor Novoa Alonso"

def so_pares(lista):
    nueva_lista = []
    for numero in lista:
        if numero % 2 == 0:
            nueva_lista.append(numero)
    return nueva_lista

print(so_pares([1,2,3,4,5,6,7,8,9,10,12,12]))