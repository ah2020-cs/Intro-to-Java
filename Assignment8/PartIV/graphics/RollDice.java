package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RollDice extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImagePanel imagePanel1;
	private ImagePanel ImagePanel2;
	
	private JPanel ansPanel;
	private JPanel buttonPanel;
	private JPanel wrapperPanel;
	private JLabel ansJLabel;
	private JPanel dicePanel;
	
	private int dice1 = 1;
	private int dice2 = 1;
	private int result = 2;

	public static int roll() {
		return (int) (Math.random() * 5) + 1;
	}

	public void initView() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		
		wrapperPanel = new JPanel(new BorderLayout());
		dicePanel = new JPanel(new GridLayout(1, 2));

		ansPanel = new JPanel();
		ansJLabel = new JLabel();
		ansPanel.add(ansJLabel);

		this.repaint();

		buttonPanel = new JPanel();
		JButton rollButton = new JButton("Roll Dice");
		
		rollButton.addActionListener((e) -> {
			this.rollNext(1);
			this.rollNext(2);
			this.repaint();
		});
		
		buttonPanel.add(rollButton);
		wrapperPanel.add(dicePanel, BorderLayout.NORTH);
		wrapperPanel.add(ansPanel, BorderLayout.CENTER);
		wrapperPanel.add(buttonPanel, BorderLayout.SOUTH);

		this.add(wrapperPanel);
		this.setSize(600, 400);
		this.setVisible(true);
		
	}

	private void rollNext(int diceNum) {
		
		if (diceNum == 1) {
			this.dice1 = roll();
		} else if (diceNum == 2) {
			this.dice2 = roll();
		}
		
	}

	public ImagePanel getDiceImage(int number, int diceIndex) {
		
		ImagePanel img = new ImagePanel("PartIV/die" + number + ".png");
		img.addMouseListener(new DiceListener(diceIndex));
		return img;
		
	}

	public void repaint() {
		
		this.result = dice1 + dice2;
		ansJLabel.setText("Result: " + this.result);
		
		dicePanel.removeAll();
		imagePanel1 = getDiceImage(dice1, 1);
		ImagePanel2 = getDiceImage(dice2, 2);
		
		dicePanel.add(imagePanel1);
		dicePanel.add(ImagePanel2);
		
	}
	
	class DiceListener extends MouseAdapter {
		
		private int diceNum;

		public DiceListener(int dice) {
			diceNum = dice;
		}

		
		public void mouseClicked(MouseEvent event) {
			rollNext(diceNum);
			RollDice.this.repaint();
		}
	}
	
	
	public RollDice() {
		this.initView();
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	
	}
}
