
public class Entity extends Node implements Position {
	public Entity() {
		super();
	}
	public Entity(String name, int x, int y) {
		super.setName(name);
		setX(x);
		setY(y);
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
