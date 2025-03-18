"""
Escribe un script que calcule o salario dun traballador. 
O programa recibirá as horas traballadas ao día e os € por hora dese traballo por parte do usuario. 
A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

Os días laborables ao mes son 22.
Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
"""

__auth__="Aitor Novoa Alonso"

horas_trabajadas = float(input("Introduce las horas trabajadas: "))
euros_hora = float(input("Introduce los euros por hora: "))
dias_laborables = 22

print("Seleccione su tarifa:")
print("\ta)Bruto")
print("\tb)Neto")
opcion = input("> ").strip().lower()

salario_mensual = horas_trabajadas*euros_hora*dias_laborables

if opcion=="a":
    irpf = float(input("Introduce el IRPF en tanto por ciento: "))
    # Calculo del salario bruto usando la formula de la tarea 1, ejercicio 11
    salario = salario_mensual-(salario_mensual*(irpf/100))
    print(f"El salario es de {salario:.2f}")
elif opcion == "b":
    print(f"El salario es de {salario_mensual:.2f}")
else:
    print("Opcion invalida")    

