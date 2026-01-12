public interface Path{
    Direction nextdirection(int x,int y,Direction current);
    boolean isout(int x,int y);
}