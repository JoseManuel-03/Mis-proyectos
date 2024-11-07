package AppControlerAbel;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;


public class CreateUserView extends View {

	private static final long serialVersionUID = 1L;
	private App controller;
	private JTextField tfUsuario;
	private JPasswordField tfPassword;
	private JTextField tfEmail;
	private JPasswordField tfPassword2;

	/**
	 * Create the panel.
	 */
	public CreateUserView(App controller) {
		this.controller = controller;
		setLayout(null);

	

		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbUsuario.setBounds(169, 64, 60, 13);
		add(lbUsuario);
		
		JLabel lbPass = new JLabel("Contraseña:");
		lbPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPass.setBounds(121, 122, 108, 13);
		add(lbPass);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(256, 61, 122, 19);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(256, 119, 122, 19);
		add(tfPassword);
		
		JButton btAceptar = new JButton("Aceptar");
		btAceptar.setBackground(new Color(255, 0, 0));
		btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.createUser(tfUsuario.getText(), 
						tfEmail.getText(),
						new String(tfPassword.getPassword()),
						new String(tfPassword2.getPassword()));
			}
		});
		btAceptar.setBounds(252, 195, 136, 21);
		add(btAceptar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBackground(new Color(255, 0, 0));
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		btCancelar.setBounds(252, 238, 136, 21);
		add(btCancelar);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmail.setBounds(169, 93, 60, 13);
		add(lbEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(256, 90, 122, 19);
		add(tfEmail);
		
		JLabel lblRepiteContrasea = new JLabel("Repite contraseña:");
		lblRepiteContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepiteContrasea.setBounds(93, 151, 136, 13);
		add(lblRepiteContrasea);
		
		tfPassword2 = new JPasswordField();
		tfPassword2.setBounds(256, 148, 122, 19);
		add(tfPassword2);
	}
	
	@Override
	public void initializeForm() {
		tfEmail.setText("");
		tfUsuario.setText("");
		tfPassword.setText("");
		tfPassword2.setText("");
		tfUsuario.requestFocus();
	}
	
}
