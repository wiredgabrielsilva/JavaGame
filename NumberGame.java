import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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

			// Remember to comment
			//System.out.println(int_random);

			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			JButton button = new JButton("Make a guess");
			JLabel label = new JLabel("Can you find out the random number? HINT: It's from 0 to 100",
					SwingConstants.CENTER);
			JLabel guessLabel = new JLabel();
			JLabel highLow = new JLabel("", SwingConstants.CENTER);
			JTextField textField = new JTextField();

			// Setting the GUI up
			panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
			panel.setLayout(new GridLayout(5, 5));
			panel.add(label);
			panel.add(textField);
			panel.add(button);
			panel.add(guessLabel);
			panel.add(highLow);

			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Number Game");
			frame.pack();
			frame.setVisible(true);

			button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					try {
						String text = textField.getText();
						int guess = Integer.parseInt(text);

						if (guess > int_random) {
							highLow.setText("Too High");
						} else if (guess < int_random) {
							highLow.setText("Too Low");
						} else if (guess == int_random) {
							highLow.setText("You won!");

						}
					} catch (Exception r) {
						highLow.setText("Oops, something went wrong. Please try something else");
					}

				} // actionPerformed
			} // ActionListener
			); // ActionListener

		}

	}

	public static void main(String args[]) {

		HelloWorld helloworld = new HelloWorld();

		HelloWorld.GUI gui = helloworld.new GUI(helloworld);
	}

}
