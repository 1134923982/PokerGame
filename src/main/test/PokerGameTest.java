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
    public void should_return_b_player_win_when_input_1C_5D_5H_7S_TD_2C_3S_4H_7D_7C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "1C,5D,5H,7S,TD,2C,3D,4H,7D,7C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_2S_2D_5H_5S_TD_2C_3S_4H_7D_7C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "2S,2D,5H,5S,TD,2C,3D,4H,7D,7C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_2S_2D_5H_5S_TD_2C_3S_3H_3D_7C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "2S,2D,5H,5S,TD,2C,3D,3H,3D,7C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_2S_5D_5H_5S_TD_2C_3S_3H_3D_7C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "2S,5D,5H,5S,TD,2C,3D,3H,3D,7C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_2S_5D_5H_5S_TD_2C_3S_4H_5C_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "2S,5D,5H,5S,TD,2C,3S,4H,5C,6C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_3C_4D_5H_6S_7D_2C_3S_4H_5C_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "3C,4D,5H,6S,7D,2C,3S,4H,5C,6C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_3S_4D_5H_6S_7D_2C_3C_4C_5C_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "3S,4D,5H,6S,7D,2C,3C,4C,5C,6C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_3S_4S_5S_6S_7S_2C_3C_4C_5C_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "3S,4S,5S,6S,7S,2C,3C,4C,5C,6C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_4S_4D_4H_6D_6S_2C_3D_4C_5C_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "4S,4D,4H,6S,6D,2C,3C,4C,5C,6C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_b_player_win_when_input_4S_4D_4H_6S_6S_2C_2D_2S_2H_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "4S,4D,4H,6S,6D,2C,2D,2S,2H,6C";
        String expectResult = "b player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void should_return_a_player_win_when_input_4S_4D_4H_4C_5S_2C_2D_2S_2H_6C(){
        //given
        PokerGame pokerGame = new PokerGame();
        String pokers = "4S,4D,4H,4C,5S,2C,2D,2S,2H,6C";
        String expectResult = "a player win";
        //when
        String actualResult = pokerGame.judge(pokers);
        //then
        Assert.assertEquals(expectResult, actualResult);
    }


}
