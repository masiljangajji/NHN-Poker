package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CardSet {


    private final List<Card> cardList = new LinkedList<>();

    public List<Card> getList() {
        return this.cardList;
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


        List<Card> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                list.add(new Card(numbers[i],symbols[j]));
            }
        }

        while(!list.isEmpty()){
            int num=(int)(Math.random()*(list.size()));
            this.cardList.add(list.get(num));
            list.remove(num);
        }
    }

    public Card remove(){
        return this.cardList.remove(0);
    }


}
