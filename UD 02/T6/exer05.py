"""
O cifrado César é un tipo de cifrado de substitución no que unha letra do texto orixinal é substituída por outra letra que é un número fixo 
de posicións posteriores no alfabeto.

Por exemplo se o desprazamento é 5, a 'a' cifrarase coa 'f'. Débense ignorar os espazos en branco.

Se nun desprazamento rematan as letras, volverase a comezar polo comezo do alfabeto.

Supoñer que todos os nomes están en minúsculas e están compostos só polas seguintes letras: 
a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z.

Realiza a implantación deste algoritmo na función cifra_cesar(texto: str, desprazamento: int): str. 
Recorda que os caracteres diferentes as letras se deben manter. Comproba se o tipo de datos introducidos son válidos, e senón é así lanza unha excepción ValueError.

O propio script debe utilizar ditas función para cifrar un texto introducido polo usuario para mostrar o texto cifrado por pantalla. 
O usuario tamén indicará por teclado o desprazamento. Ademais recorda capturar a excepción.
"""

__author__ = "Aitor Novoa Alonso"


def cifrado_cesar(texto, desplazamiento):
    """Cifra un texto introducido por el usuario usando el cifrado Cesar
        Args:
            texto (str): Texto introducido a cifrar
            desplazamiento (int): Posiciones a desplazar en el alfabeto.
        Returns:
            str: Texto cifrado
        Raises:
            ValueError: Si el texto no es una cadena de caracteres o el desplazamiento no es un numero
    """
    
    if not (type(texto) is str):
        raise ValueError("El texto debe ser una cadena de caracteres")
    if not (type(desplazamiento) is int):
        raise ValueError("El desplazamiento debe ser un número entero")
    
    texto_cifrado = ""
    for letra in texto:
        if ord(letra) >= 97 and ord(letra)<= 122:
            nueva_letra = chr((ord(letra) - ord('a') + desplazamiento) % 26 + ord('a'))
            texto_cifrado+=nueva_letra
    return texto_cifrado


try:
    texto = input("Introduce un texto a cifrar: ").lower()
    desplazamiento = int(input("Introduce el desplazamiento: "))
    texto_cifrado = cifrado_cesar(texto, desplazamiento)
    print(f"{texto_cifrado}")
except ValueError as e:
    print(f"Error: {e}")
    