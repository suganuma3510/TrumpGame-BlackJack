
import java.util.Scanner;
//PlayerBase���p���������[�U�[�N���X

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

    //���肩������J�[�h��W�����͂Ŏ󂯕t���郁�\�b�h
    public boolean hitCheck() {
        System.out.println("Hit�F0�@Stay�F1");
        Scanner scanner = new Scanner(System.in);
        //���͂����l���`�F�b�N
        while (true) {
            if (scanner.hasNextInt()) {
                int checkNum = scanner.nextInt();
                switch (checkNum) {
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
                System.out.println("�����܂��͔͈͊O�̐��l�����͂���Ă��܂��B�w�肳�ꂽ�����œ��͂��Ă��������B");
                scanner.next();
            }
        }
    }

    //�q�b�g���J�[�h��\�����Ď�D�ɃZ�b�g����
    public void hit(Card card) {
        System.out.println("�y" + card + "�z�@�������܂����B");
        setHand(card);
    }
    
    public int bet() {
        System.out.println(getName() + "����̌��݂̏������F" + getChip());
        System.out.println("������q���܂����H");
        Scanner scanner = new Scanner(System.in);
        //���͂����l���`�F�b�N
        while (true) {
            if (scanner.hasNextInt()) {
                int betChip = scanner.nextInt();
                if (getChip().getMoney() >= betChip && 1 <= betChip) {
                    getChip().setMoney(getChip().getMoney() - betChip);
                    return betChip;
                } else if(0 > betChip){
                    //�w��O�̐��������͂��ꂽ�ꍇ�̗�O����
                    System.out.println("����������܂���B������x���͂��Ă��������B");
                }else{
                    System.out.println("�P�~�ȏ�q���Ă��������B");
                }
            } else {
                //���������͂��ꂽ�ꍇ�̗�O����
                System.out.println("�͈͓��̐����œ��͂��Ă��������B");
                scanner.next();
            }
        }
    }
}
