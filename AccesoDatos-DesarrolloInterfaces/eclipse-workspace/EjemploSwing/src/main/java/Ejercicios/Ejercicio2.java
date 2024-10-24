package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class Ejercicio2 {

	private JFrame frame;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextPane textPaneDNI;
	private JTextPane txtpnFechaDeNacimiento;
	private JTextPane txtpnBarra;
	private JTextPane txtpnBarra_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 window = new Ejercicio2();
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
	public Ejercicio2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		textNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textNombre, 54, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textNombre, -49, SpringLayout.EAST, frame.getContentPane());
		textNombre.setColumns(10);
		frame.getContentPane().add(textNombre);
		
		textDNI = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textDNI, 0, SpringLayout.EAST, textNombre);
		frame.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		springLayout.putConstraint(SpringLayout.WEST, btnCancelar, 219, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancelar, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnAceptar, 0, SpringLayout.NORTH, btnCancelar);
		springLayout.putConstraint(SpringLayout.EAST, btnAceptar, -6, SpringLayout.WEST, btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 307, SpringLayout.WEST, frame.getContentPane());
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 45, SpringLayout.SOUTH, textDNI);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, -49, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -24, SpringLayout.WEST, textField_3);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 0, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_4, -53, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, -26, SpringLayout.WEST, textField_1);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		JTextPane textPaneNombre = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textNombre, 0, SpringLayout.NORTH, textPaneNombre);
		springLayout.putConstraint(SpringLayout.WEST, textNombre, 120, SpringLayout.EAST, textPaneNombre);
		springLayout.putConstraint(SpringLayout.NORTH, textPaneNombre, 24, SpringLayout.NORTH, frame.getContentPane());
		textPaneNombre.setEditable(false);
		textPaneNombre.setBackground(SystemColor.menu);
		springLayout.putConstraint(SpringLayout.WEST, textPaneNombre, 22, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textPaneNombre, 119, SpringLayout.WEST, frame.getContentPane());
		textPaneNombre.setText("Nombre:");
		frame.getContentPane().add(textPaneNombre);
		
		textPaneDNI = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textDNI, 0, SpringLayout.NORTH, textPaneDNI);
		springLayout.putConstraint(SpringLayout.WEST, textDNI, 120, SpringLayout.EAST, textPaneDNI);
		springLayout.putConstraint(SpringLayout.SOUTH, textDNI, 10, SpringLayout.SOUTH, textPaneDNI);
		springLayout.putConstraint(SpringLayout.NORTH, textPaneDNI, 43, SpringLayout.SOUTH, textPaneNombre);
		springLayout.putConstraint(SpringLayout.WEST, textPaneDNI, 0, SpringLayout.WEST, textPaneNombre);
		springLayout.putConstraint(SpringLayout.EAST, textPaneDNI, 0, SpringLayout.EAST, textPaneNombre);
		textPaneDNI.setText("DNI:");
		textPaneDNI.setEditable(false);
		textPaneDNI.setBackground(SystemColor.menu);
		frame.getContentPane().add(textPaneDNI);
		
		txtpnFechaDeNacimiento = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnFechaDeNacimiento, 0, SpringLayout.WEST, textPaneNombre);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnFechaDeNacimiento, 0, SpringLayout.SOUTH, textField_1);
		txtpnFechaDeNacimiento.setText("Fecha de Nacimiento:");
		txtpnFechaDeNacimiento.setEditable(false);
		txtpnFechaDeNacimiento.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtpnFechaDeNacimiento);
		
		txtpnBarra = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtpnBarra, -82, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, txtpnBarra);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnBarra, 0, SpringLayout.SOUTH, textField_1);
		txtpnBarra.setText("/");
		txtpnBarra.setEditable(false);
		txtpnBarra.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtpnBarra);
		
		txtpnBarra_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnBarra_1, 0, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, txtpnBarra_1, -6, SpringLayout.WEST, textField_1);
		txtpnBarra_1.setText("/");
		txtpnBarra_1.setEditable(false);
		txtpnBarra_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtpnBarra_1);
	}
}
