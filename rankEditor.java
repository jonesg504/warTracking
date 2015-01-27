package warTracking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class rankEditor extends JFrame {

	private JPanel contentPane;
	private FileHandle save;
	private ArrayList<String> saveList;
	private ArrayList<Player> edit;
	private Clan clan;
	private Clan dontEdit;
	private ArrayList<JLabel> buttons = new ArrayList<>();
	private ArrayList<JTextArea> texts = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					rankEditor frame = new rankEditor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public rankEditor(FileHandle save, ArrayList<String> saveList, ArrayList<Player> edit, Clan clan) {
		this.save = save;
		this.saveList = saveList;
		this.edit = edit;
		this.clan = clan;
		dontEdit = clan;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(edit.size() + 1, 2, 0, 3));
		showGUI();
	}
	
	
	public void showGUI() {
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		int num = 0;
		for (Player play : edit) {
			buttons.add(new JLabel(play.getName()));
			buttons.get(num).setBorder(border);
			texts.add(new JTextArea("" + play.getRank()));
			texts.get(num).setBorder(border);
			num++;
		}
		for (int i = 0; i < buttons.size(); i++) {
			contentPane.add(buttons.get(i));
			contentPane.add(texts.get(i));
		}
		
		JButton button = new JButton("Save All");
		button.addActionListener(new saveButton());
		contentPane.add(button);
		
	}
	
	private class buttonListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent action) {
			JButton butt = (JButton) action.getSource();
			int index = buttons.indexOf(butt);
			String name = butt.getText();
			String sRank = ((JTextArea) contentPane.getComponent((index * 2) + 1)).getText();
			sRank.replaceAll("\\s+","");
			int rank = Integer.parseInt(sRank);
			mainWindow.saveRanks(name, rank);
		}
		
	}
	private class saveButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent action) {
			int i = 0;
			for (JLabel butt : buttons) {
				String sRank = ((JTextArea) contentPane.getComponent((i * 2) + 1)).getText();
				sRank = sRank.replaceAll("\\s+","");
				int rank = Integer.parseInt(sRank);
				String name = butt.getText();
				mainWindow.saveRanks(name, rank);
				i++;
			}
			dispose();
		}
		
	}
	
}
