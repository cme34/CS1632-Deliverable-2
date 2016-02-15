import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class DoorTest {
	/**The constructor should initialize all the variables
	 * Check to see if room is initialized
	 */
	@Test
	public void testDoorStringRoom() {
		Room room = Mockito.mock(Room.class);
		Door d = new Door("Black", room);
		assertSame(room, d.getLinkedRoom());
	}
	
	/**Set data should give all the variables in the class a value
	 * To test, check it a door set by it's constructor is equal to a door set by setData
	 */
	@Test
	public void testSetData() {
		Room room = Mockito.mock(Room.class);
		Door d1 = new Door();
		d1.setData("Black", room);
		Door d2 = new Door("Black", room);
		assertEquals(d1, d2);
	}
	
	/**setAdjective should set the variable adjective
	 * So test if it is set
	 */
	@Test
	public void testSetAdjective() {
		Door d = new Door();
		d.setAdjective("Black");
		assertEquals("Black", d.getAdjective());
	}
	
	/**setLinkedRoom should set the variable linkedRoom
	 * So test if it is set
	 */
	@Test
	public void testSetLinkedRoom() {
		Room room = Mockito.mock(Room.class);
		Door d = new Door();
		d.setLinkedRoom(room);
		assertEquals(room, d.getLinkedRoom());
	}
	
	/**getAdjective should return the variable adjective
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetAdjective() {
		Door d = new Door("Black", null);
		assertEquals("Black", d.getAdjective());
	}
	
	/**getLinkedRoom should return the variable linkedRoom
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetLinkedRoom() {
		Room room = Mockito.mock(Room.class);
		Door d = new Door("Black", room);
		assertEquals(room, d.getLinkedRoom());
	}
	
	/**Equals should return true if to separate instances of Door have the same data
	 */
	@Test
	public void testEquals() {
		Room room = Mockito.mock(Room.class);
		Door d1 = new Door("Black", room);
		Door d2 = new Door("Black", room);
		assertTrue(d1.equals(d2));
	}
}
