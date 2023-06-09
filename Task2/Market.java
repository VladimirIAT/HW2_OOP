package Task2;

import Task1.Actor;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour{
    private List<Actor> queue;
    private List<Actor> releasesActors;

    public Market() {
        this.queue = new ArrayList();
        this.releasesActors = new ArrayList<>();
    }
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + "Покупатель вошел в магазин");
        takeInQueue(actor);
    }
    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + "Покупатель встал в очередь на получение заказа");
        this.queue.add(actor);
    }
    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + "Покупатель сделал заказ");
            }
        }
    }
    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + "Покупатель получил заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        for (Actor actor : queue) {
            if (actor.isTakeOrder) {
                releasesActors.add(actor);
                System.out.println(actor.getName() + "Покупатель покинул очередь");
            }
        }
        releaseFromMarket(releasesActors);
    }
    @Override
    public void releaseFromMarket(List<Actor> actorsList) {
        for (Actor actor : actorsList) {
            System.out.println(actor.getName() + "Покупатель покинул магазин");
            queue.remove(actor);
        }
    }
    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}
