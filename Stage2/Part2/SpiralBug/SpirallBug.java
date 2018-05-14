import info.gridworld.actor.Bug;

public class SpirallBug extends Bug
{
	 private int steps;
	    private int sideLength;

	   
	    public SpirallBug(int length)
	    {
	        steps = 0;
	        sideLength = length;
	    }

	  
	    public void act()
	    {
	        if (steps < sideLength && canMove())
	        {
	            move();
	            steps++;
	        }
	        else
	        {
	            turn();
	            turn();
	            steps = 0;
	            sideLength++;
	        }
	    }
}
