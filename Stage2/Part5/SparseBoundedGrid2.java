import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SparseBoundedGrid2<E> extends AbstractBoundedGrid<E>
{
    private Map<Location, E> occupantMap;


    public SparseBoundedGrid2(int rows, int cols)
    {
        super(rows, cols);
        occupantMap = new HashMap<Location, E>();
    }


    @Override
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet())
        {
            theLocations.add(loc);
        }

        return theLocations;
    }

    @Override
    public E get(Location loc)
    {
        checkLocation(loc);
        return occupantMap.get(loc);
    }


    public E put(Location loc, E obj)
    {
        checkLocation(loc);

        if (obj == null)
        {
            throw new IllegalArgumentException("obj == null");
        }

        //Add the object to the grid.
        return occupantMap.put(loc, obj);
    }


    public E remove(Location loc)
    {
        checkLocation(loc);

        E obj = get(loc);

        // if the location is empty, return null
        if (obj == null)
        {
            return null;
        }

        return occupantMap.remove(loc);
    }
}