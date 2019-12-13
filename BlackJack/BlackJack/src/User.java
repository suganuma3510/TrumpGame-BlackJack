
import java.util.Scanner;
//PlayerBaseを継承したユーザークラス

public class User extends PlayerBase {
    
    private Chip chip;
    
    User(String name, int money) {
        super(name);
        chip = new Chip(money);
    }
    
    public Chip getChip() {
        return this.chip;
    }
    
    public void setChip(Chip chip) {
        this.chip = chip;
    }

    //相手から引くカードを標準入力で受け付けるメソッド
    public boolean hitCheck() {
        System.out.println("Hit：0　Stay：1");
        Scanner scanner = new Scanner(System.in);
        //入力される値をチェック
        while (true) {
            if (scanner.hasNextInt()) {
                int checkNum = scanner.nextInt();
                switch (checkNum) {
                    case 0:
                        return true;
                    case 1:
                        return false;
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

    //ヒットたカードを表示して手札にセットする
    public void hit(Card card) {
        System.out.println("【" + card + "】　を引きました。");
        setHand(card);
    }
    
    public int bet() {
        System.out.println(getName() + "さんの現在の所持金：" + getChip());
        System.out.println("いくら賭けますか？");
        Scanner scanner = new Scanner(System.in);
        //入力される値をチェック
        while (true) {
            if (scanner.hasNextInt()) {
                int betChip = scanner.nextInt();
                if (getChip().getMoney() >= betChip && 1 <= betChip) {
                    getChip().setMoney(getChip().getMoney() - betChip);
                    return betChip;
                } else if(0 > betChip){
                    //指定外の数字が入力された場合の例外処理
                    System.out.println("お金が足りません。もう一度入力してください。");
                }else{
                    System.out.println("１円以上賭けてください。");
                }
            } else {
                //文字が入力された場合の例外処理
                System.out.println("範囲内の数字で入力してください。");
                scanner.next();
            }
        }
    }
}
