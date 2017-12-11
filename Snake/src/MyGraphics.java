class Direction {
	public int dir;

	// dir = 0 —> up
	// dir = 1 —> down
	// dir = 2 —> left
	// dir = 3 —> right

	public Direction() {
		dir = 1;
	}
}

class Coordinates {
	public int x, y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MyGraphics {
	public static void main(String[] args) {
		
        IntroFrame intro = new IntroFrame("Introduction");
        intro.setVisible(true);
		
	}
}