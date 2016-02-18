
public class Item extends Entity {
	private int value;
	public Item() {
		super();
	}
	public Item(String name, int x, int y) {
		super.setName(name);
		super.setX(-1);//items don't need position data
		super.setY(-1);
	}
	public Item(String name) {
		super(name, -1, -1);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int i) {
		value = i;
	}

	
}
