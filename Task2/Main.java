package Task2;

import Task1.Actor;
import Task1.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Ivan", 33, "Russia");
        Market market = new Market();
        market.acceptToMarket(human1);
        market.takeOrders();
        market.takeInQueue(human1);
        market.giveOrders();
        market.releaseFromMarket(new ArrayList<>(Arrays.asList(human1)));
    }
}
