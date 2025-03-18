"""
Escribe un script que pida o nome de usuario e contrasinal ao usuario. 
Indica se o inicio de sesión é correcto. O nome de usuario sería “python” e o contrasinal “pip
"""

__auth__="Aitor Novoa Alonso"

nombre_usuario = input("Introduce el nombre de usuarios: ")
contrasenha_usuario = input("Introduce la contraseña del usuario: ")

if nombre_usuario == "python" and contrasenha_usuario=="pip":
    print("Inicio de sesion correcto.")
else:
    print("Inicio de sesion incorrecto.")