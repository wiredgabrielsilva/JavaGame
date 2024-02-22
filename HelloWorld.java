import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HelloWorld {

//	private final GUI gui;
//	private final Game game;

	public class GUI {

		// Making them public
		public JFrame frame;
		public JPanel panel;
		public JButton button;
		public JLabel label;
		public JLabel guessLabel;
		public JTextField textField;
		public JLabel myGuess;

		public GUI(HelloWorld helloworld) {

			Random rand = new Random();
			int int_random = rand.nextInt(100);

			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			JButton button = new JButton("Make a Guess");
			JLabel label = new JLabel("Latest Guess:");
			JLabel guessLabel = new JLabel();
			JLabel highLow = new JLabel();
			JTextField textField = new JTextField();

			// Setting the GUI up
			panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
			panel.setLayout(new GridLayout());
			panel.add(button);
			panel.add(textField);
			panel.add(label);
			panel.add(guessLabel);
			panel.add(highLow);

			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Our GUI");
			frame.pack();
			frame.setVisible(true);

			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = textField.getText();

					int guess = Integer.parseInt(text);

					if (guess > int_random) {
						label.setText("too high");
					} else if (guess < int_random) {
						label.setText("too low");
					} else if (guess == int_random) {
						label.setText("You won!");
					}
				}
			});

		}

	}

	public static void main(String args[]) {

		HelloWorld helloworld = new HelloWorld();

		HelloWorld.GUI gui = helloworld.new GUI(helloworld);
	}

}
