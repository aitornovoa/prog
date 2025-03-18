"""
Escribe un script que pida o nome de usuario e contrasinal ao usuario. 
Indica se o inicio de sesión é correcto. O nome de usuario correcto sería “python” e o contrasinal “pip”. 
Crea a función login(usuario: str, contrasinal: str) -> boolean para realizar esta operación.


"""
__author__="Aitor Novoa Alonso"


def login(usuario, contrasenha):
    """
        Esta función comprueba que el inicio de sesión sea correcto, que el usario sea 'python' y la contraseña 'pip' 
        Args:
            usuario (str): El nombre de usuario
            contrasinal (str): La contraseña del usuario
        Returns:
            boolean: True si el inicio de sesión es correcto, False en caso contrario
    """
    if usuario=="python" and contrasenha=="pip":
        return True
    return False

nombre_usuario = str(input("Introduce el nombre de usuario: "))
contrasena = str(input("Introduce la contraseña: "))

if (login(nombre_usuario, contrasena)):
    print("Inicio de sesión correcto")
else:
    print("Inicio de sesión incorrecto")