//Dealerクラスを継承したブラックジャックしか出さないディーラークラス
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
        //エースを探して手札に加える
        for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
            if (1 == getTrumpDeck().getDeck().get(i).getNumber()) {
                this.setHand(getTrumpDeck().getDeck().remove(i));
                break;
            }
        }
        pointCount(this);
        showHand();
        //１０以上のカードを探して手札に加える
        for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
            if (10 == getTrumpDeck().getDeck().get(i).getPoint()) {
                this.setHand(getTrumpDeck().getDeck().remove(i));
                break;
            }
        }
        pointCount(this);

    }
}
