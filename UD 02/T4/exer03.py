"""
Escribe un script que pida ao usuario un ano e indique se é bisesto ou non. Coidado que a condición de ser bisesto non só é ser divisible entre 4.
O algoritmo debe estar implantado dentro dunha función denominada: comprobar_bisesto(ano: int) -> boolean.

Condición de ser bisesto:

Obrigatorio ten que ser divisible entre 4
Se o é, se é divisible por 100 ten que ser tamén por 400
Se é bisesto mostrarase por pantalla Bisesto e senón Non bisesto. En caso de se introduza un valor negativo, mostrarase por pantalla Erro.

"""
__author__="Aitor Novoa Alonso"

def comprobar_bisiesto(anho):
    """
        Esta función comprueba si un año es bisiesto o no. 
        Args:
            anho (int): El año a comprobar.
        Returns:
            bool: True si el año es bisiesto, False en caso contrario.
    """
    if anho%4 == 0 and anho%100==0 and anho%400==0:
        return True
    elif anho%4 == 0 and anho%100!=0:
        return True
    else:
        return False
    
anho = int(input("Introduce el año: "))

bisiesto = comprobar_bisiesto(anho)

if anho<0:
    print("Error")
elif bisiesto:
    print("Bisiesto")
else:
    print("No bisiesto")