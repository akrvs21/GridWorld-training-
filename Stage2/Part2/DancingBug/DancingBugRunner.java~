import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

		import java.awt.Color;

public class DancingBugRunner {

	public static void main(String[] args) {
		
		int[]arrBug = { 
			5,2,4,6
		};
                int[]dest = new int[4];
                System.arraycopy(arrBug,0,dest,0,arrBug.length);
		ActorWorld world = new ActorWorld();
		DancingBug alice = new DancingBug(dest);
		alice.setColor(Color.ORANGE);
		world.add(new Location(4, 4), alice);
		world.show();
	}

}
