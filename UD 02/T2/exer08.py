"""
Crea un menú nun script para seleccionar a acción que desexa realizar o usuario. Neste caso temos tres opcións:

a) Sumar 2 números introducidos por teclado e mostrar o resultado.
b) Restar 2 números introducidos por teclado e mostrar o resultado.
c) Multiplicar 2 números introducidos por teclado e mostrar o resultado.
"""
__author__="Aitor Novoa Alonso"

numero1 = float(input("Introduce el primer numero: "))
numero2 = float(input("Introduce el segundo numero: "))

print("\ta)Suma los dos numeros: ")
print("\tb)Resta los dos numeros: ")
print("\tc)Multiplica los dos numeros: ")
opcion = input("> ")

if opcion == "a":
    print(numero1+numero2)
elif opcion == "b":
    print(numero1-numero2)
elif opcion == "c":
    print(numero1*numero2)
else:
    print("Opción no válida")
