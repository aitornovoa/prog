"""
O algoritmo de ordenación que se describe a continuación permite ordenar unha lista de xeito simple pero ineficiente para listas pequenas. 
Funciona comparando elementos adxacentes na lista e intercambiándoos se están na orde incorrecta (é dicir, se o primeiro elemento é maior que o 
segundo). Este proceso repítese varias veces ata que toda a lista estea ordenada. É dicir, realízanse varias pasadas sobre a lista para ordenala 
ata que non se produza ningún intercambio de posicións.

Escribe unha función en Python ordenar(lista: List) -> List que implante o algoritmo de ordenación descrito anteriormente para unha lista de números 
de menor a maior.

Aquí temos un exemplo:

# Proba con estes datos:
lista = [64, 34, 25, 12, 22, 11, 90]
# saída esperada: [11, 12, 22, 25, 34, 64, 90]
"""

__author__ = "Aitor Novoa Alonso"

def ordenar(lista_numeros):
    """
    Ordena una lista de numeros.

    Args:
        lista_numeros (list): la lista con los números.
    Returns:
        list: la lista ordenada de menor a mayor.
    """
    
    longitud_lista =  len(lista_numeros)
    for i in range(longitud_lista):
        for j in range(0, longitud_lista-i-1):
            if lista_numeros[j] > lista_numeros[j+1] :
                lista_numeros[j], lista_numeros[j+1] = lista_numeros[j+1], lista_numeros[j]
    return lista_numeros

lista = [64, 34, 25, 12, 22, 90, 11]
print(ordenar(lista))