/**A Door is a data structure that contains the necessary data for a door in Coffee Maker Quest</br>
 * This data is as follows:
 * <ul>
 * A Adjective - A String that describes the Door</br>
 * A Linked Room - Class Room - The Room that you will go to if you go through this Door
 * </ul>
 */
public class Door {
	private String adjective;
	private Room linkedRoom;
	
	public Door() {
		setData(null, null);
	}
	
	public Door(String adj, Room linkRoom) {
		setData(adj, linkRoom);
	}
	
	/**Changes all the data about the Door with one method*/
	public void setData(String adj, Room linkRoom) {
		adjective = adj;
		linkedRoom = linkRoom;
	}
	
	public void setAdjective(String adj) {
		adjective = adj;
	}
	
	public void setLinkedRoom(Room room) {
		linkedRoom = room;
	}
	
	public String getAdjective() {
		return adjective;
	}
	
	public Room getLinkedRoom() {
		return linkedRoom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != Door.class) return false;
		Door d = (Door) obj;
		if (d.getAdjective() != this.getAdjective()) return false;
		if (d.getLinkedRoom() != this.getLinkedRoom()) return false;
		return true;
	}
}