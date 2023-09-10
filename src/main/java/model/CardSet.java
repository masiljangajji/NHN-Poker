package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CardSet {

    public static final String[] suits = {"a","Clover", "Heart", "Diamond", "Spade"};
    public static final String[] ranks = {"a","Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King"};
    private final List<Card> cardList = new LinkedList<>();

    public CardSet() {
        initSet();
    }

    // 52장의 카드 셋을 가지고 있는 list


    private void initSet() {

        // String number;  // 숫자     ace , 2 3 4 5 6 7 8 9 10  , Joney , Queem , King   , Ace는 1도되고 14도 된다 .

        List<Card> list = new ArrayList<>();

        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                list.add(new Card(i, j+20));
            }
        }

        while (!list.isEmpty()) {
            int num = (int) (Math.random() * (list.size()));
            this.cardList.add(list.get(num));
            list.remove(num);
        }
    }

    public Card remove() {
        return this.cardList.remove(0);
    }

    public void add(Card card) {
        int num = (int) (Math.random() * (this.cardList.size()));
        this.cardList.add(num, card);
    }


}