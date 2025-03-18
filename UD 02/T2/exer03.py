"""
Escribe un script que lea un número por teclado e deduza se está entre 10 e 100 (ambos inclusive). 
Se é así mostra por pantalla Está no intervalo e senón Non está no intervalo
"""
__author__="Aitor Novoa Alonso"

numero = float(input("Introduce un numero: "))

if (numero>=10) and (numero<=100):
    print("Está en el intervalo")
else:
    print("No está en el intervalo")