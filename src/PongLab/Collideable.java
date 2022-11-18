package PongLab;

public interface Collideable<T>{
    boolean didCollideLeftPaddle(T obj);
    boolean didCollideRightPaddle(T obj);
    boolean didCollideTop(int height);
    boolean didCollideBottom(int height);
    boolean didCollideLeft(int width);
    boolean didCollideRight(int width);
}
