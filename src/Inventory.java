import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemsInInventory;
	private ArrayList<Boolean> itemFound;
	
	public Inventory(Item... items) {
		itemsInInventory = new ArrayList<Item>();
		itemFound = new ArrayList<Boolean>();
		for (int i = 0; i < items.length; i++) {
			itemsInInventory.add(items[i]);
			itemFound.add(false);
		}
	}
	
	public void setItemFound(int index) {
		itemFound.set(index, true);
	}
	
	public void setItemFound(Item item) {
		for (int i = 0; i < itemsInInventory.size(); i++)
			if (itemsInInventory.get(i).equals(item))
				itemFound.set(i, true);
	}
	
	public Item getItemInInventory(int index) {
		if (index < itemsInInventory.size()) return itemsInInventory.get(index);
		else return null;
	}
	
	public boolean isItemInInventory(Item item) {
		for (int i = 0; i < itemsInInventory.size(); i++)
			if (itemsInInventory.get(i).equals(item))
				return true;
		return false;
	}
	
	public boolean isItemFound(int index) {
		if (index < itemFound.size()) return itemFound.get(index);
		else return false;
	}
	
	public boolean isItemFound(Item item) {
		for (int i = 0; i < itemsInInventory.size(); i++)
			if (itemsInInventory.get(i).equals(item))
				if (itemFound.get(i)) return true;
		return false;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < itemsInInventory.size(); i++)
			if (itemFound.get(i)) s += "You have some " + itemsInInventory.get(i).getName() + "\n";
			else s += "YOU HAVE NO " + itemsInInventory.get(i).getName().toUpperCase() + "\n";
		return s;
	}
}
