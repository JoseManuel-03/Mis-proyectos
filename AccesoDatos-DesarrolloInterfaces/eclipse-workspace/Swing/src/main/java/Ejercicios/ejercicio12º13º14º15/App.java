package Ejercicios.ejercicio12º13º14º15;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	private JFrame frame;
	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(pantalla1);
	}

	public void abrirPantalla1(String texto) {
		frame.setContentPane(pantalla1);
		pantalla1.setTexto1(texto);
		frame.revalidate();
	}

	public void abrirPantalla2(String texto) {
		frame.setContentPane(pantalla2);
		pantalla2.setTexto2(texto);
		frame.revalidate();
	}

	public void abrirPantalla3(String texto) {
		frame.setContentPane(pantalla3);
		pantalla3.setTexto3(texto);
		frame.revalidate();
	}
	

}
