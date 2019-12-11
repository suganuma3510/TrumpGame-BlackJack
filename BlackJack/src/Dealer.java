
import java.util.ArrayList;
import java.util.Collections;

//Dealerインターフェースを継承した新米ディーラークラス
public class Dealer extends Player {

    private User user;
    private TrumpDeck trumpDeck;

    Dealer(String name) {
        super(name);
    }

    public User gatUser() {
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
    public void prepareGame(User user, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setuser(user);
        user.setField(field);
        setTrumpDeck(trumpDeck);
    }

    //ゲームを始めるメソッド
    public void startGame() {
        System.out.println("【ブラックジャックを開始します】");
        System.out.println("【プレイヤーにカードを配ります。】");
        for (int i = 0; i < 2; i++) {
            gatUser().setHand(handOutCards());

        }
        this.setHand(handOutCards());
        pointCount(gatUser());
        pointCount(this);
        gatUser().showHand();
        this.showHand();
        while(user.hitCheck()){
             gatUser().setHand(handOutCards());
        }
        userTurn();
    }

    //手札を配るメソッド
    public Card handOutCards() {
        //山札をシャッフルする
        Collections.shuffle(getTrumpDeck().getDeck());
        //１枚カードをランダムに配る   
        return getTrumpDeck().getDeck().remove(0);

    }

    //勝ったプレイヤーをチェックする
    public void winuser(User user) {

    }

    public void pointCount(Player player) {
        boolean aceCheck = false;
        int point = 0;
        for (Card c : player.getHand()) {
            if (c.getNumber() == 1) {
                aceCheck = true;
            }
            point += c.getPoint();
        }
        player.setTotalPoint(point);
        if (player.getHand().size() == 2 && player.getTotalPoint() == 21) {
            player.setBlackJack(true);
        }
        if (aceCheck && player.getTotalPoint() > 21) {
            player.setTotalPoint(player.getTotalPoint() - 10);
        }
    }

    //ゲーム結果を表示す
    public void result() {
        System.out.println("【ゲーム終了】");

    }

    public void userTurn() {

    }

    public void dealerTurn() {

    }

   
}
