import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class ZBugRunner {

	public static void main(String[] args) {
		 ActorWorld world = new ActorWorld();
		 ZBug alice = new ZBug(3);
	        alice.setColor(Color.ORANGE);
	        world.add(new Location(4, 4), alice); //Location of an object
	        world.show();
	}

}
