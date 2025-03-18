__author__ = "Aitor Novoa Alonso"

salario_bruto = float(input("Introduce el salario bruto: "))
irpf = float(input("Introduce el irpf en %: "))

salario_neto = salario_bruto - (salario_bruto * (irpf/100))

print("El salario neto es "+str(salario_neto))