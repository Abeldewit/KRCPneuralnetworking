import java.util.*;

public class NodeChecker {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Node set1 = new Node();

    System.out.println("Start...");
    System.out.println("Bias: " + set1.getBias());
    System.out.println("Node1: " + set1.getNode1());
    System.out.println("Node2: " + set1.getNode2());
    System.out.println();
    System.out.println("                       bias               node1             node2");


    bias = set1.getBias();
    node1 = set1.getNode1();
    node2 = set1.getNode2();

    System.out.print("Learning step: ")
    learningstep = in.nextDouble();


    int choice1 = 0;
    int choice2 = 0;
    int choice3 = 0;
    int choice4 = 0;

    for(int i = 4; i > 0; i--) {
      int choice = (int) (Math.random()*4);
      if(choice == 0 && choice1 == 0) {
        case11();
        choice1 = 1;
      } else if(choice == 1 && choice2 == 0) {
        case01();
        choice2 = 1;
      } else if(choice == 2 && choice3 == 0) {
        case10();
        choice3 = 1;
      } else if(choice == 3 && choice4 == 0) {
        case00();
        choice4 = 1;
      } else {
        i++;
      }
      //System.err.println(choice1 + " " + choice2 + " " + choice3 + " " + choice4 + " ");
    }


    System.out.println();
    //System.out.println("Bias: " + bias);
    System.out.printf("Bias: %.4f \n", bias);

    System.out.println("Node 1: " + node1);
    System.out.println("Node 2: " + node2);
    System.out.print("With learningstep: " + learningstep);
    System.out.println(" and " + iterations +" iterations.");

  }

  public static void case11() {
    while(running) {
      if(bias+node1+node2 >= 0) {
        running = false;
        System.out.println("With 1 1 you get: " + bias + " " + " " + node1 + " " + node2);
      } else {
        node1 = node1 + learningstep;
        node2 = node2 + learningstep;
        bias = bias + learningstep;
        iterations++;
      }
    }
    running = true;

  }

  public static void case10() {
    while(running) {
      if(bias+node1 >= 0) {
        running = false;
        System.out.println("With 1 0 you get: " + bias + " " + " " + node1 + " " + node2);
      } else {
        node1 = node1 + learningstep;
        bias = bias + learningstep;
        iterations++;
      }
    }
    running = true;
  }

  public static void case01() {
    while(running) {
      if(bias+node2 >= 0) {
        running = false;
        System.out.println("With 0 1 you get: " + bias + " " + " " + node1 + " " + node2);
      } else {
        node2 = node2 + learningstep;
        bias = bias + learningstep;
        iterations++;
      }
    }
    running = true;
  }

  public static void case00() {
    while(running) {
      if(bias < 0) {
        running = false;
        System.out.println("With 0 0 you get: " + bias + " " + " " + node1 + " " + node2);
      } else {
        bias = bias - learningstep;
        iterations++;
      }
    }
    running = true;

  }

  private static double bias;
  private static double node1;
  private static double node2;
  private static double learningstep;
  private static int iterations;
  private static boolean running = true;
}
