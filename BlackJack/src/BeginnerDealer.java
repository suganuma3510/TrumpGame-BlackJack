
import java.util.Collections;

//Dealerインターフェースを継承した新米ディーラークラス
public class BeginnerDealer implements Dealer {

    private Player player;
    private TrumpDeck trumpDeck;
    private Table field;

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

    //ゲームの準備をするメソッド
    @Override
    public void prepareGame(Player player, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setPlayer(player);
        setTrumpDeck(trumpDeck);
    }

    //ゲームを始めるメソッド
    @Override
    public void startGame() {
        System.out.println("【ブラックジャックを開始します】");
        handOutCards();
    }

    //手札を配るメソッド
    @Override
    public void handOutCards() {
        System.out.println("【プレイヤーにカードを配ります】");
        //山札をシャッフルする
        Collections.shuffle(getTrumpDeck().getDeck());
        //１枚カードを配る
        player.setHand(getTrumpDeck().getDeck().get(0));
        getTrumpDeck().getDeck().remove(0);

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
}
