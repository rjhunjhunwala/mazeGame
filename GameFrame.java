/**
 * Some quotes on randomness from random.org The generation of random numbers is
 * too important to be left to chance. —Robert R. Coveyou Quantum mechanics is
 * certainly imposing. But an inner voice tells me that it is not yet the real
 * thing. The theory says a lot, but does not really bring us any closer to the
 * secret of the ‘old one.’ I, at any rate, am convinced that He does not throw
 * dice. —Albert Einstein Random numbers should not be generated with a method
 * chosen at random. —Donald Knuth Thank you to Hovercraft Full of Eels
 * stackOverflow user whose response to a question on stack overflow made this
 * code easy to write
	* All joking aside use of this source code for educational purposes is ok as 
	* long as it is attributed to the author. If you would like to use it for
	* anything else, contact me at rjhunjhunwala80@malvernprep.org
 * @author Rohan Jhunjhunwala
 */
package silvam;

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
	public static final int screenRes = 16;
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
			t.start();
			m = new GameFrame();
			while (Map.p.alive) {
				m.repaint();
			}
		} while (getBoolFromUser("Play Again?"));
		System.exit(0);
	}

	/**
	 * gets boolean from the user
	 *
	 * @param prompt a prompt to display for the user
	 * @return a boolean such that no responser or any form of y Yes yes is true
	 * anything else is true
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
		setSize(Map.map.length * screenRes, Map.map[0].length * screenRes + 22);
		setTitle("The Darkness Within");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.addKeyListener(new Controller());
		this.setResizable(false);
		this.setBackground(Color.WHITE);
	}

	/**
	 * Updates the display
	 *
	 * @param g a graphic
	 */
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < Map.map.length; i++) {
			for (int j = 0; j < Map.map[0].length; j++) {
				if (Map.map[i][j] == 'g') {
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
				} else if (Map.map[i][j] == 'p') {
					g.setColor(Color.blue);
					g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
					g.setColor(Color.orange);
					switch (Map.p.direction) {
						case up:
							g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes / 4);
							break;
						case left:
							g.fillRect(i * screenRes, 22 + screenRes * j, screenRes / 4, screenRes);
							break;
						case right:
							g.fillRect(i * screenRes + (3 * screenRes) / 4, 22 + screenRes * j, screenRes / 4, screenRes);
							break;
						case down:
							g.fillRect(i * screenRes, 22 + screenRes * j + (3 * screenRes) / 4, screenRes, screenRes / 4);
							break;
					}
				} else if (Map.map[i][j] == 'w') {
					g.setColor(Color.black);
					g.fillRect(i * screenRes, 22 + screenRes * j, screenRes, screenRes);
				}
			}
		}
//Tell the player information about the state in the top right
		g.setColor(Color.GREEN);
		g.drawString("Grenades: " + Map.p.getGrenades() + " Lasers: " + Map.p.getLasers()
										+ " Round: " + Map.round + " Gun Level: "
										+ Laser.level, screenRes * Map.map.length * 3 / 5, 35);
		try {
			Thread.sleep(40);
		} catch (InterruptedException ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
