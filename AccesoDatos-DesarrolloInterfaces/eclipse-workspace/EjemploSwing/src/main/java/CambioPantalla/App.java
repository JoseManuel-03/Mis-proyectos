package CambioPantalla;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	private JFrame frame;
	private JPanel login;
	private JPanel bienvenida;

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
		login = new LoginPantalla(this);
		bienvenida = new BienvenidaPantalla(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(login);
	}
	
	public void abrirBienvenida() {
		frame.setContentPane(bienvenida);
		frame.revalidate();
		
	}
	
	public void  abrirLogin() {
		frame.setContentPane(login);
		frame.revalidate();
		
	}
	

}
