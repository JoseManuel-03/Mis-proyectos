package AppControler;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;

import ejercicios.ejercicio05.model.User;
import ejercicios.ejercicio05.service.UserException;
import ejercicios.ejercicio05.service.UserNotFoundException;
import ejercicios.ejercicio05.service.UserServiceImpl;
import ejercicios.ejercicio05.service.UserUnauthorizedException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JPanel {

	private static final long serialVersionUID = 1L;
	protected App appController;
	private JTextField textFieldContrase;
	private JTextField textFieldUserEmail;
	private User user = new User();
	protected UserServiceImpl servie;
	/**
	 * Create the panel.
	 */
	public LoginView(App appController) {
		this.appController = appController;
		servie= new UserServiceImpl();
		setLayout(null);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblContraseña.setBounds(132, 140, 86, 14);
		add(lblContraseña);

		textFieldContrase = new JTextField();
		textFieldContrase.setColumns(10);
		textFieldContrase.setBounds(132, 154, 219, 20);
		add(textFieldContrase);

		JLabel lblUsernameEmail = new JLabel("Username/Email");
		lblUsernameEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUsernameEmail.setBounds(132, 95, 86, 14);
		add(lblUsernameEmail);

		textFieldUserEmail = new JMyTextField();
		textFieldUserEmail.setColumns(10);
		textFieldUserEmail.setBounds(132, 109, 219, 20);
		add(textFieldUserEmail);

		JLabel lblLogin = new JLabel("Login ");
		lblLogin.setForeground(new Color(255, 0, 0));
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblLogin.setBounds(191, 22, 86, 58);
		add(lblLogin);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					user = servie.login(textFieldUserEmail.getText(), textFieldContrase.getText());
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserUnauthorizedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				appController.mostrarPerfil(user);
			}
		});
		btnLogin.setForeground(UIManager.getColor("Button.light"));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnLogin.setBackground(Color.RED);
		btnLogin.setBounds(132, 210, 219, 23);
		add(btnLogin);

		JLabel lblnoTieneCuenta = new JLabel("¿No tiene cuenta?");
		lblnoTieneCuenta.setBounds(128, 249, 106, 14);
		add(lblnoTieneCuenta);

		JButton btnCrear = new JButton("Crear Cuenta");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.mostrarRegistrar(textFieldUserEmail.getText());
			}
		});
		btnCrear.setForeground(UIManager.getColor("Button.light"));
		btnCrear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCrear.setBackground(Color.RED);
		btnCrear.setBounds(234, 249, 106, 14);
		add(btnCrear);

	}

	
}
