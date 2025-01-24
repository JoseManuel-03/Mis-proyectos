import tkinter as tk
from tkinter import messagebox, PhotoImage

# Función para validar la contraseña
def verificar_credenciales():
    usuario_valido = "admin"
    contraseña_valida = "1234"

    usuario = entry_usuario.get()
    contraseña = entry_contraseña.get()

    if usuario == usuario_valido and contraseña == contraseña_valida:
        messagebox.showinfo("Inicio de sesión", "¡Acceso concedido!")
        ventana.destroy()  # Cerrar la ventana al iniciar sesión
    else:
        messagebox.showerror("Error", "Usuario o contraseña incorrectos")

# Crear ventana principal
ventana = tk.Tk()
ventana.title("Inicio de sesión")
ventana.geometry("400x500")
ventana.resizable(False, False)
ventana.configure(bg="white")

# Cargar el logo (Asegúrate de tener un archivo 'logo.gif' en el mismo directorio)
try:
    logo = PhotoImage(file="logo.gif")
    label_logo = tk.Label(ventana, image=logo, bg="white")
    label_logo.pack(pady=20)
except:
    label_logo = tk.Label(ventana, text="[ LOGO ]", font=("Arial", 20, "bold"), bg="white")
    label_logo.pack(pady=20)

# Etiqueta de usuario
label_usuario = tk.Label(ventana, text="Usuario:", font=("Arial", 14), bg="white")
label_usuario.pack(pady=5)
entry_usuario = tk.Entry(ventana, font=("Arial", 14))
entry_usuario.pack(pady=5)

# Etiqueta de contraseña
label_contraseña = tk.Label(ventana, text="Contraseña:", font=("Arial", 14), bg="white")
label_contraseña.pack(pady=5)
entry_contraseña = tk.Entry(ventana, font=("Arial", 14), show="*")  # Oculta la contraseña
entry_contraseña.pack(pady=5)

# Botón de inicio de sesión
boton_ingresar = tk.Button(ventana, text="Ingresar", font=("Arial", 14), command=verificar_credenciales, bg="blue", fg="white")
boton_ingresar.pack(pady=20)

# Bucle de la ventana
ventana.mainloop()
