
import java.util.Scanner;

//ババ抜きをするプレイヤークラス
public class Player {

    private String name;
    private Table field;
    private int totalPoint;

    Player(String name) {
        if (name == null || name == "null") {
            throw new NullPointerException("名前がnullになっています。");
        }
        if (name.isEmpty()) {
            throw new RuntimeException("名前が空白になっています。");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("名前が長すぎます");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Table getField() {
        return this.field;
    }

    public void setField(Table field) {
        this.field = field;
    }

    public int getTotalPoint() {
        return this.totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    //プレイヤーの現在の手札を表示するメソッド
    public void showHand() {
        System.out.println(getName() + "さんの現在の手札");
        for (Card c : getField().getPlayerHand()) {
            System.out.print(c.toString() + " ");
        }
        System.out.println("");
        System.out.println(getTotalPoint());
    }

    public void pointCount() {
         boolean aceCheck = false;
        for (Card c : getField().getPlayerHand()) {
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

    //相手から引くカードを標準入力で受け付けるメソッド
    public int choiceCard(Player player) throws UnsupportedSannerException {
//        if (player.getHand().size() != 1) {
//            System.out.println("相手の手札は" + player.getHand().size() + "枚あります。");
//            System.out.println("何番目のカードを引きますか？");
//            for (int i = 1; i <= player.getHand().size(); i++) {
//                System.out.print("【" + i + "】 ");
//            }
//            System.out.println("");
//            Scanner scanner = new Scanner(System.in);
//            //入力される値をチェック
//            while (true) {
//                if (scanner.hasNextInt()) {
//                    int choiceNum = scanner.nextInt();
//                    if (choiceNum > player.getHand().size() || choiceNum < 1) {
//                        //指定外の数字が入力された場合の例外処理
//                        System.out.println("指定された数字を入力してください。");
//                    } else {
//                        return choiceNum - 1;
//                    }
//                } else {
//                    //文字が入力された場合の例外処理
//                    System.out.println("文字が入力されています。指定された数字で入力してください。");
//                    scanner.next();
//                }
//            }
//        }
        return 0;
    }
}
