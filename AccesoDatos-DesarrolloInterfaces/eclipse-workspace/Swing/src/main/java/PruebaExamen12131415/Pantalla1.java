package PruebaExamen12131415;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla1 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7182746337814078971L;
	private AppControler app;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Pantalla1(AppControler app) {
		this.app=app;
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(172, 36, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("Ir a pantalla1");
		btn1.setBounds(141, 113, 144, 23);
		add(btn1);
		
		JButton btn2 = new JButton("Ir a pantalla2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.cambiarAPantalla2(textField.getText());
			}
		});
		btn2.setBounds(141, 155, 142, 23);
		add(btn2);
		
		JButton btn3 = new JButton("Ir a pantalla 3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.cambiarAPantalla3(textField.getText());
			}
		});
		btn3.setBounds(141, 196, 144, 23);
		add(btn3);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.salir();
			}
		});
		btnSalir.setBounds(256, 229, 123, 21);
		add(btnSalir);
	}
		
		
	
	public void cambiarTexto(String texto) {
		textField.setText(texto);
	}
}
