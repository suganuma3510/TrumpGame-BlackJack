//Dealer�N���X���p�������u���b�N�W���b�N�����o���Ȃ��f�B�[���[�N���X
public class FakeDealer extends Dealer {

    FakeDealer(String name) {
        super(name);
    }

    @Override
    public void firstSteps() {
        System.out.println("�y�J�[�h��z��܂��B�z");
        for (int i = 0; i < 2; i++) {
            getUser().setHand(handOutCards());
        }
        pointCount(getUser());
        getUser().showHand();
        //�G�[�X��T���Ď�D�ɉ�����
        for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
            if (1 == getTrumpDeck().getDeck().get(i).getNumber()) {
                this.setHand(getTrumpDeck().getDeck().remove(i));
                break;
            }
        }
        pointCount(this);
        showHand();
        //�P�O�ȏ�̃J�[�h��T���Ď�D�ɉ�����
        for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
            if (10 == getTrumpDeck().getDeck().get(i).getPoint()) {
                this.setHand(getTrumpDeck().getDeck().remove(i));
                break;
            }
        }
        pointCount(this);

    }
}
