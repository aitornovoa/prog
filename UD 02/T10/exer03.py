"""
Pasa a calculadora! é un xogo para dúas persoas no que se comeza cunha calculadora e cada xogador, de xeito alterno, suma un número novo, 
dun só díxito, ao valor acumulado ata o momento, comezando en 0. O xogador que, tras sumar o seu número, chegue a un resultado maior ou igual a 
31 perde.

Ademais, en cada turno un xogador só pode utilizar os números situados na mesma fila ou columna que o díxito marcado polo seu opoñente 
no turno anterior, pero non pode repetir o número. Evidentemente, o número 0 non se pode utilizar nunca.

Por exemplo, imaxina que, durante unha partida, un xogador recibe aa calculadora mostrándolle o número 28, e o opoñente 
acaba de introducir o número 9. A partir da disposición dos números da calculadora, sabemos que nesta quenda unicamente 
poderá xogar os números 3, 6, 7 y 8:



Implanta este xogo.
"""

__author__ = "Aitor Novoa Alonso"


def mostrar_tablero():
    """
    Muestra el tablero de juego con los números disponibles en la calculadora.
    
    El tablero es una matriz 3x3 con los números del 1 al 9 dispuestos de la siguiente forma:
    1 2 3
    4 5 6
    7 8 9
    """
    tablero = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    
    print("Taboleiro de xogos (dispoñibles):")
    for fila in tablero:
        print(fila)
    print()

def obtener_opcion(disponibles):
    """Solicita al jugador que elija un número válido de la lista de números disponibles.
    
    Args:
        disponibles (list): Lista de números que el jugador puede escoger.
    
    Returns:
        int: El número elegido por el jugador.
    """
    while True:
        try:
            opcion = int(input(f"Escolla un número entre {disponibles}: "))
            if opcion in disponibles:
                return opcion
            else:
                print(f"Por favor, escolla un número válido dentro de {disponibles}.")
        except ValueError:
            print("Debe introducir un número válido.")

def obter_disponibles(ultimo_numero, taboleiro):
    """
    Calcula los números disponibles para el jugador según la última elección del oponente.
    
    Los números disponibles son aquellos que están en la misma fila o columna que el número
    elegido por el oponente en el turno anterior.
    
    Args:
        ultimo_numero (int): El último número elegido por el oponente.
        tablero (list): El tabler de números (matriz 3x3).
    
    Returns:
        list: Lista de números disponibles que el jugador puede elegir.
    """
    disponibles = set()
    
    for i in range(3):
        for j in range(3):
            if taboleiro[i][j] == ultimo_numero:
                for k in range(3):
                    if taboleiro[i][k] != 0:
                        disponibles.add(taboleiro[i][k])
                    if taboleiro[k][j] != 0:
                        disponibles.add(taboleiro[k][j])
    return list(disponibles)

turno_xogador_1 = True 
numero_inicial = 0  
ultimo_numero = 0 


taboleiro = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

while True:
    mostrar_tablero()
    print(f"Valor acumulado: {numero_inicial}")
    
    if ultimo_numero != 0:
        print(f"Último número jugador: {ultimo_numero}")
    
    if ultimo_numero == 0:
        disponibles = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    else:
        disponibles = obter_disponibles(ultimo_numero, taboleiro)
    
    if turno_xogador_1:
        print("Turno jugador 1")
    else:
        print("Turno jugador 2")
    
    numero_elegido = obtener_opcion(disponibles)
    
    numero_inicial += numero_elegido
    if numero_inicial >= 31:
        if turno_xogador_1:
            print("Jugador 1 perdeu!")
        else:
            print("Jugador 2 perdeu!")
        break
    
    ultimo_numero = numero_elegido
    
    turno_xogador_1 = not turno_xogador_1