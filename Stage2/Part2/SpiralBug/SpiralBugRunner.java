import info.gridworld.actor.ActorWorld;
		import info.gridworld.grid.Location;

		import java.awt.Color;

public class SpiralBugRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		SpirallBug alice = new SpirallBug(2);
		alice.setColor(Color.ORANGE);
		//SpirallBug bob = new SpirallBug(9);
		world.add(new Location(4, 4), alice);
		//  world.add(new Location(5, 5), bob);
		world.show();
	}

}
