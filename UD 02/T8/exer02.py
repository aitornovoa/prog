"""
Escribe nun script unha función valor_maximo(dicionario: Dict[str, int]) -> List[str] que devolva as chaves asociadas ao valor máximo nun dicionario.
Devolve unha lista con todas as claves que teñan ese valor. Aquí tes un fragmento de código para probar a función:

dicionario = {'a': 5, 'b': 3, 'c': 5, 'd': 2}

print(valor_maximo(dicionario))
# Saída esperada: ['a', 'c'])

"""

__author__ = "Aitor Novoa Alonso"

def valor_maximo(dicionario):
    """
    Cuenta la frecuencia de cada unha das palabras nunha lista

    Args:
        dicionario (dict): dicionario

    Returns:
        list: lista con los valores maximos
    """
    
    maximo_valor = None
    
    claves = []
    
    for clave, valor in dicionario.items():
        if maximo_valor is None or valor > maximo_valor:
            maximo_valor = valor
            claves = [clave]
        elif valor == maximo_valor:
            claves.append(clave)
            
    return claves

dicionario = {'a': 5, 'b': 3, 'c': 5, 'd': 2}

print(valor_maximo(dicionario))