package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerGame {
    int pokersLength = 15;

    public String judge(String pokers) {
        String[] aPlayer = parsePokers(pokers, 0, pokersLength);
        String[] bPlayer = parsePokers(pokers, pokersLength, pokers.length());

        for (int i = aPlayer.length - 1; i >= 0; i--) {
            if (aPlayer[i].substring(0, aPlayer[i].length()-1).equals(bPlayer[i].substring(0, aPlayer[i].length()-1))) {
                continue;
            }
            if (Integer.parseInt(aPlayer[i].substring(0, aPlayer[i].length()-1)) > Integer.parseInt(bPlayer[i].substring(0, bPlayer[i].length()-1))) {
                return "a player win";
            } else {
                return "b player win";
            }
        }
        return "peace";
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
}
