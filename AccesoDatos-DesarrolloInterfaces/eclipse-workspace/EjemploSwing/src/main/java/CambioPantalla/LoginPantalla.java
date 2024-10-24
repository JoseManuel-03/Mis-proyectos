package CambioPantalla;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPantalla extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;

	/**
	 * Create the panel.
	 */
	public LoginPantalla(App app) {
		this.app = app;
		setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(172, 99, 46, 14);
		add(lblLogin);

		JButton btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.abrirBienvenida();
				
			}
		});

		btnLogin.setBounds(150, 189, 84, 40);
		add(btnLogin);

	}

}
