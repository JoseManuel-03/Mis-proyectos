# Obtener la desviación estándar y el promedio de un conjunto de datos de una serie. 
# Ejemplo calculadora simple con funciones 

print("Select operation.") 
print("1.Add") 
print("2.Subtract") 
print("3.Multiply") 
print("4.Divide")

opcion = int(input("Selecciona una opcion entre 1.Add, 2.Subtract, 3.Multiply, 4.Divide "))

valor1 = int(input("Numero 1 "))
valor2 = int(input("Numero 2 "))

if(opcion == 1):
    def suma(valor1,valor2):
        sumaRes = valor1 + valor2
        print(sumaRes)
        
elif(opcion == 2):
    def resta(valor1,valor2):
        restaRes = valor1 - valor2
        print(restaRes)
        
elif(opcion == 3):
    def multiplicacion(valor1,valor2):
        multRes = valor1 * valor2
        print(multRes)

elif(opcion == 4):
    def division(valor1,valor2):
        divisionRes= valor1 / valor2
        print(divisionRes)
