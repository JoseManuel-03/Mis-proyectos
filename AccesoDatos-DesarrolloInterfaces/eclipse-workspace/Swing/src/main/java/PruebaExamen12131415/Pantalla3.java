package PruebaExamen12131415;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla3 extends JPanel {

	private static final long serialVersionUID = -7819758235854662421L;
	private AppControler app;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Pantalla3(AppControler app) {
		this.app = app;
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(173, 41, 86, 20);
		add(textField);
		textField.setColumns(10);

		JButton btn1 = new JButton("Ir a pantalla 1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.cambiarAPantalla1(textField.getText());
			}
		});
		btn1.setBounds(144, 132, 149, 23);
		add(btn1);

		JButton btn2 = new JButton("Ir a pantalla 2 ");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.cambiarAPantalla2(textField.getText());
			}
		});
		btn2.setBounds(144, 173, 149, 23);
		add(btn2);

		JButton btn3 = new JButton("Ir a pantalla 3 ");
		btn3.setBounds(144, 213, 149, 23);
		add(btn3);
	}

	public void cambiarTexto(String texto) {
		textField.setText(texto);
	}

}
