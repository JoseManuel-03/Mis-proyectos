package CambioPantalla;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BienvenidaPantalla extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;

	/**
	 * Create the panel.
	 */
	public BienvenidaPantalla(App app) {
		this.app = app;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Bienvenida");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirLogin();
			}
		});
		
		btnNewButton.setBounds(140, 181, 152, 61);
		add(btnNewButton);

	}

}
