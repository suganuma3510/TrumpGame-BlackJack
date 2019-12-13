
public class BlackJack {

    public static void main(String[] args) {
        try {
            //プレイヤーの生成
            User user = new User("村田",100000);
            //進行役の生成
            Dealer dealer = new Dealer("ゲームマスター");
            FakeDealer fakeDealer =new FakeDealer("イカサマディーラー");
            //山札の生成
            TrumpDeck trumpDeck = new TrumpDeck();
            //進行役に場、プレイヤー、山札を渡しゲームの準備をする
            fakeDealer.prepareGame(user, trumpDeck);
            System.out.println(user.bet());
            System.out.println(user.getChip());
            //ゲームの開始
            fakeDealer.startGame();
            //ゲーム結果
            fakeDealer.result();
        } catch (Exception e) {
            //例外処理
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}
