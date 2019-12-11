
import java.util.ArrayList;
import java.util.Collections;

//Dealer�C���^�[�t�F�[�X���p�������V�ăf�B�[���[�N���X
public class Dealer extends Player {

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
    public void prepareGame(User user, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setuser(user);
        user.setField(field);
        setTrumpDeck(trumpDeck);
    }

    //�Q�[�����n�߂郁�\�b�h
    public void startGame() {
        System.out.println("�y�u���b�N�W���b�N���J�n���܂��z");
        firstSteps();
        userTurn();
        if (getUser().getBlackJack()) {
            System.out.println("�u���b�N�W���b�N�I");
            dealerTurn();
        }
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

    //�������v���C���[���`�F�b�N����
    public void winuser(User user) {

    }

    public void pointCount(Player player) {
        boolean aceCheck = false;
        int point = 0;
        for (Card c : player.getHand()) {
            if (c.getNumber() == 1) {
                aceCheck = true;
            }
            point += c.getPoint();
        }
        player.setTotalPoint(point);
        if (player.getHand().size() == 2 && player.getTotalPoint() == 21) {
            player.setBlackJack(true);
        }
        if (aceCheck && player.getTotalPoint() > 21) {
            player.setTotalPoint(player.getTotalPoint() - 10);
        }
    }

    //�Q�[�����ʂ�\����
    public void result() {
        System.out.println("�y�Q�[���I���z");

    }

    public void userTurn() {
        while (getUser().getTotalPoint() < 21 && user.hitCheck()) {
            getUser().hit(handOutCards());
            pointCount(getUser());
            getUser().showHand();
        }
    }

    public void dealerTurn() {
        while (getTotalPoint() < 21 && getTotalPoint() < 17) {
            setHand(handOutCards());
            pointCount(this);
            this.showHand();
        }
    }

    public void judgment() {
        if (getUser().getTotalPoint() == getTotalPoint()) {
            System.out.println("��������");
        }
        if (getUser().getTotalPoint() < getTotalPoint()) {
            System.out.println("�Q�[���}�X�^�[�̏���");
        } else {
            System.out.println(getUser().getName() + "����̏���");
        }
    }

    public void firstSteps() {
        System.out.println("�y�J�[�h��z��܂��B�z");
        for (int i = 0; i < 2; i++) {
            getUser().setHand(handOutCards());
        }
        this.setHand(handOutCards());
        pointCount(getUser());
        pointCount(this);
        getUser().showHand();
        this.showHand();
    }

    public boolean burstCheck(Player player) {
        if (player.getTotalPoint() > 21) {
            System.out.println("�o�[�X�g���܂����B");
            System.out.println(player.getName() + "����̕���");
            return true;
        }
        return false;
    }
}
