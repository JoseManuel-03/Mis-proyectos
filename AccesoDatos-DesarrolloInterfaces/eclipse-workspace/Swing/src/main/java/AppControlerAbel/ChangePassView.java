package AppControlerAbel;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ChangePassView extends View {

	private static final long serialVersionUID = 1L;
	private App controller;
	private JPasswordField tfPassNew;
	private JPasswordField tfPassNew2;
	private JPasswordField tfPassOld;

	/**
	 * Create the panel.
	 */
	public ChangePassView(App controller) {
		this.controller = controller;
		setLayout(null);
	
		
		JLabel lbPass = new JLabel("Contraseña nueva:");
		lbPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPass.setBounds(123, 100, 108, 13);
		add(lbPass);
		
		tfPassNew = new JPasswordField();
		tfPassNew.setBounds(258, 97, 122, 19);
		add(tfPassNew);
		
		JButton btAceptar = new JButton("Aceptar");
		btAceptar.setBackground(new Color(255, 0, 0));
		btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changePass(new String(tfPassOld.getPassword()),
						new String(tfPassNew.getPassword()),
						new String(tfPassNew2.getPassword()));
			}
		});
		btAceptar.setBounds(258, 175, 158, 21);
		add(btAceptar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBackground(new Color(255, 0, 0));
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openCreateForm();
			}
		});
		btCancelar.setBounds(258, 209, 158, 21);
		add(btCancelar);
		
		JLabel lbEmail = new JLabel("Contraseña antigua:");
		lbEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmail.setBounds(95, 71, 136, 13);
		add(lbEmail);
		
		JLabel lblRepiteContrasea = new JLabel("Repite contraseña:");
		lblRepiteContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepiteContrasea.setBounds(95, 129, 136, 13);
		add(lblRepiteContrasea);
		
		tfPassNew2 = new JPasswordField();
		tfPassNew2.setBounds(258, 126, 122, 19);
		add(tfPassNew2);
		
		tfPassOld = new JPasswordField();
		tfPassOld.setBounds(258, 68, 122, 19);
		add(tfPassOld);
	}
	
	@Override
	public void initializeForm() {
		tfPassOld.setText("");
		tfPassNew.setText("");
		tfPassNew2.setText("");
		tfPassOld.requestFocus();
	}
	
}
