package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerGame {
    int pokersLength = 15;
    String aPlayerWin = "a player win";
    String bPlayerWin = "b player win";
    String peace = "peace";

    public String judge(String pokers) {
        String[] aPlayer = parsePokers(pokers, 0, pokersLength);
        String[] bPlayer = parsePokers(pokers, pokersLength, pokers.length());
        aPlayer = sortPokers(aPlayer);
        bPlayer = sortPokers(bPlayer);

        String aThreeOfAKingPoker = getThreeOfAKingPoker(aPlayer);
        String bThreeOfAKingPoker = getThreeOfAKingPoker(bPlayer);
        if(aThreeOfAKingPoker!=null||bThreeOfAKingPoker!=null){
            if(aThreeOfAKingPoker!=null&&bThreeOfAKingPoker==null){
                return aPlayerWin;
            }else if(aThreeOfAKingPoker==null&&bThreeOfAKingPoker!=null){
                return bPlayerWin;
            }else {
                if(Integer.parseInt(aThreeOfAKingPoker)>Integer.parseInt(bThreeOfAKingPoker)){
                    return aPlayerWin;
                }else {
                    return bPlayerWin;
                }
            }
        }

        List<String> aPlayersPairs = getPairs(aPlayer);
        List<String> bPlayersPairs = getPairs(bPlayer);

        if (aPlayersPairs.size() > 0 || bPlayersPairs.size() > 0) {
            if (aPlayersPairs.size() > bPlayersPairs.size()) {
                return aPlayerWin;
            } else if (aPlayersPairs.size() < bPlayersPairs.size()) {
                return bPlayerWin;
            } else {
                for (int i = 0; i < aPlayersPairs.size(); i++) {
                    if (aPlayersPairs.get(i).substring(0, aPlayersPairs.get(i).length() - 1).equals(bPlayersPairs.get(i).substring(0, bPlayersPairs.get(i).length() - 1))) {
                        continue;
                    }
                    return getPokersResult(aPlayersPairs.get(i), bPlayersPairs.get(i));
                }
            }
        }

        for (int i = aPlayer.length - 1; i >= 0; i--) {
            if (aPlayer[i].substring(0, aPlayer[i].length() - 1).equals(bPlayer[i].substring(0, aPlayer[i].length() - 1))) {
                continue;
            }
            return getPokersResult(aPlayer[i], bPlayer[i]);
        }
        return peace;
    }

    private String getThreeOfAKingPoker(String[] aPlayer) {
        String aThreeOfAKingPoker = "";
        int repeat = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < aPlayer.length; j++) {
                if (aPlayer[i].substring(0, aPlayer[i].length() - 1).equals(aPlayer[j].substring(0, aPlayer[j].length() - 1))) {
                    repeat++;
                }
            }
            if (repeat >= 3) {
                aThreeOfAKingPoker = aPlayer[i].substring(0, aPlayer[i].length() - 1);
                return aThreeOfAKingPoker;
            }
            repeat = 1;
        }
        return null;
    }

    private String getPokersResult(String aPoker, String bPoker) {
        if (Integer.parseInt(aPoker.substring(0, aPoker.length() - 1)) > Integer.parseInt(bPoker.substring(0, bPoker.length() - 1))) {
            return aPlayerWin;
        } else {
            return bPlayerWin;
        }
    }

    private List<String> getPairs(String[] aPlayer) {
        List<String> playerPairs = new ArrayList<>();
        for (int i = 0; i < aPlayer.length - 1; i++) {
            for (int j = i + 1; j < aPlayer.length; j++) {
                if (aPlayer[i].substring(0, aPlayer[i].length() - 1).equals(aPlayer[j].substring(0, aPlayer[j].length() - 1))) {
                    playerPairs.add(aPlayer[i]);
                }
            }
        }
        return playerPairs;
    }

    private String[] parsePokers(String pokers, int i, int pokersLength) {
        String[] split = pokers.substring(i, pokersLength).split(",");

        List<String> collect = Arrays.stream(split).map(item -> {
            return transferred(item.substring(0, 1)) + item.substring(1, item.length());
        }).collect(Collectors.toList());

        return collect.toArray(new String[0]);
    }

    private String transferred(String str) {
        switch (str) {
            case "T":
                return "10";
            case "J":
                return "11";
            case "Q":
                return "12";
            case "K":
                return "13";
            case "A":
                return "14";
            default:
                return str;
        }
    }

    private String[] sortPokers(String[] pokers) {
        for (int i = 0; i < pokers.length; i++) {
            for (int j = 0; j < pokers.length - i - 1; j++) {
                if (Integer.parseInt(pokers[j].substring(0, pokers[j].length() - 1)) > Integer.parseInt(pokers[j + 1].substring(0, pokers[j + 1].length() - 1))) {
                    String temp = pokers[j];
                    pokers[j] = pokers[j + 1];
                    pokers[j + 1] = temp;
                }
            }
        }
        return pokers;
    }
}
