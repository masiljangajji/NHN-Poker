package service;

import model.CardSet;
import model.User;

public class CardSetService {

    public static void giveCard(CardSet cardSet, User user) { // 여기에 타입을 줄까

        for (int i = 0; i < 5; i++) {
            user.add(cardSet.remove()); // 플레이어 카드 셋에 추가
        }
    } // 카드 뽑아서 플레이어들 한테 줄꺼임 , 이건 random하게 뽑을꺼고 , 뽑힌 idx는 remove해주면 됨

    


}
