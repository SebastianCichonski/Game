package pl.sebastiancichonski;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {
    private Player player;

    @Before
    public void before(){
        player = new Player("test");
    }


    @Test
    public void addPoints_Test() {
        player.addPoints();
        assertEquals(2,player.getPoints());
    }

    @Test
    public void subPoints_Test(){
        player.subPoints();
        assertEquals(0, player.getPoints());
    }

    @Test(expected = IllegalArgumentException.class)
    public void subPoints_belowZeroTest(){
        player.subPoints();
        player.subPoints();
    }

    @Test
    public void getName_Test(){
        assertEquals("test", player.getName());
    }
}