package AppControler;

import javax.swing.JPanel;


import javax.swing.JTextField;

import ejercicios.ejercicio05.model.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterView extends JPanel {

	private static final long serialVersionUID = 1L;
	protected App appController;
	private User user = new User();
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldContraseña;
	private JLabel lblUsername;
	private JLabel lblCrearCuenta;
	private JLabel lblContraseña;
	private JLabel lblEmail;
	private JLabel lblRepetirContraseña;
	private JTextField textFieldConfirmarContra;

	/**
	 * Create the panel.
	 */
	public RegisterView(App appController) {
		this.appController = appController;
		setLayout(null);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(153, 76, 109, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(153, 120, 109, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(153, 165, 109, 20);
		add(textFieldContraseña);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUsername.setBounds(153, 61, 72, 14);
		add(lblUsername);

		lblCrearCuenta = new JLabel("Crea tu cuenta");
		lblCrearCuenta.setForeground(new Color(255, 0, 0));
		lblCrearCuenta.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCrearCuenta.setBounds(128, 17, 179, 33);
		add(lblCrearCuenta);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblContraseña.setBounds(153, 151, 86, 14);
		add(lblContraseña);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEmail.setBounds(153, 107, 46, 14);
		add(lblEmail);

		lblRepetirContraseña = new JLabel("Confirmar contraseña");
		lblRepetirContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblRepetirContraseña.setBounds(153, 196, 135, 14);
		add(lblRepetirContraseña);

		textFieldConfirmarContra = new JTextField();
		textFieldConfirmarContra.setColumns(10);
		textFieldConfirmarContra.setBounds(153, 212, 109, 20);
		add(textFieldConfirmarContra);

		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCrearCuenta.setBackground(new Color(255, 0, 0));
		btnCrearCuenta.setForeground(new Color(227, 227, 227));
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				appController.metodoRegistrar(textFieldUsername.getText(), textFieldEmail.getText(),
						textFieldContraseña.getText());

				appController.mostrarPerfil(user);
			}
		});
		btnCrearCuenta.setBounds(153, 253, 109, 23);
		add(btnCrearCuenta);

	}

	public void setTextoRegister(String texto) {
		textFieldUsername.setText(texto);
	}
}
