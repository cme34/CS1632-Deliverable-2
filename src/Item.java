/**A Item is a data structure that contains the necessary data for a item in Coffee Maker Quest</br>
 * This data is as follows:
 * <ul>
 * Item Name - A String that is the item's name</br>
 * Found Text - A String that is displayed when the item is found
 * </ul>
 */
public class Item {
	private String itemName;
	private String foundText;
	
	public Item() {
		setData(null, null);
	}
	
	public Item(String name, String foundTxt) {
		setData(name, foundTxt);
	}
	
	public void setData(String name, String foundTxt) {
		setName(name);
		setFoundText(foundTxt);
	}
	
	public void setName(String name) {
		itemName = name;
	}
	
	public void setFoundText(String foundTxt) {
		foundText = foundTxt;
	}
	
	public String getName() {
		return itemName;
	}
	
	public String getFoundText() {
		return foundText;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj.getClass() != Item.class) return false;
		Item i = (Item) obj;
		if (i.getName() != this.getName()) return false;
		if (i.getFoundText() != this.getFoundText()) return false;
		return true;
	}
}
