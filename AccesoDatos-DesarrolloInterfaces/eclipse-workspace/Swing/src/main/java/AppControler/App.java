package AppControler;

import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejercicios.ejercicio05.model.User;
import ejercicios.ejercicio05.service.UserException;
import ejercicios.ejercicio05.service.UserNotFoundException;
import ejercicios.ejercicio05.service.UserServiceImpl;
import ejercicios.ejercicio05.service.UserUnauthorizedException;

public class App {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	private JFrame frame;
	private RegisterView registrar;
	private LoginView login;
	private ProfileView perfil;
	private ChangeView contraseña;
	private UserServiceImpl services = new UserServiceImpl();
	private User userNew;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userNew = new User();

		registrar = new RegisterView(this);
		login = new LoginView(this);
		perfil = new ProfileView(this);
		contraseña = new ChangeView(this);
		mostrarLogin();

	}

	public void mostrarRegistrar(String texto) {
		frame.setContentPane(registrar);
		frame.revalidate();

	}

	public void mostrarLogin() {
		frame.setContentPane(login);
		frame.revalidate();
	}

	public void mostrarPerfil(User user) {
		frame.setContentPane(perfil);
		if (user !=null) {
			perfil.actualizarUser(user);			
		}
		frame.revalidate();
	}

	public void mostrarContraseña(User user) {
		frame.setContentPane(contraseña);
		contraseña.actualizarUser(user);
		frame.revalidate();
	}

	public void metodoContraseña(Long id, String antiguaContraseña, String nuevaContraseña) {
		try {
			services.changePassword(id, antiguaContraseña, nuevaContraseña);
		} catch (UserNotFoundException e) {

			e.printStackTrace();
		} catch (UserUnauthorizedException e) {

			e.printStackTrace();
		} catch (UserException e) {

			e.printStackTrace();
		}
	}


	public User metodoRegistrar(String username, String email, String password) {
		try {
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setCreatedDate(LocalDate.now());

			return user = services.createUser(user);
		} catch (Exception e) {
			log.error("Error en el registro", e);
		}
		return null;
	}
}
