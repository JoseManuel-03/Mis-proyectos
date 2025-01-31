import tkinter as tk

# Función para actualizar la pantalla
def click_button(value):
    current_text = entry.get()
    entry.delete(0, tk.END)  # Elimina el texto actual
    entry.insert(tk.END, current_text + str(value))  # Añade el valor al final

# Función para calcular la expresión
def calculate():
    try:
        expression = entry.get()
        result = eval(expression)  # Evalúa la expresión matemática
        entry.delete(0, tk.END)
        entry.insert(tk.END, str(result))
    except Exception as e:
        entry.delete(0, tk.END)
        entry.insert(tk.END, "Error")
# Función para borrar la pantalla
def clear():
    entry.delete(0, tk.END)

# Crear la ventana principal
root = tk.Tk()
root.title("Calculadora")

# Crear la pantalla de entrada
entry = tk.Entry(root, width=20, font=("Arial", 24), borderwidth=2, relief="solid", justify="right")
entry.grid(row=0, column=0, columnspan=4)

# Botones de la calculadora
buttons = [
    ('7', 1, 0), ('8', 1, 1), ('9', 1, 2), ('/', 1, 3),
    ('4', 2, 0), ('5', 2, 1), ('6', 2, 2), ('*', 2, 3),
    ('1', 3, 0), ('2', 3, 1), ('3', 3, 2), ('-', 3, 3),
    ('0', 4, 0), ('C', 4, 1), ('=', 4, 2), ('+', 4, 3)
]
# Crear los botones y asignarles la acción correspondiente
for (text, row, col) in buttons:
    if text == "=":
        button = tk.Button(root, text=text, width=5, height=2, font=("Arial", 18), command=calculate)
    elif text == "C":
        button = tk.Button(root, text=text, width=5, height=2, font=("Arial", 18), command=clear)
    else:
        button = tk.Button(root, text=text, width=5, height=2, font=("Arial", 18), command=lambda value=text: click_button(value))
    
    button.grid(row=row, column=col)

# Ejecutar la interfaz
root.mainloop()
