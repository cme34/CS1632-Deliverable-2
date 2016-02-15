import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class RoomTest {
	/**The constructor should initialize all the variables
	 * Check to see if item is initialized
	 */
	@Test
	public void testRoomStringStringDoorDoorItem() {
		Door doorN = Mockito.mock(Door.class);
		Door doorS = Mockito.mock(Door.class);
		Item item = Mockito.mock(Item.class);
		Room r = new Room("Blue", "Table", doorN,  doorS, item);
		assertSame(item, r.getCoffeeItem());
	}

	/**Set data should give all the variables in the class a value
	 * To test, check it a room set by it's constructor is equal to a room set by setData
	 */
	@Test
	public void testSetData() {
		Door doorN = Mockito.mock(Door.class);
		Door doorS = Mockito.mock(Door.class);
		Item item = Mockito.mock(Item.class);
		Room r1 = new Room();
		r1.setData("Blue", "Table", doorN,  doorS, item);
		Room r2 = new Room("Blue", "Table", doorN,  doorS, item);
		assertEquals(r1, r2);
	}

	/**getRoomNorth should return the room to the North of it
	 * This is obtained through the Door class by getting it's linked door
	 * So roomNorth should be the same as room.getNorthRoom
	 */
	@Test
	public void testGetNorthRoom() {
		Room roomNorth = new Room();
		Door doorN = Mockito.mock(Door.class);
		Mockito.when(doorN.getLinkedRoom()).thenReturn(roomNorth);
		Room room = new Room(null, null, doorN, null, null);
		assertSame(roomNorth, room.getNorthRoom());
	}

	/**getRoomSouth should return the room to the South of it
	 * This is obtained through the Door class by getting it's linked door
	 * So roomSouth should be the same as room.getSouthRoom
	 */
	@Test
	public void testGetSouthRoom() {
		Room roomSouth = new Room();
		Door doorS = Mockito.mock(Door.class);
		Mockito.when(doorS.getLinkedRoom()).thenReturn(roomSouth);
		Room room = new Room(null, null, null, doorS, null);
		assertSame(roomSouth, room.getSouthRoom());
	}

	/**setRoomAdjective should set the variable roomAdjective
	 * So test if it is set
	 */
	@Test
	public void testSetRoomAdjective() {
		Room r = new Room();
		r.setRoomAdjective("Blue");
		assertEquals("Blue", r.getRoomAdjective());
	}

	/**setRoomFurnishing should set the variable roomFurnishing
	 * So test if it is set
	 */
	@Test
	public void testSetRoomFurnishing() {
		Room r = new Room();
		r.setRoomFurnishing("Table");
		assertEquals("Table", r.getRoomFunishing());
	}

	/**setDoorNorth should set the variable doorNorth
	 * So test if it is set
	 */
	@Test
	public void testSetDoorNorth() {
		Door doorN = Mockito.mock(Door.class);
		Room r = new Room();
		r.setDoorNorth(doorN);
		assertSame(doorN, r.getDoorNorth());
	}

	/**setDoorSouth should set the variable doorSouth
	 * So test if it is set
	 */
	@Test
	public void testSetDoorSouth() {
		Door doorS = Mockito.mock(Door.class);
		Room r = new Room();
		r.setDoorSouth(doorS);
		assertSame(doorS, r.getDoorSouth());
	}

	/**setCoffeeItem should set the variable coffeeItem
	 * So test if it is set
	 */
	@Test
	public void testSetCoffeeItem() {
		Item item = Mockito.mock(Item.class);
		Room r = new Room();
		r.setCoffeeItem(item);
		assertSame(item, r.getCoffeeItem());
	}

	/**getRoomAdjective should return the variable roomAdjective
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetRoomAdjective() {
		String s = "Blue";
		Room r = new Room(s, null, null, null, null);
		assertEquals(s, r.getRoomAdjective());
	}

	/**getRoomFurnishing should return the variable roomFurnishing
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetRoomFunishing() {
		String s = "Table";
		Room r = new Room(null, s, null, null, null);
		assertEquals(s, r.getRoomFunishing());
	}

	/**getDoorNorth should return the variable doorNorth
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetDoorNorth() {
		Door doorN = Mockito.mock(Door.class);
		Room r = new Room(null, null, doorN, null, null);
		assertSame(doorN, r.getDoorNorth());
	}

	/**getDoorSouth should return the variable doorSouth
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetDoorSouth() {
		Door doorS = Mockito.mock(Door.class);
		Room r = new Room(null, null, null, doorS, null);
		assertSame(doorS, r.getDoorSouth());
	}

	/**getCoffeeItem should return the variable coffeeItem
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetCoffeeItem() {
		Item item = Mockito.mock(Item.class);
		Room r = new Room(null, null, null, null, item);
		assertSame(item, r.getCoffeeItem());
	}

	/**toString should not only output the values that Room contains, 
	 * but also give it in the format of how a Room is printed in the game
	 */
	@Test
	public void testToString() {
		Door doorN = Mockito.mock(Door.class);
		Door doorS = Mockito.mock(Door.class);
		Item item = Mockito.mock(Item.class);
		Room r = new Room("Blue", "Table", doorN,  doorS, item);
		Mockito.when(doorN.getAdjective()).thenReturn("Black");
		Mockito.when(doorS.getAdjective()).thenReturn("White");
		String testString = "You see a Blue room\nIt has a Table\n"
				+ "A Black door leads North\nA White door leads South\n";
		assertEquals(testString, r.toString());
	}

	/**Equals should return true if to separate instances of Room have the same data
	 */
	@Test
	public void testEquals() {
		Door doorN = Mockito.mock(Door.class);
		Door doorS = Mockito.mock(Door.class);
		Item item = Mockito.mock(Item.class);
		Room r1 = new Room("Blue", "Table", doorN,  doorS, item);
		Room r2 = new Room("Blue", "Table", doorN,  doorS, item);
		assertTrue(r1.equals(r2));
	}
}
