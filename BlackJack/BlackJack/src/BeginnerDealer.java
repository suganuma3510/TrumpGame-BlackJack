
//Dealerクラスを継承したバーストをしやすいディーラークラス
public class BeginnerDealer extends Dealer {

    BeginnerDealer(String name) {
        super(name);
    }

    //ディーラーがカードの点数が１７以上になるまで、カードを引く
    @Override
    public void dealerTurn() {
        System.out.println("\n≪" + getName() + "さんのターン≫");
        System.out.println("Hole Cardを公開");
        this.showHand();
        while (getTotalScore() < 21 && getTotalScore() < 17) {
            //２１以上にならないようなカードを手札に加える
            int notBurst = 21 - getTotalScore();
            if (notBurst < 11) {
                for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
                    if (notBurst < getTrumpDeck().getDeck().get(i).getPoint()) {
                        this.setHand(getTrumpDeck().getDeck().remove(i));
                        break;
                    }
                }
            } else {
                setHand(handOutCards());
            }
            System.out.println("\n【" + this.getHand().get(this.getHand().size() - 1) + "】　を引きました");
            pointCount(this);
            this.showHand();
        }
    }
}
