package AppControler;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;


public class ChangeView extends JPanel {

	private static final long serialVersionUID = 1L;
	protected App appController;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public ChangeView(App appController) {
		this.appController = appController;
		setLayout(null);

		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		lblNuevaContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNuevaContrasea.setBounds(139, 121, 124, 14);
		add(lblNuevaContrasea);

		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar nueva contraseña");
		lblConfirmarNuevaContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblConfirmarNuevaContrasea.setBounds(139, 166, 165, 14);
		add(lblConfirmarNuevaContrasea);

		JLabel lblAntiguaContrasea = new JLabel("Antigua Contraseña");
		lblAntiguaContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAntiguaContrasea.setBounds(139, 77, 135, 14);
		add(lblAntiguaContrasea);

		JLabel lblCambiaTuContrasea = new JLabel("Cambia tu contraseña");
		lblCambiaTuContrasea.setForeground(Color.RED);
		lblCambiaTuContrasea.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblCambiaTuContrasea.setBounds(118, 19, 209, 33);
		add(lblCambiaTuContrasea);

		JButton btnConfirmar = new JButton("Confirmar ");
		btnConfirmar.setForeground(UIManager.getColor("Button.light"));
		btnConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnConfirmar.setBackground(Color.RED);
		btnConfirmar.setBounds(165, 225, 109, 23);
		add(btnConfirmar);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 90, 219, 20);
		add(textField_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 135, 219, 20);
		add(textField_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(108, 179, 219, 20);
		add(textField_4);

	}
	public void setTextoContraseña(String texto) {
		textField_3.setText(texto);
	}

}
