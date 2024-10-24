package Ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio7º8º9º10º11 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnVerde;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnRosa;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7º8º9º10º11 window = new Ejercicio7º8º9º10º11();
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
	public Ejercicio7º8º9º10º11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(119, 32, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(119, 135, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 185, 86, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 82, 86, 20);
		frame.getContentPane().add(textField_3);

		// JComboBox de colores
		String[] options = { "Verde", "Azul", "Rojo", "Rosa" };
		comboBox = new JComboBox<>(options);
		comboBox.setBounds(119, 228, 86, 22);
		frame.getContentPane().add(comboBox);

		// Crear RadioButtons
		rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBounds(250, 32, 109, 23);
		frame.getContentPane().add(rdbtnVerde);

		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(250, 62, 109, 23);
		frame.getContentPane().add(rdbtnAzul);

		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(250, 92, 109, 23);
		frame.getContentPane().add(rdbtnRojo);

		rdbtnRosa = new JRadioButton("Rosa");
		rdbtnRosa.setBounds(250, 122, 109, 23);
		frame.getContentPane().add(rdbtnRosa);

		// Agrupar RadioButtons
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnVerde);
		group.add(rdbtnAzul);
		group.add(rdbtnRojo);
		group.add(rdbtnRosa);

		// Sincronizar JComboBox y JRadioButton
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedColor = (String) comboBox.getSelectedItem();
				switch (selectedColor) {
					case "Verde":
						rdbtnVerde.setSelected(true);
						break;
					case "Azul":
						rdbtnAzul.setSelected(true);
						break;
					case "Rojo":
						rdbtnRojo.setSelected(true);
						break;
					case "Rosa":
						rdbtnRosa.setSelected(true);
						break;
				}
			}
		});

		ActionListener radioListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnVerde.isSelected()) {
					comboBox.setSelectedItem("Verde");
				} else if (rdbtnAzul.isSelected()) {
					comboBox.setSelectedItem("Azul");
				} else if (rdbtnRojo.isSelected()) {
					comboBox.setSelectedItem("Rojo");
				} else if (rdbtnRosa.isSelected()) {
					comboBox.setSelectedItem("Rosa");
				}
			}
		};

		// Añadir listeners a los RadioButtons
		rdbtnVerde.addActionListener(radioListener);
		rdbtnAzul.addActionListener(radioListener);
		rdbtnRojo.addActionListener(radioListener);
		rdbtnRosa.addActionListener(radioListener);

		// Key and focus listener para los textfields
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_DOWN || (e.getKeyCode() == KeyEvent.VK_ENTER))) {
					((JTextField) e.getSource()).transferFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					((JTextField) e.getSource()).transferFocusBackward();
				}
			}
		};

		FocusAdapter focusAdapter = new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				e.getComponent().setBackground(Color.WHITE);
			}

			@Override
			public void focusGained(FocusEvent e) {
				String selectedColor = (String) comboBox.getSelectedItem();
				switch (selectedColor) {
					case "Verde":
						e.getComponent().setBackground(Color.GREEN);
						break;
					case "Azul":
						e.getComponent().setBackground(Color.BLUE);
						break;
					case "Rojo":
						e.getComponent().setBackground(Color.RED);
						break;
					case "Rosa":
						e.getComponent().setBackground(Color.PINK);
						break;
				}
			}
		};

		// Añadir los listeners a los textfields
		textField.addKeyListener(keyAdapter);
		textField_1.addKeyListener(keyAdapter);
		textField_2.addKeyListener(keyAdapter);
		textField_3.addKeyListener(keyAdapter);

		textField.addFocusListener(focusAdapter);
		textField_1.addFocusListener(focusAdapter);
		textField_2.addFocusListener(focusAdapter);
		textField_3.addFocusListener(focusAdapter);
	}
}
