package silvam;
/**
 *
 * @author rohan
 */
public class Laser {
public static int level=1;
	public static int range = 5;//this is the range and can be upgraded in game
	public int x;
	public int y;
/**
	* creates a laser and lets it do its thing
	* @param inX
	* @param inY 
	*/
	public Laser(int inX, int inY) {
		x = inX;
		y = inY;
		fireMahLaser();//sorry had to
	}

	/**
	 * Goes through and destroys everything in its range
		* my apologies for the name. It will not change @notTODO change the name
	 */
	public void fireMahLaser() {
		switch (Map.p.direction) {
			case up:
				for (int i = 1; i <= range; i++) {
					try {
							if(Map.map[x][y - i] == 'w'||Map.map[x][y - i] == 'z') {
								Map.map[x][y - i] = 'o';
							}
					} catch (Exception e) {
					}
					if (Map.zombies != null) {
						for (Zombie z : Map.zombies) {
							if (z != null) {
								if (z.getX() == x && z.getY() == y - i) {
									z.die();
								}
							}
						}
					}
				}
				break;
			case left:
				for (int i = 1; i <= range; i++) {
					try {
							if(Map.map[x - i][y]=='w'||Map.map[x - i][y]=='z'){
						Map.map[x - i][y] = 'o';
							}
					} catch (Exception e) {
					}
					if (Map.zombies != null) {
						for (Zombie z : Map.zombies) {
							if (z != null) {
								if (z.getX() == x - i && z.getY() == y) {
									z.die();
								}
							}
						}
					}
				}
				break;
			case right:
				for (int i = 1; i <= range; i++) {
					try {
						if (Map.map[x + i][y]=='w'||Map.map[x + i][y]=='z') {
							Map.map[x + i][y] = 'o';
						}
					} catch (Exception e) {
					}
					if (Map.zombies != null) {
						for (Zombie z : Map.zombies) {
							if (z != null) {
								if (z.getX() == x + i && z.getY() == y) {
									z.die();
								}
							}
						}
					}
				}
				break;
			case down:
				for (int i = 1; i <= range; i++) {
					try {
						if (Map.map[x][y + i] == 'w'||Map.map[x][y + i] == 'z') {
							Map.map[x][y + i] = 'o';
						}
					} catch (Exception e) {
					}
					if (Map.zombies != null) {
						for (Zombie z : Map.zombies) {
							if (z != null) {
								if (z.getX() == x && z.getY() == y + i) {
									z.die();
								}
							}
						}
					}
				}
				break;
		}
	}
}
