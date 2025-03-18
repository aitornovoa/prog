"""
 Escribe un script que comprobe se dados dous números introducidos por teclado, se un deles é divisor do outro. 
 Se un deles é divisor mostra o número divisor pon pantalla. Se ningún é divisor do outro, mostra Erro.
"""
__author__="Aitor Novoa Alonso"

numero1 = float(input("Introduce el primer numero: "))
numero2 = float(input("Introduce el segundo numero: "))


if (numero1%numero2==0):
    print(f"El numero divisor es {numero2}")
elif (numero2%numero1==0):
    print(f"El numero divisor es {numero1}")
else:
    print("Error")