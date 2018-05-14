import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown


	int[] directions = { 360, 90, 180,270 }; // ne otsuda

	/**
	 * Constructs a box bug that traces a square of a given side length
	 *
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		last = new Location(0, 0);
		ArrayList<Location> firstPass = new ArrayList<Location>();
		next = getLocation();
		firstPass.add(last);
		firstPass.add(next);
		crossLocation.push(firstPass);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd == true) {
			//to show step count when reach the goal
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
			//increase step count when move
			stepCount++;
		} else {
            reverse(); 
            stepCount++;
            }
	}

	/**
	 * Find all positions that can be move to.
	 *
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();

		if (gr == null)
		{
			return null;
		}

		ArrayList<Location> valid = new ArrayList<Location>();
		for(int vd : directions) {
			Location location = loc.getAdjacentLocation(vd);
			if (!gr.isValid(location)) //nt
			{
				continue;
			}
			Actor actorLoc = gr.get(location); // if its null,add it to valid
			if(actorLoc == null) {
				valid.add(location);

			}else if (actorLoc instanceof Rock && actorLoc.getColor().equals(Color.RED))
			{
				valid.add(location);
			}

		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 *
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		//  get valid adjacent locations
		Location loc = getLocation();
		ArrayList<Location> valid = getValid(loc);

		// if there is no valid location around
		if (valid.size() <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	private void nextMove() {
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		ArrayList<Location> valid = getValid(loc);
		Random randomno = new Random();
		int n = randomno.nextInt(valid.size());
		last = next;
		next = valid.get(n);

	}

	private void reverse()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
		{
			return;
		}

		if (crossLocation.size() == 0)
		{
			return;
		}

		Location loc = getLocation();


		crossLocation.pop(); //current location

		// the stack is empty, there is no way to go back
		if (crossLocation.size() == 0)
		{
			return;
		}

		// get the src of top. which is [0] at
		// the linked list one way below the top
		next = crossLocation.peek().get(0);
		last = loc;

		// move back to src
		setDirection(loc.getDirectionToward(next));
		moveTo(next);

		// drop flower
		FlowerF(loc);
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
		{
			return;
		}

		// pick next location (via field next and last)
		// assert: canMove -- getValid.size != 0 -- next != here
		nextMove();

		if (!gr.isValid(next))
		{
			removeSelfFromGrid();
			return;
		}

		// if the end is reached, mark it
		Actor nextActor = gr.get(next);
		if (nextActor instanceof Rock)
		{
			isEnd = true;
		}

		// move to the next location
		Location loc = getLocation();

		setDirection(loc.getDirectionToward(next));
		moveTo(next);

		FlowerF(loc);

		//  add next to the end of the top linked list (visited from here)
		crossLocation.peek().add(next);

		//  push a new <(next)> into the stack
		ArrayList<Location> Top = new ArrayList<Location>();
		Top.add(next);
		crossLocation.push(Top);
	}

	private void FlowerF(Location loc)
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
		{
			return;
		}
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}


}

