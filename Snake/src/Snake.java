import java.util.Vector;

import javax.swing.JComponent;

class Snake extends JComponent {
	private int cell_size;
	public Vector<Coordinates> sn;

	public Snake(int cell_size) {
		sn = new Vector<Coordinates>();
		this.cell_size = cell_size;
		init();
	}

	public void init() {
		Coordinates tmp = new Coordinates(5, 5);
		sn.add(tmp);
		tmp = new Coordinates(5, 6);
		sn.add(tmp);
	}
}