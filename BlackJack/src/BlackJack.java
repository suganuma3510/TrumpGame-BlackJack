
import java.util.ArrayList;

public class BlackJack {

    public static void main(String[] args) {

        try {
            //プレイヤーの生成
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("村田"));
            player.add(new Player("山田"));
            //進行役の生成
            Dealer dealer = new Dealer();
            //山札の生成
            Deck deck = new Deck();
            //場の生成
            Table field = new Table();
            //進行役に場、プレイヤー、山札を渡しゲームの準備をする
            dealer.prepareGame(player, deck, field);
            //ゲームの開始
            dealer.startGame();
            //ゲーム結果
            dealer.result();
        } catch (Exception e) {
            //例外処理
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}
