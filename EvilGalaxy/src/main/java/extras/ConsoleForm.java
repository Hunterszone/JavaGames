package extras;

import java.awt.Color;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import main.Main;
import util.AutoSuggestor;
import util.ConsoleContent;

public final class ConsoleForm extends ConsoleContent {

	Vector<String> matches = new Vector<>();
	JList<Object> list = new JList<>();
	public static JFrame frame;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			if (ConsoleContent.console == null) {
				ConsoleContent.console = new ConsoleForm();
			}
			final Main ex = new Main();
			ex.setVisible(true);
			try {
				ConsoleContent.console.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		});
	}

	public ConsoleForm() {

		frame = new JFrame();
		frame.setTitle("Game Console");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(textField);
		frame.add(contentPane);
		frame.pack();
		frame.setVisible(true);

		new AutoSuggestor(textField, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
			@Override
			protected boolean wordTyped(String typedWord) {
				setDictionary(textField.getText());
				return super.wordTyped(typedWord);
			}
		};
	}
}