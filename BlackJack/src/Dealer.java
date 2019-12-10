
import java.util.ArrayList;

//ゲームの進行をするディーラークラス
public interface Dealer {

    //ゲームの準備をするメソッド
    public void prepareGame( Player player, TrumpDeck trumpDeck, Table field);

    //ゲームを始めるメソッド
    public void startGame();

    //手札を配るメソッド
    public Card handOutCards();

    //勝ったプレイヤーをチェックする
    public void winPlayer();

    //ゲーム結果を表示する
    public void result();
}
