package EjerciciosRepaso.ejercicio5;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vista1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNuevaCiudad;

	/**
	 * Create the panel.
	 */
	public Vista1() {
		setLayout(null);

		String[] options = {};

		JComboBox<String> comboBox = new JComboBox<>(options);

		comboBox.setToolTipText("\r\n\r\n");
		comboBox.setBounds(247, 169, 68, 35);
		add(comboBox);

		JLabel lblDestinos = new JLabel("Destinos disponibles");
		lblDestinos.setBounds(95, 169, 142, 35);
		add(lblDestinos);
		
		txtNuevaCiudad = new JTextField();
		txtNuevaCiudad.setText("Nueva ciudad");
		txtNuevaCiudad.setBounds(174, 102, 93, 26);
		add(txtNuevaCiudad);
		txtNuevaCiudad.setColumns(10);



	}
}
