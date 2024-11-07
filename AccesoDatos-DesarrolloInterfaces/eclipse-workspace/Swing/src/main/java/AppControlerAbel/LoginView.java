package AppControlerAbel;

import javax.swing.ImageIcon;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends View {

	private static final long serialVersionUID = 1L;
	private App controller;
	private JTextField tfUsuario;
	private JPasswordField tfPassword;

	/**
	 * Create the panel.
	 */
	public LoginView(App controller) {
		this.controller = controller;
		setLayout(null);
		

		JLabel lbUsuario = new JLabel("Usuario / Email:");
		lbUsuario.setBounds(168, 110, 106, 13);
		add(lbUsuario);
		
		JLabel lbPass = new JLabel("Contraseña:");
		lbPass.setBounds(168, 132, 106, 13);
		add(lbPass);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(295, 104, 122, 19);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(295, 126, 122, 19);
		add(tfPassword);
		
		JButton btAceptar = new JButton("Aceptar");
		btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.login(tfUsuario.getText(), new String(tfPassword.getPassword()));
			}
		});
		btAceptar.setBounds(316, 185, 135, 21);
		add(btAceptar);
		
		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openCreateForm();
			}
		});
		btnRegistrarme.setBounds(316, 215, 135, 21);
		add(btnRegistrarme);
		

	}
	
	public void initializeForm() {
		tfUsuario.setText("");
		tfPassword.setText("");
		tfUsuario.requestFocus();
	}
	
	
}
