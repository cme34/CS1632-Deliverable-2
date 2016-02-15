import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mockito;

public class GameTest {
	/**Construct Game creates and links all of the Rooms in the game
	 * It should be possible to travel all the way from one end to another
	 * So this test keeps changing the room till it reaches the end, and then goes all the way back
	 */
	@Test
	public void testConstructGame() {
		Game g = new Game();
		//constructGame() is called by the constructor
		Room currRoom = g.getCurrentRoom();
		while (currRoom.getDoorNorth() != null)
			currRoom = currRoom.getDoorNorth().getLinkedRoom();
		while (currRoom.getDoorSouth() != null)
			currRoom = currRoom.getDoorSouth().getLinkedRoom();
		assertSame(g.getCurrentRoom(), currRoom);
	}
	
	/**THIS TEST DOES NOT PASS. INSTEAD IT ENDS WITH AN ERROR SINCE SCANNER IS NOT MOCKABLE.
	 * This test checks to see if getCommandFromPlayer returns what scanner's nextLine
	 */
	@Test
	public void testGetCommandFromPlayer() {
		Game g = new Game();
		Scanner scan = Mockito.mock(Scanner.class);
		Mockito.when(scan.nextLine()).thenReturn("N");
		assertEquals("N", g.getCommandFromPlayer(scan));
	}
	
	/**Execute Command should take a String as a parameter and perform a task based on that
	 * In the case of N, the current room should change
	 */
	@Test
	public void testExecuteCommand() {
		Game g = new Game();
		Room firstRoom = g.getCurrentRoom();
		g.executeCommand("N");
		assertSame(firstRoom.getNorthRoom(), g.getCurrentRoom());
	}
	
	/**Command N should cause the current room to change to the room to the North
	 */
	@Test
	public void testCommandN() {
		Game g = new Game();
		Room firstRoom = g.getCurrentRoom();
		g.commandN();
		assertSame(firstRoom.getNorthRoom(), g.getCurrentRoom());
	}

	/**Command S should cause the current room to change to the south
	 * Since the game starts in the first room, moving south should keep the room the same
	 */
	@Test
	public void testCommandS() {
		Game g = new Game();
		Room firstRoom = g.getCurrentRoom();
		g.commandS();
		assertSame(firstRoom, g.getCurrentRoom());
	}

	/**Command L should check to see if the current room has an item
	 * If it does it should put the item in the player's inventory and set the current room's item to null
	 */
	@Test
	public void testCommandL() {
		Game g = new Game();
		g.commandL();
		assertNull(g.getCurrentRoom().getCoffeeItem());
	}

	/**Command D should return a String that represents the end game message
	 * When having no items in the inventory, the message about drinking the air should be returned
	 */
	@Test
	public void testCommandD() {
		Game g = new Game();
		String testString = "You drink the air, as you have no coffee, sugar, or cream.\nThe air is invigorating, "
				+ "but not invigorating enough. You cannot study.\nYou lose!";
		assertEquals(testString, g.commandD());
	}

	/**Get current room should return the current room
	 * Since the constructor calls constructGame, the current room should not be null
	 */
	@Test
	public void testGetCurrentRoom() {
		Game g = new Game();
		g.constructGame();
		assertNotNull(g.getCurrentRoom());
	}
}
