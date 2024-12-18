package PruebaExamen12131415;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla2 extends JPanel {

	private static final long serialVersionUID = -7819758235854662421L;;
	private AppControler app;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Pantalla2(AppControler app) {
		this.app = app;
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(174, 35, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("Ir a pantalla1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.cambiarAPantalla1(textField.getText());
			}
		});
		btn1.setBounds(149, 114, 134, 23);
		add(btn1);
		
		JButton btn2 = new JButton("Ir a pantalla 2");
		btn2.setBounds(149, 156, 134, 23);
		add(btn2);
		
		JButton btn3 = new JButton("Ir a pantalla 3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.cambiarAPantalla3(textField.getText());
			}
		});
		btn3.setBounds(149, 197, 134, 23);
		add(btn3);

	}
	public void cambiarTexto(String texto) {
		textField.setText(texto);
	}

}
