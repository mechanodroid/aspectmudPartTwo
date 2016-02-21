import java.util.ArrayList;

public class ItemList extends EntityGroup implements Printable {
	public void addItem(Item i) {
		addNode(i);
	}
	public Item getItem(int i) {
		Node n = getNode(i);
		return (Item)n;
	}
	public void removeItem(Item i) {
		removeNode(i);
	}
	public int getItemListSize() {
		ArrayList<Node> itemListfromAspect = getNodes();
		return itemListfromAspect.size();
	}
	
}
