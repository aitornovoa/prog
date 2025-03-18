"""
Escribe nun script unha función agrupar_datos_por_valor(dicionario: Dict[str, List[int]]) -> Dict[int, List[str]] que reciba un dicionario onde 
os valores son listas e devolva un novo dicionario que agrupe as claves segundo os valores que teñen en común.
Aquí tes un fragmento de código para probar a función:

dicionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}
print(agrupar_datos_por_valor(dicionario))
# Saída esperada:
# {1: ['a', 'c'], 2: ['a', 'b'], 3: ['b'], 4: ['c']}

"""

__author__ = "Aitor Novoa Alonso"

def agrupar_datos_por_valor(dicionario):
    """
    Indica con que claves aparece cada valor

    Args:
        dicionario (dict): dicionario donde cada valor es una lista con números

    Returns:
        dict: diccionario donde cada clave es un número y su valor las claves donde aparecen
    """
    
    resultado = {}
    
    for clave,lista in dicionario.items():
        for numero in lista:
            if numero in resultado:
                resultado[numero].append(clave)
            else:
                resultado[numero] = [clave]
    return resultado

dicionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}
print(agrupar_datos_por_valor(dicionario))