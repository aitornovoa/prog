"""
 Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra “fin”. 
 Tras finalizar a introdución de números, indícalle cal é o número máis pequeno introducido.
"""
__author__="Aitor Novoa Alonso"

menor = None

while True:
    entrada = input("Introduce un número entero: ")
    if entrada.lower() == "fin":
        break
    if entrada.lstrip('-').isdigit():
        numero = int(entrada)
        
        if menor == None or numero<menor:
            menor=numero
    else:
        print("Introduce un número válido.")

if menor != None:
    print(f"El número más pequeño es: {menor}")
else:
    print("Non se introduciu ningún número válido.")

