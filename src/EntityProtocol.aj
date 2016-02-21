import java.util.ArrayList;
import java.util.HashMap;

public abstract aspect EntityProtocol {
	public interface Leaf {}
	declare parents: (Item||Player||Creature) implements Leaf;
	
	public interface Component {}
	declare parents: (Node||Entity) implements Component;
	
	public interface Composite {}
	declare parents: (EntityGroup||ItemList||Room) implements Composite;
	
	public HashMap<EntityGroup, ArrayList<Node>> children = new HashMap<EntityGroup, ArrayList <Node>>(); 
	
	
	
	abstract pointcut addNode(EntityGroup e, Node n);
	
	abstract pointcut removeNode(EntityGroup e, Node n);
	
	abstract pointcut find(EntityGroup e, Node n);
	
	abstract pointcut getNodes(EntityGroup e);
	
	abstract pointcut getNode(EntityGroup e, int i);
		
	
	public ArrayList<Node> getChildren(EntityGroup e) {
		if(!children.containsKey(e))
		{
			ArrayList<Node> newarraylist = new ArrayList<Node>();
			children.put(e, newarraylist);
		}
		return children.get(e);
	}
	public Node getChild(EntityGroup e, int i) {
		return children.get(e).get(i);
	}
	public void addChild(EntityGroup e, Node node) {
		if(!children.containsKey(e)) {
			EntityGroup newGroup = new EntityGroup();
			ArrayList<Node> a = new ArrayList<Node>();
			if(e==null){
				children.put(newGroup, a);
				children.get(newGroup).add(node);
			} else {
				children.put(e, a);
				children.get(e).add(node);
			}
		} else {
			children.get(e).add(node);
		}
	}
	public void removeChild(EntityGroup e, Node node) {
		if(children.containsKey(e))
		{
			children.get(e).remove(node);
		}
			
	}
	public boolean findChild(EntityGroup e, Node node) {
		return children.containsKey(e) && children.get(e).contains(node);
	}
	
	public void check() {
		
	}
}
