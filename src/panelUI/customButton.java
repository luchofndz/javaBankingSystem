package panelUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

import javax.swing.JButton;

public class customButton implements ActionListener {
	private JButton button;
	private Function<?, ?> buttonMethod;
	
	public customButton(String buttonName, Function<?, ?> buttonMethod) {
		super();
		this.button = new JButton(buttonName);
		this.buttonMethod = buttonMethod;
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//this.buttonMethod();
	}
}
