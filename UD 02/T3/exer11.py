"""
Escribe un script que calcule o mínimo común múltiplo de dous números introducidos polo usuario.
Non utilices ningún algoritmo, vai probando números ata que atopes un número que sexa múltiplo dos dous números.
"""
__author__="Aitor Novoa Alonso"

numero1 = int(input("Introduce un numero: "))
numero2 = int(input("Introduce otro numero: "))

while numero1 <= 0 or numero2 <= 0:
    print("Ambos os números deben ser positivos.")
    numero1 = int(input("Introduce o primeiro número: "))
    numero2 = int(input("Introduce o segundo número: "))

while numero1 < numero2:
    mcm = numero2
    break

while numero2 < numero1:
    mcm = numero1
    break
#En vez de usar dos while hubiese sido más fácil y eficiente usar un if else
    #if num1 > num2:
    #    mcm = num1
    #else:
    #    mcm = num2
#O sino haber usado max, que sólo llevaría una línea
    # mcm = max(numero1, numero2)
    
while mcm % numero1 != 0 or mcm % numero2 != 0:
    mcm+=1

print(f"El minimo comun multiplo de {numero1} e {numero2} é {mcm}.")