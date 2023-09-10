package service;

import model.CardSet;
import model.Result;
import model.User;

/**
 * 게임 진행에 필요한 연산들의 집합 클래스.
 */
public class GameService {
    /**
     * CardSet에서 카드를 뽑아 준다.
     *
     * @param cardSet CardSet.
     * @param user    카드 받을 User.
     */
    public static void giveCard(CardSet cardSet, User user) { // 여기에 타입을 줄까

        for (int i = 1; i <= 5; i++) {
            user.add(i, cardSet.remove()); // 플레이어 카드 셋에 추가
        }

    } // 카드 뽑아서 플레이어들 한테 줄꺼임 , 이건 random하게 뽑을꺼고 , 뽑힌 idx는 remove해주면 됨

    /**
     * CardSet으로 카드를 버린다.
     *
     * @param cardSet    CardSet.
     * @param user       카드 받을 User.
     * @param throwArray 버릴 카드의 index.
     */
    public static void userThrowCard(CardSet cardSet, User user, int[] throwArray) {

        for (Integer idx : throwArray) {
            cardSet.add(user.remove(idx));
        }
    }

    /**
     * CardSet에서 카드를 받는다.
     *
     * @param cardSet      CardSet.
     * @param user         카드 받을 User.
     * @param receiveArray 받을 카드의 index.
     */
    public static void userReceiveCard(CardSet cardSet, User user, int[] receiveArray) {

        // 버린 카드 수 만큼 받을 꺼임
        for (int i = 0; i < receiveArray.length; i++) {
            user.add(receiveArray[i], cardSet.remove());
        }
    }

    /**
     * 게임의 승자를 판별하는 메서드.
     *
     * @param users 모든 User.
     * @return 이긴 User의 index.
     */
    public static int getWinner(User[] users) {

        Result results;

        int winIdx = 0; // 몇번쨰 플레이어
        int winRank = 99; // 족보 내림차
        int winNum = -99; // 숫자 오름차
        int winSuit = -99; // 무늬 오름차

        for (int i = 0; i < users.length; i++) {
            results = users[i].checkRank(i);
            if (results != null) {

                if (results.getRank() < winRank) { // 족보 비교
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
