/*
	"The Only Easy Day Was Yesterday"-Us seal teams
"It Pays to be a Winner"-US seal teams
"The generation of random numbers is too important to be left to chance."
-Robert coveyou
*/
package silvam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
	* This class generates the maze
	* implements a simple depth first recursive backtracker 
	* @author rohan
	*/
public class MazeHandler {
/**
	* if the size is even the maze will not be nicely contained by walls
	* Also the "glade" in the middle will be off center. 
	* Not a big deal because the program automatically renders positions off the 
	* side of the maze as walls
	* recommended size 31
	*/
	 public static int size=50;

/**
	* THe size along the y dimension
	*/
public	static int ySize = size;
	/**
		* The size of the x dimension
		*/
public	static int xSize = size;
	/**
		* The dimensions are by default all the same. I.e the maze is a square
		*/
	/**
		* start position for the human and the maze generator
		*/
	public static int[] position = { 0,0,1, 1};
	/**
		* 2d maze 1 is an open space 0 is a wall (they all start as walls)
	 */
	public static int[][] maze = new int[ySize][xSize];
	/**
		* the nodes for use in the algorithm to make a perfect maze (theoretically)
		* there is a odd bug somewhere here that leaves a loop
		* note in the end this is irrelevant as we poke holes in the maze anyway 
		* A place for the program to store the places its carved passages to
		* This way it can recursively backtrack to them when needed 
	 */
	private static ArrayList<int[]> nodes = new ArrayList(1);
	/**
		* turns the int[][] maze into a 2d maze with a recursively backtracking
		* algorithm that
		* carves passages by setting the value of the index =1 
		* 1=hole 
		* 0= wall 
		* (optimized to prevent me from having to manually fill in walls)
	 * @return a int[][] of mazes
		*/
	public static int[][] make2dMaze() {
		maze = new int[ySize][xSize];
		position=new int[4];
		position[2]=1;
		position[3]=1;
		int[] mazeCoords = position.clone();
		nodes.add(0, mazeCoords);
		while (nodes.size() > 0) {
			findNewNode(nodes.get(nodes.size() - 1));
		}

int d=size/10+7;	
//make little open dungeons
		for(int x=d+3;x<size-d-3;x+=d){
			for(int y=d+3;y<size-d-3;y+=d){
				int xShift=Utility.getRandom(7)-3;
				int yShift=Utility.getRandom(7)-3;
				if(Utility.getRandom(100)<65){
		makeGlade(x+xShift,y+yShift);
	}
		}
		}
	return maze.clone();
		}
		
	/**
		*finds the next non visited node in the maze
		* @param node
		* from which its looking for nodes to grow to
		* if it fails it deletes this node from the list of nodes its growing to
		* otherwise it adds the first random node it finds
		*/
	public static void findNewNode(int[] node) {
		boolean done = false;
		int counter = 0;
		int choice;
		while (!done) {
			if (counter >= 12) {
				choice = counter - 12;
			} else {
				choice = Utility.getRandom(4)+4;
			}
			try { if (choice == 4) {
					if (maze[node[2] + 2][node[3]] == 0) {
						maze[node[2] + 2][node[3]] = 1;
						maze[node[2] + 1][node[3]] = 1;
						node[2] += 2;
						done = true;
					}
				} else if (choice == 5) {
					if (maze[node[2] - 2][node[3]] == 0) {
						maze[node[2] - 2][node[3]] = 1;
						maze[node[2] - 1][node[3]] = 1;
						node[2] -= 2;
						done = true;
					}
				} else if (choice == 6) {
					if (maze[node[2]][node[3] + 2] == 0) {
						maze[node[2]][node[3] + 2] = 1;
						maze[node[2]][node[3] + 1] = 1;
						node[3] += 2;
						done = true;
					}
				} else if (choice == 7) {
					if (maze[node[2]][node[3] - 2] == 0) {
						maze[node[2]][node[3] - 2] = 1;
						maze[node[2]][node[3] - 1] = 1;
						node[3] -= 2;
						done = true;
					}
				} else if (choice == 8) {//wait a second there are no choices left
					nodes.remove(nodes.size() - 1);
					return;
				}
				
			} catch (Exception e) {/*gotcha*/
//cant afford to go off the map now can we
				
			}
			counter++;
		}
		int[] cloned = node.clone();
		nodes.add(cloned);
		
	}

		public static boolean getUserBool(String prompt){
			IOSTRING u=new IOSTRING();
			return u.getStringFromPopUp(prompt).toLowerCase().contains("y");
		}
	/**
		* makes the little holes in the maze
		* Almost like the glade in maze runner
		* By glade radius it means the farthest distance away from the center cube
		* the glade extends counting diagonals as only one unit of distance 
		* (we use neither pythagoras nor taxicab norms)
	 * @param centerX
	 * @param centerY
		*/
	public static void makeGlade(int centerX,int centerY) {
		int d=size/20+1;
			for (int y = centerY- d; y <= centerY + d; y++) {
				for (int x = centerX - d; x <= centerX + d; x++) {
					try {
						if(Math.abs(x-centerX)==d||Math.abs(y-centerY)==d){
							
						}else {
							maze[y][x]=1;
						}
					} catch (Exception e) {
						/**gotcha*/
					}
			}
		}
		
	}
}