package EjerciciosRepaso.ejercicio1;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
				contenido = textField.getText();

				Integer numeroFinal = 0;
				try {

					if (KeyEvent.VK_UP == e.getKeyCode()) {
						numeroFinal = Integer.parseInt(contenido);
						numeroFinal++;

					} else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
						numeroFinal = Integer.parseInt(contenido);
						if (numeroFinal > 1) {
							numeroFinal--;
						}

					} else if (KeyEvent.VK_DOWN == e.getKeyCode()
							|| KeyEvent.VK_UP == e.getKeyCode() && contenido.isEmpty()) {
						numeroFinal = 1;

					} else {
						e.consume();
					}

					textField.setText(String.valueOf(numeroFinal));

				} catch (NumberFormatException er) {
					numeroFinal = 1;
					textField.setText(String.valueOf(numeroFinal));
				}
			}

		});

		textField.setForeground(new Color(255, 0, 0));
		textField.setBounds(144, 150, 122, 20);
		add(textField);
		textField.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Acepto la política de privacidad\r\n");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				chckbxNewCheckBox.setDisabledSelectedIcon(null);
				textField.setText("");
				textField.setEnabled(false);

			//	textField.setEnabled(true);

			}
		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(127, 218, 182, 23);
		add(chckbxNewCheckBox);
	}
}
