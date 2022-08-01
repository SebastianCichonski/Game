package pl.sebastiancichonski;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class LogicTest {

    private Player player_X_Mock = Mockito.mock(Player.class);
    private Player player_O_Mock = Mockito.mock(Player.class);
    private GameBoard gameBoardMock = GameBoardTestFactory.create();

    private Logic logic_cut = new Logic(gameBoardMock,player_O_Mock,player_X_Mock);


    @Test
    public void endGame_NoMorePawns_Test() {
        BDDMockito.given(player_O_Mock.getPoints()).willReturn(0);
        BDDMockito.given(player_O_Mock.getName()).willReturn("O");
        BDDMockito.given(player_X_Mock.getName()).willReturn("X");

        boolean result = logic_cut.endGame(player_X_Mock);

        assertTrue(result);
    }


    @Test
    public void endGame_NoEmptySquares_Test() {
        BDDMockito.given(player_O_Mock.getPoints()).willReturn(43);
        BDDMockito.given(player_X_Mock.getPoints()).willReturn(21);
        BDDMockito.given(player_O_Mock.getName()).willReturn("O");
        BDDMockito.given(player_X_Mock.getName()).willReturn("X");

        boolean result = logic_cut.endGame(player_X_Mock);

        assertTrue(result);
    }

    @Test
    public void endGame_BlockedOpponent_True_Test() {
        BDDMockito.given(player_O_Mock.getPoints()).willReturn(41);
        BDDMockito.given(player_X_Mock.getPoints()).willReturn(5);
        BDDMockito.given(player_O_Mock.getName()).willReturn("O");
        BDDMockito.given(player_X_Mock.getName()).willReturn("X");

        boolean result = logic_cut.endGame(player_O_Mock);

        assertTrue(result);
    }

    @Test
    public void endGame_BlockedOpponent_False_Test() {
        BDDMockito.given(player_O_Mock.getPoints()).willReturn(41);
        BDDMockito.given(player_X_Mock.getPoints()).willReturn(5);
        BDDMockito.given(player_O_Mock.getName()).willReturn("O");
        BDDMockito.given(player_X_Mock.getName()).willReturn("X");

        boolean result = logic_cut.endGame(player_X_Mock);

        assertFalse(result);
    }
}