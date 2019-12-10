
import java.util.ArrayList;
import java.util.Collections;

//Dealerインターフェースを継承した新米ディーラークラス
public class BeginnerDealer implements Dealer {

    private Player player;
    private TrumpDeck trumpDeck;
    private Table field;
    private int totalPoint;

    public Player getPlayer() {
        return this.player;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    public TrumpDeck getTrumpDeck() {
        return this.trumpDeck;
    }

    private void setTrumpDeck(TrumpDeck trumpDeck) {
        this.trumpDeck = trumpDeck;
    }

    public Table getField() {
        return this.field;
    }

    private void setField(Table field) {
        this.field = field;
    }

    public int getTotalPoint() {
        return this.totalPoint;
    }

    private void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    //ゲームの準備をするメソッド
    @Override
    public void prepareGame(Player player, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setPlayer(player);
        player.setField(field);
        setTrumpDeck(trumpDeck);
    }

    //ゲームを始めるメソッド
    @Override
    public void startGame() {
        System.out.println("【ブラックジャックを開始します】");
        getField().setPlayerHand(handOutCards());
        getField().setPlayerHand(handOutCards());
        getField().setPlayerHand(handOutCards());
        player.pointCount();
    }

    //手札を配るメソッド
    @Override
    public Card handOutCards() {
        System.out.println("【プレイヤーにカードを配ります】");
        //山札をシャッフルする
        Collections.shuffle(getTrumpDeck().getDeck());
        //１枚カードをランダムに配る   
        return getTrumpDeck().getDeck().remove(0);

    }

    //勝ったプレイヤーをチェックする
    @Override
    public void winPlayer() {

    }

    //ゲーム結果を表示する
    @Override
    public void result() {
        System.out.println("【ゲーム終了】");

    }

    public void pointCount() {
        boolean aceCheck = false;
        for (Card c : getField().getDealerHand()) {
            aceCheck = c.getNumber() == 11;
            setTotalPoint(getTotalPoint() + c.getPoint());
        }
        if (aceCheck) {
            if (getTotalPoint() < 11) {
                setTotalPoint(getTotalPoint() + 10);
            } else {
                setTotalPoint(getTotalPoint() - 10);
            }
        }
    }

    public void playerTurn() {
        pointCount();
    }
}
