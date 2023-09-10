package model;

import static model.CardSet.ranks;
import static model.CardSet.suits;

public class Card {

    // 52장
    private  final int number;

    private  final int suit;

    // 각각의 숫자는 4개의 무늬를 가진다

    // 따라서 13*4 = 52장 의 카드 셋을 가지게 된다.

    public int getNumber() {
        return number;
    }

    public int getSuit() {
        return suit;
    }

    public Card(int number, int suit) {
        this.number = number;
        this.suit=suit;
    }



}