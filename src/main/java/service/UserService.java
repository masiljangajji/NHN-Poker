package service;

import model.CardSet;
import model.User;

public class UserService {

    // 여기서 교환 할꺼임


    public static void userReceiveCard(CardSet cardSet, User user, int[] receiveArray) {

        // 버린 카드 수 만큼 받을 꺼임
        for (int i = 0; i < receiveArray.length; i++) {
            user.add(receiveArray[i], cardSet.remove());
        }
    }


}
