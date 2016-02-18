
public class ItemList extends EntityGroup implements Printable {
	public void addItem(Item i) {
		addNode(i);
	}
	public Item getItem(int i) {
		return (Item)super.getNode(i);
	}
	public void removeItem(Item i) {
		super.removeNode(i);
	}
	public int getItemListSize() {
		return super.getNodes().size();
	}
	
}
