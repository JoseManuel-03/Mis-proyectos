import tkinter as tk
import mariadb
from tkinter import messagebox, PhotoImage


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


def verificar_credenciales():
    usuario = entry_usuario.get()
    contraseña = entry_contraseña.get()

    connection = conectar_bd()
    cursor = connection.cursor()

    try:
        cursor.execute("SELECT password FROM login WHERE name = %s", (usuario,))
        resultado = cursor.fetchone()

        if resultado is None:
            messagebox.showerror("Error", "Usuario no encontrado")
        else:
            contraseña_bd = resultado[0]
            if contraseña == contraseña_bd:
                messagebox.showinfo("Inicio de sesión", "¡Acceso concedido!")
                ventana.destroy()
            else:
                messagebox.showerror("Error", "Contraseña incorrecta")
    except mariadb.Error as e:
        messagebox.showerror("Error", f"Error en la consulta: {e}")
    finally:
        cursor.close()
        connection.close()


ventana = tk.Tk()
ventana.title("Inicio de sesión")
ventana.geometry("400x500")
ventana.resizable(True, True)
ventana.configure(bg="Cyan")

# Etiqueta de usuario
label_usuario = tk.Label(ventana, text="Usuario:", font=("Arial", 14))
label_usuario.pack(pady=5)
entry_usuario = tk.Entry(ventana, font=("Arial", 14))
entry_usuario.pack(pady=5)

# Etiqueta de contraseña
label_contraseña = tk.Label(ventana, text="Contraseña:", font=("Arial", 14))
label_contraseña.pack(pady=5)
entry_contraseña = tk.Entry(ventana, font=("Arial", 14), show="*")
entry_contraseña.pack(pady=5)

# Botón de inicio de sesión
boton_ingresar = tk.Button(
    ventana,
    text="Ingresar",
    font=("Arial", 14),
    command=verificar_credenciales,
    bg="blue",
    fg="white",
)
boton_ingresar.pack(pady=20)

# Bucle de la ventana
ventana.mainloop()
