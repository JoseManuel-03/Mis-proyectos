import mariadb
import sys

def conectar_bd():
    try:
        return mariadb.connect(
            user="Python",
            password="root",
            host="127.0.0.1",
            port=3306,
            database="usuariopython",
        )
    except mariadb.Error as e:
        print(f"Error conectando a la base de datos: {e}")
        sys.exit(1)

def crear_usuario(conexion, nombre, email):
    try:
        cursor = conexion.cursor()
        query = "INSERT INTO users (name, email) VALUES (%s, %s)"
        valores = (nombre, email)
        cursor.execute(query, valores)
        conexion.commit()
        print("Usuario creado correctamente")
    except mariadb.Error as e:
        print(f"Error al crear usuario: {e}")

# Función para leer todos los usuarios (Read)
def leer_usuarios(conexion):
    try:
        cursor = conexion.cursor()
        cursor.execute("SELECT * FROM users")
        resultados = cursor.fetchall()
        print("\nLista de usuarios:")
        for fila in resultados:
            print(f"ID: {fila[0]}, Nombre: {fila[1]}, Email: {fila[2]}")
    except mariadb.Error as e:
        print(f"Error al leer usuarios: {e}")

# Función para actualizar un usuario (Update)
def actualizar_usuario(conexion, id, nombre, email):
    try:
        cursor = conexion.cursor()
        query = "UPDATE users SET name = %s, email = %s WHERE id = %s"
        valores = (nombre, email, id)
        cursor.execute(query, valores)
        conexion.commit()
        print("Usuario actualizado correctamente")
    except mariadb.Error as e:
        print(f"Error al actualizar usuario: {e}")

# Función para eliminar un usuario (Delete)
def eliminar_usuario(conexion, id):
    try:
        cursor = conexion.cursor()
        query = "DELETE FROM users WHERE id = %s"
        valores = (id,)
        cursor.execute(query, valores)
        conexion.commit()
        print("Usuario eliminado correctamente")
    except mariadb.Error as e:
        print(f"Error al eliminar usuario: {e}")

def main():
    conexion = conectar_bd()
    if conexion:
        while True:
            print("\n--- Menú CRUD ---")
            print("1. Crear usuario")
            print("2. Leer usuarios")
            print("3. Actualizar usuario")
            print("4. Eliminar usuario")
            print("5. Salir")
            opcion = input("Selecciona una opción: ")
            if opcion == "1":
                nombre = input("Nombre: ")
                email = input("Email: ")
                crear_usuario(conexion, nombre, email)
            elif opcion == "2":
                leer_usuarios(conexion)
            elif opcion == "3":
                id = input("ID del usuario a actualizar: ")
                nombre = input("Nuevo nombre: ")
                email = input("Nuevo email: ")
                actualizar_usuario(conexion, id, nombre, email)
            elif opcion == "4":
                id = input("ID del usuario a eliminar: ")
                eliminar_usuario(conexion, id)
            elif opcion == "5":
                print("Saliendo...")
                break
            else:
                print("Opción no válida. Intenta de nuevo.")
        
    conexion.close()
    print("Conexión cerrada")

# Ejecutar el programa
if __name__ == "__main__":
    main()
