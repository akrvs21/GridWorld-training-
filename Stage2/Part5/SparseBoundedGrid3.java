import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.util.ArrayList;

public class SparseBoundedGrid3<E> extends AbstractBoundedGrid<E>
{
    private UnboundedGrid<E> innerGrid;


    public SparseBoundedGrid3(int rows, int cols)
    {
        super(rows, cols);
        this.innerGrid = new UnboundedGrid<E>();
    }


    public E get(Location loc)
    {
        return innerGrid.get(loc);
    }


    public ArrayList<Location> getOccupiedLocations()
    {
        return innerGrid.getOccupiedLocations();
    }


    public E put(Location loc, E obj)
    {
        return innerGrid.put(loc, obj);
    }


    public E remove(Location loc)
    {
        return innerGrid.remove(loc);
    }
}