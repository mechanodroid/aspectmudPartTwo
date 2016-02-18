
public abstract class Node {

	/**
	 * @param args
	 */
	private String name;

	//in general we don't want nodes to have positional data
	//anything with positional data should implement Position
	//and from there it can retrieve x and y
	protected int x; 
	protected int y;

	public Node() {
		
	}
	public Node(String name) {
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

}
