# Ejercicio 1
# Realizar un programa que conste de una clase llamada Estudiante, que tenga como atributos el nombre y la nota del alumno. 
# Definir los métodos para inicializar sus atributos, imprimirlos y mostrar un mensaje con el resultado de la nota y si ha aprobado o no.

class Estudiante:
    def __init__(self, nombre, notaAlumno):
        self.nombre = nombre  
        self.notaAlumno = notaAlumno 
        
    def aprobadoSuspenso(self):
        if(self.notaAlumno >= 5):
            print("Nota del alumno: ", self.notaAlumno,  " El alumno ha aprobado ")
        else:
            print("Nota del alumno: ", self.notaAlumno,  " El alumno ha suspendido ")
    

    

# Ejercicio 2
# Crea una clase “Persona”. Con atributos nombre y edad. Además, hay que crear un método “cumpleaños”, que aumente en 1 la edad de la persona 
# cuando se invoque sobre un objeto creado con “Persona”.

class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre  
        self.edad = edad 

    def cumpleaños(self):
        self.edad += 1 
        print(self.edad)
    

# Ejercicio 3
# Realizar un programa en el cual se declaren dos valores enteros por teclado utilizando el método __init__. Calcular después la suma, 
# resta, multiplicación y división. Utilizar un método para cada una e imprimir los resultados obtenidos. Llamar a la clase Calculadora.

class Calculadora:
    def __init__(self, valor1, valor2):
        self.valor1 = valor1  
        self.valor2 = valor2
    
    def suma(self):
        sumaRes = self.valor1 + self.valor2
        print(sumaRes)
    
    def resta(self):
        restaRes = self.valor1 - self.valor2
        print(restaRes)
    
    def multiplicacion(self):
        multRes = self.valor1 * self.valor2
        print(multRes)

    def division(self):
        divisionRes= self.valor1 / self.valor2
        print(divisionRes)



# Ejercicio 4
# Crear una clase “Persona” que sea la clase padre de otra clase “Estudiante”. Por tanto: En la clase “Persona” su método __init__() debe de estar preparado 
# para recibir nombre y apellido. Además, esta clase , debe tener un método para mostrar nombre_completo() el cual debe mostrar el nombre acompañado del apellido.
# La otra clase “Estudiante”, debe de poder heredar de “Persona”, y además recibir los argumentos nombre y edad. También la clase “Estudiante”, recibe el valor “carrera”,
# y además contar con un método mostrar_carrera(). Las dos clases son obligatorias.


class Persona:
    def __init__(self, nombre, apellido):
        self.nombre = nombre  
        self.apellido = apellido 
    
    def nombre_completo(self):
        nombre = self.nombre + " "+ self. apellido
        print(nombre)

class Estudiante(Persona):
    def __init__(self, nombre, edad, carrera):
        super(). __init__(nombre)
        self.edad = edad 
        self.carrera = carrera
    
    def mostrar_carrera(self):
        print(self.carrera)
        
    
# Ejercicio 5
# Crear una clase Fabrica que tenga los atributos de Llantas, Color y Precio; luego crear dos clases más que hereden de Fabrica, las cuales son Moto y Carro. 
# Crear métodos que muestren la cantidad de llantas, color y precio de ambos transportes. Por último, crear objetos para cada clase y mostrar por pantalla los atributos de cada uno.

class Fabrica:
    def __init__(self, llantas, color, precio):
        self.llantas = llantas  
        self.color = color 
        self.precio = precio
        
class Moto(Fabrica):
    def __init__(self, llantas, color, precio):
        super(). __init__(llantas, color, precio)
    
    def cantidad(self):
        print(self.llantas)  
        print(self.color)
        print(self.precio)
        
class Carro(Fabrica):
    def __init__(self, llantas, color, precio):
        super(). __init__(llantas, color, precio)
    
    def cantidad(self):
        print(self.llantas)  
        print(self.color)
        print(self.precio)
    

# Ejercicio 6
# Crear una clase llamada Marino(), con un método que sea hablar, en donde muestre un mensaje que diga «Hola, soy un animal marino!». 
# Luego, crear una clase Pulpo() que herede Marino, pero modificar el mensaje de hablar por «Hola soy un Pulpo!». Por último, crear una clase Foca(), heredada de Marino, 
# pero que tenga un atributo nuevo llamado mensaje y que muestre ese mensaje como parámetro.

class Marino:
    def hablar():
        print("Hola, soy un animal marino!")

class Pulpo(Marino):
    def hablar():
        print("Hola soy un Pulpo!")


class Foca(Marino):
    def __init__(self, mensaje):
        self.mensaje = self.hablar

# Ejercicio 7
# Desarrollar un programa con tres clases: La primera debe ser Universidad, con atributos nombre (Donde se almacena el nombre de la Universidad). 
# La segunda llamada Carerra, con los atributos especialidad (En donde me guarda la especialidad de un estudiante). Y por último, una llamada Estudiante, 
# que tenga como atributos su nombre y edad. El programa debe imprimir la especialidad, edad, nombre y universidad de dicho estudiante con un objeto llamado persona.

class Universidad:
    def __init__(self, nombre):
        self.nombre = nombre

class Carrera(Universidad):
    def __init__(self,nombre, especialidad):
        super(). __init__(nombre)
        self.especialidad = especialidad

class Estudiante(Carrera):
    def __init__(self, nombre, especialidad, nombreUni, edad):
        super(). __init__(nombre, especialidad)
        self.nombreUni = nombreUni
        self.edad = edad
        
    def imprimir(self):
        print(self.nombre, self.edad, self.especialidad, self.nombreUni)

#Main para probar las funciones (descomenta cada línea para probar el método)
if __name__ == "__main__":
 #EJ1 
    # estudiante1 = Estudiante("Dani", 8)
    # estudiante1.aprobadoSuspenso()
    
 #EJ2 

    # persona1 = Persona("Dani", 9)
    # persona1.cumpleaños()
    
 #EJ3

    # calculadora1 = Calculadora(5,3)
    # calculadora1.suma()
    # calculadora1.resta()
    # calculadora1.multiplicacion()
    # calculadora1.division()
    
 #EJ4   

    # persona2 = Persona("Daniel", "Gonzalez")
    # persona2.nombre_completo()
    # estudiante2 = Estudiante("Daniel", 8, "DAM")
    # estudiante2.mostrar_carrera()
    
 #EJ5

    # fabrica1 = Fabrica(3,"Rojo", 45)
    # moto1 = Moto(2,"Amarillo", 5)
    # moto1.cantidad()
    # carro1 = Carro(4,"Azul", 15)
    # carro1.cantidad()

 #EJ6

    # marino1 = Marino
    # marino1.hablar()
    # pulpo1 = Pulpo
    # pulpo1.hablar()
    # foca1 = Foca("Hola soy una foca")

 #EJ7
    
    # uni = Universidad("Universidad Nacional")
    # carrera = Carrera("Universidad Nacional","Ingeniería de Software")
    # persona = Estudiante("Universidad Nacional","Ingeniería de Software","Carlos Pérez", 22)
    # persona.imprimir()








