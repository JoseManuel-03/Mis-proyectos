package EjerciciosRepaso.ejercicio5;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vista1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNuevaCiudad;

	/**
	 * Create the panel.
	 */
	public Vista1() {
		setLayout(null);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(255, 0, 255));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		comboBox.setToolTipText("\r\n\r\n");
		comboBox.setBounds(242, 94, 116, 35);
		add(comboBox);

		JLabel lblDestinos = new JLabel("Destinos disponibles");
		lblDestinos.setBounds(90, 94, 142, 35);
		add(lblDestinos);

		txtNuevaCiudad = new JTextField();
		txtNuevaCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = txtNuevaCiudad.getText();
				if (!text.isEmpty()) {
					comboBox.addItem(text);
					comboBox.setSelectedItem(text);
					txtNuevaCiudad.setText("");
				}
			}
		});

		txtNuevaCiudad.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtNuevaCiudad.setText("Nueva ciudad");
		txtNuevaCiudad.setBounds(178, 47, 93, 26);
		add(txtNuevaCiudad);
		txtNuevaCiudad.setColumns(10);

		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				comboBox.removeAllItems();
			}
		});

		btnLimpiar.setBackground(new Color(128, 255, 0));
		btnLimpiar.setBounds(90, 173, 89, 23);
		add(btnLimpiar);

		JLabel lblCiudadSeleccionada = new JLabel("New label");
		lblCiudadSeleccionada.setForeground(new Color(0, 0, 0));
		lblCiudadSeleccionada.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCiudadSeleccionada.setBounds(145, 207, 213, 14);
		add(lblCiudadSeleccionada);
		lblCiudadSeleccionada.setVisible(false);

		JButton btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBox.getItemCount() == 0) {
					e.consume();
				}
				lblCiudadSeleccionada.setVisible(true);
				lblCiudadSeleccionada.setText("Ciudad Seleccionada: " + comboBox.getSelectedItem().toString());
			}
		});

		btnSeleccionar.setBackground(new Color(128, 255, 0));
		btnSeleccionar.setBounds(242, 173, 116, 23);
		add(btnSeleccionar);

	}
}
