"""
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctico. 
Escribe un script que lle pedirá ao usuario as súas tres notas sobre 10. 
Indicaralle por pantalla se obtivo Sobresaliente, Notable, Ben, Suficiente ou Insuficiente.

Deduce o número necesario de funcións e defíneas.
"""
__author__="Aitor Novoa Alonso"

def calcular_nota_tarea(nota_tareas):
    """
        Esta funcion calcula el porcentaje de la nota de las tareas.
        Args:
            nota_tareas (float): la nota de las tareas sobre 10
        Returns:
            float: el porcentaje de la nota de las tareas
    """
    return nota_tareas*(15/100)
    
def calcular_nota_teorico(nota_teorico):
    """
        Esta funcion calcula el porcentaje de la nota de la parte teórica.
        Args:
            nota_teorico (float): la nota de la parte teorica sobre 10.
        Returns:
            float: el porcentaje de la nota de la parte teórica.
    """
    return nota_teorico*(20/100)

def calcular_nota_practico(nota_practico):
    """
        Esta funcion calcula el porcentaje de la nota de la parte práctica.
        Args:
            nota_practico (float): la nota de la parte práctica sobre 10.
        Returns:
            float: el porcentaje de la nota de la parte práctica.
    """
    return nota_practico*(65/100)

def calcular_nota_total(nota_tarea, nota_teorica, nota_practica):
    """
        Esta funcion calcula la nota total.
        Args:
            nota_tarea (float): el resultado del porcentaje de la nota de la tarea.
            nota_teorica (float): el resultado del porcentaje de la nota de la parte teórica.
            nota_practica (float): el resultado del porcentaje de la nota de la parte práctica.
        Returns:
            float: la nota total.
    """
    return nota_tarea + nota_teorica + nota_practica

def obtencion_nota(nota_total):
    """
        Esta funcion obtiene la nota final.
        Args:
            nota_total (float): la nota total.
        Returns:
            str: la nota final.
    """
    if nota_total>10 and nota_total<0:
        return "Nota invalida"
    elif nota_total>=9:
        return "Sobresaliente"
    elif nota_total>=7:
        return "Notable"
    elif nota_total>=6:
        return "Bien"
    elif nota_total>=5:
        return "Suficiente"
    else:
        return "Insuficiente"

def validar_nota(prompt):
    """"
    Esta funcion valida si la nota está en el rango de 0 y 10
    Args:
        prompt (str): el mensaje que muestra el usuario al ingresar la nora
    Returns:
        float: la nota validada.
    """
    nota = float(input(prompt))
    while nota < 0 or nota > 10:
        print("Nota invalida, ingrese una nota entre 0 y 10")
        nota = float(input(prompt))
        return nota
    return nota

nota_tareas= validar_nota("Introduce la nota de las tareas: ")
nota_teorica = validar_nota("Introduce la nota del examen teórica: ")
nota_practica = validar_nota("Introduce la nota del examen práctico: ")

porcentaje_nota_tara = calcular_nota_tarea(nota_tareas)
porcentaje_nota_teorica = calcular_nota_teorico(nota_teorica)
porcentaje_nota_practica = calcular_nota_practico(nota_practica)
nota_total = calcular_nota_total(porcentaje_nota_tara, porcentaje_nota_teorica, porcentaje_nota_practica)

print(obtencion_nota(nota_total))