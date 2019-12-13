
public class Chip {

    private int money;

    Chip(int money) {
        setMoney(money);
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("%,d", getMoney()) + "Åè";
    }
}
