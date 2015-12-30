package zombieMaze;

import zombieMaze.Map;

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

public	static double normaliseAngle(double angleOffset) {
	angleOffset+=Math.PI*2;
	angleOffset%=Math.PI*2;
	return angleOffset;
	}

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

	/**
	 * @return the x coordinate
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * @return the y coordinate
	 */
	public int getY() {
		return (int) y;
	}

/**
	* Angle from facing up in radians
	*/
	public double angle=Math.PI;//player starts facing down
	/**
	* ammo for the laser gun
	*/
	private  int lasers = 24;// Ima fire my laser!
/**
	* number of grenades we have
	*/
	private int grenades = 5;//melee weapon
	/**
		* if the player is alive are not
		*/
	public boolean alive = true;
	/**
		* x coordinate
		*/
	public double x = 5.0;
	/**
		* y coordinate
		*/
	public double y = 5.0;

/**
	* shoots a laser which breaks the blocks in its range
	*/
	public void shoot() {
		if(getLasers()>0){
		lasers--;
		new Laser(getX(), getY());
		}
		}
/**
	* wasd to move
	* space to drop a grenade 
	* q to shoot
	* @param move the move being made as a character 
	*/
	public void move(char move) {
		Map.map[getX()][getY()]='o';
		dance:
		{
		int oldX = getX();
		int oldY = getY();
		if (move == 'w') {
			x+=.5*Math.sin(angle);
					y-=.5*Math.cos(angle);
		} else if (move == 's') {
						x-=.5*Math.sin(angle);
					y+=.5*Math.cos(angle);
		} else if (move == 'a') {
			angle-=Math.PI/24;
			angle%=2*Math.PI;
		} else if (move == 'd') {
			angle+=Math.PI/24;
			angle%=2*Math.PI;
		} else if (move == ' ') {
			if (Map.zombies != null) {
				if (getGrenades() > 0) {
					for (Zombie z : Map.zombies) {
						if (z != null) {
							int meleeDist = 5;
							if (Math.sqrt(Math.pow(z.getX() - this.getX(), 2) + Math.pow(z.getY() - this.getY(), 2)) < meleeDist) {
								z.die();
							}
						}
					}
					for (int i = getX() - 3; i <= getX() + 3; i++) {
						for (int j = getY() - 3; j <= getY() + 3; j++) {
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
			break dance;
		} else if(move=='q'){
			shoot();
			break dance;
		}
		boolean open = false;
		try {
			//if Map.pathFind at that coordinate is 0 then it is unreachable
			//either a wall or a diagonal movement through a corner
			open = Map.pathFind[getX()][getY()]!=0;
		if(!open&&Map.pathFind[oldX][getY()]!=0){
			open=true;
			x=oldX;
		}else if(!open&&Map.pathFind[getX()][oldY]!=0){
			y=oldY;
			open=true;
		}
		} catch (Exception e) {
		}
		if (!open) {
			x = oldX;
			y = oldY;
		}
		}
		Map.doPathFinding();
	if(Map.map[getX()][getY()]=='a'){
		lasers+=5;
	grenades+=1;
	}
	else if(Map.map[getX()][getY()]=='g'){
		lasers+=10;
		Laser.range+=2;
	 Laser.level+=1;
		grenades+=2;
	}
				Map.map[getX()][getY()]='o';
	}
}
