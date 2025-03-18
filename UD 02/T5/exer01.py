"""
Escribe un script que solicite ao usuario dous números e a continuación mostre o resultado de dividir o primeiro número polo segundo. 
Asegúrate de manexar as excepcións no caso de que o usuario intente dividir entre cero ou introduza por teclado un valor que non sexa un número. 
Para realizar isto deberás capturar as excepcións ZeroDivisionError e ValueError. Para cada unha das mensaxes mostra unha mensaxe de erro diferente:

- Cando se capture a excepción ZeroDivisionError mostra por pantalla: Erro: Non se pode dividir entre cero.
- Cando se capture a excepción ValueError mostra por pantalla: Erro: Entrada non válida, por favor introduce números..

"""
__author__="Aitor Novoa Alonso"

try:
    numero1 = float(input("Introduce un numero: "))
    numero2 = float(input("Introduce otro numero: "))
    resultado = numero1/numero2
    print(f"El resultade de la division {numero1}/{numero2} es {resultado}")
except ZeroDivisionError:
    print("Error: no se puede dividir entre 0")
except ValueError:
    print("Error: Entrada no válida, por favor introduce números.")