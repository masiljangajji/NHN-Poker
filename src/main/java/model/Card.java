package model;

/**
 *  카드를 나타내는 클래스 {숫자,무늬}를 int로 저장 .
 */
public class Card {

    private final int number;

    private final int suit;


    public int getNumber() {
        return number;
    }

    public int getSuit() {
        return suit;
    }

    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
    }


}