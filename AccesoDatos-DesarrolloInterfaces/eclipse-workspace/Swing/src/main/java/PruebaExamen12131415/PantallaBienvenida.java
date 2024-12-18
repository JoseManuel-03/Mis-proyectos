package PruebaExamen12131415;

import javax.swing.JPanel;

import AppControler.App;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class PantallaBienvenida extends JPanel {

	private AppControler app;
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	private JCheckBox chckbxSeleccionaTexto;

	/**
	 * Create the panel.
	 */
	public PantallaBienvenida(AppControler app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblBienvenida = new JLabel("Bienvenido a mi aplicación");
		lblBienvenida.setBounds(147, 62, 149, 23);
		add(lblBienvenida);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.entrar(comboBox.getSelectedIndex(), chckbxSeleccionaTexto.isSelected());
			}
		});
		btnEntrar.setBounds(172, 146, 89, 23);
		add(btnEntrar);
		
		chckbxSeleccionaTexto = new JCheckBox("Seleccionar texto");
		chckbxSeleccionaTexto.setSelected(true);
		chckbxSeleccionaTexto.setBounds(268, 221, 109, 23);
		add(chckbxSeleccionaTexto);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(105, 203, 109, 32);
		comboBox.addItem("Pantalla 1");
		comboBox.addItem("Pantalla 2");
		comboBox.addItem("Pantalla 3");
		add(comboBox);
	}
}
