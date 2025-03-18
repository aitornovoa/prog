"""
Escribe unha función en Python piramide(lonxitude: int) que imprima unha pirámide de números. 
Esta recibe un enteiro que indica a lonxitude da pirámide.

Por exemplo se introducimos a lonxitude 5, imprimirase:

1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
Utiliza a función range().
"""

__author__ = "Aitor Novoa Alonso"

def longitud(numero):
    for i in range(1, numero + 1): #Bucle exterior fila
        fila = ""
        for j in range(1, i + 1):
            fila += str(j) + " " #Bucle imprimir numeros fila
        fila = fila[:-1]
        print(fila)
   
longitud(5)