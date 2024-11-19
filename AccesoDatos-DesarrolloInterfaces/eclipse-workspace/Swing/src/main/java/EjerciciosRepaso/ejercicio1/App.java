package EjerciciosRepaso.ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {
	private JFrame frame;
	private View1 view1;
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

		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view1 = new View1();
		mostrarPantalla(); // inicializar metodo que muestra la pantalla       
														// previamente a ver echo la propiedad para incluir la pantalla
														//private View1 view1; 
	}
	public void mostrarPantalla() {  //metodo para mostrar pantalla
		frame.setContentPane(view1);  
		frame.revalidate();
	}
}
