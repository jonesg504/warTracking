package warTracking;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

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
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
	private final Action action_12 = new SwingAction_12();
	private final Action action_13 = new SwingAction_13();
	private final Action action_14 = new SwingAction_14();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		saveList = save.loadFile();
		clan = save.loadClan();
		System.out.println(clan);
		sortedClan = clan.getList();
		Collections.sort(sortedClan);
		currentWarNumber = Integer.parseInt(saveList.get(0));
		setBest();
		setWorst();
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				editGraph(1);
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

		JButton btnNewButton_14 = new JButton("New button");
		btnNewButton_14.setAction(action_14);
		panel_1.add(btnNewButton_14);

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

		panel_5.setBounds(10, 33, 434, 293);
		panel_4.add(panel_5);

		JButton btnNewButton_5 = new JButton("Previous War");
		btnNewButton_5.setAction(action_7);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_5.setBounds(236, 7, 109, 23);
		panel_4.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Next War");
		btnNewButton_6.setAction(action_8);

		btnNewButton_6.setBounds(345, 7, 109, 23);
		panel_4.add(btnNewButton_6);

		JButton btnNewButton_12 = new JButton("New button");
		btnNewButton_12.setAction(action_12);
		btnNewButton_12.setBounds(10, 7, 116, 23);
		panel_4.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("New button");
		btnNewButton_13.setAction(action_13);
		btnNewButton_13.setBounds(127, 7, 109, 23);
		panel_4.add(btnNewButton_13);

		contentPane.add(scrollPane, BorderLayout.EAST);
		scrollPane.setPreferredSize(new Dimension(100, 22));
		txtrHelloMyName.setEditable(false);

		txtrHelloMyName.setLineWrap(true);
		currWar = save.loadWar(currentWarNumber);
		txtrHelloMyName.setText("War: " + (currentWarNumber + 1) + "\n"
				+ currWar.toString() + "\n" + topAttackers());
		scrollPane.setViewportView(txtrHelloMyName);
	}

	private static void setBest() {
		Collections.sort(sortedClan);
		bestPlayers = "Top Members: \n";
		for (int i = 0; i < 7; i++) {
			bestPlayers = bestPlayers + (i + 1) + ") "
					+ sortedClan.get(i).getName() + "\n";
		}
		txtrTopPlayers.setText(bestPlayers);

	}

	private static void runPlayerStats() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playerStats frame = new playerStats(clan, saveList, save);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static void runWarStats() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					warStats frame = new warStats(clan, saveList, save);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void setWorst() {
		Collections.sort(sortedClan);
		int s = sortedClan.size() - 1;
		worstPlayers = "Bottom Members: \n";
		for (int i = s; i > s - 5; i--) {
			if (sortedClan.get(i).getWorth() != -1) {
				
			worstPlayers = worstPlayers + (i + 1) + ") "
					+ sortedClan.get(i).getName() + "\n";
			} else {
				s--;
			}
		}
		txtrWorstPlayers.setText(worstPlayers);
	}

	

	private static void editGraph(int choice) {
		List<Double> scores = new ArrayList<>();
		Random random = new Random();
		if (choice == 1) {
			JFreeChart xylineChart = ChartFactory.createXYLineChart(null,
					"War Number", "Percent of Stars Obtained",
					graphData.performance(save, saveList),
					PlotOrientation.VERTICAL, true, true, false);
			final ChartPanel chartPanel = new ChartPanel(xylineChart);
			chartPanel.setPreferredSize(new java.awt.Dimension(450, 280));
			final XYPlot plot = xylineChart.getXYPlot();
			ValueAxis yAxis = plot.getRangeAxis();
			yAxis.setRange(0.0, 100.0);
			NumberAxis xAxis = new NumberAxis();
			xAxis.setTickUnit(new NumberTickUnit(1));
			plot.setDomainAxis(xAxis);
			xAxis.setRange(1, Integer.parseInt(saveList.get(0)) + 1);
			xAxis.setLabel("War Number");
			xAxis.setLabelFont(yAxis.getLabelFont());
			XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
			renderer.setSeriesPaint(0, Color.RED);
			renderer.setSeriesPaint(1, Color.GREEN);
			renderer.setSeriesPaint(2, Color.YELLOW);
			renderer.setSeriesStroke(0, new BasicStroke(4.0f));
			renderer.setSeriesStroke(1, new BasicStroke(3.0f));
			renderer.setSeriesStroke(2, new BasicStroke(2.0f));
			plot.setRenderer(renderer);
			chartPanel.getChart().removeLegend();
			panel_5.removeAll();
			panel_5.add(chartPanel);
			panel_5.repaint();
			panel_5.validate();
		} else if (choice == 2) {
			JFreeChart xylineChart = ChartFactory.createXYLineChart(null,
					"War Number", "Participation",
					graphData.parting(save, saveList),
					PlotOrientation.VERTICAL, true, true, false);
			final ChartPanel chartPanel = new ChartPanel(xylineChart);
			chartPanel.setPreferredSize(new java.awt.Dimension(450, 280));
			final XYPlot plot = xylineChart.getXYPlot();
			ValueAxis yAxis = plot.getRangeAxis();
			yAxis.setRange(0.0, 100.0);
			NumberAxis xAxis = new NumberAxis();
			xAxis.setTickUnit(new NumberTickUnit(1));
			plot.setDomainAxis(xAxis);
			xAxis.setRange(1, Integer.parseInt(saveList.get(0)) + 1);
			xAxis.setLabel("War Number");
			xAxis.setLabelFont(yAxis.getLabelFont());
			XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
			renderer.setSeriesPaint(0, Color.RED);
			renderer.setSeriesPaint(1, Color.GREEN);
			renderer.setSeriesPaint(2, Color.YELLOW);
			renderer.setSeriesStroke(0, new BasicStroke(4.0f));
			renderer.setSeriesStroke(1, new BasicStroke(3.0f));
			renderer.setSeriesStroke(2, new BasicStroke(2.0f));
			plot.setRenderer(renderer);
			chartPanel.getChart().removeLegend();
			panel_5.remove(0);
			panel_5.add(chartPanel);
			panel_5.repaint();
			panel_5.validate();
		} else if (choice == 3) {
			JFreeChart xylineChart = ChartFactory.createXYLineChart(null,
					"War Number", "Number of Wasted Attacks",
					graphData.losses(save, saveList),
					PlotOrientation.VERTICAL, true, true, false);
			final ChartPanel chartPanel = new ChartPanel(xylineChart);
			chartPanel.setPreferredSize(new java.awt.Dimension(450, 280));
			final XYPlot plot = xylineChart.getXYPlot();
			ValueAxis yAxis = plot.getRangeAxis();
			yAxis.setRange(0.0, 40.0);
			NumberAxis xAxis = new NumberAxis();
			xAxis.setTickUnit(new NumberTickUnit(1));
			plot.setDomainAxis(xAxis);
			xAxis.setRange(1, Integer.parseInt(saveList.get(0)) + 1);
			xAxis.setLabel("War Number");
			xAxis.setLabelFont(yAxis.getLabelFont());
			XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
			renderer.setSeriesPaint(0, Color.RED);
			renderer.setSeriesPaint(1, Color.GREEN);
			renderer.setSeriesPaint(2, Color.YELLOW);
			renderer.setSeriesStroke(0, new BasicStroke(4.0f));
			renderer.setSeriesStroke(1, new BasicStroke(3.0f));
			renderer.setSeriesStroke(2, new BasicStroke(2.0f));
			plot.setRenderer(renderer);
			chartPanel.getChart().removeLegend();
			panel_5.remove(0);
			panel_5.add(chartPanel);
			panel_5.repaint();
			panel_5.validate();
		}
	}

	private static void removePlayers() {
		int num = Integer
				.parseInt(JOptionPane
						.showInputDialog("How many players are you removing?(Integer plz)"));
		for (int i = 0; i < num; i++) {
			String removed = JOptionPane.showInputDialog("Enter Name:")
					.toLowerCase();
			Player gone = clan.remove(new Player(removed));
			if (gone == null) {
				JOptionPane.showMessageDialog(null, "Player doesnt Exist!");
			}

		}
	}

	private static void addPlayers() {
		int num = Integer
				.parseInt(JOptionPane
						.showInputDialog("How many players are you adding?(Integer plz)"));
		for (int i = 0; i < num; i++) {
			final JTextField username = new JTextField(10);
			final JTextField thLevel = new JTextField(10);
			final JPanel panel = new JPanel(new GridLayout(4, 1));
			panel.add(new JLabel("Username:"));
			panel.add(username);
			panel.add(new JLabel("Townhall Level:"));
			panel.add(thLevel);

			Object[] options = { "OK", "Cancel" };
			int result = JOptionPane.showOptionDialog(null, panel,
					"Data Entry", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, null);

			if (result == JOptionPane.OK_OPTION) {
				clan.add(new Player(username.getText().toLowerCase(), Integer
						.parseInt(thLevel.getText())));
				savePlayer(clan.getPlayer(username.getText().toLowerCase()));
				save.saveFile(saveList);

			}
		}
	}
	private static String topAttackers() {
		ArrayList<Player> warPlay = currWar.getMembers();
		Collections.sort(warPlay, new starComp());
		String list = "\nTop Attackers: \n";
		for (int i = 0; i < 10; i++) {
			Player player = warPlay.get(i);
			list += (i + 1) + ") " + player.getName() + "(" + player.getStars() + ")\n";
		}
		return list;
		
	}
	private static void savePlayer(Player player) {
		saveList.add(3,
				player.getName().toLowerCase() + " " + player.getThLevel()
						+ " " + player.getWorth());
	}

	private static void editWorth(Player player, double worth) {
		int pointer = saveList.indexOf(player.getName().toLowerCase() + " "
				+ player.getThLevel() + " " + player.getWorth() + " " + player.getRank());
		

		player.addWorth(worth);
		saveList.set(pointer,
				player.getName().toLowerCase() + " " + player.getThLevel()
						+ " " + player.getWorth() + " " + player.getRank());
		Collections.sort(sortedClan);
		setWorst();

	}
	static void saveRanks(String name, int rank) {
		Player player = clan.getPlayer(name);
		System.out.println(player.getName().toLowerCase() + " "
				+ player.getThLevel() + " " + player.getWorth() + " " + player.getRank());
		int pointer = saveList.indexOf(player.getName().toLowerCase() + " "
				+ player.getThLevel() + " " + player.getWorth() + " " + player.getRank());
		player.setRank(rank);
		saveList.set(pointer,
				player.getName().toLowerCase() + " " + player.getThLevel()
						+ " " + player.getWorth() + " " + player.getRank());
		
		save.saveFile(saveList);
	}

	private static void addAttack() {
		int num = Integer
				.parseInt(JOptionPane
						.showInputDialog("How many attacks are you adding?(Integer plz)"));
		for (int i = 0; i < num; i++) {
			final JTextField username = new JTextField(10);
			final JTextField defLevel = new JTextField(10);
			final JTextField stars = new JTextField(10);
			final JTextField rank = new JTextField(10);
			final JPanel panel = new JPanel(new GridLayout(8, 1));
			panel.add(new JLabel("Attacker:"));
			panel.add(username);
			panel.add(new JLabel("Bonus Stars:"));
			panel.add(stars);
			panel.add(new JLabel("Defender TownHall Level: "));
			panel.add(defLevel);
			panel.add(new JLabel("Opponent Rank: "));
			panel.add(rank);
			Object[] options = { "OK", "Cancel" };
			int result = JOptionPane.showOptionDialog(null, panel,
					"Data Entry", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, null);

			if (result == JOptionPane.OK_OPTION) {
				if (clan.getPlayer(username.getText().toLowerCase()) != null) {
					currWar = save.loadWar(currentWarNumber);
					Player play = currWar.getPlayer(username.getText()
							.toLowerCase());
					saveAttack(play, Integer.parseInt(stars.getText()));
					double worth = currWar.attack(
							clan.getPlayer(username.getText().toLowerCase()),
							Integer.parseInt(defLevel.getText()),
							Integer.parseInt(stars.getText()),
							Integer.parseInt(rank.getText()));
					editWorth(clan.getPlayer(username.getText()), worth);
					save.saveFile(saveList);
					currWar = save.loadWar(currentWarNumber);
					txtrHelloMyName.setText("War: " + currentWarNumber + "\n"
							+ currWar.toString() + "\n" + topAttackers());
					txtrHelloMyName.setCaretPosition(0);
				} else {
					JOptionPane
							.showMessageDialog(null,
									"ERROR: I think you typed the name wrong? Check clan list!");
					i--;
				}
			}
		}
	}

	private static void addDefense() {
		int num = Integer
				.parseInt(JOptionPane
						.showInputDialog("How many defenses are you adding?(Integer plz)"));
		for (int i = 0; i < num; i++) {
			final JTextField username = new JTextField(10);
			final JTextField defLevel = new JTextField(10);
			final JTextField stars = new JTextField(10);
			final JPanel panel = new JPanel(new GridLayout(6, 1));
			panel.add(new JLabel("Defender:"));
			panel.add(username);
			panel.add(new JLabel("Added Stars:"));
			panel.add(stars);
			panel.add(new JLabel("Attacker TownHall Level: "));
			panel.add(defLevel);
			Object[] options = { "OK", "Cancel" };
			int result = JOptionPane.showOptionDialog(null, panel,
					"Data Entry", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, null);

			if (result == JOptionPane.OK_OPTION) {
				if (clan.getPlayer(username.getText().toLowerCase()) != null) {
					double worth = currWar.defense(
							clan.getPlayer(username.getText().toLowerCase()),
							Integer.parseInt(defLevel.getText()),
							Integer.parseInt(stars.getText()));
					editWorth(clan.getPlayer(username.getText().toLowerCase()),
							worth);
					save.saveFile(saveList);
					txtrHelloMyName.setText("War: " + currentWarNumber + "\n"
							+ currWar.toString() + "\n" + topAttackers());
					txtrHelloMyName.setCaretPosition(0);
				} else {
					JOptionPane
							.showMessageDialog(null,
									"ERROR: I think you typed the name wrong? Check clan list!");
					i--;
				}

			}
		}
	}
	private static void editAttack() {
		String name = JOptionPane.showInputDialog("Who's Attacks?");
		String choice = JOptionPane
				.showInputDialog("Have they attacked more than once? (y/n)");
		int num = 0;
		if (choice.equalsIgnoreCase("y")) {
			num = 2;
		} else if (choice.equalsIgnoreCase("n")) {
			num = 1;
		}
		
		Player player = currWar.getPlayer(name);
		
		System.out.println(player.getName().toLowerCase() + " "
				+ player.getThLevel() + " " + player.getStars() + " "
				+ player.getAttackU() + " " + player.getAttackW());
		int pointer = saveList.lastIndexOf(player.getName().toLowerCase() + " "
				+ player.getThLevel() + " " + player.getStars() + " "
				+ player.getAttackU() + " " + player.getAttackW());
		saveList.set(pointer, player.getName() + " " + player.getThLevel()
				+ " 0 0 0");
		player.setAttackU(0);
		player.setStars(0);
		player.setAttackW(0);
		for (int i = 0; i < num; i++) {
			final JTextField defLevel = new JTextField(10);
			final JTextField stars = new JTextField(10);
			final JTextField rank = new JTextField(10);
			final JPanel panel = new JPanel(new GridLayout(7, 1));
			panel.add(new JLabel("Attack " + (i + 1)));
			panel.add(new JLabel("Added Stars:"));
			panel.add(stars);
			panel.add(new JLabel("Attacker TownHall Level: "));
			panel.add(defLevel);
			panel.add(new JLabel("Opponent Rank: "));
			panel.add(rank);
			Object[] options = { "OK", "Cancel" };
			int result = JOptionPane.showOptionDialog(null, panel,
					"Data Entry", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, null);

			if (result == JOptionPane.OK_OPTION) {
				saveAttack(player, Integer.parseInt(stars.getText()));
				double worth = currWar.attack(player,
						Integer.parseInt(defLevel.getText()),
						Integer.parseInt(stars.getText()),
						Integer.parseInt(rank.getText()));
				save.saveFile(saveList);
				player = clan.getPlayer(name);
				System.out.println(player.getWorth());
				editWorth(player, worth);
				
				currWar = save.loadWar(currentWarNumber);
				txtrHelloMyName.setText("War: " + currentWarNumber + "\n"
						+ currWar.toString() + "\n" + topAttackers());
				txtrHelloMyName.setCaretPosition(0);

			}
		}
	}


	private static void saveAttack(Player player, int stars) {
		int pointer = saveList.lastIndexOf(player.getName().toLowerCase() + " "
				+ player.getThLevel() + " " + player.getStars() + " "
				+ player.getAttackU() + " " + player.getAttackW());
		if (false) {
			JOptionPane
					.showMessageDialog(null,
							"ERROR: I think you typed the name wrong? Check clan list!");
		} else {
			int aU = player.getAttackU() + 1;
			int aW = player.getAttackW();
			if (stars > 0) {
				aW++;
			}
			int star = player.getStars() + stars;
			System.out.println(player.getAttackU());
			saveList.set(pointer,
					player.getName().toLowerCase() + " " + player.getThLevel()
							+ " " + star + " " + aU + " " + aW);
		}
	}

	private static void addWar() {
		Clan tempClan = clan;
		int num = Integer
				.parseInt(JOptionPane
						.showInputDialog("How many people aren't participating?(Integer plz)"));
		for (int i = 0; i < num; i++) {
			String removed = JOptionPane.showInputDialog("Enter Name:")
					.toLowerCase();
			Player gone = tempClan.remove(new Player(removed));
			if (gone == null) {
				JOptionPane.showMessageDialog(null, "Player Doesn't Exist");
				i--;
			}
		}
		ArrayList<Player> sortClan = clan.getList();
		String text = "";
		rankComp ranksort = new rankComp();
		Collections.sort(sortClan, ranksort);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clan tempClan = clan;
					rankEditor rankEdit = new rankEditor(save, saveList, sortedClan, tempClan);
					rankEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		currWar = new war(tempClan.getMembers().toArray(new Player[1]));
		currWar.resetPlayers();
		addWarSave();
		saveList.set(0, "" + (Integer.parseInt(saveList.get(0)) + 1));
		save.saveFile(saveList);
		currentWarNumber++;
		txtrHelloMyName.setText("War: " + currentWarNumber + "\n"
				+ currWar.toString() + "\n" + topAttackers());
		currentWarNumber = Integer.parseInt(saveList.get(0));
		txtrHelloMyName.setCaretPosition(0);

	}

	private static void addWarSave() {
		int pointer = saveList.lastIndexOf("war" + saveList.get(0) + "End");
		pointer++;
		saveList.add(pointer, "");
		pointer++;
		saveList.add(pointer, "war" + (Integer.parseInt(saveList.get(0)) + 1));
		for (Object play : currWar) {
			pointer++;
			Player p = (Player) play;
			saveList.add(pointer,
					p.getName() + " " + p.getThLevel() + " " + p.getStars()
							+ " " + p.getAttackU() + " " + p.getAttackW());
		}
		pointer++;
		saveList.add(pointer, "war" + (Integer.parseInt(saveList.get(0)) + 1)
				+ "End");
	}

	private static void loadPreviousWar() {
		if (currentWarNumber <= 0) {
			JOptionPane.showMessageDialog(null, "ALREADY ON EARLIEST WAR");
		} else {
			currWar = save.loadWar(currentWarNumber - 1);
			currentWarNumber--;
			txtrHelloMyName.setText("War: " + (currentWarNumber + 1) + "\n"
					+ currWar.toString() + "\n" + topAttackers());
			txtrHelloMyName.setCaretPosition(0);

		}
	}

	private static void loadNextWar() {
		if (currentWarNumber >= Integer.parseInt(saveList.get(0))) {
			JOptionPane.showMessageDialog(null, "ALREADY ON CURRENT WAR");
		} else {
			currWar = save.loadWar(currentWarNumber + 1);
			currentWarNumber++;
			txtrHelloMyName.setText("War: " + (currentWarNumber + 1) + "\n"
					+ currWar.toString() + "\n" + topAttackers());
			txtrHelloMyName.setCaretPosition(0);
			topAttackers();
		}
	}

	
	// SWING ACTIONS
	// -----------------------------------------------------------------------------------------------------------------------------------------------
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Performance");
			putValue(SHORT_DESCRIPTION, "Performance of the clan");
		}

		public void actionPerformed(ActionEvent e) {
			editGraph(1);
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Participation");
			putValue(SHORT_DESCRIPTION, "Participation of the clan through wars");
		}

		public void actionPerformed(ActionEvent e) {
			editGraph(2);
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Wasted Attacks");
			putValue(SHORT_DESCRIPTION, "Show Wasted attacks");
		}

		public void actionPerformed(ActionEvent e) {
			editGraph(3);
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "New Player(s)");
			putValue(SHORT_DESCRIPTION, "Add a new player or players");
		}

		public void actionPerformed(ActionEvent e) {
			addPlayers();
		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Remove Player(s)");
			putValue(SHORT_DESCRIPTION, "Remove players from clan");
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane pane = new JOptionPane();
			removePlayers();
		}
	}

	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Add Attack");
			putValue(SHORT_DESCRIPTION, "Add an attack to the current war");
		}

		public void actionPerformed(ActionEvent e) {
			addAttack();
		}
	}

	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "New War");
			putValue(SHORT_DESCRIPTION, "Start a new war");
		}

		public void actionPerformed(ActionEvent e) {
			addWar();
		}
	}

	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "Prev War");
			putValue(SHORT_DESCRIPTION, "Show Previous war");
		}

		public void actionPerformed(ActionEvent e) {
			loadPreviousWar();
		}
	}

	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "Next War");
			putValue(SHORT_DESCRIPTION, "Show next war");
		}

		public void actionPerformed(ActionEvent e) {
			loadNextWar();
		}
	}

	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Add Defense");
			putValue(SHORT_DESCRIPTION, "Add a defense");
		}

		public void actionPerformed(ActionEvent e) {
			addDefense();
		}
	}

	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "Edit Attack");
			putValue(SHORT_DESCRIPTION, "Edit someones attacks");
		}

		public void actionPerformed(ActionEvent e) {
			editAttack();
		}
	}

	private class SwingAction_11 extends AbstractAction {
		public SwingAction_11() {
			putValue(NAME, "Clan List");
			putValue(SHORT_DESCRIPTION, "Show everyone in the clan");
		}

		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> sortClan = clan.getList();
			String text = "";
			Collections.sort(sortClan, new playerComp());
			for (Player play : sortClan) {
				text = text + play.getName() + "(" + play.getThLevel() + ")\n";
			}

			JTextArea textArea = new JTextArea(text);
			Font font = new Font("Verdana", Font.BOLD, 20);
			textArea.setFont(font);
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane,
					"dialog test with textarea", JOptionPane.YES_NO_OPTION);
		}
	}

	private class SwingAction_12 extends AbstractAction {
		public SwingAction_12() {
			putValue(NAME, "Player Stats");
			putValue(SHORT_DESCRIPTION, "Individual player stats");
		}

		public void actionPerformed(ActionEvent e) {
			runPlayerStats();
		}
	}

	private class SwingAction_13 extends AbstractAction {
		public SwingAction_13() {
			putValue(NAME, "War Ranks");
			putValue(SHORT_DESCRIPTION, "Edit/View War Ranks");
		}

		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> sortClan = clan.getList();
			String text = "";
			rankComp ranksort = new rankComp();
			Collections.sort(sortClan, ranksort);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Clan tempClan = clan;
						rankEditor rankEdit = new rankEditor(save, saveList, sortedClan, tempClan);
						rankEdit.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
//			ArrayList<Player> sortClan = clan.getList();
//			String text = "";
//			Collections.sort(sortClan, new rankComp());
//			for (Player play : sortClan) {
//				text = text + play.getRank() + ") " + play.toString();
//			}
//			JTextArea textArea = new JTextArea(text);
//			JButton butt = new JButton("Edit War Ranks");
//			butt.addActionListener(new editRanks());
//			Font font = new Font("Verdana", Font.BOLD, 20);
//			textArea.setFont(font);
//			textArea.setEditable(false);
//			JPanel pane = new JPanel();
//			JScrollPane scrollPane = new JScrollPane(textArea);
//			textArea.setLineWrap(true);
//			textArea.setWrapStyleWord(true);
//			scrollPane.setPreferredSize(new Dimension(500, 500));
//			pane.setLayout(new FlowLayout());
//			
//			pane.add(scrollPane);
//			pane.add(butt);
//			butt.setSize(new Dimension(20, 5));
//			JOptionPane.showMessageDialog(null, pane,
//					"dialog test with textarea", JOptionPane.YES_NO_OPTION);
		}
	}

	private class playerComp implements Comparator {

		@Override
		public int compare(Object a0, Object a1) {
			Player p1 = (Player) a0;
			Player p2 = (Player) a1;
			return (p1.getName().compareToIgnoreCase(p2.getName()));
		}

	}
	
	private class editRanks implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> sortClan = clan.getList();
			String text = "";
			rankComp ranksort = new rankComp();
			Collections.sort(sortClan, ranksort);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Clan tempClan = clan;
						rankEditor rankEdit = new rankEditor(save, saveList, sortedClan, tempClan);
						rankEdit.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
	}

	private class SwingAction_14 extends AbstractAction {
		public SwingAction_14() {
			putValue(NAME, "Clan Rankings");
			putValue(SHORT_DESCRIPTION, "Clan rankings");
		}

		public void actionPerformed(ActionEvent e) {
			ArrayList<Player> sortClan = clan.getList();
			String text = "";
			Collections.sort(sortClan);
			int i = 1;
			for (Player play : sortClan) {
				text = text + i + ") " + play.getName() + "(" + play.getWorth() + ")\n";
				i++;
			}

			JTextArea textArea = new JTextArea(text);
			Font font = new Font("Verdana", Font.BOLD, 20);
			textArea.setFont(font);
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane,
					"dialog test with textarea", JOptionPane.YES_NO_OPTION);
		}
	}
}
