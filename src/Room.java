
public class Room extends EntityGroup implements Printable{
	
	private ItemList itemsInRoom = new ItemList(); //this is only for the items
	//note that since this is also an Entity group we have arraylist of Nodes!
	//this is useful for things like items within items (treasure chests)
	//or even a room within an item or something like that
	public void setItemList(ItemList items) {
		itemsInRoom = items;
	}
	public void addItemToRoom(Item i) {
		itemsInRoom.addItem(i);
	}
	public ItemList getItemList() {
		return itemsInRoom;
	}
	public void deleteItemFromRoom(Item item) {
		//caution: will delete all items with that name
		for(int i = 0; i<itemsInRoom.getItemListSize(); i++){
			Item curItem = itemsInRoom.getItem(i);
			if(curItem.getName().equals(item.getName())) {
				itemsInRoom.removeItem(item);
			}
		}
	}
	Room(){
		super();
	}
	Room(String name){
		super(name);
	}
	Room(ItemList itemlist)
	{
		super();
		setItemList(itemlist);
	}
	Room(ItemList itemlist, int x, int y){
		setItemList(itemlist);
		setX(x);
		setY(y);
	}
	Room(String name, ItemList itemlist, int x, int y){
		super(name);
		setItemList(itemlist);
		setX(x);
		setY(y);
	}


}
