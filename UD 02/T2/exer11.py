"""
Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. 
Crea un menú para que o usuario escolla o cambio que desexa realizar e a continuación introducirá o valor da moeda correspondente para realizar o cambio de divisas. 
1 € son 1,10 libras.
"""

__auth__="Aitor Novoa Alonso"

print("Elige que operacion quieres hacer: ")
print("\ta)Euros a libras")
print("\tb)Libras a euros")
opcion = input("> ").strip().lower() #En caso de que se introduzca en mayúscula la letra, esta será convertida en minúscula, por lo que no daría error

if(opcion== "a"):
    cantidad_euros = float(input("Introduce cuantos euros quieres cambiar: "))
    operacion = cantidad_euros*1.10
    print(f"Has cambiado {cantidad_euros} euros a {operacion} libras")
elif(opcion=="b"):
    cantidad_libras = float(input("Introduce cuantas libras quieres cambiar: "))
    operacion = cantidad_libras/1.10
    print(f"Has cambiado {cantidad_libras} libras a {operacion} euros")
else:
    print("Opcion invalida")
    