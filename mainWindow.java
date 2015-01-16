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
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;

public class mainWindow extends JFrame {
	private static JPanel panel_5 = new JPanel();
	private static JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private static Clan clan = new Clan();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private static war currWar = new war();
	private static JTextArea textArea = new JTextArea();
	private static FileHandle save = new FileHandle();
	private static ArrayList<String> saveList;
	private static JTextArea txtrHelloMyName = new JTextArea();
	private static int currentWarNumber = 0;
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private static JScrollPane scrollPane = new JScrollPane();
	private final Action action_9 = new SwingAction_9();
	private static ArrayList<Player> sortedClan;
	private static String bestPlayers = "";
	private static String worstPlayers = "";
	private static JTextArea txtrTopPlayers = new JTextArea();
	private static JTextArea txtrWorstPlayers = new JTextArea();
	private final Action action_10 = new SwingAction_10();
	private final Action action_11 = new SwingAction_11();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		saveList  = save.loadFile();
		clan = save.loadClan();
		sortedClan = clan.getList();
		Collections.sort(sortedClan);
		currentWarNumber = Integer.parseInt(saveList.get(0));
		setBest();
		setWorst();
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
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_10.setAction(action_6);
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setAction(action_5);
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setAction(action_9);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setAction(action_10);
		panel.add(btnNewButton_7);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New Player(s)");
		btnNewButton.setAction(action_3);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove Player");
		btnNewButton_1.setAction(action_4);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_11.setAction(action_11);
		panel_1.add(btnNewButton_11);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2.setPreferredSize(new Dimension(100, 200));
		
		
		txtrTopPlayers.setEditable(false);
		txtrTopPlayers.setText(bestPlayers);
		panel_2.add(txtrTopPlayers);
		
		txtrWorstPlayers.setEditable(false);
		txtrWorstPlayers.setText(worstPlayers);
		panel_2.add(txtrWorstPlayers);
		
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
		btnNewButton_5.setAction(action_7);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_5.setBounds(83, 7, 132, 23);
		panel_4.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Next War");
		btnNewButton_6.setAction(action_8);
		
		btnNewButton_6.setBounds(235, 7, 132, 23);
		panel_4.add(btnNewButton_6);
		
		
		contentPane.add(scrollPane, BorderLayout.EAST);
		scrollPane.setPreferredSize(new Dimension(100, 22));
		txtrHelloMyName.setEditable(false);
		
		
		txtrHelloMyName.setLineWrap(true);
		currWar = save.loadWar(currentWarNumber);
		txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
		scrollPane.setViewportView(txtrHelloMyName);
	}
	private static void setBest() {
		Collections.sort(sortedClan);
		bestPlayers = "Top Members: \n";
		for(int i = 0; i < 7; i++) {
			bestPlayers = bestPlayers + (i + 1) + ") " + sortedClan.get(i).getName() + "\n";
		}
		txtrTopPlayers.setText(bestPlayers);
		
	}
	private static void setWorst() {
		Collections.sort(sortedClan);
		int s = sortedClan.size() - 1;
		worstPlayers = "Bottom Members: \n";
		for(int i = s  ; i > s - 5 ; i--) {
			worstPlayers = worstPlayers + (i + 1) + ") " + sortedClan.get(i).getName() + "\n";
		}
		txtrWorstPlayers.setText(worstPlayers);
	}
	private static void createAndShowGui() {
		GraphPanel mainPanel = new GraphPanel(graphData.performance(save, saveList));
        mainPanel.setPreferredSize(new Dimension(450, 300));
        panel_5.add(mainPanel);
    }
	
	private static void editGraph(int choice) {
		List<Double> scores = new ArrayList<>();
        Random random = new Random();
        if (choice == 1) {
            GraphPanel mainPanel = new GraphPanel(graphData.performance(save, saveList));
            mainPanel.setPreferredSize(new Dimension(450,300));
            panel_5.remove(0);
            panel_5.add(mainPanel);
            panel_5.repaint();
            panel_5.validate();
        } else if (choice == 2) {
        	GraphPanel mainPanel = new GraphPanel(graphData.parting(save, saveList));
            mainPanel.setPreferredSize(new Dimension(450,300));
            panel_5.remove(0);
            panel_5.add(mainPanel);
            panel_5.repaint();
            panel_5.validate();
        } else if (choice == 3) {
        	GraphPanel mainPanel = new GraphPanel(graphData.losses(save, saveList));
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
			String removed = JOptionPane.showInputDialog("Enter Name:").toLowerCase();
			Player gone = clan.remove(new Player(removed));
			if (gone == null) {
				JOptionPane.showMessageDialog(null, "Player doesnt Exist!");
			}
			
		}
	}
	private static void addPlayers() {
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many players are you adding?(Integer plz)"));
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
	            clan.add(new Player(username.getText().toLowerCase(), Integer.parseInt(thLevel.getText())));
	            savePlayer(clan.getPlayer(username.getText().toLowerCase()));
	            save.saveFile(saveList);
	            
	        } 
		}
	}
	private static void savePlayer(Player player) {
		saveList.add(3, player.getName().toLowerCase() + " " + player.getThLevel() + " " + player.getWorth());
	}
	private static void editWorth(Player player, double worth) {
		int pointer = saveList.indexOf(player.getName().toLowerCase() + " " + player.getThLevel() + " " + player.getWorth());
		player.addWorth(worth);
		saveList.set(pointer, player.getName().toLowerCase() + " " + player.getThLevel() + " " + player.getWorth());
		Collections.sort(sortedClan);
		setBest();
        setWorst();
		
	}
	
	private static void addAttack() {
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many attacks are you adding?(Integer plz)"));
		for(int i = 0; i < num; i++) {
			final JTextField username = new JTextField(10);  
			final JTextField defLevel = new JTextField(10);
			final JTextField stars = new JTextField(10);
	        final JPanel panel = new JPanel(new GridLayout(6,1));  
	        panel.add(new JLabel("Attacker:"));  
	        panel.add(username);
	        panel.add(new JLabel("Bonus Stars:"));  
	        panel.add(stars);
	        panel.add(new JLabel("Defender TownHall Level: "));
	        panel.add(defLevel);
	        Object[] options = { "OK", "Cancel" };          
	        int result = JOptionPane.showOptionDialog(null, panel, "Data Entry", JOptionPane.OK_CANCEL_OPTION,   
	                            JOptionPane.QUESTION_MESSAGE, null, options, null);  
	          
	        if (result == JOptionPane.OK_OPTION) {
	        	saveAttack(clan.getPlayer(username.getText().toLowerCase()), Integer.parseInt(stars.getText()));
	            double worth = currWar.attack(clan.getPlayer(username.getText().toLowerCase()), Integer.parseInt(defLevel.getText()), Integer.parseInt(stars.getText()) );
	            editWorth(clan.getPlayer(username.getText()), worth);
	            save.saveFile(saveList);
	            currWar = save.loadWar(currentWarNumber);
	    		txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
	    		txtrHelloMyName.setCaretPosition(0);
	            
	        } 
		}
	}
	private static void addDefense() {
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many defenses are you adding?(Integer plz)"));
		for(int i = 0; i < num; i++) {
			final JTextField username = new JTextField(10);  
			final JTextField defLevel = new JTextField(10);
			final JTextField stars = new JTextField(10);
	        final JPanel panel = new JPanel(new GridLayout(6,1));  
	        panel.add(new JLabel("Defender:"));  
	        panel.add(username);
	        panel.add(new JLabel("Added Stars:"));  
	        panel.add(stars);
	        panel.add(new JLabel("Attacker TownHall Level: "));
	        panel.add(defLevel);
	        Object[] options = { "OK", "Cancel" };          
	        int result = JOptionPane.showOptionDialog(null, panel, "Data Entry", JOptionPane.OK_CANCEL_OPTION,   
	                            JOptionPane.QUESTION_MESSAGE, null, options, null);  
	          
	        if (result == JOptionPane.OK_OPTION) {
	            double worth = currWar.defense(clan.getPlayer(username.getText().toLowerCase()), Integer.parseInt(defLevel.getText()), Integer.parseInt(stars.getText()) );
	            editWorth(clan.getPlayer(username.getText().toLowerCase()), worth);
	            save.saveFile(saveList);
	    		txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
	    		txtrHelloMyName.setCaretPosition(0);
	            
	        } 
		}
	}
	
	private static void saveAttack(Player player, int stars) {
		int pointer = saveList.lastIndexOf(player.getName().toLowerCase() + " " + player.getThLevel() + " " + player.getStars() + " " + player.getAttackU() + " " + player.getAttackW());
		if (pointer  == -1) {
			JOptionPane.showMessageDialog(null, "ERROR: I think you typed the name wrong? Check clan list!");
			
		} else {
			int aU = player.getAttackU() + 1;
			int aW = player.getAttackW();
			if (stars > 0 ) {
				aW++;
			}
			int star = player.getStars() + stars;
			saveList.set(pointer, player.getName().toLowerCase() + " " + player.getThLevel() + " " + star + " " + aU + " " + aW);
		}
	}
	private static void addWar() {
		Clan tempClan = clan;
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many people aren't participating?(Integer plz)"));
		for(int i = 0; i < num; i++) {
			String removed = JOptionPane.showInputDialog("Enter Name:").toLowerCase();
			Player gone = tempClan.remove(new Player(removed));
			if (gone == null) {
				JOptionPane.showMessageDialog(null, "Player Doesn't Exist");
				i--;
			}
		}
		
		currWar = new war(tempClan.getMembers().toArray(new Player[1]));
		currWar.resetPlayers();
		addWarSave();
		saveList.set(0, "" + (Integer.parseInt(saveList.get(0)) + 1));
		save.saveFile(saveList);
		currentWarNumber++;
		txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
		currentWarNumber = Integer.parseInt(saveList.get(0));
		txtrHelloMyName.setCaretPosition(0);
		
	}
	private static void addWarSave() {
		int pointer = saveList.lastIndexOf("war" + saveList.get(0) + "End");
		pointer++;
		saveList.add(pointer, "");
		pointer++;
		saveList.add(pointer, "war" + (Integer.parseInt(saveList.get(0)) + 1));
		for(Object play : currWar) {
			pointer++;
			Player p = (Player) play;
			saveList.add(pointer, p.getName() + " " + p.getThLevel() + " " + p.getStars() + " " + p.getAttackU() + " " + p.getAttackW());
		}
		pointer++;
		saveList.add(pointer, "war" + (Integer.parseInt(saveList.get(0)) + 1) + "End");
	}
	private static void loadPreviousWar() {
		if (currentWarNumber <= 0) {
			JOptionPane.showMessageDialog(null, "ALREADY ON EARLIEST WAR");
		} else {
			currWar = save.loadWar(currentWarNumber - 1); 
			currentWarNumber--;
			txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
			txtrHelloMyName.setCaretPosition(0);
			
		}
	}
	private static void loadNextWar() {
		if (currentWarNumber >= Integer.parseInt(saveList.get(0))) {
			JOptionPane.showMessageDialog(null, "ALREADY ON CURRENT WAR");
		} else {
			currWar = save.loadWar(currentWarNumber + 1); 
			currentWarNumber++;
			txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
			txtrHelloMyName.setCaretPosition(0);
		}
	}
	private static void editAttack() {
		String name = JOptionPane.showInputDialog("Who's Attacks?");
		String choice = JOptionPane.showInputDialog("Have they attacked more than once? (y/n)");
		int num = 0;
		if(choice.equalsIgnoreCase("y")) {
			num = 2;
		} else if (choice.equalsIgnoreCase("n")) {
			num = 1;
		}
		Player player = clan.getPlayer(name);
		//System.out.println(player.getName() + " " + player.getThLevel() + " " + player.getStars() + " " + player.getAttackU() + " " + player.getAttackW());
		int pointer = saveList.lastIndexOf(player.getName() + " " + player.getThLevel() + " " + player.getStars() + " " + player.getAttackU() + " " + player.getAttackW());
		saveList.set(pointer, player.getName() + " " + player.getThLevel() + " 0 0 0");
		player.setAttackU(0);
		player.setStars(0);
		player.setAttackW(0);
		for(int i = 0; i < num; i++) {
			final JTextField defLevel = new JTextField(10);
			final JTextField stars = new JTextField(10);
	        final JPanel panel = new JPanel(new GridLayout(5,1)); 
	        panel.add(new JLabel("Attack " + (i+1)));  
	        panel.add(new JLabel("Added Stars:"));  
	        panel.add(stars);
	        panel.add(new JLabel("Attacker TownHall Level: "));
	        panel.add(defLevel);
	        Object[] options = { "OK", "Cancel" };          
	        int result = JOptionPane.showOptionDialog(null, panel, "Data Entry", JOptionPane.OK_CANCEL_OPTION,   
	                            JOptionPane.QUESTION_MESSAGE, null, options, null);  
	          
	        if (result == JOptionPane.OK_OPTION) {
	        	saveAttack(player, Integer.parseInt(stars.getText()));
	            double worth = currWar.attack(player, Integer.parseInt(defLevel.getText()), Integer.parseInt(stars.getText()) );
	            editWorth(player, worth);
	            save.saveFile(saveList);
	            currWar = save.loadWar(currentWarNumber);
	    		txtrHelloMyName.setText("War: "+ currentWarNumber + "\n" + currWar.printWar());
	    		txtrHelloMyName.setCaretPosition(0);
	        
			}
		}
	}
	//SWING ACTIONS
	//-----------------------------------------------------------------------------------------------------------------------------------------------
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
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Add Attack");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			addAttack();
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "New War");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			addWar();
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "Previous War");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			loadPreviousWar();
		}
	}
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "Next War");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			loadNextWar();
		}
	}
	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Add Defense");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			addDefense();
		}
	}
	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "Edit Attack");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			editAttack();
		}
	}
	private class SwingAction_11 extends AbstractAction {
		public SwingAction_11() {
			putValue(NAME, "Clan List");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, clan.toString());
		}
	}
}
