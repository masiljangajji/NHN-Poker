package service;

import java.util.List;
import model.CardSet;
import model.User;

public class UserService {

    // 여기서 교환 할꺼임


    public static void userReceiveCard(CardSet cardSet, User user, List<Integer> list) {


        // 버린 카드 수 만큼 받을 꺼임
        for(int i=0;i<list.size();i++)
            user.add(list.get(i),cardSet.remove());
    }


}
