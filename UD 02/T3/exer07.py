"""
 Escribe un script que pida que se introduzan números por teclado ata que o total da suma de tódolos números introducidos sexa 100 ou máis. 
 Ao rematar indica por pantalla a cantidade de números introducidos.


"""
__author__="Aitor Novoa Alonso"

suma = 0
cantidad = 0

while suma<100:
    numero = int(input("Introduce el numero a sumar: "))
    suma+=numero
    cantidad+=1
    
print(f"La cantidad de numeros introducidos es {cantidad}")