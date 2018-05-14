import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
    @Override
    public ArrayList<Location> getMoveLocations()
    {
        int direction = getDirection();
        int[] dir = { direction + Location.LEFT, direction + Location.RIGHT };
        ArrayList<Location> locs = getLocationsTwoSpaceAway(dir);

        if (locs.size() == 0)
        {
            return super.getMoveLocations();
        }

        return locs;
    }

    private ArrayList<Location> getLocationsTwoSpaceAway(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> grid = getGrid();
        Location current = getLocation();

        for (int d : directions)
        {
            Location loc = current.getAdjacentLocation(d);


            if (grid.isValid(loc) && grid.get(loc) == null)
            {
                Location dest = loc.getAdjacentLocation(d);


                if (grid.isValid(dest) && grid.get(dest) == null)
                {
                    locs.add(dest);
                }
            }
        }

        return locs;
    }
}