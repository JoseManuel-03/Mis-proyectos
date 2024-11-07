package AppControler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class JMyTextField extends JTextField implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1321701459957591880L;

	public JMyTextField() {
		super();
		addKeyListener(this);
	}

	public JMyTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
	}

	public JMyTextField(int columns) {
		super(columns);
	}

	public JMyTextField(String text, int columns) {
		super(text, columns);
	}

	public JMyTextField(String text) {
		super(text);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(getText().length()>30) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
