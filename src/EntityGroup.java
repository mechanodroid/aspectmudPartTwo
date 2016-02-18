import java.util.ArrayList;


public class EntityGroup extends Node implements Position {
	private ArrayList<Node> nodes = new ArrayList<Node>();

	
	EntityGroup() {
		super();
	}
	EntityGroup(String name) {
		super(name);
	}
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public Node getNode(int i) {
		return nodes.get(i);
	}
	public void addNode(Node node) {
		nodes.add(node);
	}
	public void removeNode(Node node) {
		nodes.remove(node);
	}
	public boolean find(Node node) {
		return nodes.contains(node);
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
