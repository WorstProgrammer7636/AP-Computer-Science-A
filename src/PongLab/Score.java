package PongLab;

class Score {
    private int leftScore;
    private int rightScore;

    public Score(){
        leftScore = 0;
        rightScore = 0;
    }

    public void addLeftScore(){
        leftScore++;
    }

    public void addRightScore(){
        rightScore++;
    }

    public int getLeftScore(){
        return leftScore;
    }

    public int getRightScore(){
        return rightScore;
    }
}
