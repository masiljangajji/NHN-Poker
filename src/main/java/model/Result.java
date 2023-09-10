package model;

/**
 * 우선순위 결과를 나타냄  족보,숫자,무늬 를 가짐.
 */
public class Result {



    private final int rank;
    private final int number;
    private final int suit;

    /**
     * 우선순위 를 나타냄.
     *
     * @param rank   가장 높은 족보.
     * @param number 가낭 높은 숫자.
     * @param suit   가낭 높은 무늬.
     */
    public Result(int rank, int number, int suit) {
        this.suit = suit;
        this.number = number;
        this.rank = rank;
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
