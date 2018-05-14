package jump;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import java.awt.Color;
import info.gridworld.actor.Flower;

public class JumperRunner
{
     public static void main(String[]  srgs)
     {
    ActorWorld world = new ActorWorld();
    Jumper grasshopper = new Jumper(); /* objects */
    grasshopper.setColor(Color.ORANGE); /* setting color */
    world.add(new Location(4,0),grasshopper);  /* location  */
    world.add(new Rock()); /* adding a rock */
    world.add(new Flower()); /* adding a flower */
    world.show(); 
    
     }
}