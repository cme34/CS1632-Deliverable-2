import java.util.Scanner;

/**One instance of this class will create one whole instance of Coffee Maker Quest.*/
public class Game
{
	private Room currentRoom;
	private Item coffee;
	private Item cream;
	private Item sugar;
	private Inventory inventory;
	
	public Game() {
		currentRoom = null;
		coffee = new Item("Coffee", "caffeinated coffee");
		cream = new Item("Cream", "creamy cream");
		sugar = new Item("Sugar", "sweet sugar");
		inventory = new Inventory(coffee, cream, sugar);
		constructGame();
	}
	
	/**This is essentially the main method of the program. It is NOT tested for this reason*/
	public void run() {
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		System.out.println(currentRoom.toString());
		while (running) {
			running = executeCommand(getCommandFromPlayer(scan));
		}
	}
	
	/**Creates all of the Rooms for the game as well as all of their content, such as Doors and Items.*/
	public void constructGame() {
		Room rooms[] = new Room[6];
		for (int i = 0; i < rooms.length; i++)
			rooms[i] = new Room();
		rooms[0].setData("Small", "Quaint sofa", new Door("Magenta", rooms[1]), null, cream);
		rooms[1].setData("Funny", "Sad record player", new Door("Beige", rooms[2]), new Door("Massive", rooms[0]), null);
		rooms[2].setData("Refinanced", "Tight pizza", new Door("Dead", rooms[3]), new Door("Smart", rooms[1]), coffee);
		rooms[3].setData("Dumb", "Flat energy drink", new Door("Vivacious", rooms[4]), new Door("Slim", rooms[2]), null);
		rooms[4].setData("Bloodthirsty", "Beautiful bag of money", new Door("Purple", rooms[5]), new Door("Sandy", rooms[3]), null);
		rooms[5].setData("Rough", "Perfect air hockey table", null, new Door("Minimalist", rooms[4]), sugar);
		currentRoom = rooms[0];
	}
	
	/**This method gets the input from the user*/
	public String getCommandFromPlayer(Scanner scan) {
		String input = null;
		System.out.println("INSTRUCTIONS (N, S, L , I, D, H)");
		while (input == null || input.length() == 0) {
			input = scan.nextLine();
		}
		System.out.println("");
		return input;
	}
	
	/**This method takes the users entered command and executes the command*/
	public boolean executeCommand(String playerCommand) {
		playerCommand = playerCommand.toUpperCase();
		if (playerCommand.equals("N")) {
			commandN();
		}
		else if (playerCommand.equals("S")) {
			commandS();
		}
		else if (playerCommand.equals("L")) {
			commandL();
		}
		else if (playerCommand.equals("I")) {
			commandI();
		}
		else if (playerCommand.equals("H")) {
			commandH();
		}
		else if (playerCommand.equals("D")) {
			System.out.println(commandD());
			return false;//Ends the game loop (run method)
		}
		else {
			System.out.println("What?");
		}
		return true;
	}
	
	/**Go through North door*/
	public void commandN() {
		if (currentRoom.getDoorNorth() == null) {
			System.out.println("BOOM! You walked into a wall because there was no door.\n");
		}
		else {
			currentRoom = currentRoom.getNorthRoom();
			System.out.println(currentRoom.toString());
		}
	}
	
	/**Go through South door*/
	public void commandS() {
		if (currentRoom.getDoorSouth() == null) {
			System.out.println("BOOM! You walked into a wall because there was no door.\n");
		}
		else {
			currentRoom = currentRoom.getSouthRoom();
			System.out.println(currentRoom.toString());
		}
	}
	
	/**Look around the room for coffee items*/
	public void commandL() {
		if (currentRoom.getCoffeeItem() == null) {
			System.out.println("You don't see anything out of the ordinary.\n");
		}
		else if (inventory.isItemInInventory(currentRoom.getCoffeeItem())) {
			System.out.println("There might be something here...\nYou found some " + currentRoom.getCoffeeItem().getFoundText() + "!\n");
			inventory.setItemFound(currentRoom.getCoffeeItem());
			currentRoom.setCoffeeItem(null);
		}
	}

	/**Prints the inventory. It is NOT tested since all it does is prints Inventory's toString*/
	public void commandI() {
		System.out.println(inventory.toString());
	}
	
	/**Prints the help menu. It is NOT tested since there is nothing to test.*/
	public void commandH() {
		System.out.println("---HELP---");
		System.out.println("N: Go through the North door if there is one");
		System.out.println("S: Go through the South door if there is one");
		System.out.println("L: Check the room for coffee ingredients");
		System.out.println("I: Check your inventory");
		System.out.println("D: Drink the coffee");
		System.out.println("----------\n");
	}
	
	/**Drink the coffee.*/
	public String commandD() {
		String endGameMsg = "";
		//All 3
		if (inventory.isItemFound(coffee) && inventory.isItemFound(cream) && inventory.isItemFound(sugar)) {
			endGameMsg = "You drink the beverage and are ready to study!\nYou win!";
		}
		//Coffee and cream
		else if (inventory.isItemFound(coffee) && inventory.isItemFound(cream) && !inventory.isItemFound(sugar)) {
			endGameMsg = "Without sugar, the coffee is too bitter. You cannot study.\nYou lose!";
		}
		//Coffee and sugar
		else if (inventory.isItemFound(coffee) && !inventory.isItemFound(cream) && inventory.isItemFound(sugar)) {
			endGameMsg = "Without cream, you get an ulcer and cannot study.\nYou lose!";
		}
		//Cream and Sugar
		else if (!inventory.isItemFound(coffee) && inventory.isItemFound(cream) && inventory.isItemFound(sugar)) {
			endGameMsg = "You drink the sweetened cream, but without caffeine, you cannot study.\nYou lose!";
		}
		//Coffee only
		else if (inventory.isItemFound(coffee) && !inventory.isItemFound(cream) && !inventory.isItemFound(sugar)) {
			endGameMsg = "Without cream and sugar, you get an ulcer and cannot study.\nYou lose!";
		}
		//Cream only
		else if (!inventory.isItemFound(coffee) && inventory.isItemFound(cream) && !inventory.isItemFound(sugar)) {
			endGameMsg = "You drink the cream, but without caffeine, you cannot study.\nYou lose!";
		}
		//Sugar only
		else if (!inventory.isItemFound(coffee) && !inventory.isItemFound(cream) && inventory.isItemFound(sugar)) {
			endGameMsg = "You eat the sugar, but without caffeine, you cannot study.\nYou lose!";
		}
		//Nothing
		else {
			endGameMsg = "You drink the air, as you have no coffee, sugar, or cream.\nThe air is invigorating, "
					+ "but not invigorating enough. You cannot study.\nYou lose!";
		}
		return endGameMsg;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void main(String[] args) {
		new Game().run();
	}
}
