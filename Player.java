package silvam;

import silvam.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rohan
 */
public class Player {

	/**
	 * @return the lasers
	 */
	public int getLasers() {
		return lasers;
	}

	/**
	 * @return the grenades
	 */
	public int getGrenades() {
		return grenades;
	}

	public static enum Direction {

		/**
		 * facing towards negative y
		 */
		up,//negative y
		/**
		 * facing towards positive y
		 */
		down,//positive y
		/**
		 * facing towards negative x
		 */
		left,//negative x
		/**
		 * facing towards positive x
		 */
		right //positive x
	}
	/**
		* The direction this is facing
		*/
	public Direction direction = Direction.up;
/**
	* ammo for the laser gun
	*/
	private int lasers = 16;// Ima fire my laser!
/**
	* number of grenades we have
	*/
	private int grenades = 2;//melee weapon
	/**
		* if the player is alive are not
		*/
	public boolean alive = true;
	/**
		* x coordinate
		*/
	public int x = 1;
	/**
		* y coordinate
		*/
	public int y = 1;
/**
	* shoots a laser which breaks the blocks in its range
	*/
	public void shoot() {
		if(getLasers()>0){
		lasers--;
		new Laser(x,y);
		}
		}
/**
	* wasd to move
	* space to drop a grenade 
	* q to shoot
	* @param move the move being made as a character 
	*/
	public void move(char move) {
		//System.out.println(x+"|"+y);
		int oldX = x;
		int oldY = y;
		Map.map[oldX][oldY] = 'o';
		if (move == 'w') {
			direction = Direction.up;
			y--;
		} else if (move == 's') {
			direction = Direction.down;
			y++;
		} else if (move == 'a') {
			direction = Direction.left;
			x--;
		} else if (move == 'd') {
			direction=Direction.right;
		 x++;
		} else if (move == ' ') {
			if (Map.zombies != null) {
				if (getGrenades() > 0) {
					for (Zombie z : Map.zombies) {
						if (z != null) {
							int meleeDist = 5;
							if (Math.sqrt(Math.pow(z.getX() - this.x, 2) + Math.pow(z.getY() - this.y, 2)) < meleeDist) {
								z.die();
							}
						}
					}
					for (int i = x - 3; i <= x + 3; i++) {
						for (int j = y - 3; j <= y + 3; j++) {
							try {
								if (Map.map[i][j] == 'w' || Map.map[i][j] == 'z') {
									Map.map[i][j] = 'o';
								}
							} catch (Exception e) {
							}
						}
					}
					grenades--;
				}
			}
		} else if(move=='q'){
			shoot();
		}
		boolean open = false;
		try {
			open = Map.map[x][y] == 'o' || Map.map[x][y] == 'a'||Map.map[x][y] == 'g';
			if (Map.map[x][y] == 'a') {
				grenades += Utility.getRandom(5)==0?1:0;
				lasers+=2+Utility.getRandom(3);
			}
				if (Map.map[x][y] == 'g') {
	//gun upgrade kit
					lasers+=5;
				Laser.range+=2;
				Laser.level++;
			}
		} catch (Exception e) {
		}
		if (!open) {
			x = oldX;
			y = oldY;
		}
		Map.map[x][y] = 'p';
		Map.doPathFinding();
	}
}
