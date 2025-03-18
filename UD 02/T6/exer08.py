"""
Queremos realizar un programa que calcule o índice dunha chave para un dicionario utilizando o algoritmo de hashing por folding. 
O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división por folding e a chave.
"""

__author__ = "Aitor Novoa Alonso"

def hashing_por_folding(tamaño_tabla, divisiones, clave):
    """
    Calcula el índice de una clave para un diccionario usando el algoritmo de hashing por folding, solo utilizando cadenas de texto.
    
    Args:
        tamaño_tabla (int): El tamaño de la tabla de hash (número de buckets).
        divisiones (int): Número de divisiones por folding.
        clave (str): La clave que se usará para calcular el índice.
    
    Returns:
        int: El índice calculado para la clave en la tabla de hash.
    """
    # 1. Convertir la clave en una cadena de valores ASCII concatenados
    concatenado_ascii = ""
    for caracter in clave:
        concatenado_ascii += str(ord(caracter))  # Obtener el valor ASCII de cada carácter y concatenarlo
    
    # 2. Determinar el tamaño de cada parte
    tamaño_parte = len(concatenado_ascii) // divisiones  # Tamaño de cada parte
    resto = len(concatenado_ascii) % divisiones  # El resto, para la última parte

    suma_partes = 0
    # 3. Dividir la cadena de ASCII en las partes deseadas
    for i in range(divisiones):
        # Asegurarse de que la última parte maneje el resto
        if i == divisiones - 1:  # Última parte
            parte = concatenado_ascii[i * tamaño_parte:]
        else:
            parte = concatenado_ascii[i * tamaño_parte: (i + 1) * tamaño_parte]

        # Sumar los valores ASCII de esa parte sin usar `sum`
        parte_suma = 0
        for digito in parte:
            parte_suma += int(digito)  # Convertir cada dígito a entero y sumarlo manualmente
        
        suma_partes += parte_suma  # Añadir la suma de la parte a la suma total

    # 4. Aplicar modulación para obtener el índice final
    indice = suma_partes % tamaño_tabla
    
    return indice


# Solicitar parámetros al usuario
tamaño_tabla = int(input("Introduce el tamaño de la tabla de hash: "))
divisiones = int(input("Introduce el número de divisiones por folding: "))
clave = input("Introduce la clave: ")

# Calcular el índice
indice = hashing_por_folding(tamaño_tabla, divisiones, clave)

# Mostrar el índice calculado
print(f"El índice calculado para la clave '{clave}' es: {indice}")