"""
Realiza a implantación da función descifra_cesar(texto: str, desprazamento: int): str nun script que descifre unha cadea cifrada con cifrado César. 
Lanza tamén excepción ValueError se os argumentos da función son do tipo de datos inválidos.

O propio script debe utilizar dita función para descifrar un texto introducido polo usuario para mostrar o texto descifrado por pantalla. 
O usuario tamén indicará por teclado o desprazamento.
"""

__author__ = "Aitor Novoa Alonso"


def descifra_cesar(texto, desplazamiento):
    """Descifra un texto introducido por el usuario usando el cifrado Cesar
        Args:
            texto (str): Texto introducido a descifrar
            desplazamiento (int): Posiciones a desplazar en el alfabeto.
        Returns:
            str: Texto descifrado
        Raises:
            ValueError: Si el texto no es una cadena de caracteres o el desplazamiento no es un numero
    """
    
    if not (type(texto) is str):
        raise ValueError("El texto debe ser una cadena de caracteres")
    if not (type(desplazamiento) is int):
        raise ValueError("El desplazamiento debe ser un número entero")
    
    texto_descifrado = ""
    for letra in texto:
        if ord(letra) >= 97 and ord(letra)<= 122:
            nueva_letra = chr((ord(letra) - ord('a') - desplazamiento) % 26 + ord('a'))
            texto_descifrado+=nueva_letra
    return texto_descifrado


try:
    texto = input("Introduce un texto a cifrar: ").lower()
    desplazamiento = int(input("Introduce el desplazamiento: "))
    texto_cifrado = descifra_cesar(texto, desplazamiento)
    print(f"{texto_cifrado}")
except ValueError as e:
    print(f"Error: {e}")
    