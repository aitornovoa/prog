"""
Un número de DNI ten o seguinte formato 00000000A.

Escribe un script que lle pida ao usuario o seu DNI e comprobe que sexa correcto. Para iso sigue os seguintes pasos:

Comproba a lonxitude da cadea.

Comproba que os 8 primeiros díxitos son números e o último é unha letra maiúscula. PISTA: utiliza a táboa do código ASCII.

Comproba que a letra introducida é o código de control do DNI. 
https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/#:~:text=Por%20ejemplo%2C%20si%20el%20n%C3%BAmero,n%C3%BAmeros%20y%20d%C3%ADgito%20de%20control.
"""

__author__ = "Aitor Novoa Alonso"



def comprobar_dni(dni):
    """Comprueba si la letra del dni introducido es válida
        Args:
            dni (str): el dni que se inntroduce
        Returns:
            bool: True si es correcta, sino False
        Raises:
            ValueError: Si el texto no es una cadena de caracteres o el desplazamiento no es un numero
    """
    letra = "TRWAGMYFPDXBNJZSQVHLCKE"
    if len(dni) == 9:
        numeros_dni = dni[:8]
        letra_dni = dni[8].upper()
        if numeros_dni.isdigit() and letra:
            numero_dni = int(numeros_dni)
            posicion_letra = numero_dni%23
            if letra_dni == letra[posicion_letra]:
                return True
            else:
                return False
        else: 
            return False
    else:
        False
        
dni = input("Introduce el dni: ")
if comprobar_dni(dni):
    print("Valido")
else:
    print("No valido")