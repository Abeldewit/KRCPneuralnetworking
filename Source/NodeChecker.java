import java.util.*;

public class NodeChecker {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    Node set1 = new Node();

    System.out.print("learningstep: ");
    double learningstep = in.nextDouble();

    double biasWeight = set1.getBias();
    double node1Weight = set1.getNode1();
    double node2Weight = set1.getNode2();
    int iterations = 1000;
    int correctnessCount = 0;
    int stepCounter = 0;

    for(int i = 0; i < iterations; i++) {
      //random case solver with formula:
      // learningstep*(wanted output - real output)*input of the node
      int bias = 1;
      int node1 = (int) Math.floor(Math.random()+0.5);
      int node2 = (int) Math.floor(Math.random()+0.5);
      //System.out.println("Testing case " + node1 + " " + node2);

      int wantedOutput = 1;
      if(node1 == 0 && node2 == 0) { wantedOutput = 0; }

      double calculation = biasWeight*bias + node1Weight*node1 + node2Weight*node2;
      int output;
      if(calculation >= 0) { output = 1; } else { output = 0; }
      //System.err.println(calculation);
      if(wantedOutput == output)
      {
        correctnessCount++;
      } else {
        correctnessCount = 0;
      }
      if(correctnessCount > 40) { iterations = i-1; }

      biasWeight = biasWeight + (learningstep*(wantedOutput-output)*1);
      node1Weight = node1Weight + (learningstep*(wantedOutput-output)*node1);
      node2Weight = node2Weight + (learningstep*(wantedOutput-output)*node2);
      System.out.println("Case: " + node1 + " " + node2 + " gave " + output + " expecting "+ wantedOutput);
      stepCounter++;
      if(correctnessCount == 0) {System.out.println("Need to learn more!");}
      System.out.println();
    }
    System.out.println("Needed " + stepCounter + " actual iterations to fully learn.");
    System.out.println("             Bias                "  + "Node 1               " + "Node 2");
    System.out.println("start: " + set1.getBias() + "         " + set1.getNode1() + "         " + set1.getNode2());
    System.out.println("end:   " + biasWeight + "         " + node1Weight + "         " + node2Weight);

  }
}
