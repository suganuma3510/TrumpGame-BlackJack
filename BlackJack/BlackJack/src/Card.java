
//�P���̃J�[�h�N���X
public class Card {

    private Suit mark;
    private int number;
    private int point;

    Card(Suit mark, int number) {
        setMark(mark);
        setNumber(number);
        cardPoints();
    }

    public Suit getMark() {
        return this.mark;
    }

    private void setMark(Suit mark) {
        this.mark = mark;
    }

    public int getNumber() {
        return this.number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    public int getPoint() {
        return this.point;
    }

    private void setPoint(int point) {
        this.point = point;
    }

    //�J�[�h�̖��O�𕶎���ŕԂ�
    @Override
    public String toString() {
        switch (getNumber()) {
            case 1:
                return getMark() + "��A";
            case 11:
                return getMark() + "��J";
            case 12:
                return getMark() + "��Q";
            case 13:
                return getMark() + "��K";
            default:
                return getMark() + "��" + getNumber();
        }
    }

    //�J�[�h�̓_��
    public void cardPoints() {
        switch (getNumber()) {
            case 1:
                setPoint(11);
                break;
            case 11:
                setPoint(10);
                break;
            case 12:
                setPoint(10);
                break;
            case 13:
                setPoint(10);
                break;
            default:
                setPoint(getNumber());
        }
    }
}