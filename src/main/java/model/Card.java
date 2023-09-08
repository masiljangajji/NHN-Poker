package model;

public class Card {


    // 52장
    String number;  // 숫자     ace , 2 3 4 5 6 7 8 9 10  , Joney , Queem , King   , Ace는 1도되고 14도 된다 .
    String symbol; // 무늬 하트 , 다이아 , 클로버 , 스페이드 ,

    // 각각의 숫자는 4개의 무늬를 가진다

    // 따라서 13*4 = 52장 의 카드 셋을 가지게 된다.

    public Card(String number,String symbol) {
        this.number = number;
        this.symbol=symbol;
    }


    public String getSymbol() {
        return symbol;
    }

    public String getNumber() {
        return number;
    }

}
