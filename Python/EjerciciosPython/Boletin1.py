from datetime import datetime

# EJERCICIO 1

# Escribir un programa que almacene las asignaturas de un curso (Matemáticas, Física, Química,
# Historia, Lengua, Anatomía, SGE) en una lista, pregunte al usuario la nota que ha sacado en
# cada asignatura, y después las muestre por pantalla con el mensaje En <asignatura> has sacado
# <nota>” donde <asignatura> es cada una des las asignaturas de la lista y <nota> cada una de
# # las correspondientes notas introducidas por el usuario. 

def notasAsignaturas():
    asignaturas=["Matemáticas", "Física", "Química", "Historia", "Lengua", "Anatomía", "SGE"] 
    
    for i in asignaturas:
        nota = input("¿Que nota has sacado en " + i + " ?")
        print("En ", i ,"has sacado ", nota)
        



# # EJERCICIO 2

# # Escribir un programa que almacene el abecedario en una lista, elimine de la lista las letras que
# # ocupen posiciones múltiplos de 3, y muestre por pantalla la lista resultante. 


def abecedario():
    
    letras = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    contador = 0 
    for i in range(len(letras)):
        if (i+1) % 3 == 0:
            del letras[i - contador]
            contador += 1
    print(letras)
    


# EJERCICIO 3

# Escribir una función que convierta un número decimal en binario y otra que convierta un
# número binario en decimal. 

def decimal_binario(decimal):
    binario = ""
    while decimal > 0:
        binario = str(decimal % 2) + binario  
        decimal = decimal // 2
    print(binario)



def binario_decimal(binario):
    print(int(binario, 2))

# EJERCICIO 4

# Una inmobiliaria de una ciudad maneja una lista de inmuebles como la siguiente:
# [{'año': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
# {'año': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
# {'año': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
# {'año': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
# {'año': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}]
# Construir una función que permita hacer búsqueda de inmuebles en función de un presupuesto
# dado. La función recibirá como entrada la lista de inmuebles y un precio, y devolverá otra lista
# con los inmuebles cuyo precio sea menor o igual que el dado. Los inmuebles de la lista que se
# devuelva deben incorporar un nuevo par a cada diccionario con el precio del inmueble, donde el
# precio de un inmueble se calcula con las siguiente fórmula en función de la zona: 

# Zona A: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-
# antiguedad/100)
# Zona B: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-
# antiguedad/100) * 1.5 

def busqueda_inmuebles(lista, precioEntrada):
    resultados = []
    for i in lista:
        antiguedad = datetime.now().year - i['año']
        
        if i['zona'] == 'A':
            precio = (i['metros'] * 1000 + i['habitaciones'] * 5000 + i['garaje'] * 15000) * (1-antiguedad/100)
            if precio <= precioEntrada:
                i['precio'] = precio
        
        else:
            precio = (i['metros'] * 1000 + i['habitaciones'] * 5000 + i['garaje'] * 15000) * (1-antiguedad/100) * 1.5
            i['precio'] =  precio
            
            if precio <= precioEntrada:
                i['precio'] = precio
        resultados.append(i)
    print(resultados)
    return resultados  
        
    
lista = [{'año': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
 {'año': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
 {'año': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
 {'año': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
 {'año': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}]

precioEntrada = 3000000000000000000

# EJERCICIO 5

# Algoritmo que, dado un año, nos diga si es bisiesto o no. Un año es bisiesto bajo las siguientes
# condiciones:
# • Un año divisible por 4 es bisiesto y no debe ser divisible entre 100.
# • Si un año es divisible entre 100 y además es divisible entre 400, también resulta bisiesto. 

def añoBisiesto(año):
    
    
    print(resultado)
    




# EJERCICIO 6

# Crea una tupla con los meses del año, pide números al usuario, si el numero esta entre 1 y la
# longitud máxima de la tupla, muestra el contenido de esa posición sino muestra un mensaje de
# error. El programa termina cuando el usuario introduce un cero. 

def muestraMensaje(numero):
    
   
    print(resultado)
    


# EJERCICIO 7

# Escribe un programa que en primer lugar pregunte si se quiere calcular el área de un triángulo o
# la de un círculo. Si se contesta que se quiere calcular el área de un triángulo, el programa tiene
# que pedir entonces la base y la altura y escribir el área. Si se contesta que se quiere calcular el
# área de un círculo, el programa tiene que pedir entonces el radio y escribir el área. En ambos
# casos el programa debe ser capaz de calcular y mostrar el resultado adecuado. 

def calculaArea(poligono):
    
    print(resultado)





#Main para probar las funciones
if __name__ == "__main__":
    
    #notasAsignaturas()
    #abecedario()
    #decimal_binario(int(input("Introduce numero decimal ")))
    #binario_decimal(input("Introduce numero binario "))
    #busqueda_inmuebles(lista, precioEntrada)
    añoBisiesto(int(input("Introduce año")))
    #muestraMensaje(int(input("Introduce numero")))
    #calculaArea(input("Introduce triangulo o circulo"))