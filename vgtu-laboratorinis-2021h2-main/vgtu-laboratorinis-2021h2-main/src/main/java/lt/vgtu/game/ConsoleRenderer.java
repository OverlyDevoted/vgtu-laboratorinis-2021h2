package lt.vgtu.game;

import java.util.List;

public class ConsoleRenderer {

	private List<Rocket> rockets;
	private Map map;

	public ConsoleRenderer(Map map, List<Rocket> rockets) {
		this.map = map;
		this.rockets = rockets;
	}

	public void render() {
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth(); x++) {
				int element = map.getElement(x, y);
				drawMap(y, x, element);
			}
			System.out.println();
		}
	}

	private void drawMap(int y, int x, int element) {
		if (element == 1)
			drawAsteroid();
		else
		if (isRocketTail(x, y))
			drawRocketTail();
		else
		if (isRocketHead(x, y))
			drawRocketHead();
		else
			drawSpace();
	}

	private boolean isRocketHead(int x, int y) {
		for (Rocket rocket: rockets)
			if (rocket.getX()+1 ==x && rocket.getY() == y)
				return true;
		
		return false;
	}

	private boolean isRocketTail(int x, int y) {
		for (Rocket rocket: rockets)
			if (rocket.getX() ==x && rocket.getY() == y)
				return true;
		
		return false;
	}

	private static void drawSpace() {
		System.out.print(" ");
	}

	private static void drawRocketHead() {
		System.out.print(">");
	}

	private static void drawRocketTail() {
		System.out.print("<");
	}

	private static void drawAsteroid() {
		System.out.print("*");
	}
}
