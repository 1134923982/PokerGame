package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.PokerGame;

public class PokerGameTest {

    @Test
    public void should_return_a_player_win_when_input_3D_5H_7S_9D_1C_3D_5H_7S_8D(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,9D,2C,3D,4H,5S,8D";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);

    }


}
