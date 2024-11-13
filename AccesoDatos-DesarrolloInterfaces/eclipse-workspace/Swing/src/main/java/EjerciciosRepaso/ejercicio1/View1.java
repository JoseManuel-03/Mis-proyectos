package EjerciciosRepaso.ejercicio1;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public View1() {
		setLayout(null);

		JLabel lblEdad = new JLabel("Edad del usuario:");
		lblEdad.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdad.setBounds(156, 104, 150, 35);
		add(lblEdad);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {

			String contenido = lblEdad.getText();

			@Override
			public void keyTyped(KeyEvent e) {
				contenido = lblEdad.getText();
				if (Character.isDigit(e.getKeyChar())) {
					lblEdad.setText(contenido);
				} else {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				contenido = lblEdad.getText();
				if (KeyEvent.VK_UP == e.getKeyCode()) {

				}
			}
		});

		textField.setForeground(new Color(255, 0, 0));
		textField.setBounds(144, 150, 122, 20);
		add(textField);
		textField.setColumns(10);

	}
}
