package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);


    Card []list = new Card[5];


    public void add(int idx,Card card) {
        if(this.list[idx-1]!=null){
            throw new IllegalArgumentException("값이 이미 있습니다.");
        }
        this.list[idx-1]=card;
    }

    public Card remove(int idx) {

        if(this.list[idx-1]==null){
            throw new IllegalArgumentException("값이 이미 없습니다.");
        }
        Card card = this.list[idx];
        this.list[idx-1]=null;
        return card;
    }

    public void printCardSet() {

        for (int i = 0; i < list.length; i++) {
            logger.info("{} 번째 카드 " + list[i], i + 1);
        }
    }

}
