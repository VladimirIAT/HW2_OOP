package Task1;

public abstract class Actor implements ActorBehaviour {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;
    public Actor (String name) {
        this.name = name;
    }

    @Override
    public void setMakeOrder() {
        System.out.println(name + "сделал заказ");
        isMakeOrder = true;
    }
    @Override
    public void setTakeOrder() {
        System.out.println(name + "забрал заказ");
        isTakeOrder = true;
    }
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

}
