package PruebaExamen12131415;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppControler {

	private JFrame frame;
	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;
	private PantallaBienvenida pantallaBienvenida;
	private Boolean mantenerTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppControler window = new AppControler();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppControler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		pantallaBienvenida = new PantallaBienvenida(this);
		cambiarAPantallaBienvenida();
	}

	public void cambiarAPantalla1(String texto) {
		frame.setContentPane(pantalla1);
		pantalla1.cambiarTexto(texto);
		frame.revalidate();

	}

	public void cambiarAPantalla2(String texto) {
		frame.setContentPane(pantalla2);
		pantalla2.cambiarTexto(texto);
		frame.revalidate();

	}

	public void cambiarAPantalla3(String texto) {

		frame.setContentPane(pantalla3);
		pantalla3.cambiarTexto(texto);
		frame.revalidate();
	}

	public void cambiarAPantallaBienvenida() {
		frame.setContentPane(pantallaBienvenida);
		frame.revalidate();
	}

	public void entrar(Integer selectedIndex, boolean mantenerTexto) {
		this.mantenerTexto = mantenerTexto;
		switch (selectedIndex) {
		case 0: {
			cambiarAPantalla1("");
		}
		case 1: {
			cambiarAPantalla2("");
		}
		case 2: {
			cambiarAPantalla3("");
		}
		}

	}
	
	public void salir() {
		Integer option = JOptionPane.showConfirmDialog(frame, "¿Está seguro de salir?","Salir", JOptionPane.YES_NO_OPTION);
		if (option == 0) {
			System.exit(0);
		}
	}

}
