"""
 A busca binaria é un algoritmo eficiente para atopar un elemento nunha lista ordenada. 
 En vez de buscar elemento por elemento de forma secuencial (como fai a busca lineal), a busca binaria reduce a metade o espazo de busca en cada paso. 
 Funciona comparando o elemento obxectivo co elemento central da lista:

Se o elemento central é o obxectivo, xa se atopou e o proceso remata.
Se o obxectivo é menor que o elemento central, a busca continúa na metade esquerda da lista.
Se o obxectivo é maior que o elemento central, a busca continúa na metade dereita da lista.
Este proceso repítese de forma de xeito iterativo ata atopar o elemento ou ata que non quede máis lista que buscar (nese caso, o obxectivo 
non está presente).

Escribe unha función en Python buscar(lista: List, obxectivo) que implante o algoritmo de busca binaria que devolva o índice do obxectivo 
ou None en caso de non se atopar o valor obxectivo.

# Proba con estes datos:
lista_ordenada = [1, 3, 5, 7, 9, 11, 13, 15]
obxectivo = 7
# saída esperada: 3 (o índice de 7 na lista é 3)

obxectivo = 4
# saída esperada: None (4 non está na lista)
"""

__author__ = "Aitor Novoa Alonso"

def buscar(lista, objetivo):
    inicio = 0
    fin = len(lista) - 1
  
    while inicio <= fin:
        medio = (inicio + fin) // 2
      
        if lista[medio]==objetivo:
            return medio
        elif lista[medio] < objetivo:
            inicio = medio + 1
        else:
            inicio = medio - 1
    
    return None

print(buscar([1, 3, 5, 7, 9, 11, 13, 15], 15))