import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
	 private int steps;
	    private int sideLength;

	   
	    public ZBug(int length)
	    {
	        steps = 0;
	        sideLength = length;
	        setDirection(90); // Seting direction to East
	    }

	  
	    public void act() {
			if (steps < sideLength && canMove())//moving Z pattern
			{
			move();
			steps++;
			}

			else if(steps == sideLength)//changing direction
			{
			setDirection(225);
			if(canMove())// if true,continue move
			{
				move();
				steps++;
			}
			}

			else if(steps < sideLength * 2 && canMove())// moving Z pattern(2)
			{
				move();
				steps++;
			}

			else if (steps == sideLength * 2 && canMove())//changing direction
			{
				setDirection(90);
				if(canMove())
				{
					move();
					steps++;
				}
			}

			else if(steps < sideLength * 3 && canMove())// moving Z pattern(3)
			{
				move();
				steps++;
			}
	    }


}
