package model;

import java.util.LinkedList;
import java.util.Queue;

public class CardSet {


    private final Queue<Card> cardQueue = new LinkedList<>();

    public Queue<Card> getList() {
        return this.cardQueue;
    }

    public CardSet() {
        initSet();
    }

    // 52장의 카드 셋을 가지고 있는 list


    private void initSet() {

        // String number;  // 숫자     ace , 2 3 4 5 6 7 8 9 10  , Joney , Queem , King   , Ace는 1도되고 14도 된다 .

        String[] symbols = {"Heart", "Spade", "Clover", "DIA"};
        String[] numbers =
                {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "J", "Q", "K"};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                this.cardQueue.add(new Card(numbers[i], symbols[j]));
            }
        }

    }
    public void giveCard(User user) { // 여기에 타입을 줄까

        for (int i = 0; i < 5; i++) {
            user.add(this.cardQueue.poll()); // 플레이어 카드 셋에 추가
            this.cardQueue.remove(); // 카드 셋에서 삭제
        }
    } // 카드 뽑아서 플레이어들 한테 줄꺼임 , 이건 random하게 뽑을꺼고 , 뽑힌 idx는 remove해주면 됨


}
