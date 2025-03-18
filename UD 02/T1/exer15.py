"""
Escribe un script que pida ao usuario os coeficientes dunha ecuación de segundo grao e calcula as dúas solucións. 
Mostra as dúas solucións por pantalla.
ax^2 + bx + c
"""

__auth__="Aitor Novoa Alonso"

a = float(input("Introduce el primero coeficiente: "))
b = float(input("Introduce el segundo coeficiente: "))
c = float(input("Introduce el tercero coeficiente: "))

discriminante = b**2-4*a*c
raiz_discriminante = discriminante**(1/2)

x1 = (-b+raiz_discriminante)/(2*a)
x2 = (-b-raiz_discriminante)/(2*a)

print(f"Las soluciones de la ecuacion son {x1} y {x2}")

