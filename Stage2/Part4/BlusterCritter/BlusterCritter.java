import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


public class BlusterCritter extends Critter
{
    private final int critters;
    private static final Color DEFAULT_COLOR = Color.GREEN;


    public BlusterCritter(int critters)
    {
        this.critters = critters;
        setColor(DEFAULT_COLOR);
    }


    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();

        Grid<Actor> grid = getGrid();
        if (grid == null)
        {
            return actors;
        }


        Location location = getLocation();
        int left = location.getRow() - 2;
        int right = location.getRow() + 2;
        int top = location.getCol() - 2;
        int bottom = location.getCol() + 2;


        for (int i = left; i <= right; i++)
        {
            for (int j = top; j <= bottom; j++)
            {
                Location checkedLoc = new Location(i, j);
                if (grid.isValid(checkedLoc))
                {
                    Actor neighbor = grid.get(checkedLoc);
                    if (neighbor != null && neighbor != this)
                    {
                        actors.add(neighbor);
                    }
                }
            }
        }

        return actors;
    }


    public void processActors(ArrayList<Actor> actors)
    {
        int count = 0;
        for (Actor neighbor : actors)
        {
            if (neighbor instanceof Critter)
            {
                count++;
            }
        }

        changeColor(count < critters);
    }

    private void changeColor(boolean brighter)
    {
        int p = brighter ? 10 : -10;

        Color color = getColor();
        int red = channelFilter(color.getRed(), p);
        int blue = channelFilter(color.getBlue(), p);
        int green = channelFilter(color.getGreen(), p);

        setColor(new Color(red, green, blue));
        return;
    }

    private int channelFilter(int channel, int p)
    {
        int result = channel + p;
        result = result >= 255 ? 255 : result;
        result = result < 0 ? 0 : result;
        return result;
    }
}