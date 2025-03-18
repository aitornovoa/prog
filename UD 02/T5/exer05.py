"""
Escribe unha función calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float nun script o soldo bruto e o IRPF en tanto por cen. 
Comproba que estes dous valores son números, que o soldo é maior que 0 e que o IRPF é un valor válido. 
Se algunha destas condicións non se cumpre, lanza a excepción ValueError. 
O propio script deberá recibir estes datos por teclado, e utilizar a función creada para calcular o desconto do IRPF. 
Captura a excepción que lanza a función.
"""
__author__="Aitor Novoa Alonso"

def calcular_descuento_irpf(sueldo_bruto, irpf):
    """
    Esta función calcula el descuento de IRPF en función de su sueldo bruto
    Args:
        sueldo_bruto (int/float): el sueldo bruto asignado al trabajador
        irpf (int): el porcentaje de IRPF que se le descontará al trabajador
    Returns:
        float:  el descuento del irpf
    Raises:
        ValueError: si loa parametros no son números, si el sueldo bruto es menor que 0 o si el irpf no es un valor válido
    """
    if not(type(sueldo_bruto) is int or type(sueldo_bruto) is float):
        raise ValueError("El sueldo bruto debe ser un número")
    if not(type(irpf) is int or type(irpf) is float):
        raise ValueError("El irpf debe ser un número")
    if sueldo_bruto < 0:
        raise ValueError("El sueldo debe ser mayor que 0")
    if irpf < 0 or irpf > 100:
        raise ValueError("El irpf debe ser un valor válido entre 0 y 100")
    
    return sueldo_bruto * (irpf / 100)

try:
    sueldo = float(input("Introduce el sueldo bruto: "))
    irpf = float(input("Introduce el irpf: "))
    descuento = calcular_descuento_irpf(sueldo, irpf)
    print(f"El descuento es {descuento}")
except ValueError as e:
    print(f"Error: {e}")

