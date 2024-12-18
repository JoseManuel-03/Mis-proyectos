package AppControlerAbel;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import ceu.dam.ad.ejerciciosTema3.csv.ejercicio02.Ejercicio02ServiceImpl;
import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;
import ejercicios.ejercicio05.model.User;
import ejercicios.ejercicio05.service.DuplicateUserException;
import ejercicios.ejercicio05.service.UserException;
import ejercicios.ejercicio05.service.UserNotFoundException;
import ejercicios.ejercicio05.service.UserService;
import ejercicios.ejercicio05.service.UserServiceImpl;
import ejercicios.ejercicio05.service.UserUnauthorizedException;

public class App {

	private JFrame frame;
	private LoginView loginView;
	private CreateUserView registroView;
	private ChangePassView changePassView;
	private ProfileView profileView;
	private UserService userService;
	private User userSession;
	private Ejercicio02ServiceImpl serviceEjer02;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		serviceEjer02 = new Ejercicio02ServiceImpl();
		loginView = new LoginView(this);
		registroView = new CreateUserView(this);
		changePassView = new ChangePassView(this);
		profileView = new ProfileView(this);
		userService = new UserServiceImpl();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		logout();

	}

	public void logout() {
		userSession = null;
		changeView(loginView);
	}

	public void chooserFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selecciona archivo");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheros csv", "csv");
		Integer selection = fileChooser.showOpenDialog(frame);
		fileChooser.setFileFilter(filter);
		if (selection == JFileChooser.APPROVE_OPTION) {
			File fileToOpen = fileChooser.getSelectedFile();
			try {
				serviceEjer02.importarUsuarioCSV(fileToOpen.getAbsolutePath());

			} catch (CsvException e) {
				e.printStackTrace();
			}
		}
	}

	public void login(String login, String password) {
		try {
			userSession = userService.login(login, password);
			openProfile();
		} catch (UserNotFoundException | UserUnauthorizedException | UserException e) {
			showError(e.getMessage());
		}

	}

	public void createUser(String username, String email, String pass, String pass2) {
		if (username.isBlank() || email.isBlank() || pass.isBlank()) {
			showError("Todos los campos son obligatorios");
			return;
		}
		if (!pass.equals(pass2)) {
			showError("Las contraseñas no coinciden");
			return;
		}
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(pass);
		try {
			userService.createUser(user);
			showConfirm("Usuario registrado correctamente");
			changeView(loginView);
		} catch (DuplicateUserException | UserException e) {
			showError(e.getMessage());
		}

	}

	public void changePass(String passOld, String passNew, String passNew2) {
		try {
			if (passNew.isBlank()) {
				showError("Todos los campos son obligatorios");
				return;
			}
			if (!passNew.equals(passNew2)) {
				showError("Las contraseñas nuevas no coinciden");
				return;
			}
			userService.changePassword(userSession.getId(), passOld, passNew);
			showConfirm("Contraseña cambiada!!");
			openProfile();
		} catch (UserNotFoundException | UserUnauthorizedException | UserException e) {
			showError(e.getMessage());
		}
	}

	public void openCreateForm() {
		changeView(registroView);
	}

	public void openProfile() {
		changeView(profileView);
		profileView.updateUserData(userSession);
	}

	public void openChangePassword() {
		changeView(changePassView);
	}

	private void changeView(View panel) {
		frame.setContentPane(panel);
		frame.revalidate();
		panel.initializeForm();
	}

	private void showError(String msg) {

		JOptionPane.showMessageDialog(frame, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void showConfirm(String msg) {
		JOptionPane.showMessageDialog(frame, msg, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}

}
