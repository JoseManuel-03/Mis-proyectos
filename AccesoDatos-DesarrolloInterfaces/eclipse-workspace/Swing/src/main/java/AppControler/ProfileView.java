package AppControler;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Ejercicio4.Modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

public class ProfileView extends JPanel {

	private static final long serialVersionUID = 1L;
	protected App appController;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblFecha;
	private JLabel lblTuPerfil;
	private JLabel lblFechaUltimaA;

	/**
	 * Create the panel.
	 */
	public ProfileView(App appController) {
		this.appController = appController;
		setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(150, 85, 109, 20);
		add(textField);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUsername.setBounds(150, 70, 72, 14);
		add(lblUsername);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEmail.setBounds(150, 116, 46, 14);
		add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 129, 109, 20);
		add(textField_1);

		lblFecha = new JLabel("Fecha Alta");
		lblFecha.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFecha.setBounds(150, 160, 86, 14);
		add(lblFecha);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 174, 109, 20);
		add(textField_2);

		lblFechaUltimaA = new JLabel("Fecha Último Login");
		lblFechaUltimaA.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFechaUltimaA.setBounds(150, 205, 135, 14);
		add(lblFechaUltimaA);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 221, 109, 20);
		add(textField_3);

		JLabel lblTuPerfil = new JLabel("Tu Perfil");
		lblTuPerfil.setForeground(Color.RED);
		lblTuPerfil.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblTuPerfil.setBounds(163, 24, 86, 33);
		add(lblTuPerfil);

		JLabel lblquieresCambiarTu = new JLabel("¿Cambiar tu contraseña?");
		lblquieresCambiarTu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appController.mostrarContraseña(textField_1.getText());
			}
		});
		lblquieresCambiarTu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblquieresCambiarTu.setBounds(150, 252, 122, 14);
		add(lblquieresCambiarTu);

	}

	public void setTextoPerfil(String texto) {
		textField.setText(texto);
	}

	public void actualizarUsuario(Usuario user) {
		lblUsername.setText(user.getUsername());
		lblEmail.setText(user.getEmail());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		lblFecha.setText(user.getFechaAlta().format(formatter));
		lblFechaUltimaA.setText(user.getFechaUltLogin().format(formatter));

	}

}
