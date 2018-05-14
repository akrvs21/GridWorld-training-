
public class OccupantInCol
{
    private Object occupant;
    private int col;

    public OccupantInCol(Object occupant, int col)
    {
        this.occupant = occupant;
        this.col = col;
    }


    public void setOccupant(Object occupant)
    {
        this.occupant = occupant;
    }

    public Object getOccupant()
    {
        return occupant;
    }

    public int getCol()
    {
        return col;
    }
}