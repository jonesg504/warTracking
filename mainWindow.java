package warTracking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class mainWindow extends JFrame {
	private static JPanel panel_5 = new JPanel();
	private static JPanel contentPane;
	private static JTextArea txtrHellosdfbasjd = new JTextArea();
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private static Clan clan = new Clan();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FileHandle save = new FileHandle();
		clan = save.loadClan();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		Button button = new Button("New War");
		panel.add(button);
		
		Button button_1 = new Button("Add Attack");
		panel.add(button_1);
		
		Button button_2 = new Button("Add Defense");
		panel.add(button_2);
		
		Button button_3 = new Button("End War");
		panel.add(button_3);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New Player(s)");
		btnNewButton.setAction(action_3);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove Player");
		btnNewButton_1.setAction(action_4);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2.setPreferredSize(new Dimension(100, 200));
		
		JTextArea txtrTopPlayers = new JTextArea();
		txtrTopPlayers.setEditable(false);
		txtrTopPlayers.setText("Top Players \r\n Griffin \r\n Your Mom");
		panel_2.add(txtrTopPlayers);
		
		JTextArea txtrWorstPlayers = new JTextArea();
		txtrWorstPlayers.setEditable(false);
		txtrWorstPlayers.setText("Worst Players");
		panel_2.add(txtrWorstPlayers);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setPreferredSize(new Dimension(100, 200));
		panel_3.setOpaque(true);
	    panel_3.setBackground(Color.WHITE);
		
		
		txtrHellosdfbasjd.setEditable(false);
		txtrHellosdfbasjd.setText(clan.toString());
		panel_3.add(txtrHellosdfbasjd);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("War Performance");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setAction(action);
		btnNewButton_2.setBounds(10, 333, 132, 23);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setAction(action_1);
		btnNewButton_3.setBounds(152, 333, 145, 23);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setAction(action_2);
		btnNewButton_4.setBounds(307, 333, 137, 23);
		panel_4.add(btnNewButton_4);
		
		
		panel_5.setBounds(10, 33, 434,293);
		panel_4.add(panel_5);
		
		JButton btnNewButton_5 = new JButton("Previous War");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_5.setBounds(83, 7, 132, 23);
		panel_4.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Next War");
		
		btnNewButton_6.setBounds(235, 7, 132, 23);
		panel_4.add(btnNewButton_6);
	}
	private static void createAndShowGui() {
        List<Double> scores = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 10;
        int maxScore = 10;
        for (int i = 0; i < maxDataPoints; i++) {
          //  scores.add((double) random.nextDouble() * maxScore);
            scores.add((double) i);
        }
        GraphPanel mainPanel = new GraphPanel(scores);
        mainPanel.setPreferredSize(new Dimension(450, 300));
        panel_5.add(mainPanel);
        //JFrame frame = new JFrame("DrawGraph");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(mainPanel);
        //frame.pack();
        //frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
    }
	
	private static void editGraph(int choice) {
		List<Double> scores = new ArrayList<>();
        Random random = new Random();
        if (choice == 1) {
        	int maxDataPoints = 13;
            int maxScore = 45;
            for (int i = 1; i <= maxDataPoints; i++) {
                //scores.add((double) random.nextDouble() * maxScore);
                scores.add((double) i);
            }
            GraphPanel mainPanel = new GraphPanel(scores);
            mainPanel.setPreferredSize(new Dimension(450,300));
            panel_5.remove(0);
            panel_5.add(mainPanel);
            panel_5.repaint();
            panel_5.validate();
        } else if (choice == 2) {
        	int maxDataPoints = 13;
            int maxScore = 100;
            for (int i = 1; i <= maxDataPoints; i++) {
                //scores.add((double) random.nextDouble() * maxScore);
            	scores.add((double) random.nextDouble() * maxScore);
            }
            GraphPanel mainPanel = new GraphPanel(scores);
            mainPanel.setPreferredSize(new Dimension(450,300));
            panel_5.remove(0);
            panel_5.add(mainPanel);
            panel_5.repaint();
            panel_5.validate();
        } else if (choice == 3) {
        	int maxDataPoints = 13;
            int maxScore = 45;
            for (int i = 1; i <= maxDataPoints; i++) {
                scores.add((double) random.nextDouble() * maxScore);
                //scores.add((double) i);
            }
            GraphPanel mainPanel = new GraphPanel(scores);
            mainPanel.setPreferredSize(new Dimension(450,300));
            panel_5.remove(0);
            panel_5.add(mainPanel);
            panel_5.repaint();
            panel_5.validate();
        }
	}
	private static void removePlayers() {
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many players are you removing?(Integer plz)"));
		for (int i = 0; i < num; i++) {
			String removed = JOptionPane.showInputDialog("Enter Name:");
			Player gone = clan.remove(new Player(removed));
			if (gone == null) {
				System.out.println ("Player Doesnt Exist");
			} else {
				System.out.println( "Removed:\n" + gone);
			}
		}
		System.out.println(clan);
	}
	private static void addPlayers() {
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many players are you removing?(Integer plz)"));
		for(int i = 0; i < num; i++) {
			final JTextField username = new JTextField(10);  
			final JTextField thLevel = new JTextField(10); 
	        final JPanel panel = new JPanel(new GridLayout(4,1));  
	        panel.add(new JLabel("Username:"));  
	        panel.add(username);  
	        panel.add(new JLabel("Townhall Level:"));  
	        panel.add(thLevel);
	  
	        Object[] options = { "OK", "Cancel" };          
	        int result = JOptionPane.showOptionDialog(null, panel, "Data Entry", JOptionPane.OK_CANCEL_OPTION,   
	                            JOptionPane.QUESTION_MESSAGE, null, options, null);  
	          
	        if (result == JOptionPane.OK_OPTION) {    
	            clan.add(new Player(username.getText(), Integer.parseInt(thLevel.getText())));
	            txtrHellosdfbasjd.setText(clan.toString());
	            
	        } 
			/*JTextField username = new JTextField();
			JTextField thLevel = new JTextField();
			Object[] message = {
			    "Username:", username,
			    "TownHall Level:", thLevel
			};
			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			
			if (option == JOptionPane.OK_OPTION) {
			   clan.add(new Player(username.getText(), Integer.parseInt(thLevel.getText())));
			   System.out.println(clan);
			}*/
		}
	}
	//SWING ACTIONS
	//--------------------------------------------------------------------------------------------------------------------------
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Performance");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			editGraph(1);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Participation");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			editGraph(2);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Attacks Lost");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			editGraph(3);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "New Player(s)");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			addPlayers();
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Remove Player(s)");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			JOptionPane pane = new JOptionPane();
			removePlayers();
		}
	}
}
