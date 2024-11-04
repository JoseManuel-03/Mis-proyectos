package AppControler;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ejercicio4.Modelo.Usuario;
import Ejercicio4.Services.ErrorCambiandoPasswordException;
import Ejercicio4.Services.HayUsuariosException;
import Ejercicio4.Services.NoHayUsuariosException;
import Ejercicio4.Services.UserService;

public class App {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	private JFrame frame;
	private RegisterView registrar;
	private LoginView login;
	private ProfileView perfil;
	private ChangeView contraseña;
	private UserService services = new UserService();

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

		registrar = new RegisterView(this);
		login = new LoginView(this);
		perfil = new ProfileView(this);
		contraseña = new ChangeView(this);
		mostrarLogin();

	}

	public void mostrarRegistrar(String texto) {
		frame.setContentPane(registrar);
		frame.revalidate();
		registrar.setTextoRegister(texto);
	}

	public void mostrarLogin() {
		frame.setContentPane(login);
		frame.revalidate();
	}

	public void mostrarPerfil(String texto) {
		frame.setContentPane(perfil);
		perfil.setTextoPerfil(texto);
		frame.revalidate();
	}

	public void mostrarContraseña(String texto) {
		frame.setContentPane(contraseña);
		contraseña.setTextoContraseña(texto);
		frame.revalidate();
	}

	public void metodoContraseña(Long id, String antiguaConstraseña, String nuevaContraseña)
			throws ErrorCambiandoPasswordException {
		services.changePass(id, antiguaConstraseña, nuevaContraseña);
	}

	public void metodoPerfil(Long id) throws NoHayUsuariosException {
		perfil.actualizarUsuario(null);
		services.consult(id);
	}

	public void metodoLogin(String usuario, String contraseña) throws NoHayUsuariosException {
		try {
			services.login(usuario, contraseña);
		} catch (Exception e) {
			log.error("Error en el login", e);
		}
	}

	public void metodoRegistrar(String username, String email, String password) throws HayUsuariosException {
		try {

			Usuario user = new Usuario();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);

			services.registrer(user);
		} catch (Exception e) {
			log.error("Error en el registro", e);
		}
	}
}
