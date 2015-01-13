package warTracking;

import javax.swing.JFrame;


public class ExampleGraph extends JFrame {
	public ExampleGraph() {
		super("Example Graph");
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Graph graph = new Graph(1000, 600);
		
		//{{x1, y1}, {x2, y2}, ...}
		double[][] points = {{1, 10}, {2, 15}, {3, 13}, {4, 22}, {5, 17}};
		graph.setPoints(points);
		graph.setRange(0,45);
		
		//{{m, b, start_x_interval, end_x_interval}, ...}
		double[][] equations = {{1, 4, -10, 0}, {-4, 1, 0, 10}};
		graph.setEquations(equations);
		
		getContentPane().add(graph);
		
		setVisible(true);
	}
	public static void main(String args[]) {
		new ExampleGraph();
	}
}