package Ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 window = new Ejercicio6();
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
	public Ejercicio6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblLabel = new JLabel("");
		lblLabel.setBounds(65, 168, 319, 56);
		frame.getContentPane().add(lblLabel);
		
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSumar.setBounds(7, 7, 434, 67);
		frame.getContentPane().add(btnSumar);
		
		btnSumar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String textoBoton = lblLabel.getText();
				if(textoBoton.isEmpty()) {
					lblLabel.setText(textoBoton = "1");
				}else {
					String textoLabel = lblLabel.getText();
					Integer numero = Integer.parseInt(textoLabel);
					Integer suma = numero + 1;
					textoLabel = String.valueOf(suma);
					lblLabel.setText(textoLabel);
				}
				
			}
		});
	}

}
