package jump;

import info.gridworld.actor.Actor; //importing actor
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;


public class Jumper extends Bug { // inherit methods from Bug
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
		{	return;}
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location nextTOnext = next.getAdjacentLocation(getDirection());

		if (gr.isValid(next) && (gr.get(next) == null))
			{moveTo(next);}
		else if (gr.isValid(nextTOnext))
			{ moveTo(nextTOnext); }
		else {removeSelfFromGrid();}
	}

	public boolean canMove() { // if empty,return true
		Grid<Actor> gr = getGrid();
		if (gr == null)  
		{	return false; }

		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location nextTOnext = next.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			{ return false; }

		Actor neighbor = gr.get(next);
		return (neighbor == null) || (gr.isValid(nextTOnext) && neighbor != null && gr.get(nextTOnext) == null);
	}

}
