"""
Escribe nun script unha función contar_frecuencia(lista: List[str]) -> Dict[str, int] que conte a frecuencia de cada palabra nunha lista de palabras.
A función debe devolver un dicionario onde as chaves son as palabras e os valores son as frecuencias. 
Aquí tes un fragmento de código para probar dita función:

lista_palabras = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá']

print(contar_frecuencia(lista_palabras))

"""

__author__ = "Aitor Novoa Alonso"

def contar_frecuencia(lista):
    """
    Cuenta la frecuencia de cada unha das palabras nunha lista

    Args:
        lista (list): lista de palabras

    Returns:
        dict: diccionario donde las llaves son las palabras y su valor el número de ocurrencias
    """
    contador = {}

    for palabra in lista:
      
        if palabra in contador:
            contador[palabra] +=  1
        else:
            contador[palabra] = 1

    return contador

lista_palabras = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá']

print(contar_frecuencia(lista_palabras))