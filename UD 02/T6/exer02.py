"""
Escribe un *script* que determine se unha cadea de texto introducida por teclado é un palíndromo. 
Un palíndromo é unha palabra ou frase que se le da mesma maneira de esquerda a dereita que de dereita a esquerda, ignorando espazos e maiúsculas. 
Se é palíndromo mostrará por pantalla `É palíndromo` e se non o é `Non é palíndromo`.
"""

__author__ = "Aitor Novoa Alonso"

texto = input("Introduce un texto: ")

#Quitar espacios
novo_texto = ""
for letra in texto:
    if letra != " ":
        novo_texto += letra
# novo_texto = texto.rstrip()
print(novo_texto)

# pasamos todo a minúsculas (podería ser todo a maiúsculas)
novo_texto = novo_texto.lower()

# Collemos o texto pero ao revés
texto_ao_reves = novo_texto[::-1]

# COmprobamos se é palíndromo
if texto_ao_reves == novo_texto:
    print("É palíndromo")
else:
    print("Non é palíndromo")