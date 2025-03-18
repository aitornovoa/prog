"""
Escribe un script que pida ao usuario o seu nome e apelidos por separado e mostra a seguinte mensaxe por pantalla: 
O usuario <apelido1> <apelido 2>, <nome> rexistrouse correctamente.

Os dous apelidos débense pedir por separado.
"""

__auth__="Aitor Novoa Alonso"

nombre = str(input("Introduce el nombre: "))
apellido1 = str(input("Introduce el primer apellido: "))
apellido2 = str(input("Introduce el segundo apellido: "))

print(f"El usuario {apellido1} {apellido2}, {nombre} se registró correctamente.")

