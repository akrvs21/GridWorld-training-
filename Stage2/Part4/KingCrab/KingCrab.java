import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{

    private boolean isAdjacent(Location loca, Location locb)
    {
        int m1 = loca.getRow();
        int m2 = locb.getRow();
        int n1 = loca.getCol();
        int n2 = locb.getCol();
        double dist = Math.sqrt((m1 - m2) * (m1 - m2) + (n1 - n2) * (n1 - n2));
        return ((int) Math.floor(dist + 0.5)) <= 1;
    }

    private boolean canMoveAway(Actor a)
    {

        if (a instanceof Rock || a instanceof Flower)
        {
            return false;
        }

        ArrayList<Location> locs =
                getGrid().getEmptyAdjacentLocations(a.getLocation());

        for (Location loc : locs)
        {

            if (!isAdjacent(getLocation(), loc))
            {
                a.moveTo(loc);
                return true;
            }
        }
        return false;
    }

    @Override
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor neighbor : actors)
        {
            if (!canMoveAway(neighbor))
            {
                neighbor.removeSelfFromGrid();
            }
        }
    }
}