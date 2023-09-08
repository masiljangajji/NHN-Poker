package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {

    List<Card>list = new ArrayList<>();

    // add  remove;


    void add(Card card){
        this.list.add(card);
    }

    void remove(int idx){
        this.list.remove(idx);
    }


}
