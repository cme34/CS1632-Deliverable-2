import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class InventoryTest {
	/**The constructor should initialize all the variables
	 * Check to see if items is initialized
	 */
	@Test
	public void testInventory() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		assertSame(item, inv.getItemInInventory(0));
	}

	/**setItemFound with the int argument should set an item to found at the specified index IF IT EXISTS
	 * So put an item in and check if it is found
	 */
	@Test
	public void testSetItemFoundInt() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		inv.setItemFound(0);
		assertTrue(inv.isItemFound(0));
	}

	/**setItemFound with the Item argument should set an item to found with equal data IF IT EXISTS
	 * So put an item in and check if it is found
	 */
	@Test
	public void testSetItemFoundItem() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		inv.setItemFound(item);
		assertTrue(inv.isItemFound(item));
	}

	/**getItemInInventory should return the Item at the specified index
	 * If the index is higher than the size of items, then it returns null
	 */
	@Test
	public void testGetItemInInventory() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		assertSame(item, inv.getItemInInventory(0));
	}
	
	/**isItemInInventory checks to see if the Item specified is in the inventory
	 * returns true if it is, false if it's not
	 */
	@Test
	public void testIsItemInInventory() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		assertTrue(inv.isItemInInventory(item));
	}
	
	/**isItemFound with the int argument checks if the item at the specified index is found
	 * returns true if it is, false if it's not
	 * if the index is greater than the size of the ArrayList, always returns false
	 */
	@Test
	public void testIsItemFoundInt() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		assertFalse(inv.isItemFound(0));
	}
	
	/**isItemFound with the Item argument checks if an item with equal data is found
	 * returns true if it is, false if it's not
	 */
	@Test
	public void testIsItemFoundItem() {
		Item item = Mockito.mock(Item.class);
		Inventory inv = new Inventory(item);
		assertFalse(inv.isItemFound(item));
	}
	
	/**toString should not only output the values that Inventory contains, 
	 * but also give it in the format of how the Inventory is printed in the game
	 */
	@Test
	public void testToString() {
		Item coffee = Mockito.mock(Item.class);
		Mockito.when(coffee.getName()).thenReturn("Coffee");
		Item cream = Mockito.mock(Item.class);
		Mockito.when(cream.getName()).thenReturn("Cream");
		Item sugar = Mockito.mock(Item.class);
		Mockito.when(sugar.getName()).thenReturn("Sugar");
		Inventory inv = new Inventory(coffee, cream, sugar);
		inv.setItemFound(cream);
		String testString = "YOU HAVE NO COFFEE\nYou have some Cream\nYOU HAVE NO SUGAR\n";
		assertEquals(testString, inv.toString());
	}
}
