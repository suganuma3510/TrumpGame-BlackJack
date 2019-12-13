
import java.util.Collections;

//PlayerBase���p�������f�B�[���[�N���X
public class Dealer extends PlayerBase {

    private User user;
    private TrumpDeck trumpDeck;

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

    //�Q�[���̏��������郁�\�b�h
    public void prepareGame(User user, TrumpDeck trumpDeck) {
        setuser(user);
        setTrumpDeck(trumpDeck);
    }

    //�Q�[�����n�߂郁�\�b�h
    public void startGame() {
        System.out.println("�y�u���b�N�W���b�N���J�n���܂��z");
        firstSteps();
        //���[�U�[���u���b�N�W���b�N�ŏ��������̏���
        if (getUser().getBlackJack() && this.getBlackJack() == false) {
            this.showHand();
            System.out.println("\n" + getUser().getName() + "����̏���");
            return;
        }
        userTurn();
        if (burstCheck(getUser())) {
            this.showHand();
            return;
        }
        //�f�B�[���[���u���b�N�W���b�N�ŏ��������̏���
        if (getUser().getBlackJack() == false && this.getBlackJack()) {
            System.out.println("\n" + this.getName() + "����̏���");
            return;
        }
        //���҂Ƃ��o�[�X�g���Ă��Ȃ���΂Q�P�ɋ߂����𔻒�
        if (burstCheck(getUser()) == false) {
            dealerTurn();
            if (burstCheck(this) == false) {
                judgment();
            }
        }
    }

    //��D��z�郁�\�b�h
    public Card handOutCards() {
        //�R�D���V���b�t������
        Collections.shuffle(getTrumpDeck().getDeck());
        //�P���J�[�h�������_���ɔz��  
        return getTrumpDeck().getDeck().remove(0);
    }

    /*
    �ŏ��Ƀ��[�U�[�ƃf�B�[���[�ɂQ�����J�[�h�𕪂��A
    ���[�U�[�͂Q���A�f�B�[���[�͂P���J�[�h�����J����
     */
    public void firstSteps() {
        System.out.println("�y�J�[�h��z��܂��B�z");
        for (int i = 0; i < 2; i++) {
            getUser().setHand(handOutCards());
            this.setHand(handOutCards());
        }
        pointCount(getUser());
        pointCount(this);
        getUser().showHand();
        System.out.println("\n" + getName() + "����̎�D");
        System.out.println("�y" + getHand().get(0) + "�z�@�F�@" + getHand().get(0).getPoint() + "�_");
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
        if (player.getHand().size() == 2 && player.getTotalScore() == 21) {
            player.setBlackJack(true);
        }
        //��D�ɃG�[�X������A�_�����Q�P�𒴂�����P�_�Ƃ��Čv�Z
        if (aceCheck && player.getTotalScore() > 21) {
            player.setTotalScore(player.getTotalScore() - 10);
        }
    }

    //���[�U�[���q�b�g�܂��͓_�����Q�P�ȉ��̊ԁA�J�[�h������
    public void userTurn() {
        while (getUser().getTotalScore() < 21 && user.hitCheck()) {
            getUser().hit(handOutCards());
            pointCount(getUser());
            getUser().showHand();
        }
    }

    //�f�B�[���[���J�[�h�̓_�����P�V�ȏ�ɂȂ�܂ŁA�J�[�h������
    public void dealerTurn() {
        while (getTotalScore() < 21 && getTotalScore() < 17) {
            setHand(handOutCards());
            System.out.println("�y" + this.getHand().get(this.getHand().size() - 1) + "�z�@�������܂���");
            pointCount(this);
            this.showHand();
        }
    }

    //�J�[�h�̓_�����Q�P�ɋ߂��ق��𔻒肵�A���҂𔻒肷��
    public void judgment() {
        if (getUser().getTotalScore() < getTotalScore()) {
            System.out.println("\n" + this.getName() + "����̏���");
        } else if (getUser().getTotalScore() > getTotalScore()) {
            System.out.println("\n" + getUser().getName() + "����̏���");
        } else {
            System.out.println("��������");
        }
    }

    //�o�[�X�g���������`�F�b�N����
    public boolean burstCheck(PlayerBase player) {
        if (player.getTotalScore() > 21) {
            System.out.println("\n" + player.getName() + "���񂪃o�[�X�g���܂����B");
            System.out.println(player.getName() + "����̕���");
            return true;
        }
        return false;
    }

    //�Q�[�����ʂ�\����
    public void result() {
        System.out.println("�y�Q�[���I���z");
        //�g�����v���R�D�ɖ߂�
        while (this.getHand().isEmpty() == false) {
            this.getTrumpDeck().setDeck(this.getHand().remove(0));
        }
        while (getUser().getHand().isEmpty() == false) {
            this.getTrumpDeck().setDeck(getUser().getHand().remove(0));
        }
    }
}
