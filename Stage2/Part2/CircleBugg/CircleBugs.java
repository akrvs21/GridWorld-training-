

import info.gridworld.actor.Bug;


public class CircleBugs extends Bug
{
	 private int steps;
	    private int sideLength;

	    
	    public CircleBugs(int length)
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
	            turn(); //如果变量steps等于sideLength，同时还能走。就转方向45度
	            steps = 0;//重新开始计算步数
	        }
	    }

}
