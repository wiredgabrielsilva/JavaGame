import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NumberGame {

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

		public GUI(NumberGame helloworld) {

			Random rand = new Random();
			int int_random = rand.nextInt(100);

			// Remember to comment
			// System.out.println(int_random);

			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			JPanel bottomPanel = new JPanel();

			JButton button = new JButton("Make a guess");
			JLabel label = new JLabel("Can you find out the random number? HINT: It's from 0 to 100",
					SwingConstants.CENTER);
			JLabel guessLabel = new JLabel();
			JLabel highLow = new JLabel("", SwingConstants.CENTER);
			JTextField textField = new JTextField("", SwingConstants.CENTER);
			JLabel lifeBar = new JLabel("HEALTH: ", SwingConstants.RIGHT);
			JLabel lifeTotal = new JLabel("100");

			// Setting the GUI up
			panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 1, 10));
			panel.setLayout(new GridLayout(0, 1, 0, 10));
			panel.add(label);
			panel.add(textField);
			panel.add(button);
			panel.add(guessLabel);
			panel.add(highLow);
			panel.setAlignmentX(Component.LEFT_ALIGNMENT);
			bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 30, 30));
			panel.add(bottomPanel, BorderLayout.PAGE_END);
			bottomPanel.add(lifeBar);
			bottomPanel.add(lifeTotal);

			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Number Game");
			frame.pack();
			frame.setVisible(true);

			button.addActionListener(new ActionListener() {
				int life = 100;

				public void actionPerformed(ActionEvent e) {
					life = life - 5;
					String setLife = String.valueOf(life);
					lifeTotal.setText(setLife);

					try {
						String text = textField.getText();
						int guess = Integer.parseInt(text);
						int trial = Math.abs(int_random - guess);
						// debug
						// System.out.println(trial);

						if (guess > int_random) {
							if (trial > 0 && trial < 5 && trial != int_random) {
								highLow.setText("Almost!!!");
							} else if (trial > 0 && trial < 15) {
								highLow.setText("High but close");
							} else if (trial > 0 && trial < 30) {
								highLow.setText("High");
							} else {
								highLow.setText("Too High");
							}

						} else if (guess < int_random) {

							if (trial > 0 && trial < 5 && guess != int_random) {
								highLow.setText("Almost!!!");
							} else if (trial > 0 && trial < 15) {
								highLow.setText("Low but close");
							} else if (trial > 0 && trial < 30) {
								highLow.setText("Low");
							} else {
								highLow.setText("Too Low");
							}
						} else {
							highLow.setText("You won!!!!");
							button.setEnabled(false);
						}

					} catch (Exception r) {
						life = life + 5;
						highLow.setText("Oops, something went wrong. Please try something else.");
					}

					if (life == 0) {
						highLow.setText("GAME OVER");
						lifeTotal.setText("GAME OVER");
						button.setEnabled(false);
					}

				} // actionPerformed
			} // ActionListener
			); // ActionListener

		}

	}

	public static void main(String args[]) {

		NumberGame helloworld = new NumberGame();

		NumberGame.GUI gui = helloworld.new GUI(helloworld);
	}

}
