package jump;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import org.junit.Test;
import static org.junit.Assert.*;

public class JumperTest {
 
    @Test
    public void testFrontFlower() {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        Flower flower = new Flower();
        world.add(new Location(7, 6), jumper);
        world.add(new Location(5, 6), flower);
        
        jumper.act();
        
          assertFalse(jumper.getLocation().getRow() == 5);
          assertTrue(jumper.getLocation().getCol() ==  6);

    }

    @Test
    public void testFrontRock() {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        Rock rock = new Rock();
        world.add(new Location(7, 3), jumper);
        world.add(new Location(5, 3), rock);

        jumper.act();
        
          assertFalse(jumper.getLocation().getRow() == 5);
          assertTrue(jumper.getLocation().getCol() ==  3);

    }

    @Test
    public void outOfGrid() { // b
        
        ActorWorld world = new ActorWorld();
   
        Jumper jumper = new Jumper();
        world.add(new Location(1, 7), jumper);

        int previousDir = jumper.getDirection();
        jumper.act();

          assertNotNull(jumper.getGrid());
          assertTrue(jumper.getDirection() == previousDir);
    }

    @Test
    public void facingEdge() {
        
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        world.add(new Location(0, 0), jumper);
        int originalDir = jumper.getDirection();
        
        jumper.act(); 
        
          assertFalse(jumper.getDirection() == originalDir);
    }

    @Test
    public void testFrontBug() {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        Bug bug = new Bug();
        world.add(new Location(4, 6), jumper);
        world.add(new Location(5, 6), bug);

        int originalDir = jumper.getDirection();
        
        jumper.act();
          assertFalse(jumper.getLocation().getRow() == 5);
          assertTrue(jumper.getLocation().getCol() ==  6);
          assertEquals(jumper.getDirection(), originalDir);

    }

    @Test
    public void testNewJumper() {
      
        ActorWorld world = new ActorWorld();

        Jumper jumper = new Jumper();
        Jumper jumper2 = new Jumper();
        world.add(new Location(8, 2), jumper);
        world.add(new Location(6, 2), jumper2);
        
        int originalDir = jumper.getDirection();
        
        jumper.act();
        
          assertTrue(jumper.getDirection() == originalDir);
          assertNotNull(jumper2.getGrid());
          assertEquals(jumper2.getLocation().getRow(), 6);
          assertEquals(jumper2.getLocation().getCol(), 2);

   }
}