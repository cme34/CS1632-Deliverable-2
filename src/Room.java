/**A Room is a data structure that contains the necessary data for a room in Coffee Maker Quest</br>
 * This data is as follows:
 * <ul>
 * A Room Adjective - A String that describes the Room</br>
 * A Room Furnishing - A String that represents a furnishing in the Room</br>
 * A Door North - Class Door - If null, then no door North.</br>
 * A Door South - Class Door - If null, then no door South.</br>
 * A Coffee Item - Class Item - If null, then no Item 
 * </ul>
 */
public class Room {
	private Door doorNorth;
	private Door doorSouth;
	private String roomAdjective;
	private String roomFunishing;
	private Item coffeeItem;
	
	public Room() {
		setData(null, null, null, null, null);
	}
	
	public Room(String roomAdj, String roomFurnish, Door doorN, Door doorS, Item item) {
		setData(roomAdj, roomFurnish, doorN, doorS, item);
	}
	
	/**Changes all the data in the Room with one method*/
	public void setData(String roomAdj, String roomFurnish, Door doorN, Door doorS, Item item) {
		roomAdjective = roomAdj;
		roomFunishing = roomFurnish;
		doorNorth = doorN;
		doorSouth = doorS;
		coffeeItem = item;
	}
	
	public Room getNorthRoom() {
		return doorNorth.getLinkedRoom();
	}
	
	public Room getSouthRoom() {
		return doorSouth.getLinkedRoom();
	}
	
	public void setRoomAdjective(String roomAdj) {
		roomAdjective = roomAdj;
	}
	
	public void setRoomFurnishing(String roomFurnish) {
		roomFunishing = roomFurnish;
	}
	
	public void setDoorNorth(Door doorN) {
		doorNorth = doorN;
	}
	
	public void setDoorSouth(Door doorS) {
		doorSouth = doorS;
	}
	
	public void setCoffeeItem(Item item) {
		coffeeItem = item;
	}
	
	public String getRoomAdjective() {
		return roomAdjective;
	}
	
	public String getRoomFunishing() {
		return roomFunishing;
	}
	
	public Door getDoorNorth() {
		return doorNorth;
	}
	
	public Door getDoorSouth() {
		return doorSouth;
	}
	
	public Item getCoffeeItem() {
		return coffeeItem;
	}
	
	@Override
	public String toString() {
		String s = "You see a " + getRoomAdjective() + " room\n" + "It has a " + getRoomFunishing() + "\n";
		if (getDoorNorth() != null)
			s += "A " + getDoorNorth().getAdjective() + " door leads North\n";
		if (getDoorSouth() != null)
			s += "A " + getDoorSouth().getAdjective() + " door leads South\n";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != Room.class) return false;
		Room r = (Room) obj;
		if (this.getCoffeeItem() != r.getCoffeeItem()) return false;
		if (this.getDoorNorth() != r.getDoorNorth()) return false;
		if (this.getDoorSouth() != r.getDoorSouth()) return false;
		if (this.getRoomAdjective() != r.getRoomAdjective()) return false;
		if (this.getRoomFunishing() != r.getRoomFunishing()) return false;
		return true;
	}
}
