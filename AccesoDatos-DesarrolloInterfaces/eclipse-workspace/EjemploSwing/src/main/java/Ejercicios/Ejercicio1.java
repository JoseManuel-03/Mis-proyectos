package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ejercicio1 {

	private JFrame frame;
	private JTextField text1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 window = new Ejercicio1();
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
	public Ejercicio1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		text1 = new JTextField();
		text1.setText("Hola mundo");
		text1.setBounds(153, 55, 86, 20);
		frame.getContentPane().add(text1);
		text1.setColumns(10);
	}
}
