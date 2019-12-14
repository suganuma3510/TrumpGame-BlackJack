
import java.util.Collections;
import java.util.Scanner;

//PlayerBaseを継承したディーラークラス
public class Dealer extends PlayerBase {

    private User user;
    private TrumpDeck trumpDeck;
    private int betChip;

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

    public int getBetChip() {
        return this.betChip;
    }

    public void setBetChip(int betChip) {
        this.betChip = betChip;
    }

    //ゲームの準備をするメソッド
    public void prepareGame(User user, TrumpDeck trumpDeck) {
        setuser(user);
        setTrumpDeck(trumpDeck);
    }

    //ゲームを始めるメソッド
    public void startGame() {
        System.out.println("【ブラックジャックを開始します】");
        //掛け金を入力しフィールドにセット
        setBetChip(getUser().bet());
        firstSteps();
        //ユーザーがブラックジャックか判定
        if (getUser().getTotalScore() == 21 && this.getTotalScore() != 21) {
            this.showHand();
            getUser().setIsWin(true);
            return;
        }
        //ディーラーがブラックジャックか判定
        if (this.getTotalScore() == 21) {
            this.setIsWin(true);
        }
        userTurn();

        //ユーザーがバーストしたか判定
        if (burstCheck(getUser())) {
            this.showHand();
            this.setIsWin(true);
            return;
        }
        dealerTurn();
        //ディーラーがバーストしたか判定
        if (burstCheck(this)) {
            this.showHand();
            getUser().setIsWin(true);
            return;
        }
        //両者ともバーストしていなければ２１に近い方を判定
        judgment();

    }

    //手札を配るメソッド
    public Card handOutCards() {
        //山札をシャッフルする
        Collections.shuffle(getTrumpDeck().getDeck());
        //１枚カードをランダムに配る  
        return getTrumpDeck().getDeck().remove(0);
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
        //手札にエースがあり、点数が２１を超えたら１点として計算
        if (aceCheck && player.getTotalScore() > 21) {
            player.setTotalScore(player.getTotalScore() - 10);
        }
    }

    /*
    最初にユーザーとディーラーに２枚ずつカードを分け、
    ユーザーは２枚、ディーラーは１枚カードを公開する
     */
    public void firstSteps() {
        System.out.println("【カードを配ります。】");
        for (int i = 0; i < 2; i++) {
            getUser().setHand(handOutCards());
        }
        pointCount(getUser());
        getUser().showHand();
        this.setHand(handOutCards());
        pointCount(this);
        this.showHand();
        this.setHand(handOutCards());
        pointCount(this);

    }

    //ユーザーがヒットまたは点数が２１以下の間、カードを引く
    public void userTurn() {
        System.out.println("\n≪" + getUser().getName() + "さんのターン≫");
        while (getUser().getTotalScore() < 21 && user.hitCheck()) {
            getUser().hit(handOutCards());
            pointCount(getUser());
            getUser().showHand();
        }
    }

    //ディーラーがカードの点数が１７以上になるまで、カードを引く
    public void dealerTurn() {
        System.out.println("\n≪" + getName() + "さんのターン≫");
        System.out.println("２枚目のカードを公開");
        this.showHand();
        while (getTotalScore() < 21 && getTotalScore() < 17) {
            setHand(handOutCards());
            System.out.println("【" + this.getHand().get(this.getHand().size() - 1) + "】　を引きました");
            pointCount(this);
            this.showHand();
        }
    }

    //カードの点数が２１に近いほうを判定し、勝者を判定する
    public void judgment() {
        if (getUser().getTotalScore() > this.getTotalScore()) {
            getUser().setIsWin(true);
        } else if (getUser().getTotalScore() < this.getTotalScore()) {
            this.setIsWin(true);
        }
    }

    //バーストしたかをチェックする
    public boolean burstCheck(PlayerBase player) {
        if (player.getTotalScore() > 21) {
            System.out.println("\n" + player.getName() + "さんがバーストしました。");
            return true;
        }
        return false;
    }

    //ゲーム結果を表示する
    public void result() {

        if (getUser().getIsWin() && this.getIsWin() == false) {
            System.out.println("\n" + getUser().getName() + "さんの勝ち");
            getUser().getChip().setMoney(getUser().getChip().getMoney() + getBetChip() * 2);
        } else if (this.getIsWin() && getUser().getIsWin() == false) {
            System.out.println("\n" + getUser().getName() + "さんの負け");
        } else {
            System.out.println("\n引分け");
            getUser().getChip().setMoney(getUser().getChip().getMoney() + getBetChip());
        }
        System.out.println(getUser().getName() + "さんの現在の所持金：" + getUser().getChip());
        
        //所持金がなくなったらゲーム終了
        if (getUser().getChip().getMoney() == 0) {
            System.out.println("所持金がなくなりました。");
            System.out.println("【ゲーム終了】");
            System.exit(0);
        }
        //トランプを山札に戻す
        while (this.getHand().isEmpty() == false) {
            this.getTrumpDeck().setDeck(this.getHand().remove(0));
        }
        while (getUser().getHand().isEmpty() == false) {
            this.getTrumpDeck().setDeck(getUser().getHand().remove(0));
        }
        getUser().setIsWin(false);
        this.setIsWin(false);
        rematch();
    }

    //再戦するメソッド
    public void rematch() {
        System.out.println("再戦しますか？");
        System.out.println("Yes：0　No：1");
        Scanner scanner = new Scanner(System.in);
        //入力される値をチェック
        while (true) {
            if (scanner.hasNextInt()) {
                int checkNum = scanner.nextInt();
                switch (checkNum) {
                    case 0:
                        startGame();
                        result();
                    case 1:
                        System.out.println("【ゲーム終了】");
                        System.exit(0);
                    default:
                        //指定外の数字が入力された場合の例外処理
                        System.out.println("指定された数字を入力してください。");
                }
            } else {
                //文字が入力された場合の例外処理
                System.out.println("文字または範囲外の数値が入力されています。指定された数字で入力してください。");
                scanner.next();
            }
        }
    }
}
