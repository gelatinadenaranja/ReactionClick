package uiClass;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ClickityPanel {
	private long startTime;
	private long clickedTime;
	private int buttonState;
	private JLabel clickingButton;
	
	public ClickityPanel() {
		startTime = 0;
		clickedTime = 0;
		buttonState = 0;
		clickingButton = new JLabel("Click to start", SwingConstants.CENTER);
		clickingButton.setOpaque(true);
		clickingButton.setBackground(new Color(120, 120, 120));
		
		clickingButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(buttonState == 2) {
					buttonState = 3;
					end();
					return;
				};
				
				switch(buttonState) {
				case 0:
					start();
					break;
				case 1:
					//toosoon
					break;
				case 3:
					clickingButton.setBackground(new Color(120, 120, 120));
					clickingButton.setText("Click to start");
					startTime = 0;
					clickedTime = 0;
					buttonState = 0;
					break;
				default:
					System.out.println("buttonState = " + buttonState);
				};
			};
		});
		
	};
	
	public JLabel getClickingButton() {
		return this.clickingButton;
	};
	
	private void start() {
		waitABit();
		clickingButton.setText("Wait for red");
		buttonState = 1;
	};
	
	private void waitABit() {
		Thread waitingThread = new Thread() {
			public void run() {
				Random waitTime = new Random();
				
				try {
					Thread.sleep((waitTime.nextInt(5) + 1) * 1000);
					buttonState = 2;
					startTime = System.nanoTime();
					clickingButton.setBackground(new Color(255, 0, 0));
					clickingButton.setText("CLICK NOW!");
				} catch(InterruptedException e) {
					System.out.println("Error: " + e);
				};
			};
		};
		
		waitingThread.start();
	};
	
	private void end() {
		clickedTime = System.nanoTime();
		clickingButton.setBackground(new Color(0, 255, 0));
		clickingButton.setText("<html>" + showTime() + "<br>Click to restart.");
	};
	
	private String showTime() {
		return (clickedTime - startTime) / 1000000 + " MS!";
	};
};
