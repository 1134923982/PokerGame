package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.PokerGame;

public class PokerGameTest {

    @Test
    public void should_return_a_player_win_when_input_1C_3D_5H_7S_9D_2C_3D_4H_5S_8D(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,9D,2C,3D,4H,5S,8D";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_1C_3D_5H_7S_8D_2C_3D_4H_5S_9C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,8D,2C,3D,4H,7D,9C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_1C_3D_5H_7S_9D_2C_3D_4H_7D_9C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,9D,2C,3D,4H,7D,9C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_1C_3D_5H_7S_AD_2C_3D_4H_7D_9C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,AD,2C,3D,4H,7D,9C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_1C_3D_5H_7S_TD_2C_3D_4H_7D_AC(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,TD,2C,3D,4H,7D,AC";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_1C_3D_5H_7S_TD_1D_3C_5S_7H_TC(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,TD,1D,3C,5S,7H,TC";
        String expectResult = "peace";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_1C_3D_5H_7S_TD_2C_3D_4H_AD_7C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,3D,5H,7S,TD,2C,3D,4H,AD,7C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_1C_5D_5H_7S_TD_2C_3S_4H_7D_AC(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,5D,5H,7S,TD,2C,3D,4H,7D,AC";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_1C_5D_5H_7S_TD_2C_3S_4H_7D_7C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,5D,5H,7S,TD,2C,3D,4H,7D,7C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }


}
