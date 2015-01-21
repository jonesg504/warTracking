package warTracking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import java.awt.Font;

public class playerStats extends JFrame {

	private JPanel contentPane;
	private static JPanel panel_1 = new JPanel();
	private static ArrayList<String> saveList; 
	private static FileHandle save;
	private static Clan clan;
	String selected = "Double Click";
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					//playerStats frame = new playerStats();
//					//frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public playerStats(Clan clan, ArrayList<String> saveList, FileHandle save) {
		this.saveList = saveList;
		this.save = save;
		this.clan = clan;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 103, 367);
		contentPane.add(panel);
		String[] selections = populate(clan);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 83, 345);
		panel.add(scrollPane);
		
		final JList list = new JList(selections);
		scrollPane.setViewportView(list);
		
		panel_1.setBounds(115, 55, 470, 323);
		contentPane.add(panel_1);
		
		final JLabel lblNewLabel = new JLabel(selected);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(274, 11, 144, 33);
		contentPane.add(lblNewLabel);
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
		           String selectedItem = (String) list.getSelectedValue();
		           System.out.println(selectedItem);
		           createAndShowGui(selectedItem);
		           selected = selectedItem;
		           lblNewLabel.setText(selected);
		     

		         }
		    }
		};
		list.addMouseListener(mouseListener);
	}
	private static void createAndShowGui(String name) {
		
        GraphPanel mainPanel = new GraphPanel(graphData.playerWarStat(clan.getPlayer(name), save, saveList));
        panel_1.removeAll();
        mainPanel.setPreferredSize(new Dimension(450, 300));
        panel_1.add(mainPanel);
        panel_1.validate();
    }
	private static String[] populate(Clan clan) {
		ArrayList<String> names = new ArrayList<String>();
		for (Object o : clan) {
			Player player = (Player) o;
			names.add(player.getName());
		}
		return names.toArray(new String[9]);
	}
}
