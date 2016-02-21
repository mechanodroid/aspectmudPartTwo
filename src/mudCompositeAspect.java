import java.util.ArrayList;
public class mudCompositeAspect {
	public static class mud {
		public Node masterNode = new EntityGroup("master");
		mud()
		{
			((EntityGroup)masterNode).setName("masterEntityGroup");
			((EntityGroup)masterNode).populateMasterNode(masterNode);
		}
		public void printFromMasterNode() {
			ArrayList<Node> e = ((EntityGroup)masterNode).getNodes();
			for(int i = 0; i<((EntityGroup)masterNode).getNodes().size(); i++) {
				Node curNode = ((EntityGroup)masterNode).getNode(i);
				if(curNode instanceof Room) {
					System.out.println(((Room) curNode).getDescription(curNode));
				} else if(curNode instanceof Player) {
					System.out.println(((Player) curNode).getDescription(curNode));
				} else if(curNode instanceof ItemList){
					System.out.println(((ItemList) curNode).getDescription(curNode));
				} else if(curNode instanceof Creature){
					System.out.println(((Creature) curNode).getDescription(curNode));
					
				} else if(curNode instanceof Item) {
					System.out.println(((Item) curNode).getDescription(curNode));
				}
			}
		}
		public void loadTestMud()
		{
			ItemList itemList1 = new ItemList();
			//now add a bunch of items
			Item wallet = new Item("Wallet");
			Item remote = new Item("Remote");
			//then add it to the room
			Room room1 = new Room("Living Room",itemList1,0,0);
			room1.addItemToRoom(wallet);
			room1.addItemToRoom(remote);
			((EntityGroup)masterNode).addNode(room1);

			ItemList itemList2 = new ItemList();
			Room room2 = new Room("Kitchen",itemList2,0,1);
			Item sword = new Item("Sword");
			Item pie = new Item("Pie");
			Item apple = new Item("Apple");
			room2.addItemToRoom(sword);
			room2.addItemToRoom(pie);
			room2.addItemToRoom(apple);
			((EntityGroup)masterNode).addNode(room2);
			//^^this is because technically the item list is a seperate composition from the room
			
			
			ItemList itemList3 = new ItemList();
			Room room3 = new Room("Parlour",itemList3,1,1);
			Item trumpet = new Item("Trumpet");
			//treasure will be an entity group because it's an arraylist of nodes, probably most of which are items but could also be other entity types
			EntityGroup treasure = new EntityGroup("Treasure Chest");
			room3.addItemToRoom(trumpet);
			room3.addNode(treasure); //<-- the power of the composite pattern, we can store whatever in here, assuming its defined from node type
			((EntityGroup)masterNode).addNode(room3);
			//^^this is because technically the item list is a seperate composition from the room, so we add it again, useful for traversal
			
		

			ItemList itemList4 = new ItemList();
			itemList4.addItem(new Item("Statue"));
			Room room4 = new Room("Bedroom",itemList4,1,0);
			Room closet = new Room("Closet");//an empty room, but a room within a room
			room4.addNode(closet);
			((EntityGroup)masterNode).addNode(room4);
			((EntityGroup)masterNode).addNode(closet);

			//on the other hand we don't want players to be able to carry around nodes
			//this is probably too powerful and could create cheats.  So players
			//will only have item lists
			Player player = new Player();
			Item axe = new Item("Axe");
			Item deodorant = new Item("Deodorant");
			player.addToInventory(axe);
			player.addToInventory(deodorant);
			((EntityGroup)masterNode).addNode(player);
			((EntityGroup)masterNode).addNode(player.getInventory());
			
			Creature swampMonster = new Creature("Swamp Monster",10,100,1,1);
			((EntityGroup)masterNode).addNode(swampMonster);
			
			

		}
	}
	public static mud theMud;
	public static void init()
	{
		theMud = new mud();
		theMud.loadTestMud();
	}
	public static void print()
	{
		theMud.printFromMasterNode();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		print();
		
	}

}