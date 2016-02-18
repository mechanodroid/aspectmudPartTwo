
public class Creature extends Entity implements Printable {
	private int health;
	public Creature(){
		super();
	}
	public Creature(int hp, int xp){
		setHealth(hp);
		setXPBonus(xp);
	}
	public Creature(String name, int hp, int xp, int x, int y) {
		super(name, x, y);
		setHealth(hp);
		setXPBonus(xp);
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health = h;
	}
	private int xpbonus;
	public int getXPBonus() {
		return xpbonus;
	}
	public void setXPBonus(int b) {
		xpbonus = b;
	}
	public String getDescription() {
		return getName()+"\n";
	}
}
