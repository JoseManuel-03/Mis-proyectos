package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;

public class Ejercicio3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 window = new Ejercicio3();
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
	public Ejercicio3() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 191, 434, 70);
		frame.getContentPane().add(lblNewLabel);


		JButton btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn1.setBackground(null);
			}
		});
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has hecho click en el botón 1");
				String textoBoton = btn1.getText();
				btn1.setText(textoBoton+ "!");
			}
		});
		
		
		btn1.setBounds(0, 0, 434, 70);
		frame.getContentPane().add(btn1);

		
		JButton btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn2.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn2.setBackground(null);
			}
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has hecho click en el botón 2");
				String textoBoton = btn2.getText();
				btn2.setText(textoBoton+ "!");
			}
		});
		
		btn2.setBounds(0, 64, 434, 70);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn3.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn3.setBackground(null);
			}
		});
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has hecho click en el botón 3");
				String textoBoton = btn3.getText();
				btn3.setText(textoBoton+ "!");
			}
		});
		
		btn3.setBounds(0, 125, 434, 70);
		frame.getContentPane().add(btn3);
	}

}
