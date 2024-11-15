package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 window = new Ejercicio5();
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
	public Ejercicio5() {
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
				if (textoBoton.isEmpty()) {
					lblLabel.setText(textoBoton = "1");
				} else {
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
