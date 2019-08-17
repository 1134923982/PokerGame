package main.java;

public class PokerGame {
    int pokersLength = 15;

    public String judge(String pokers) {
        String[] aPlayer = pokers.substring(0,pokersLength).split(",");
        String[] bPlayer = pokers.substring(pokersLength,pokers.length()-1).split(",");

        for(int i = aPlayer.length-1; i>=0; i--){
            if(Integer.parseInt(aPlayer[i].substring(0,1))> Integer.parseInt(bPlayer[i].substring(0,1))){
                return "a player win";
            }
        }
        return null;
    }
}
