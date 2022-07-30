package pl.sebastiancichonski;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

  //  @InjectMocks
    private Player player = new Player("test");

    @Test
    public void addPoints_Test() {
        player.addPoints();
        assertEquals(2,player.getPoints());
    }
}