package AppControler;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;

import ejercicios.ejercicio05.model.User;
import ejercicios.ejercicio05.service.UserException;
import ejercicios.ejercicio05.service.UserNotFoundException;
import ejercicios.ejercicio05.service.UserUnauthorizedException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ChangeView extends JPanel {

		private static final long serialVersionUID = 1L;
		private JPasswordField passwordFieldActual;
		private JPasswordField passwordFieldNueva;
		private App appControler;
		private User user = new User();
		/**
		 * Create the panel.
		 */
		public ChangeView(App appControler) {
			
			this.appControler = appControler;
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Contraseña actual:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel.setBounds(29, 103, 132, 14);
			add(lblNewLabel);
			JLabel lblNewLabel_1 = new JLabel("Contraseña nueva:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(29, 172, 115, 14);
			add(lblNewLabel_1);
			JLabel LabelTitulo = new JLabel("Change Password");
			LabelTitulo.setForeground(new Color(255, 0, 0));
			LabelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 22));
			LabelTitulo.setBounds(113, 10, 233, 63);
			add(LabelTitulo);
			passwordFieldActual = new JPasswordField();
			passwordFieldActual.setBounds(167, 100, 164, 20);
			add(passwordFieldActual);
			passwordFieldNueva = new JPasswordField();
			passwordFieldNueva.setBounds(167, 169, 164, 20);
			add(passwordFieldNueva);
			JButton btnNewButton = new JButton("Cambia la contraseña");
			btnNewButton.setBackground(new Color(255, 0, 0));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String passwordBien1 = new String(passwordFieldActual.getPassword());
					String passwordBien2 = new String(passwordFieldNueva.getPassword());
					appControler.metodoContraseña(user.getId(), passwordBien1, passwordBien2);
					//appControler.servicioChangePassword(user.getId(), passwordBien1, passwordBien2);
				}
			});
			btnNewButton.setBounds(123, 248, 187, 23);
			add(btnNewButton);
	 
		}
		public void actualizarUser(User user) {
			this.user = user;
		}
	}