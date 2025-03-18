"""
 Implantar unha aplicación que calcule o menor de tres números introducidos por teclado polo usuario e o mostre por pantalla. 
 Comproba antes de nada que ningún par de números é igual. Se isto é así, indícallo mostra por pantalla Erro. e non calcules cal é o menor dos 3
"""
__author__="Aitor Novoa Alonso"

numero1 = float(input("Introduce el primer numero: "))
numero2 = float(input("Introduce el segundo numero: "))
numero3 = float(input("Introduce el tercero numero: "))


if numero1==numero2 or numero2==numero3 or numero1==numero3:
    print("Error")
else:
    if numero1<numero2 and numero1<numero3:
        print(f"El menor de los tres numeros es {numero1}")
    elif numero2<1 and numero2<numero3:
        print(f"El menor de los tres numeros es {numero2}")
    else:
        print(f"El menor de los tres numeros es {numero3}")