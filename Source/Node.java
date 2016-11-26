import java.util.*;

public class Node {
  public Node() {
    bias = 0-(Math.random()*50-25);
    node1 = Math.random()*4;
    node2 = Math.random()*4;
  }

  public double getBias() {
    return bias;
  }

  public double getNode1() {
    return node1;
  }

  public double getNode2() {
    return node2;
  }

  private double bias;
  private double node1;
  private double node2;
}
