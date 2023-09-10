import controller.Input;
import model.CardSet;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.CardSetService;
import service.ResultService;
import service.UserService;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        CardSet cardSet = new CardSet();

        int num = Input.playerNumber();
        logger.info("Player는 총 {}명 입니다.", num);

        int order = (int) (Math.random() * (num) + 1); // 최대 num 최소 1

        logger.info("User는 {}번쨰 Player 입니다.\n", order);

        User[] users = new User[num];

        for (int i = 1; i <= num; i++) {
            users[i - 1] = new User();
            CardSetService.giveCard(cardSet, users[i - 1]); // 전체 플레이어한테 5장씩 줌
        }

        users[order - 1].printCardSet(); // 유저가 가진 것 출력


        int[] swapList = Input.swapCard(); // 카드 바꿀 꺼임

        if (swapList.length != 0) {
            CardSetService.userThrowCard(cardSet, users[order - 1], swapList); // 여기다가 버려
            UserService.userReceiveCard(cardSet, users[order - 1], swapList); // 새로 받아
        }

        users[order - 1].printCardSet(); // 유저가 가진 것 출력

        int winIdx = ResultService.getWinner(users);


        logger.info("\n{}번쨰 Player가 이겼습니다 !", winIdx);


    }


}
