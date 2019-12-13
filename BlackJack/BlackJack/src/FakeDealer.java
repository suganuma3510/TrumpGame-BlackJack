
public class FakeDealer extends Dealer {

    FakeDealer(String name) {
        super(name);
    }

    @Override
    public void firstSteps() {
        System.out.println("【カードを配ります。】");
        for (int i = 0; i < 2; i++) {
            getUser().setHand(handOutCards());
        }
        pointCount(getUser());
        getUser().showHand();
        System.out.println("\n" + getName() + "さんの手札");
        for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
            if (1 == getTrumpDeck().getDeck().get(i).getNumber()) {
                this.setHand(getTrumpDeck().getDeck().remove(i));
                System.out.println("【" + getHand().get(0) + "】　：　" + getHand().get(0).getPoint() + "点");
                break;
            }
        }
        for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
            if (10 == getTrumpDeck().getDeck().get(i).getPoint()) {
                this.setHand(getTrumpDeck().getDeck().remove(i));
                break;
            }
        }
        pointCount(this);

    }
}
