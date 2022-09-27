package mainClass;
import java.awt.EventQueue;

import javax.swing.JFrame;

import uiClass.ClickityPanel;

import java.awt.BorderLayout;

public class MainClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClickityPanel clickingPanel = new ClickityPanel();
		
		frame.getContentPane().add(clickingPanel.getClickingButton(), BorderLayout.CENTER);
	};

}
