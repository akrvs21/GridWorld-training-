

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class CircleBugRunner {

	public static void main(String[] args) {
		  ActorWorld world = new ActorWorld();
		CircleBugs alice = new CircleBugs(2);// 定义对象alice的sideLength值
	        alice.setColor(Color.ORANGE);
		CircleBugs bob = new CircleBugs(2);//定义对象bob的sideLength值
	        world.add(new Location(8, 5), alice);//对象的位置
	        world.add(new Location(4, 4), bob);//对象的位置
	        world.show();

	}

}
