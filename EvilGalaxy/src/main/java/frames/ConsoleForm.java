package frames;

import java.awt.Color;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

public final class ConsoleForm extends ConsoleContent {

	Vector<String> matches = new Vector<>();
	JList<Object> list = new JList<>();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ConsoleForm consoleForm = new ConsoleForm();
				Main ex = new Main();
				ex.setVisible(true);
				try {
					consoleForm.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsoleForm() {

		JFrame frame = new JFrame();
		frame.setTitle("Game Console");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(textField);
		frame.add(contentPane);
		frame.pack();
		frame.setVisible(true);

		new AutoSuggestor(textField, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
			@Override
			boolean wordTyped(String typedWord) {
				setDictionary(textField.getText());
				return super.wordTyped(typedWord);
			}
		};
	}
}