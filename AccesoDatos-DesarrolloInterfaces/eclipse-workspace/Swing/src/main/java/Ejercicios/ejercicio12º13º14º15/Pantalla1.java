package Ejercicios.ejercicio12º13º14º15;

import javax.swing.JPanel;

import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.TextField;
import java.awt.event.ActionEvent;

public class Pantalla1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPantalla1;
	private App app;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Pantalla1(App app) {
		this.app = app;
		setLayout(null);
		
		
		JButton btnNewButton1 = new JButton("Ir a la pantalla 2");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla2(null);
			}
		});
		btnNewButton1.setBounds(131, 149, 163, 36);
		add(btnNewButton1);
		
		
		
		JButton btnNewButton_1 = new JButton("Ir a la pantalla 3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla3(null);
			}
		});
		btnNewButton_1.setBounds(131, 196, 163, 36);
		add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(141, 243, 153, 20);
		add(textField);
		textField.setColumns(10);
		this.setTexto1(textField.getText());
		
		JButton btnNewButton = new JButton("Ir a la pantalla 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla1(textField.getText());
			}
		});
		
		btnNewButton.setBounds(131, 102, 163, 36);
		add(btnNewButton);
		
		
		
		
	}
	public void setTexto1(String texto) {
		textField.setText(texto);
	}
}
