import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

class Game_Manager {
	private MyJFrame frame;
	private Fruit fruit;
	private Snake snake;
	private Direction dir;
	private Thread m;
	private int speed;

	public Game_Manager(Fruit fruit, Snake snake, final Direction dir,
			int cell_size, int speed) {
		this.fruit = fruit;
		this.snake = snake;
		this.dir = dir;
		this.speed = speed;

		frame = new MyJFrame("Snake", snake, dir, fruit, cell_size,speed);
		m = new Thread(frame);
		m.start();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);

				if (e.getKeyCode() == KeyEvent.VK_W) {
					if (dir.dir != 1)
						dir.dir = 0;
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					if (dir.dir != 0)
						dir.dir = 1;
				} else if (e.getKeyCode() == KeyEvent.VK_A) {
					if (dir.dir != 3)
						dir.dir = 2;
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					if (dir.dir != 2)
						dir.dir = 3;
				}
			}
		});
		fruit.setFrame(frame);
	}

}