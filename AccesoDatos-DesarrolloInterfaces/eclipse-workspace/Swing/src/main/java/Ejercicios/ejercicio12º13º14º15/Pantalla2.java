package Ejercicios.ejercicio12º13º14º15;

import javax.swing.JPanel;

import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla2 extends JPanel {

	private static final long serialVersionUID = -7819758235854662421L;
	private JTextField txtPantalla2;
	private App app;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public Pantalla2(App app) {
		this.app = app;
		setLayout(null);
		
		txtPantalla2 = new JTextField();
		txtPantalla2.setText("Pantalla2");
		txtPantalla2.setBounds(154, 21, 153, 56);
		add(txtPantalla2);
		txtPantalla2.setColumns(10);

		
		JButton btnNewButton2 = new JButton("Ir a la pantalla 3");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla3(null);
			}
		});
		btnNewButton2.setBounds(154, 195, 153, 35);
		add(btnNewButton2);
		
		JButton btnIrALa_1 = new JButton("Ir a la pantalla 2");
		btnIrALa_1.setBounds(154, 149, 153, 35);
		add(btnIrALa_1);
		
		JButton btnIrALa = new JButton("Ir a la pantalla 1");
		btnIrALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirPantalla1(null);
				
			}
		});
		btnIrALa.setBounds(154, 103, 153, 35);
		add(btnIrALa);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 251, 153, 20);
		add(textField);
		this.setTexto2(textField.getText());

	}
	public void setTexto2(String texto) {
		textField.setText(texto);
	}

}
