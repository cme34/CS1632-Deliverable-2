import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DoorTest.class, GameTest.class, InventoryTest.class, ItemTest.class, RoomTest.class })
public class AllTests {

}
