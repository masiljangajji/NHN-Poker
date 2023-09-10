package model;

public class Result {



    // 족보
    // 숫자
    // 무늬
    private final  int rank;
    private final int number;
    private final int suit;

    public Result(int rank,int number,int suit) {
        this.suit=suit;
        this.number=number;
        this.rank=rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public int getRank() {
        return rank;
    }



}
