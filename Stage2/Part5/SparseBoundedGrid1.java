
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import info.gridworld.grid.Location;

public class SparseBoundedGrid1<E> extends AbstractBoundedGrid<E>
{

    private ArrayList<LinkedList<OccupantInCol>> occupantArray;


    public SparseBoundedGrid1(int rows, int cols)
    {
        super(rows, cols);

        // initialize the occupant array with LinkedLists
        occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
        for (int i = 0; i < rows; i++)
        {
            occupantArray.add(new LinkedList<OccupantInCol>());
        }
    }


    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        int rows = getNumRows();


        for (int r = 0; r < rows; r++)
        {
            LinkedList<OccupantInCol> row = occupantArray.get(r);
            if (row != null)
            {
                for (OccupantInCol occ : row)
                {
                    theLocations.add(new Location(r, occ.getCol()));
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

        int targetCol = loc.getCol();

        LinkedList<OccupantInCol> row = occupantArray.get(loc.getRow());
        if (row != null)
        {
            for (OccupantInCol occ : row)
            {
                if (occ.getCol() == targetCol)
                {
                    return (E) occ.getOccupant();
                }
            }
        }
        return null;
    }



    public E put(Location loc, E obj)
    {
        checkLocation(loc);

        if (obj == null)
        {
            throw new IllegalArgumentException("obj == null");
        }

        //Add the object to the grid.
        E oldOccupant = remove(loc);
        int targetRow = loc.getRow();
        int targetCol = loc.getCol();
        LinkedList<OccupantInCol> row = occupantArray.get(targetRow);
        row.add(new OccupantInCol(obj, targetCol));
        return oldOccupant;
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

        LinkedList<OccupantInCol> row = occupantArray.get(loc.getRow());

        int targetCol = loc.getCol();

        // assert: row != null
        Iterator<OccupantInCol> it = row.iterator();
        while (it.hasNext())
        {
            if (it.next().getCol() == targetCol)
            {
                it.remove();
                break;
            }
        }

        return obj;
    }
}