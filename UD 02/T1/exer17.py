"""
Escribe un script que pida ao usuario o número de quilómetros recorridos na súa última viaxe en coche, o consumo do coche en litros cada 100 quilómetros e o prezo en euros dun litro de combustible. 
Calcula o custo da viaxe e móstrallo ao usuario por pantalla.
"""

__auth__="Aitor Novoa Alonso"

numero_kilometros = float(input("Introduce el numero de kilometros recorridos: "))
consumo_100_kilometros = float(input("Introduce el consumo del coche en cada 100 kilometros: "))
precio_litro_combustimble = float(input("Introduce el precio del combustible "))

litros_consumidos = (numero_kilometros/100)*consumo_100_kilometros
coste_viaje = litros_consumidos*precio_litro_combustimble

print(f"El coste del viaje será de {coste_viaje:.2f} €")

