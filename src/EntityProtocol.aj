import java.util.HashMap;
public abstract aspect EntityProtocol {
	public interface Leaf {}
	declare parents: (Item||Player||Creature) implements Leaf;
	
	public interface Component {}
	declare parents: (Node||Entity) implements Component;
	
	public interface Composite {}
	declare parents: (EntityGroup||ItemList||Room) implements Composite;
	
	public HashMap children = new HashMap(); 
	
	public HashMap getChildren() {
		return children;
	}
	
	public void check() {
		
	}
}
