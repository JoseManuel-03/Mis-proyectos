import tkinter as tk

# Crear ventana principal
root = tk.Tk()
root.title("Ejemplos de Tkinter")

# 1. Label() - Crear etiqueta
label = tk.Label(root, text="Hola Mundo")
label.pack()

# 2. Button() - Crear botón
def saludar():
    label.config(text="¡Hola, has hecho clic!")
button = tk.Button(root, text="Haz clic", command=saludar)
button.pack()

# 3. Entry() - Campo de texto de una línea
entry = tk.Entry(root)
entry.pack()

# 4. Text() - Área de texto para múltiples líneas
text = tk.Text(root, height=5, width=20)
text.pack()

# 5. Frame() - Crear un marco (contenedor)
frame = tk.Frame(root)
frame.pack()

# 6. Canvas() - Crear un área de dibujo
canvas = tk.Canvas(root, width=200, height=200, bg="lightgray")
canvas.create_rectangle(50, 50, 150, 150, fill="blue")
canvas.pack()

# 7. Radiobutton() - Crear botones de opción
var_radio = tk.IntVar()
radiobutton1 = tk.Radiobutton(root, text="Opción 1", variable=var_radio, value=1)
radiobutton2 = tk.Radiobutton(root, text="Opción 2", variable=var_radio, value=2)
radiobutton1.pack()
radiobutton2.pack()

# 8. Checkbutton() - Crear casilla de verificación
var_check = tk.BooleanVar()
check = tk.Checkbutton(root, text="Aceptar términos", variable=var_check)
check.pack()

# 9. Listbox() - Crear lista de elementos con Scrollbar
frame_list = tk.Frame(root)
frame_list.pack()

scrollbar = tk.Scrollbar(frame_list, orient=tk.VERTICAL)
listbox = tk.Listbox(frame_list, yscrollcommand=scrollbar.set)
scrollbar.config(command=listbox.yview)

listbox.pack(side=tk.LEFT)
scrollbar.pack(side=tk.RIGHT, fill=tk.Y)

listbox.insert(tk.END, "Elemento 1")
listbox.insert(tk.END, "Elemento 2")
listbox.insert(tk.END, "Elemento 3")

# 10. OptionMenu() - Crear menú desplegable
var_menu = tk.StringVar(value="Opción 1")
dropdown = tk.OptionMenu(root, var_menu, "Opción 1", "Opción 2", "Opción 3")
dropdown.pack()

# 11. Toplevel() - Crear ventana secundaria
def abrir_ventana():
    new_window = tk.Toplevel(root)
    new_window.title("Ventana Secundaria")
    label = tk.Label(new_window, text="Esta es una nueva ventana")
    label.pack()
button2 = tk.Button(root, text="Abrir Ventana", command=abrir_ventana)
button2.pack()

# 12. Grid() - Posicionar widgets en una cuadrícula
frame_grid = tk.Frame(root)
frame_grid.pack()

label1 = tk.Label(frame_grid, text="Nombre:")
label1.grid(row=0, column=0)
entry1 = tk.Entry(frame_grid)
entry1.grid(row=0, column=1)

# 13. Pack() - Otro ejemplo de pack
button3 = tk.Button(root, text="Botón con Pack")
button3.pack()

# 14. Place() - Posicionar widgets en coordenadas específicas
button4 = tk.Button(root, text="Botón con Place")
button4.place(x=100, y=250)

# Ejecutar la interfaz
root.mainloop()
 