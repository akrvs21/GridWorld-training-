import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public abstract class AbstractBoundedGrid<E> extends AbstractGrid<E>
{
    // size of the grid
    private int cols;
    private int rows;

    public AbstractBoundedGrid(int rows, int cols)
    {
        if (rows <= 0)
        {
            throw new IllegalArgumentException("rows <= 0");
        }

        if (cols <= 0)
        {
            throw new IllegalArgumentException("cols <= 0");
        }

        this.cols = cols;
        this.rows = rows;
    }


    @Override
    public int getNumRows()
    {
        return rows;
    }


    @Override
    public int getNumCols()
    {
        return cols;
    }


    @Override
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
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