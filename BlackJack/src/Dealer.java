
import java.util.Collections;

//PlayerBaseを継承したディーラークラス
public class Dealer extends PlayerBase {

    private User user;
    private TrumpDeck trumpDeck;

    Dealer(String name) {
        super(name);
    }

    public User getUser() {
        return this.user;
    }

    private void setuser(User user) {
        this.user = user;
    }

    public TrumpDeck getTrumpDeck() {
        return this.trumpDeck;
    }

    private void setTrumpDeck(TrumpDeck trumpDeck) {
        this.trumpDeck = trumpDeck;
    }

    //ゲームの準備をするメソッド
    public void prepareGame(User user, TrumpDeck trumpDeck) {
        setuser(user);
        setTrumpDeck(trumpDeck);
    }

    //ゲームを始めるメソッド
    public void startGame() {
        System.out.println("【ブラックジャックを開始します】");
        firstSteps();
        //ユーザーがブラックジャックで勝った時の処理
        if (getUser().getBlackJack() && this.getBlackJack() == false) {
            this.showHand();
            System.out.println("\n" + getUser().getName() + "さんの勝ち");
            return;
        }
        userTurn();
        if (burstCheck(getUser())) {
            this.showHand();
            return;
        }
        //ディーラーがブラックジャックで勝った時の処理
        if (getUser().getBlackJack() == false && this.getBlackJack()) {
            System.out.println("\n" + this.getName() + "さんの勝ち");
            return;
        }
        //両者ともバーストしていなければ２１に近い方を判定
        if (burstCheck(getUser()) == false) {
            dealerTurn();
            if (burstCheck(this) == false) {
                judgment();
            }
        }
    }

    //手札を配るメソッド
    public Card handOutCards() {
        //山札をシャッフルする
        Collections.shuffle(getTrumpDeck().getDeck());
        //１枚カードをランダムに配る  
        return getTrumpDeck().getDeck().remove(0);
    }

    /*
    最初にユーザーとディーラーに２枚ずつカードを分け、
    ユーザーは２枚、ディーラーは１枚カードを公開する
     */
    public void firstSteps() {
        System.out.println("【カードを配ります。】");
        for (int i = 0; i < 2; i++) {
            getUser().setHand(handOutCards());
            this.setHand(handOutCards());
        }
        pointCount(getUser());
        pointCount(this);
        getUser().showHand();
        System.out.println("\n" + getName() + "さんの手札");
        System.out.println("【" + getHand().get(0) + "】　：　" + getHand().get(0).getPoint() + "点");
    }

    //カードの点数を計算する
    public void pointCount(PlayerBase player) {
        //手札にエースがあったらtrue
        boolean aceCheck = false;
        int point = 0;
        for (Card c : player.getHand()) {
            if (c.getNumber() == 1) {
                aceCheck = true;
            }
            point += c.getPoint();
        }
        player.setTotalScore(point);
        if (player.getHand().size() == 2 && player.getTotalScore() == 21) {
            player.setBlackJack(true);
        }
        //手札にエースがあり、点数が２１を超えたら１点として計算
        if (aceCheck && player.getTotalScore() > 21) {
            player.setTotalScore(player.getTotalScore() - 10);
        }
    }

    //ユーザーがヒットまたは点数が２１以下の間、カードを引く
    public void userTurn() {
        while (getUser().getTotalScore() < 21 && user.hitCheck()) {
            getUser().hit(handOutCards());
            pointCount(getUser());
            getUser().showHand();
        }
    }

    //ディーラーがカードの点数が１７以上になるまで、カードを引く
    public void dealerTurn() {
        while (getTotalScore() < 21 && getTotalScore() < 17) {
            setHand(handOutCards());
            System.out.println("【" + this.getHand().get(this.getHand().size() - 1) + "】　を引きました");
            pointCount(this);
            this.showHand();
        }
    }

    //カードの点数が２１に近いほうを判定し、勝者を判定する
    public void judgment() {
        if (getUser().getTotalScore() < getTotalScore()) {
            System.out.println("\n" + this.getName() + "さんの勝ち");
        } else if (getUser().getTotalScore() > getTotalScore()) {
            System.out.println("\n" + getUser().getName() + "さんの勝ち");
        } else {
            System.out.println("引き分け");
        }
    }

    //バーストしたかをチェックする
    public boolean burstCheck(PlayerBase player) {
        if (player.getTotalScore() > 21) {
            System.out.println("\n" + player.getName() + "さんがバーストしました。");
            System.out.println(player.getName() + "さんの負け");
            return true;
        }
        return false;
    }

    //ゲーム結果を表示す
    public void result() {
        System.out.println("【ゲーム終了】");
        //トランプを山札に戻す
        while (this.getHand().isEmpty() == false) {
            this.getTrumpDeck().setDeck(this.getHand().remove(0));
        }
        while (getUser().getHand().isEmpty() == false) {
            this.getTrumpDeck().setDeck(getUser().getHand().remove(0));
        }
    }
}
