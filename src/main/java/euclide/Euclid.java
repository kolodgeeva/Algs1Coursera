package main.java.euclide;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Euclid {

  private static int gcd(int firstNumber, int secondNumber) {
    if (secondNumber == 0)
      return firstNumber;

    int modulo = firstNumber % secondNumber;

    return gcd(secondNumber, modulo);
  }

  public static void main(String[] args) {

    int result = gcd(48, 36);
    StdOut.println("Greater common divisor:");
    StdOut.println(result);

  }

}
