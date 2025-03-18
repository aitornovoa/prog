"""
Escribe un script que calcule o salario dun traballador. 
O programa recibirá por parte do usuario as horas traballadas ao día e os € por cada hora de traballo. 
A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

Os días laborables ao mes son 22.
Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
Deduce o número necesario de funcións e defíneas.
"""
__author__="Aitor Novoa Alonso"

def calcular_salario_mensual(horas_trabajadas, euros_hora):
    """
        Esta funcion calcula el salario mensual del trabajador.
        Args:
            horas_trabajadas (float): las horas trabajadas
            euros_hora (float): el valor de cada hora de trabajo
        Returns:
            float: devuelve el salario neto del trabajador
    """
    return horas_trabajadas*euros_hora*22
    

def calcular_salario_bruto(horas_trabajadas, euros_hora, irpf):
    """
        Esta funcion calcula el salario del trabajador en base a su salario bruto.
        Args:
            horas_trabajadas (float): las horas trabajadas
            euros_hora (float): el valor de cada hora de trabajo
            irpf (float): el porcentaje de IRPF
        Returns:
            float: devuelve el salario neto del trabajador
    """
    salario_mensual_bruto = horas_trabajadas*euros_hora*22
    return salario_mensual_bruto-(salario_mensual_bruto*(irpf/100))

horas_mes_trabajadas = float(input("Introduce las horas trabajadas al día: "))
euros_hora = float(input("Introduce los euros por hora: "))
calcular_salario_mensual = calcular_salario_mensual(horas_mes_trabajadas, euros_hora)

while True:
    print("Elige el coste de la hora : ")
    print("\ta)Netos")
    print("\tb)Brutos")
    opcion = input("> ").strip().lower()

    if opcion=="a":
        print(f"El trabajador cobra {calcular_salario_mensual:.2f}")
        break
    elif opcion=="b":
        irpf = float(input("Introduce el IRPF en tanto por ciento: "))
        print(f"El trabajador cobre {calcular_salario_bruto(calcular_salario_mensual, irpf)}")
        break
    else:
        print("Opción non válida. Vuelve a intentarlo.")