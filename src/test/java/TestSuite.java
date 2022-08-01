import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import pl.sebastiancichonski.GameBoardTest;
import pl.sebastiancichonski.LogicTest;
import pl.sebastiancichonski.PlayerTest;

@Suite
@SelectClasses({GameBoardTest.class,
        LogicTest.class,
        PlayerTest.class})

public class TestSuite {
}
