package AppControler;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ejercicios.ejercicio05.model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

public class ProfileView extends JPanel {

	private static final long serialVersionUID = 1L;
	private App appControler;
	private User user = new User();
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private String fechaComoString;
	private String fechaComoString2;

	
	
	public ProfileView(App appControler) {
		this.appControler = appControler;
		setLayout(null);
		
 
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		LabelUsuario.setBounds(65, 66, 46, 14);
		add(LabelUsuario);
 
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		LabelEmail.setBounds(65, 103, 46, 14);
		add(LabelEmail);
 
		JLabel LabelFechaUltimoInicio = new JLabel("Fecha ultimo inicio:");
		LabelFechaUltimoInicio.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		LabelFechaUltimoInicio.setBounds(63, 149, 139, 14);
		add(LabelFechaUltimoInicio);
 
		JLabel LabelFechaCreacion = new JLabel("Fecha creacion:");
		LabelFechaCreacion.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		LabelFechaCreacion.setBounds(65, 193, 98, 14);
		add(LabelFechaCreacion);
 
		JLabel lblNewLabel = new JLabel("Tu PERFIL");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 4, 139, 51);
		add(lblNewLabel);
 
		JLabel labelMostarUsuario = new JLabel("usuario");
		labelMostarUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelMostarUsuario.setBackground(new Color(128, 64, 0));
		labelMostarUsuario.setBounds(249, 66, 98, 14);
		add(labelMostarUsuario);
		this.label1 = labelMostarUsuario;
 
		JLabel labelMostrarEmail = new JLabel(user.getEmail());
		labelMostrarEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelMostrarEmail.setBackground(new Color(128, 64, 0));
		labelMostrarEmail.setBounds(249, 103, 139, 14);
		add(labelMostrarEmail);
		this.label2 = labelMostrarEmail;
 
		JLabel labelMostrarFechaInicio = new JLabel(fechaComoString);
		labelMostrarFechaInicio.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelMostrarFechaInicio.setBackground(new Color(128, 64, 0));
		labelMostrarFechaInicio.setBounds(249, 149, 108, 14);
		add(labelMostrarFechaInicio);
		this.label3 = labelMostrarFechaInicio;
		
		JLabel labelMostrarFechaCreacion = new JLabel(fechaComoString2);
		labelMostrarFechaCreacion.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelMostrarFechaCreacion.setBackground(new Color(128, 64, 0));
		labelMostrarFechaCreacion.setBounds(249, 193, 139, 14);
		add(labelMostrarFechaCreacion);
		this.label4 = labelMostrarFechaCreacion;
		JLabel labelSinImportancia = new JLabel("¿Quieres cambiar contraseña?");
		labelSinImportancia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelSinImportancia.setBounds(63, 263, 186, 14);
		add(labelSinImportancia);
 
		JLabel labelCambiasPass = new JLabel("Cambiar aqui");
		labelCambiasPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appControler.mostrarContraseña(user);
			}
		});
		labelCambiasPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCambiasPass.setForeground(new Color(255, 0, 0));
		labelCambiasPass.setBounds(260, 263, 74, 14);
		add(labelCambiasPass);
 
	}

	public void actualizarUser(User user) {
		this.user = user;
		label1.setText(user.getUsername());
		label2.setText(user.getEmail());
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fechaComoString = user.getLastLoginDate().format(formato);
		label3.setText(fechaComoString);
		fechaComoString2 = user.getCreatedDate().format(formato);
		label4.setText(fechaComoString2);

	}

}
