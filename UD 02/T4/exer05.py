"""
 Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. 
 Crea un menú para que o usuario escolla o cambio que desexa realizar. Realiza unha función para cada un dos cambios:

 libras_to_euros(libras: float) -> float
 euros_to_libras(euros: float) -> float
 
 Un € é igual a 1,10 libras
"""
__author__="Aitor Novoa Alonso"

def libras_to_euros(libras):
    """
        Esta función transforma libras a euros 
        Args:
            libras (float): valor en libras
        Returns:
            float: valor en euros
    """
    return  libras/1.10

def euros_to_libras(euros):
    """
        Esta función transforma euros a libras 
        Args:
            euros (float): valor en euros
        Returns:
            float: valor en libras
    """
    return  euros*1.10

while True:
    print("Elige que operacion quieres hacer: ")
    print("\ta)Euros a libras")
    print("\tb)Libras a euros")
    opcion = input("> ").strip().lower()

    if opcion=="a":
        euros = float(input("Introduce la cantidad de euros: "))
        print(f"{euros}€ son {euros_to_libras(euros)}£")
        break
    elif opcion=="b":
        libras = float(input("Introduce la cantidad de libras: "))
        print(f"{libras}£ son {libras_to_euros(libras)}€")
        break
    else:
        print("Opción non válida. Vuelve a intentarlo.")
    