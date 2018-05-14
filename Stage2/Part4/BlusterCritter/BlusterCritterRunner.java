import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;

public class BlusterCritterRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Critter());
        world.add(new Critter());
        world.add(new Critter());
        world.add(new BlusterCritter(1));
        world.show();
    }
}