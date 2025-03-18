"""
 Escribe un script que pida as notas dun exame dos alumnos de unha clase e conte o numero de aprobados e suspensos. 
 Pediráselle ao usuario que introduza notas por teclado ata que introduza un número inferior a 0 ou superior a 10.
 Mostrará primeiro o número de aprobados e despois o de suspensos.
"""
__author__="Aitor Novoa Alonso"

aprobados = 0
suspensos = 0

while True:
    nota = float(input("Introduce la nota: "))
    
    if nota<0 or nota>10:
        print("Se cierra el script")
        break
    elif nota>=5:
        aprobados += 1
    else:
        suspensos += 1
        
print(f"El numero de aprobados es {aprobados}.")
print(f"El numero de suspensos es {suspensos}")