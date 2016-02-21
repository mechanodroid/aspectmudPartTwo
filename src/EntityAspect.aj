import java.util.ArrayList;
//TODO: make get position pointcut and around get position advice which can maybe derive from the abstract
//aspect and be defined in the following aspect
public aspect EntityAspect extends EntityProtocol{
	private String Component.description;
	public String Component.getDescription(Node n){
		if(description==null) {
			description = n.getName();
		}
		return description;
	}
	private String Composite.description;
	public String Composite.getDescription(Node n){
		//we could have checked if description (above) was null and if it is,
		//only set it once.  But rooms will change from time to time
		String toReturn = "";
		if(n instanceof ItemList) {
			ItemList itemlist = (ItemList)n;
			for(int i = 0; i<itemlist.getItemListSize(); i++){
				Item curItem = itemlist.getItem(i);
				toReturn += curItem.getDescription(curItem)+"\n";
			}
		} else if (n instanceof Room) {
			Room r = (Room)n;
			return "You are in: "+r.getName() + "\n" + r.getItemList().getDescription(r.getItemList()) + "\n";

		}
		return toReturn;	
	}
	
	public String Leaf.description;
	public String Leaf.getDescription(Node n){
		if(description == null) {
			if(n instanceof Item) {
				description = ((Item)n).getName();
				return description;
			} else if(n instanceof Player){
				description = "player:"+((Player)n).getName();
				return description;
			} else if(n instanceof Creature){
				description = "creature:"+((Creature)n).getName();
				return description;
			}
		}
		return ""; //keep description null, maybe it will be possible to set next time
	}
	
	pointcut getDescription(Item item, Node n):
		call(String *.getDescription(Node)) && target(item) && args(n) && !within(EntityAspect);
	
	after(Item item, Node n) returning(String s): getDescription(item, n) {
		s = item.getDescription(n);
		
	}
	
	pointcut removeNode(EntityGroup e, Node n):
		call(* *.removeN*(Node)) && target(e) && args(n) && !within(EntityAspect) && !within(EntityProtocol);
	
	after(EntityGroup e, Node n) returning(): removeNode(e, n) {
		removeChild(e,n);
	}
	pointcut addNode(EntityGroup e, Node n):
		call(void *.addNode(Node)) && target(e) && args(n) && !within(EntityAspect) && !within(EntityProtocol);
	void around(EntityGroup e, Node n): addNode(e, n) {
		addChild(e,n);
	}
	
	pointcut find(EntityGroup e, Node n):
		call(boolean *.find(Node)) && target(e) && args(n) && !within(EntityAspect) && !within(EntityProtocol);
	boolean around(EntityGroup e, Node n): find(e, n) {
		return findChild(e,n);
	}
	
	
	pointcut getNodes(EntityGroup e):
		call(* *.getNo*()) && target(e);
	ArrayList<Node> around(EntityGroup e): getNodes(e) 
	{
		System.out.println("foo!!!");
		
		return getChildren(e);
	}
	
	pointcut getNode(EntityGroup e, int i):
		call(Node *.getNode(int)) && target(e) && args(i) && !within(EntityAspect) && !within(EntityProtocol);
	Node around(EntityGroup e, int i): getNode(e,i) {
		return getChild(e,i);
	}
	
	pointcut EntityGroupConstructorHelper(EntityGroup e):
		call(ArrayList<Node> EntityGroupConstructorHelper()) && target(e) && !within(EntityAspect);
	ArrayList<Node> around(EntityGroup e): EntityGroupConstructorHelper(e) {
		return getChildren(e);
		
	}
	
	

		
}
