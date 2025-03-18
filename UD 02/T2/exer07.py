"""
Escribe un script que pida ao usuario un ano e indique se é bisesto ou non. Coidado que a condición de ser bisesto non só é ser divisible entre 4.

Condición de ser bisesto:

Obrigatorio ten que ser divisible entre 4
Se o é, se é divisible por 100 ten que ser tamén por 400
Se é bisesto mostrarase por pantalla Bisesto e senón Non bisesto. En caso de se introduza un valor negativo, mostrarase por pantalla Erro.
"""
__author__="Aitor Novoa Alonso"

anho = int(input("Introduce el anho: "))

if anho<=0:
    print("Error")
else:
    if anho%4==0 and anho%100==0 and anho%400==0:
        print("Bisiesto")
    elif anho%4==0 and anho%100!=0:
        print("Bisiesto")
    else:
        print("No bisiesto")