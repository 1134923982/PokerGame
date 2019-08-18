package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class PokerGame {
    private int pokersLength;
    private String aPlayerWin;
    private String bPlayerWin;
    private String peace;

    public PokerGame() {
        aPlayerWin = "a player win";
        bPlayerWin = "b player win";
        peace = "peace";
        pokersLength = 15;
    }

    public String judge(String pokers) {
        pokers = pokers.toUpperCase();
        String[] aPlayer = parsePokers(pokers, 0, pokersLength);
        String[] bPlayer = parsePokers(pokers, pokersLength, pokers.length());
        aPlayer = sortPokers(aPlayer);
        bPlayer = sortPokers(bPlayer);

        String result = "";

        result = getResultWithFlushAndStraight(aPlayer, bPlayer, result);
        if (result.length() > 0)
            return result;

        result = getResultWithFourOfAKingPoker(aPlayer, bPlayer, result);
        if (result.length() > 0)
            return result;

        result = getResultWithFullHose(aPlayer, bPlayer, result);

        if (result.length() > 0)
            return result;

        result = getResultWithFlush(result, isFlush(aPlayer), !isFlush(bPlayer), !isFlush(aPlayer), isFlush(bPlayer));

        if (result.length() > 0)
            return result;

        result = getResultWithStraight(aPlayer, bPlayer, result);
        if (result.length() > 0)
            return result;

        result = getResultWithThreeOfAKings(result, aPlayer, bPlayer);

        if (result.length() > 0)
            return result;

        result = getResultWithPairs(result, aPlayer, bPlayer);
        if (result.length() > 0)
            return result;

        result = getResultWithHighCard(aPlayer, bPlayer, result);
        return result.length() > 0 ? result : peace;
    }

    private String getResultWithStraight(String[] aPlayer, String[] bPlayer, String result) {
        if (isStraight(aPlayer) && !isStraight(bPlayer)) {
            result = aPlayerWin;
        }
        if (isStraight(bPlayer) && !isStraight(aPlayer)) {
            result = bPlayerWin;
        }
        return result;
    }

    private String getResultWithFlush(String result, boolean flush, boolean b, boolean b2, boolean flush2) {
        if (flush && b) {
            result = aPlayerWin;
        } else {
            if (b2 && flush2) {
                result = bPlayerWin;
            }
        }
        return result;
    }

    private String getResultWithFullHose(String[] aPlayer, String[] bPlayer, String result) {
        HashMap<String, String> aFullHose = getFullHose(aPlayer);
        HashMap<String, String> bFullHose = getFullHose(bPlayer);

        if ((aFullHose.get("threeOfAKingPoker") != null && aFullHose.get("pair") != null) && (bFullHose.get("pair") == null)) {
            result = aPlayerWin;
        } else if ((bFullHose.get("threeOfAKingPoker") != null && bFullHose.get("pair") != null) && (aFullHose.get("pair") == null)) {
            result = bPlayerWin;
        }
        return result;
    }

    private String getResultWithFourOfAKingPoker(String[] aPlayer, String[] bPlayer, String result) {
        String aFourOfAKingPoker = getRepeatOfAKingPoker(aPlayer, 4);
        String bFourOfAKingPoker = getRepeatOfAKingPoker(bPlayer, 4);
        result = getResultWithFlush(result, aFourOfAKingPoker != null, bFourOfAKingPoker == null, bFourOfAKingPoker != null, aFourOfAKingPoker == null);
        return result;
    }

    private String getResultWithFlushAndStraight(String[] aPlayer, String[] bPlayer, String result) {
        if (isFlush(aPlayer) && isStraight(aPlayer) && (!isStraight(bPlayer) || !isFlush(bPlayer))) {
            result = aPlayerWin;
        } else if (isFlush(bPlayer) && isStraight(bPlayer) && (!isStraight(aPlayer) || !isFlush(aPlayer))) {
            result = bPlayerWin;
        }
        return result;
    }

    private String getResultWithHighCard(String[] aPlayer, String[] bPlayer, String result) {
        for (int i = aPlayer.length - 1; i >= 0; i--) {
            if (aPlayer[i].substring(0, aPlayer[i].length() - 1).equals(bPlayer[i].substring(0, aPlayer[i].length() - 1))) {
                continue;
            }
            result = getPokersResult(aPlayer[i], bPlayer[i]);
            break;
        }
        return result;
    }

    private String getResultWithPairs(String result, String[] aPlayer, String[] bPlayer) {
        List<String> aPlayersPairs = getPairs(aPlayer);
        List<String> bPlayersPairs = getPairs(bPlayer);
        if (aPlayersPairs.size() > 0 || bPlayersPairs.size() > 0) {
            if (aPlayersPairs.size() > bPlayersPairs.size()) {
                result = aPlayerWin;
            } else if (aPlayersPairs.size() < bPlayersPairs.size()) {
                result = bPlayerWin;
            } else {
                for (int i = 0; i < aPlayersPairs.size(); i++) {
                    if (aPlayersPairs.get(i).substring(0, aPlayersPairs.get(i).length() - 1).equals(bPlayersPairs.get(i).substring(0, bPlayersPairs.get(i).length() - 1))) {
                        continue;
                    }
                    result = getPokersResult(aPlayersPairs.get(i), bPlayersPairs.get(i));
                }
            }
        }
        return result;
    }

    private String getResultWithThreeOfAKings(String result, String[] aPlayer, String[] bPlayer) {
        String aThreeOfAKingPoker = getRepeatOfAKingPoker(aPlayer, 3);
        String bThreeOfAKingPoker = getRepeatOfAKingPoker(bPlayer, 3);
        if (aThreeOfAKingPoker != null || bThreeOfAKingPoker != null) {
            if (aThreeOfAKingPoker != null && bThreeOfAKingPoker == null) {
                result = aPlayerWin;
            } else if (aThreeOfAKingPoker == null && bThreeOfAKingPoker != null) {
                result = bPlayerWin;
            } else {
                if (Integer.parseInt(aThreeOfAKingPoker) > Integer.parseInt(bThreeOfAKingPoker)) {
                    result = aPlayerWin;
                } else {
                    result = bPlayerWin;
                }
            }
        }
        return result;
    }

    private HashMap<String, String> getFullHose(String[] pokers) {
        HashMap<String, String> resultMap = new HashMap<>();
        String threeOfAKingPoker = getRepeatOfAKingPoker(pokers, 3);
        if (threeOfAKingPoker == null) {
            resultMap.put("threeOfAKingPoker", null);
            return resultMap;
        }
        resultMap.put("threeOfAKingPoker", threeOfAKingPoker);
        List<String> remainPokers = Arrays.stream(pokers)
                .filter(poker -> !poker.substring(0, poker.length() - 1).equals(threeOfAKingPoker))
                .map(item -> item.substring(0, item.length() - 1))
                .distinct()
                .collect(Collectors.toList());
        if (remainPokers.size() == 1) {
            resultMap.put("pair", remainPokers.get(0));
            return resultMap;
        }
        return resultMap;
    }

    private boolean isFlush(String[] pokers) {
        List<String> suitList = Arrays.stream(pokers).map(poker -> poker.substring(poker.length() - 1, poker.length())).distinct().collect(Collectors.toList());
        if (suitList.size() == 1) {
            return true;
        }
        return false;
    }

    private boolean isStraight(String[] pokers) {
        List<String> collect = Arrays.stream(pokers).map(poker -> poker.substring(0, poker.length() - 1)).collect(Collectors.toList());
        for (int i = 0; i < collect.size() - 1; i++) {
            if (Integer.parseInt(collect.get(i)) + 1 != Integer.parseInt(collect.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private String getRepeatOfAKingPoker(String[] aPlayer, int repeatNum) {
        String aThreeOfAKingPoker = "";
        int repeat = 1;

        for (int i = 0; i < repeatNum; i++) {
            for (int j = i + 1; j < aPlayer.length; j++) {
                if (aPlayer[i].substring(0, aPlayer[i].length() - 1).equals(aPlayer[j].substring(0, aPlayer[j].length() - 1))) {
                    repeat++;
                }
            }
            if (repeat >= repeatNum) {
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
