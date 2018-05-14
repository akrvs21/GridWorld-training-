
import java.util.ArrayList;
import info.gridworld.grid.Location;

public class SparseBoundedGrid<E> extends AbstractBoundedGrid<E>
{
    // the array storing the occupants
    private SparseGridNode[] occupantArray;


    public SparseBoundedGrid(int rows, int cols)
    {
        super(rows, cols);
        occupantArray = new SparseGridNode[rows];
    }

    @Override
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        int rows = getNumRows();

        for (int i = 0; i < rows; i++)
        {
            SparseGridNode node = occupantArray[i];
            while (node != null)
            {
                Location loc = new Location(i, node.getCol());
                theLocations.add(loc);
                node = node.getNext();
            }
        }

        return theLocations;
    }


    @SuppressWarnings("unchecked")
    @Override
    public E get(Location loc)
    {
        checkLocation(loc);
        
        SparseGridNode node = occupantArray[loc.getRow()];

        while (node != null)
        {
            if (loc.getCol() == node.getCol())
            {
                return (E) node.getOccupant();
            }
            node = node.getNext();
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


        E oldOccupant = remove(loc);
        int row = loc.getRow();
        int col = loc.getCol();
        SparseGridNode node = occupantArray[row];
        occupantArray[row] = new SparseGridNode(obj, col, node);

        return oldOccupant;
    }


    public E remove(Location loc)
    {
        checkLocation(loc);

        E obj = get(loc);

        if (obj == null)
        {
            return null;
        }

        int targetRow = loc.getRow();
        int targetCol = loc.getCol();
        SparseGridNode target = occupantArray[targetRow];

        if (target.getCol() == targetCol)
        {
            // move the next one ahead
            occupantArray[targetRow] = target.getNext();
        }
        else
        {

            SparseGridNode cur = target.getNext();
            while (cur != null && cur.getCol() != targetCol)
            {
                target = target.getNext();
                cur = cur.getNext();
            }

            // remove the found occupant
            if (cur != null)
            {
                // let the previous node point to the next node
                target.setNext(cur.getNext());
            }
        }

        return obj;
    }
}