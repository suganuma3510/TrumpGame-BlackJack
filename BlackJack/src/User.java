
import java.util.Scanner;

public class User extends Player {

    User(String name) {
        super(name);
    }

    //���肩������J�[�h��W�����͂Ŏ󂯕t���郁�\�b�h
    public boolean hitCheck() {

        System.out.println("�q�b�g���܂����H");
        System.out.println("Yes�F0�@No�F1");
        Scanner scanner = new Scanner(System.in);
        //���͂����l���`�F�b�N
        while (true) {
            if (scanner.hasNextInt()) {
                int hit = scanner.nextInt();
                switch (hit) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        //�w��O�̐��������͂��ꂽ�ꍇ�̗�O����
                        System.out.println("�w�肳�ꂽ��������͂��Ă��������B");
                }
            } else {
                //���������͂��ꂽ�ꍇ�̗�O����
                System.out.println("���������͂���Ă��܂��B�w�肳�ꂽ�����œ��͂��Ă��������B");
                scanner.next();
            }
        }
    }
}
