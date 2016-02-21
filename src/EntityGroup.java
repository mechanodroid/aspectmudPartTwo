import java.util.ArrayList;


public class EntityGroup extends Node implements Position {

	Entity empty = new Entity();
	EntityGroup() {
		super();
	}
	EntityGroup(String name) {
		super(name);
	}
	ArrayList<Node> EntityGroupConstructorHelper() {
		return null; //overriden by advice
	}
	public void populateMasterNode(Node master) {
		ArrayList<Node> myNodes = EntityGroupConstructorHelper();
		myNodes.size(); //<--this is just to get rid of the warning on the line above which is meaningless
		
	}
	public ArrayList<Node> getNodes() {
		return null; //overriden by advice!
	}
	public Node getNode(int i) {
		//taken care of by advice
		return empty;
	}
	public void addNode(Node node) {
		//taken care of in the aspect!
	}
	public void removeNode(Node node) {
		//taken care of in the aspect
	}
	public boolean find(Node node) {
		return false;  //overriden by advice
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
}
