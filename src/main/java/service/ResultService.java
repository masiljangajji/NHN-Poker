package service;

import model.Result;
import model.User;

public class ResultService {


    public static int getWinner(User[] users) {

        Result results;

        int winIdx = 0; // 몇번쨰 플레이어
        int winRank = 99; // 족보 내림차
        int winNum = -99; // 숫자 오름차
        int winSuit = -99; // 무늬 오름차

        for (int i = 0; i < users.length; i++) {
            results = users[i].checkRank(i);
            if (results != null) {

                if (results.getRank() < winRank) { //
                    winRank = results.getRank();
                    winIdx = i;
                    winNum = results.getNumber();
                    winSuit = results.getSuit();
                } else if (results.getRank() == winRank) { // 족보 같으면 숫자로
                    if (results.getNumber() > winNum) {
                        winIdx = i;
                        winNum = results.getNumber();
                        winSuit = results.getSuit();
                    } else if (results.getNumber() == winNum) { // 숫자 같으면 무늬로(족보 , 숫자 같음)
                        if (results.getSuit() > winSuit) {
                            winIdx = i;
                            winSuit = results.getSuit();
                        }
                        // 전부다 같으면 먼저 턴 잡은 사람이 이김
                    }
                }

            }
        }


        return winIdx + 1;
    }


}
