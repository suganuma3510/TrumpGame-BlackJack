
public class BlackJack {

    public static void main(String[] args) {
        try {
            //山札の生成
            TrumpDeck trumpDeck = new TrumpDeck();

            //プレイヤーの生成と同時に所持金を代入
            User user = new User("村田", 100000);

            //進行役の生成
//            Dealer dealer = new Dealer("ディーラー");
//            //必ずブラックジャックを出す
//            Dealer dealer = new FakeDealer("イカサマディーラー");
//            //絶対にバーストしない
//            Dealer dealer = new VeteranDealer("ベテランディーラー");
            //バーストしやすい
            Dealer dealer = new BeginnerDealer("新米ディーラー");

            //進行役に場、プレイヤー、山札を渡しゲームの準備をする
            dealer.prepareGame(user, trumpDeck);
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
