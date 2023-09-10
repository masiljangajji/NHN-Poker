package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Card들의 집합을 나타냄 , 52장의 카드를 무작위로 갖음 .
 */
public class CardSet {

    private final List<Card> cardList = new LinkedList<>();

    public CardSet() {
        initSet();
    }



    private void initSet() {


        List<Card> list = new ArrayList<>();

        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                list.add(new Card(i, j + 20));
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