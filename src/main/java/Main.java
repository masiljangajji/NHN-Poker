import controller.Input;
import model.CardSet;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.GameService;

/**
 * 게임이 시작되는 클래스.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * 게임이 시작됨 .
     *
     * @param args args.
     */
    public static void main(String[] args) {

        logger.info("NHN - Poker 게임을 시작합니다\n");

        CardSet cardSet = new CardSet();
        int num = Input.playerNumber();
        int order = (int) (Math.random() * (num) + 1);

        logger.info("User는 {}번쨰 Player 입니다.\n", order);

        User[] users = new User[num];

        for (int i = 1; i <= num; i++) {
            users[i - 1] = new User();
            GameService.giveCard(cardSet, users[i - 1]); // 전체 플레이어한테 5장씩 카드 분배
        }

        users[order - 1].printCardSet(); // 유저가 가진 카드 출력


        int[] swapList = Input.swapCard(); // 바꿀 카드 입력

        if (swapList.length != 0) {
            GameService.userThrowCard(cardSet, users[order - 1], swapList);
            GameService.userReceiveCard(cardSet, users[order - 1], swapList);
        }

        users[order - 1].printCardSet();

        int winIdx = GameService.getWinner(users); // 승자 판별

        logger.info("\n{}번쨰 Player가 이겼습니다 !", winIdx);


    }


}
