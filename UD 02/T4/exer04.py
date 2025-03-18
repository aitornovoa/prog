"""
 Escribe un script que pide ao usuario os coeficientes dunha ecuación de segundo grao e calcula a solución. 
 Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda. Crea as seguintes funcións:

 Unha función que calcule o discriminante: descriminante(a: float, b: float, c: float) -> float

 Unha función que calcule o número de solucións: numero_solucions(a: float, b: float, c: float) -> int. Debe utilizar internamente descriminante().

 Unha para calcular a solución cando esta é única: solucion_unica(a: float, b: float) -> float

 Unha para calcular as dúas solucións: calcula_duas_solucions (a: float, b: float, c: float) -> (float, float). 
 Esta debe devolver las dos soluciones. Debe utilizar internamente descriminante()
"""
__author__="Aitor Novoa Alonso"

import math

def discriminante(a, b, c):
    """
        Esta función calcula el discriminante de una ecuación de segundo grado. 
        Args:
            a (float): Coeficiente del término cuadrático.
            b (float): Coeficiente del término lineal.
            c (float): Coeficiente del término constante.
        Returns:
            float: El discriminante de la ecuación.
    """
    return b**2-4*a*c

def numero_soluciones(a, b,c):
    """
        Esta función calcula el número de soluciones de una ecuación de segundo grado. 
        Args:
            a (float): Coeficiente del término cuadrático.
            b (float): Coeficiente del término lineal.
            c (float): Coeficiente del término constante.
        Returns:
            int: El número de soluciones de la ecuación.
    """
    valor_discriminante = discriminante(a,b,c)
    if valor_discriminante > 0:
        return 2
    elif valor_discriminante == 0:
        return 1
    else:
        return 0
    
def solucion_unica(a,b):
    """
        Esta función calcula la única solución de una ecuación de segundo grado (sólo cuando el discriminante es 0). 
        Args:
            a (float): Coeficiente del término cuadrático.
            b (float): Coeficiente del término lineal.
            c (float): Coeficiente del término constante.
        Returns:
            float: La única solución de la ecuación.
    """
    return -b/(2*a)

def calcula_dos_soluciones(a,b,c):
    """
        Esta función calcula las dos soluciones de una ecuación de segundo grado (sólo cuando el discriminante es mayor de 0). 
        Args:
            a (float): Coeficiente del término cuadrático.
            b (float): Coeficiente del término lineal.
            c (float): Coeficiente del término constante.
        Returns:
            tuple: Las dos soluciones de la ecuación, no enteros.
    """
    valor_discriminante = discriminante(a,b,c)
    raiz_discriminante = math.sqrt(valor_discriminante)
    x1 = (-b+raiz_discriminante)/(2*a)
    x2 = (-b-raiz_discriminante)/(2*a)
    return x1,x2

a = float(input("Introduce el coeficiente a: "))
b = float(input("Introduce el coeficiente b: "))
c = float(input("Introduce el coeficiente c: "))

numero_soluciones = numero_soluciones(a,b,c)

if numero_soluciones==2:
    x1, x2 = calcula_dos_soluciones(a,b,c)
    print(f"Las soluciones son {x1:.2f} y {x2:.2f}")
elif numero_soluciones==1:
    x = solucion_unica(a,b,c)
    print(f"La solución es {x:.2f}")
else:
    print("No hay solucion para la ecuacion")