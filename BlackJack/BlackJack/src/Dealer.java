
import java.util.Collections;
import java.util.Scanner;

//PlayerBase���p�������f�B�[���[�N���X
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

    //�Q�[���̏��������郁�\�b�h
    public void prepareGame(User user, TrumpDeck trumpDeck) {
        setuser(user);
        setTrumpDeck(trumpDeck);
    }

    //�Q�[�����n�߂郁�\�b�h
    public void startGame() {
        System.out.println("�y�u���b�N�W���b�N���J�n���܂��z");
        //�|��������͂��t�B�[���h�ɃZ�b�g
        setBetChip(getUser().bet());
        firstSteps();
        //���[�U�[���u���b�N�W���b�N������
        if (getUser().getTotalScore() == 21 && this.getTotalScore() != 21) {
            this.showHand();
            getUser().setIsWin(true);
            return;
        }
        //�f�B�[���[���u���b�N�W���b�N������
        if (this.getTotalScore() == 21) {
            this.setIsWin(true);
        }
        userTurn();

        //���[�U�[���o�[�X�g����������
        if (burstCheck(getUser())) {
            this.showHand();
            this.setIsWin(true);
            return;
        }
        dealerTurn();
        //�f�B�[���[���o�[�X�g����������
        if (burstCheck(this)) {
            this.showHand();
            getUser().setIsWin(true);
            return;
        }
        //���҂Ƃ��o�[�X�g���Ă��Ȃ���΂Q�P�ɋ߂����𔻒�
        judgment();

    }

    //��D��z�郁�\�b�h
    public Card handOutCards() {
        //�R�D���V���b�t������
        Collections.shuffle(getTrumpDeck().getDeck());
        //�P���J�[�h�������_���ɔz��  
        return getTrumpDeck().getDeck().remove(0);
    }

    //�J�[�h�̓_�����v�Z����
    public void pointCount(PlayerBase player) {
        //��D�ɃG�[�X����������true
        boolean aceCheck = false;
        int point = 0;
        for (Card c : player.getHand()) {
            if (c.getNumber() == 1) {
                aceCheck = true;
            }
            point += c.getPoint();
        }
        player.setTotalScore(point);
        //��D�ɃG�[�X������A�_�����Q�P�𒴂�����P�_�Ƃ��Čv�Z
        if (aceCheck && player.getTotalScore() > 21) {
            player.setTotalScore(player.getTotalScore() - 10);
        }
    }

    /*
    �ŏ��Ƀ��[�U�[�ƃf�B�[���[�ɂQ�����J�[�h�𕪂��A
    ���[�U�[�͂Q���A�f�B�[���[�͂P���J�[�h�����J����
     */
    public void firstSteps() {
        System.out.println("�y�J�[�h��z��܂��B�z");
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

    //���[�U�[���q�b�g�܂��͓_�����Q�P�ȉ��̊ԁA�J�[�h������
    public void userTurn() {
        System.out.println("\n��" + getUser().getName() + "����̃^�[����");
        while (getUser().getTotalScore() < 21 && user.hitCheck()) {
            getUser().hit(handOutCards());
            pointCount(getUser());
            getUser().showHand();
        }
    }

    //�f�B�[���[���J�[�h�̓_�����P�V�ȏ�ɂȂ�܂ŁA�J�[�h������
    public void dealerTurn() {
        System.out.println("\n��" + getName() + "����̃^�[����");
        System.out.println("�Q���ڂ̃J�[�h�����J");
        this.showHand();
        while (getTotalScore() < 21 && getTotalScore() < 17) {
            setHand(handOutCards());
            System.out.println("�y" + this.getHand().get(this.getHand().size() - 1) + "�z�@�������܂���");
            pointCount(this);
            this.showHand();
        }
    }

    //�J�[�h�̓_�����Q�P�ɋ߂��ق��𔻒肵�A���҂𔻒肷��
    public void judgment() {
        if (getUser().getTotalScore() > this.getTotalScore()) {
            getUser().setIsWin(true);
        } else if (getUser().getTotalScore() < this.getTotalScore()) {
            this.setIsWin(true);
        }
    }

    //�o�[�X�g���������`�F�b�N����
    public boolean burstCheck(PlayerBase player) {
        if (player.getTotalScore() > 21) {
            System.out.println("\n" + player.getName() + "���񂪃o�[�X�g���܂����B");
            return true;
        }
        return false;
    }

    //�Q�[�����ʂ�\������
    public void result() {

        if (getUser().getIsWin() && this.getIsWin() == false) {
            System.out.println("\n" + getUser().getName() + "����̏���");
            getUser().getChip().setMoney(getUser().getChip().getMoney() + getBetChip() * 2);
        } else if (this.getIsWin() && getUser().getIsWin() == false) {
            System.out.println("\n" + getUser().getName() + "����̕���");
        } else {
            System.out.println("\n������");
            getUser().getChip().setMoney(getUser().getChip().getMoney() + getBetChip());
        }
        System.out.println(getUser().getName() + "����̌��݂̏������F" + getUser().getChip());
        
        //���������Ȃ��Ȃ�����Q�[���I��
        if (getUser().getChip().getMoney() == 0) {
            System.out.println("���������Ȃ��Ȃ�܂����B");
            System.out.println("�y�Q�[���I���z");
            System.exit(0);
        }
        //�g�����v���R�D�ɖ߂�
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

    //�Đ킷�郁�\�b�h
    public void rematch() {
        System.out.println("�Đ킵�܂����H");
        System.out.println("Yes�F0�@No�F1");
        Scanner scanner = new Scanner(System.in);
        //���͂����l���`�F�b�N
        while (true) {
            if (scanner.hasNextInt()) {
                int checkNum = scanner.nextInt();
                switch (checkNum) {
                    case 0:
                        startGame();
                        result();
                    case 1:
                        System.out.println("�y�Q�[���I���z");
                        System.exit(0);
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
}
