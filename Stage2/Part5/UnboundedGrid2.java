import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class UnboundedGrid2<E> extends AbstractGrid<E>
{
    private Object[][] occupantArray;
    // current size
    private int size;
    // default size
    private static final int DEFAULT_SIZE = 16;


    public UnboundedGrid2()
    {
        size = DEFAULT_SIZE;
        occupantArray = new Object[size][size];
    }


    public int getNumRows()
    {
        return -1;
    }


    public int getNumCols()
    {
        return -1;
    }


    protected int getSize()
    {
        return size;
    }

    protected void setSize(int size)
    {
        this.size = size;
    }


    public boolean isValid(Location loc)
    {
        // All valid locations have non-negative row and
        // column values.

        return loc.getRow() >= 0 && loc.getCol() >= 0;
    }



    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        int size = getSize();

        // Look at all grid locations.
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                Location loc = new Location(i, j);
                if (get(loc) != null)
                {
                    theLocations.add(loc);
                }
            }
        }
        return theLocations;
    }


    @SuppressWarnings("unchecked")
    @Override
    public E get(Location loc)
    {
        checkLocation(loc);

        int targetRow = loc.getRow();
        int targetCol = loc.getCol();
        int size = getSize();

        // The location is out of the grid
        if (targetRow >= size || targetCol >= size)
        {
            return null;
        }

        Object obj = occupantArray[targetRow][targetCol];
        if (obj == null)
        {
            return null;
        }
        else
        {
            return (E) obj;
        }
    }



    public E put(Location loc, E obj)
    {
        checkLocation(loc);

        if (obj == null)
        {
            throw new IllegalArgumentException("obj == null");
        }

        int targetRow = loc.getRow();
        int targetCol = loc.getCol();
        int size = getSize();

        // if the Location is out of the grid, resize the grid
        if (targetRow >= size || targetCol >= size)
        {
            resize(loc);
        }

        // Add the object to the grid.
        E oldOccupant = get(loc);
        occupantArray[targetRow][targetCol] = obj;
        return oldOccupant;
    }



    public E remove(Location loc)
    {
        checkLocation(loc);

        E obj = get(loc);

        // if the location is empty or not in the grid, return null
        if (obj == null)
        {
            return null;
        }

        // Remove the object from the grid.
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }

    private void resize(Location loc)
    {
        int oldSize = getSize();

        // double both array bounds until they are large enough
        int sizeNeeded = oldSize;
        int targetRow = loc.getRow();
        int targetCol = loc.getCol();

        while (targetRow >= sizeNeeded || targetCol >= sizeNeeded)
        {
            sizeNeeded *= 2;
        }

        Object[][] temp = new Object[sizeNeeded][sizeNeeded];

        // copy the occupants over
        for (int i = 0; i < oldSize; i++)
        {
            for (int j = 0; j < oldSize; j++)
            {
                temp[i][j] = occupantArray[i][j];
            }
        }

        // update the occupantArray and the zie
        occupantArray = temp;
        this.size = sizeNeeded;
    }

    protected void checkLocation(Location loc)
    {
        if (loc == null)
        {
            throw new IllegalArgumentException("loc == null");
        }

        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
    }
}