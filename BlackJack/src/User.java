
import java.util.Scanner;

public class User extends Player {

    User(String name) {
        super(name);
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
                System.out.println("文字が入力されています。指定された数字で入力してください。");
                scanner.next();
            }
        }
    }

    public void hit(Card card) {
        System.out.println("【" + card + "】　を引きました。");
        setHand(card);
    }
}
