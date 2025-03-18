"""
 Crea un script que pida as notas dun exame dos alumnos dunha clase para procesalos. T
 ódalas notas téñense que ir almacenando nunha lista. 
 Mostra un menú que se mostre continuamente ata que o usuario seleccione a opción saír. As entradas do menú son:

a) Engadir nota
b) Ver media
c) Ver número de aprobados
d) Ver máxima nota
e) Eliminar nota Primeiro debes de mostrar un menú onde mostres para cada índice da lista, a súa nota. O usuario indicará o índice da nota a eliminar.
f) Saír
Para poder realizar cada acción do menú, implanta as seguintes funcións:

engadir_nota(lista: list[float], nota: float).

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
Se a nota é un valor inválido, lanza a excepción ValueError.
mostrar_notas(lista: list[float])

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
Débese mostrar neste formato: índice: nota. Exemplo:
0 : nota1
1 : nota2
...
media_notas(lista: list[float]) -> float

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
numero_aprobados(lista list[float]) -> int

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
maxima_nota(lista: list[float]) -> float

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
eliminar_nota(lista: list[float], indice: int)

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
Se o índice non é válido lanza excepción ValueError.
IMPORTANTE: Non utilices para realizar estas funcións as funcións do sistema max, min, etc. realiza este cálculo iterando sobre a lista.
"""

__author__ = "Aitor Novoa Alonso"

def engadir_nota(lista_notas, notas):
    """
        Añade una nota a la lista de notas

        Args:
            lista_notas (list[float]): la lista donde se guardan las notas, que serán decimales
            notas (float): la nota que se mete
        Raises:
            ValueError: si lista_notas no es una lista o notas no es válida
    """
    if not type(lista_notas) is list:
        raise ValueError("La lista de notas debe ser una lista")
    if not type(notas) is float or not (0<=notas<=10):
        raise ValueError("La nota debe ser una nota válida.")
    lista_notas.append(notas)

def mostrar_notas(lista_notas):
    """
        Muestra las notas de la lista

        Args:
            lista_notas (list[float]): la lista donde se guardan las nota
        Raises:
            ValueError: si lista_notas no es una lista o está vacía
    """
    if not type(lista_notas) is list or not lista_notas:
        raise ValueError("La lista de notas debe ser una lista o estar llena")
    for nota in lista_notas:
        print(nota, end=", ")
        
def media_notas(lista_notas):
    """
        Muestra las notas de la lista

        Args:
            lista_notas (list[float]): la lista donde se guardan las nota
        Returns:
            float: La media de las notas (0 si la lista está vacía)
        Raises:
            ValueError: si lista_notas no es una lista o notas no es válida
    """
    if not type(lista_notas) is list:
        raise ValueError("La lista de notas debe ser una lista")
    suma_notas = 0
    if not lista_notas:
        return 0.0
    for nota in lista_notas:
        suma_notas += nota
    return suma_notas/len(lista_notas)    

def numero_aprobados(lista_notas):
    """
        Muestra el número de aprobados

        Args:
            lista_notas (list[float]): la lista donde se guardan las nota
        Returns:
            int: La cantidad de aprobados
        Raises:
            ValueError: si lista_notas no es una lista 
    """
    if not type(lista_notas) is list or not lista_notas:
        raise ValueError("La lista de notas debe ser una lista o estar llena")
    numero_aprobados = 0
    
    for nota in lista_notas:
        if nota >= 5:
            numero_aprobados += 1
    return numero_aprobados

def maxima_nota(lista_notas):
    """
        Muestra la nota máxima

        Args:
            lista_notas (list[float]): la lista donde se guardan las nota
        Returns:
            float: La nota máxima
        Raises:
            ValueError: si lista_notas no es una lista o est vacía
    """
    if not type(lista_notas) is list or not lista_notas:
        raise ValueError("La lista de notas debe ser una lista o estar llena")
    max_nota = lista_notas[0]
    for nota in lista_notas:
        if nota > max_nota:
            max_nota = nota
    return max_nota
    
    
def eliminar_nota(lista_notas, indice):
    """
        Muestra el número de aprobados

        Args:
            lista_notas (list[float]): la lista donde se guardan las nota
            indice (int): el indice que se quiere eliminar de la lista
       
        Raises:
            ValueError: si lista_notas no es una lista o indice no es válida
    """
    if not type(lista_notas) is list or not lista_notas:
        raise ValueError("La lista de notas debe ser una lista o estar llena")
    if not type(indice) is int or not (0<=indice<=len(lista_notas)):
        raise ValueError("El indice debe ser un entero")
    lista_notas.pop(indice)
    

notas = []
#Añadí la opción de ver notas al menú
while True:
    print("\nMenú:")
    print("a) Añadir nota")
    print("b) Ver notas")
    print("c) Ver media")
    print("d) Ver número de aprobados")
    print("e) Ver máxima nota")
    print("f) Eliminar nota")
    print("g) Saír")
    opcion = input("Introduce la opcion: ")
    
    if opcion =="a":
        try:
            nota = float(input("Introduce la nota: "))
            engadir_nota(notas, nota)
        except ValueError as e:
            print(f"Error: {e}")
            
    elif opcion=="b":
        try:
            mostrar_notas(notas)
        except ValueError as e:
            print(f"Error: {e}")
            
    elif opcion=="c":
        try:
            media = media_notas(notas)
            print(f"Media: {media:.2f}")
        except ValueError as e:
            print(f"Error: {e}")
           
    elif opcion=="d":
        try:
            aprobados = numero_aprobados(notas)
            print(f"Número de aprobados: {aprobados}")
        except ValueError as e:
            print(f"Error: {e}")
            
    elif opcion=="e":
        try:
            max_nota = maxima_nota(notas)
            print(f"Máxima nota: {max_nota:.2f}")
        except ValueError as e:
            print(f"Error: {e}")
            
    elif opcion=="f":
        try:
            indice = int(input("Introduce el índice da nota a eliminar: "))
            eliminar_nota(notas, indice)
        except ValueError as e:
            print(f"Error: {e}")
    
    elif opcion=="g":
        print("Salida del script")
        break
    
    else:
        print("Opción no válida. Inténtalo de nuevo.")