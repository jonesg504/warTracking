package warTracking;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class warStats extends JFrame {

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
	public warStats(Clan clan, ArrayList<String> saveList, FileHandle save) {
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
		final int curr = Integer.parseInt(saveList.get(0));
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
		           String selectedItem = (String) list.getSelectedValue();
		           createAndShowGui(selectedItem, curr);
		           selected = selectedItem;
		           lblNewLabel.setText(selected);
		     

		         }
		    }
		};
		list.addMouseListener(mouseListener);
	}
	private static void createAndShowGui(String name, int curr) {
		
		JFreeChart xylineChart = ChartFactory.createXYLineChart(null,
				"War Number", "Number of Wasted Attacks",
				graphData.playerWarStat(clan.getPlayer(name), save, saveList),
				PlotOrientation.VERTICAL, true, true, false);
		final ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(450, 280));
		final XYPlot plot = xylineChart.getXYPlot();
		ValueAxis yAxis = plot.getRangeAxis();
		yAxis.setRange(0.0, 7.0);
		NumberAxis xAxis = new NumberAxis();
		xAxis.setTickUnit(new NumberTickUnit(1));
		plot.setDomainAxis(xAxis);
		xAxis.setRange(1, curr + 1);
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
		panel_1.removeAll();
        panel_1.add(chartPanel);
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
