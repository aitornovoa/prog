"""
Escribe un script que pide ao usuario por teclado os coeficientes dunha ecuación de segundo grao e calcula a solución. 
Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda.
ax^2 + bx + c
"""

__auth__="Aitor Novoa Alonso"

import math 
#En el enunciado no se menciona que no se pueda usar este la librería de math, así que por más sencillez en el código así que optimización,la usaré

a = float(input("Introduce el primero coeficiente: "))
b = float(input("Introduce el segundo coeficiente: "))
c = float(input("Introduce el tercero coeficiente: "))

if a == 0:
    print("La ecuación no es de segundo grado")
else:
    discriminante = b**2 - 4*a*c
    
    if discriminante>0:
        x1 = (-b+math.sqrt(discriminante))/(2*a)
        x2 = (-b-+math.sqrt(discriminante))/(2*a)
        print(f"Las soluciones de la ecuacion son {x1} y {x2}")
    elif discriminante==0:
        x = -b/(2*a)
        print(f"La solucion de la ecuacion es {x}")
    else:
        print("La ecuación no tiene solucion real.")
