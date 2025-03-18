"""
Escribe un script que que calcule o importe a pagar por un vehículo ao circular por unha autoestrada. Seleccionade o vehículo mediante un menú. 
Se é necesario pedídelle ao usuario os quilómetros recorridos pola autoestrada e o seu peso.

a) Moto: importe fixo de 1€
b) Turismo: 0,25€ por km recorrido
c) Camión: 0,25€ por km más 0,15€ por tonelada de peso (Primeiro pídeselle a distancia e despois o peso)
"""
__author__="Aitor Novoa Alonso"

print("Elige un transporte: ")
print("\ta)Moto")
print("\tb)Turismo")
print("\tc)Camion")
opcion = input("> ")

if opcion == "a":
    print("El importe a pagar es 1€")
elif opcion == "b":
    kilometros_recorridos = float(input("Introduce los kilometros recorridos: "))
    coste_turismo = 0.25*kilometros_recorridos
    print(f"El importe a pagar es {coste_turismo:.2f}€")
elif opcion == "c":
    kilometros_recorridos = float(input("Introduce los kilometros recorridos: "))
    peso_toneladas = float(input("Introduce el peso en toneladas: "))
    coste_camion = 0.25*kilometros_recorridos+0.15*peso_toneladas
    print(f"El importe a pagar es {coste_camion:.2f}€")
else:
    print("Opcion no valida")

