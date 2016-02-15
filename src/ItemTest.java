import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {
	/**The constructor should initialize all the variables
	 * Test to see if item name is initialized
	 */
	@Test
	public void testItemStringString() {
		String cream = "Cream";
		Item i = new Item(cream, "creamy cream");
		assertEquals(cream, i.getName());
	}
	
	/**Set data should give all the variables in the class a value
	 * To test, check it a item set by it's constructor is equal to a item set by setData
	 */
	@Test
	public void testSetData() {
		Item i1 = new Item();
		i1.setData("Cream", "creamy cream");
		Item i2 = new Item("Cream", "creamy cream");
		assertEquals(i1, i2);
	}

	/**setName should set the variable itemName
	 * So test if it is set
	 */
	@Test
	public void testSetName() {
		Item i = new Item();
		i.setName("Cream");
		assertEquals("Cream", i.getName());
	}

	/**setFoundText should set the variable foundText
	 * So test if it is set
	 */
	@Test
	public void testSetFoundText() {
		Item i = new Item();
		i.setFoundText("creamy cream");
		assertEquals("creamy cream", i.getFoundText());
	}

	/**getName should return the variable itemName
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetName() {
		Item i = new Item("Cream", "creamy cream");
		assertEquals("Cream", i.getName());
	}

	/**getFoundText should return the variable foundText
	 * Test if it returns the value given in the constructor
	 */
	@Test
	public void testGetFoundText() {
		Item i = new Item("Cream", "creamy cream");
		assertEquals("creamy cream", i.getFoundText());
	}

	/**Equals should return true if to separate instances of Item have the same data
	 */
	@Test
	public void testEqualsObject() {
		Item i1 = new Item("Cream", "creamy cream");
		Item i2 = new Item("Cream", "creamy cream");
		assertEquals(i1, i2);
	}
}
