# Module Imports
import mariadb


# Connect to MariaDB Platform
try:
    connection = mariadb.connect(
      user="Python",
        password="root",
        host="127.0.0.1",
        port=3306,
        database="usuariopython"


    )
except mariadb.Error as e:
    print(f"Error connecting to MariaDB Platform: {e}")
    sys.exit(1)

# Get Cursor
cursor = connection.cursor()
cursor.execute(
    "SELECT * FROM login")



# Mostrar los resultados
for fila in cursor:
    print(fila)

cursor.close()
connection.close()