package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Input {

    // 입력 받는 모든 것
    private static final Logger logger = LoggerFactory.getLogger(Input.class);
    private static final Scanner sc = new Scanner(System.in);

    public static int playerNumber() {
        int num;
        while (true) {
            try {
                logger.info("Player의 수를 입력해 주세요 | 2~10 명 ");
                num = sc.nextInt();
                if (num < 2 || num > 10) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                logger.warn("2명에서 10명까지 입력 가능합니다");
                sc.nextLine();
                continue;
            }
            return num;
        }
    }

    public  static  int[] swapCard(){
        int number = throwCardAmount();
        return getCard(number);
    }

    public static int throwCardAmount() {

        int number;
        while (true) {
            logger.info("교환할 카드 개수를 입력해 주세요");
            try {
                number = sc.nextInt();
                if (!(number >= 0 & number <= 5)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                logger.warn("개수 입력은 0~5 사이의 숫자만 가능합니다 !!");
                sc.nextLine();
                continue;
            }
            return number;
        }
    }

    public static int[] getCard(int number) {
        logger.info("교환할 카드가 몇 번째 카드인지 입력해 주세요");
        int[]swapList=  new int[number];

        for (int i = 0; i < number; i++) {
            logger.info("교환할 카드 : {}개 남았습니다", number - i);
            int swapIdx;
            while (true) {
                try {
                    swapIdx = sc.nextInt();
                    if (!(swapIdx >= 1 && swapIdx <= 5)) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    logger.warn("입력은 1~5사이만 가능합니다!!\n다시 입력해 주세요");
                    sc.nextLine();
                    continue;
                }
                break;
            }
            swapList[i]=swapIdx;
        }
        return swapList;
    }


}
