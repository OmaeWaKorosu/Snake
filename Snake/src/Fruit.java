import javax.swing.JComponent;

class Fruit extends JComponent {
	int x, y;
	private MyJFrame frame;
	private Snake snake;

	public Fruit(Snake snake) {
		this.snake = snake;
	}

	public void setFrame(MyJFrame frame) {
		this.frame = frame;
		createFruit();
	}

	public void createFruit() {
		// Ставлю фрукты мои
		while (true) {
			boolean not_in_snake = true;
			x = (int) (Math.random() * frame.getCol());
			y = (int) (Math.random() * frame.getRows());
			for (int i = 0; i < snake.sn.size(); i++)
				if (snake.sn.get(i).x == x && snake.sn.get(i).y == y && y >= 2) {
					not_in_snake = false;
					break;
				}

			if (not_in_snake)
				break;
		}
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}