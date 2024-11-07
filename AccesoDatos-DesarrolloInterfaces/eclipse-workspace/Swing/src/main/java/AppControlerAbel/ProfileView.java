package AppControlerAbel;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ejercicios.ejercicio05.model.User;
import java.awt.Color;

public class ProfileView extends View {

	private static final long serialVersionUID = 1L;
	private App controller;
	private JTextField tfUserName;
	private JTextField tfCreateDate;
	private JTextField tfEmail;
	private JTextField tfLastLogin;

	/**
	 * Create the panel.
	 */
	public ProfileView(App controller) {
		this.controller = controller;
		setLayout(null);
		
	
		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbUsuario.setBounds(165, 36, 60, 13);
		add(lbUsuario);
		
		JLabel lbFechaAlta = new JLabel("Fecha alta:");
		lbFechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFechaAlta.setBounds(117, 94, 108, 13);
		add(lbFechaAlta);
		
		tfUserName = new JTextField();
		tfUserName.setEditable(false);
		tfUserName.setBounds(252, 33, 122, 19);
		add(tfUserName);
		tfUserName.setColumns(10);
		
		tfCreateDate = new JTextField();
		tfCreateDate.setEditable(false);
		tfCreateDate.setBounds(252, 91, 122, 19);
		add(tfCreateDate);
		
		JButton btnImportararchivo = new JButton("ImportarArchivo");
		btnImportararchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.chooserFile();
			}
		});
		btnImportararchivo.setBackground(Color.RED);
		btnImportararchivo.setBounds(237, 157, 203, 21);
		add(btnImportararchivo);
		
		JButton btSalir = new JButton("Salir");
		btSalir.setBackground(new Color(255, 0, 0));
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		btSalir.setBounds(237, 221, 203, 21);
		add(btSalir);
		
		JButton btCambiarPass = new JButton("Cambiar contraseña");
		btCambiarPass.setBackground(new Color(255, 0, 0));
		btCambiarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openChangePassword();
			}
		});
		btCambiarPass.setBounds(237, 189, 203, 21);
		add(btCambiarPass);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmail.setBounds(165, 65, 60, 13);
		add(lbEmail);
		
		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(252, 62, 122, 19);
		add(tfEmail);
		
		JLabel lbFechaUltLogin = new JLabel("Fecha último login:");
		lbFechaUltLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFechaUltLogin.setBounds(89, 123, 136, 13);
		add(lbFechaUltLogin);
		
		tfLastLogin = new JTextField();
		tfLastLogin.setEditable(false);
		tfLastLogin.setBounds(252, 120, 122, 19);
		add(tfLastLogin);
		
		
	}
	
	public void updateUserData(User user) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		tfEmail.setText(user.getEmail());
		tfUserName.setText(user.getUsername());
		tfCreateDate.setText(formatter.format(user.getCreatedDate()));
		tfLastLogin.setText(formatter.format(user.getLastLoginDate()));
	}
	
	
}
