import java.util.Vector;

import javax.swing.JComponent;

class Wall extends JComponent {
	public MyJFrame frame;
	public Snake snake;
	public Vector<Coordinates> wl;

	public Wall(Snake snake) {
         wl = new Vector<Coordinates>();
         this.snake = snake;       
	}
	
	public void setFrame(MyJFrame frame){
		this.frame = frame;
	}
}