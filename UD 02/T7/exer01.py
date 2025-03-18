"""
Crea un script no que se ingresen as notas de alumnos. Vai gardando todas as notas que están entre 0 e 10 nunha lista. 
Cando o usuario introduza a palabra “fin”, non se pediran máis notas. 
Ao finalizar o ingreso de notas mostra por pantalla a media de todas as notas.

"""

__author__ = "Aitor Novoa Alonso"

notas = []

while True:

    nota_str = input()

    if nota_str == "fin":
        break

    try:
        nota = int(nota_str)
    except:
        continue

    if 0 <= nota and nota <= 10:
        notas.append(nota)
    else:
        print()

suma = 0
for nota in notas:
    suma +=  nota

media = suma / len(notas)

print(media)