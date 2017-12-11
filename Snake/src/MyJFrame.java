import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class MyJFrame extends JFrame implements Runnable {
	private boolean lose = false;
	private Image image = null;
	private Snake snake;
	private Direction dir;
	private Fruit fr;
	private int speed;
	private BufferedImage fruitImage;
	int height, width;
	int cell_size;
	int rows = 30, col = 40;

	public MyJFrame(String name, Snake sn, Direction dir, Fruit fr,
			int cell_size, int speed) {
		super(name);
		setBackground(Color.white);
        this.speed = speed;
		height = rows * cell_size;
		width = col * cell_size;
		try {
			fruitImage = ImageIO.read(new File("apple2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setSize(width, height);
		super.setResizable(false);

		this.cell_size = cell_size;
		this.snake = sn;
		this.dir = dir;
		this.fr = fr;
	}

	public void updateData() {

		// Если сьели фрукт, добавляем новую ячейку
		int x = snake.sn.get(snake.sn.size() - 1).x;
		int y = snake.sn.get(snake.sn.size() - 1).y;
		for (int i = snake.sn.size() - 1; i > 0; i--) {
			snake.sn.get(i).y = snake.sn.get(i - 1).y;
			snake.sn.get(i).x = snake.sn.get(i - 1).x;
		}

		// Перемещение головы
		switch (dir.dir) {
		case 0: {
			snake.sn.get(0).y--;
			break;
		}
		case 1: {
			snake.sn.get(0).y++;
			break;
		}
		case 2: {
			snake.sn.get(0).x--;
			break;
		}
		case 3: {
			snake.sn.get(0).x++;
			break;
		}
		}

		// Змейка врезается саму в себя
		for (int i = 1; i < snake.sn.size(); i++)
			if (snake.sn.get(0).x == snake.sn.get(i).x
					&& snake.sn.get(0).y == snake.sn.get(i).y) {
				lose = true;
				repaint();

			}

		// Выход за пределы поля
		if (snake.sn.get(0).x >= col)
			lose = true;
			//snake.sn.get(0).x = 0;
		else if (snake.sn.get(0).x < 0)
			lose = true;
			//snake.sn.get(0).x = col;
		else if (snake.sn.get(0).y >= rows)
			lose = true;
			//snake.sn.get(0).y = 0;
		else if (snake.sn.get(0).y < 2)
			lose = true;
			//snake.sn.get(0).y = rows;

		// Голова находится в одном блоке с фруктой
		if (snake.sn.get(0).x == fr.getX() && snake.sn.get(0).y == fr.getY()) {
			Coordinates cor = new Coordinates(x, y);
			snake.sn.add(cor);
			fr.createFruit();
		}

		repaint();
	}

	public int getRows() {
		return rows;
	}

	public int getCol() {
		return col;
	}

	public void paint(Graphics g) {
		image = createImage(width, height);
		Graphics graph = image.getGraphics();
		if (lose) {
            graph.setColor(Color.cyan);
			graph.drawString("U LOSE THIS GAME",
					5 * cell_size, 4 * cell_size);
			// g.drawImage(image, width/2, height/2, null);
		}
		// Paint fruit
		int fruit_x = fr.getX();
		int fruit_y = fr.getY();
		// graph.drawImage(fruitImage, fruit_x, fruit_y, null);
		graph.setColor(Color.red);
		graph.fillRect(fruit_x * cell_size, fruit_y * cell_size, cell_size + 1,
				cell_size + 1);

		// Paint Snake
		graph.setColor(Color.darkGray);
		graph.fillRect(snake.sn.get(0).x * cell_size, snake.sn.get(0).y
				* cell_size, cell_size + 1, cell_size + 1);
		graph.setColor(Color.gray);
		for (int i = 1; i < snake.sn.size(); i++)
			graph.fillRect(snake.sn.get(i).x * cell_size, snake.sn.get(i).y
					* cell_size, cell_size + 1, cell_size + 1);

		// Paint Canvas
		graph.setColor(Color.blue);
		for (int i = 0; i < width; i += cell_size)
			graph.drawLine(i, 0, i, height);

		for (int i = 0; i < width; i += cell_size)
			graph.drawLine(0, i, width, i);

		g.drawImage(image, 0, 0, width, height, null);
	}

	public void run() {

		while (this.isEnabled()) {
			if (!lose) {
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				updateData();
			}
		}
	}
}