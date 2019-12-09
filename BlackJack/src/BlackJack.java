
import java.util.ArrayList;

public class BlackJack {

    public static void main(String[] args) {

        try {
            //プレイヤーの生成
            Player player = new Player("村田");
            //進行役の生成
            Dealer dealer = new BeginnerDealer();
            //山札の生成
            TrumpDeck trumpDeck = new TrumpDeck();
            //場の生成
            Table field = new Table();
            //進行役に場、プレイヤー、山札を渡しゲームの準備をする
            dealer.prepareGame(player, trumpDeck, field);
            //ゲームの開始
            dealer.startGame();
            
            player.showHand();
            System.out.println(player.getHand().get(0).getPoint());
            //ゲーム結果
            dealer.result();
        } catch (Exception e) {
            //例外処理
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}
