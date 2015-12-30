/**
 * Some quotes on randomness from random.org The generation of random numbers is
 * too important to be left to chance. —Robert R. Coveyou Quantum mechanics is
 * certainly imposing. But an inner voice tells me that it is not yet the real
 * thing. The theory says a lot, but does not really bring us any closer to the
 * secret of the ‘old one.’ I, at any rate, am convinced that He does not throw
 * dice. —Albert Einstein Random numbers should not be generated with a method
 * chosen at random. —Donald Knuth Thank you to Hovercraft Full of Eels
 * stackOverflow user whose response to a question on stack overflow made this
 * code easy to write All joking aside use of this source code for educational
 * purposes is ok as long as it is attributed to the author. If you would like
 * to use it for anything else, contact me at rjhunjhunwala80@malvernprep.org
 *
 * @author Rohan Jhunjhunwala
 */
package zombieMaze;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameFrame extends JFrame {

	/**
	 * The amount of pixels in each tile here we are using 16 by 16 tiles
	 */
	public static final int screenRes = 3;
	/**
	 * the main JFRAME for the game
	 */
	static GameFrame m;
	/**
	 * Plays the game
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		do {
			Map map = new Map();
			Thread t = new Thread(map);
			//System.out.println(Arrays.deepToString(Map.map));
			t.start();
			m = new GameFrame();
			while (Map.p.alive) {
				m.repaint();
			}
			Map.round=0;
		} while (getBoolFromUser("Play Again?"));
		System.exit(0);
	}

	/**
	 * gets boolean from the user
	 *
	 * @param prompt a prompt to display for the user
	 * @return a boolean such that no response or any form of y Yes yes is true
	 * anything else is false
	 */
	public static boolean getBoolFromUser(String prompt) {
		IOSTRING i = new IOSTRING();
		String r = i.getStringFromPopUp(prompt);
		if (r.equals("")) {
			return true;
		} else {
			return r.toLowerCase().contains('y' + "");
		}
	}

	/**
	 * creates the game display frame
	 */
	GameFrame() {
		setSize(900, 900 + 22);
		setTitle("The Darkness Within");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.addKeyListener(new Controller());
		this.setResizable(false);
		this.setBackground(Color.orange);
	}

	/**
	 * Updates the display
	 *
	 * @param g a graphic
	 */

	public void twoD(Graphics g) {
		for (int i = 0; i < Map.map.length; i++) {
			for (int j = 0; j < Map.map[0].length; j++) {
				if (((int) Map.p.x == i) && ((int) Map.p.y == j)) {
					g.setColor(Color.blue);
					g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
					g.setColor(Color.orange);
					g.drawLine(i * screenRes + (screenRes / 2), j * screenRes + (screenRes / 2) + 22,
													(int) (i * screenRes + (screenRes / 2) + screenRes * Math.sin(Map.p.angle)), (int) (j * screenRes + (screenRes / 2) - screenRes * Math.cos(Map.p.angle)) + 22);
				} else if (Map.map[i][j] == 'g') {
					g.setColor(Color.GREEN);
					g.fillOval(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
				} else if (Map.map[i][j] == 'a') {
					g.setColor(Color.DARK_GRAY);
					g.fillOval(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
				} else if (Map.map[i][j] == 'o') {
					g.setColor(this.getBackground());
					g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
				} else if (Map.map[i][j] == 'z') {
					g.setColor(Color.RED);
					g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
				} else if (Map.map[i][j] == 'w') {
					g.setColor(Color.black);
					g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
				}
			}
	}
	}
	/**
	 * updates graphic
	 * @param board
	 */
	@Override
	public void paint(Graphics board){
	 double distance;
double lineHeight=-1;
double angleOff;			
double angleCast;
for(int i=0;i<900;i++){
				//i is the line across from the side.
			angleOff=Math.atan(((i-450.0)/4000.0)/.3);
			boolean hit=false;
			board.setColor(GameFrame.m.getBackground());
			board.drawLine(i, 922, i, 0);
			for( double rayDist=0;!hit;rayDist+=.02){
				try{
					char block=Map.map[(int) (Map.p.x+Math.sin(Player.normaliseAngle(angleOff+Map.p.angle))*rayDist)][(int) (Map.p.y-Math.cos(Player.normaliseAngle(angleOff+Map.p.angle))*rayDist)];
				if(block!='o'){
					lineHeight=800/(rayDist*Math.cos(angleOff  ));
					switch(block){
						case 'w':
							board.setColor(Color.BLACK);
					break;
						case 'z':
							board.setColor(Color.red);
						break;
						case 'g':
							board.setColor(Color.green);
						break;
						case 'a':
					board.setColor(Color.DARK_GRAY);
							break; 
					}
				hit=true;
				}
				}catch(Exception e){
					hit=true;
					lineHeight=800/(rayDist*Math.cos(angleOff));
					board.setColor(Color.black);}
			}

		board.drawLine(i,(int) (461-(lineHeight/2)), i,(int) (461+(lineHeight/2)));
}		
		board.setColor(Color.CYAN);
		board.drawString("Grenades: " + Map.p.getGrenades() + " Lasers: " + Map.p.getLasers()
										+ " Round: " + Map.round + " Gun Level: "
										+ Laser.level,620,35);
	board.setColor(Color.cyan);

	if(Map.zombies!=null){
	for(Zombie z:Map.zombies){
		if(z!=null){
			if(Math.sqrt(Math.pow(Map.p.x-z.getX(),2)+Math.pow(Map.p.y-z.getY(),2))<6){
				board.drawString("WARNING ZOMBIE(S) nearby!",15,850);
			break;
			}
		}
	}
	}
	board.setColor(Color.GRAY);
	board.drawString((int) ((Math.toDegrees(Map.p.angle)+360)%360)+"|"+Map.p.getX()+"|"+Map.p.getY(),15,900);
			twoD(board);
	try {
			Thread.sleep(30);
		} catch (InterruptedException ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
