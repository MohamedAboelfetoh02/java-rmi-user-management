import java.io.Serializable;

public class MyObject implements Serializable {
    private int length = 4, height = 5, breadth = 3;
    public int getLength() { return length; }
    public int getHeight() { return height; }
    public int getBreadth() { return breadth; }
}