
//�g�����v�̕�
enum Mark {
    spade, heart, club, diamond, Joker;

    //�J�[�h�̕��𕶎���ŕԂ�
    public String toString() {
        switch (this) {
            case spade:
                return "�X�y�[�h";
            case heart:
                return "�n�[�g";
            case club:
                return "�N���u";
            case diamond:
                return "�_�C��";
            case Joker:
                return "�W���[�J�[";
            default:
                return "�W���[�J�[";
        }
    }
}
