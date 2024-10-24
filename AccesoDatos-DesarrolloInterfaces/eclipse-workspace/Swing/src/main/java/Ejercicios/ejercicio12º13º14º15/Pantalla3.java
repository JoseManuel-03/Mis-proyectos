package Ejercicios.ejercicio12º13º14º15;

import javax.swing.JPanel;


import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPantalla3;
	private App app;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Pantalla3(App app) {
		this.app = app;
		setLayout(null);
		
		txtPantalla3 = new JTextField();
		txtPantalla3.setText("Pantalla3");
		txtPantalla3.setBounds(128, 11, 170, 67);
		add(txtPantalla3);
		txtPantalla3.setColumns(10);
		
		JButton btnNewButton3 = new JButton("Ir a la pantalla 1");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla1(null);
			}
		});
		btnNewButton3.setBounds(128, 105, 170, 35);
		add(btnNewButton3);
		
		JButton btnIrALa_1 = new JButton("Ir a la pantalla 2");
		btnIrALa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla2(null);
			}
		});
		btnIrALa_1.setBounds(128, 151, 170, 35);
		add(btnIrALa_1);
		
		JButton btnIrALa = new JButton("Ir a la pantalla 3");
		btnIrALa.setBounds(128, 197, 170, 35);
		add(btnIrALa);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 254, 170, 20);
		add(textField);

	}
	public void setTexto3(String texto) {
		textField.setText(texto);
	}

}
