"""
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctico. 
Escribe un script que lle pida ao usuario as súas tres notas sobre 10 e indicaralle por pantalla a súa nota final sobre 10."""

__auth__="Aitor Novoa Alonso"

nota_tareas = float(input("Introduce la nota de las tareas: "))
nota_teorico = float(input("Introduce la nota del examen teorico: "))
nota_practico = float(input("Introduce la nota del examen practico: "))

nota_final = nota_tareas*(15/100)+nota_teorico*(20/100)+nota_practico*(65/100)

print(f"La nota final es {nota_final:.2f}")


