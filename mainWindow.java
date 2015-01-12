package warTracking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class mainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		
		Button button_1 = new Button("Edit War");
		panel.add(button_1);
		
		Button button_2 = new Button("Update Stars");
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
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove Player");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea txtrTopPlayers = new JTextArea();
		txtrTopPlayers.setText("Top Players \n Griffin \n Your Mom");
		panel_2.add(txtrTopPlayers);
		
		JTextArea txtrWorstPlayers = new JTextArea();
		txtrWorstPlayers.setText("Worst Players");
		panel_2.add(txtrWorstPlayers);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JTextArea txtrHellosdfbasjd = new JTextArea();
		txtrHellosdfbasjd.setText("Recent Stats");
		panel_3.add(txtrHellosdfbasjd);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][][][][grow][][][][]", "[][][][][][grow][][][][][][]"));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, "cell 1 1 7 5,grow");
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_4.add(btnNewButton_2, "cell 1 11");
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_4.add(btnNewButton_3, "cell 3 11 3 1");
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_4.add(btnNewButton_4, "cell 6 11");
	}

}
