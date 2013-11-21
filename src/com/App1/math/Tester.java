package com.App1.math;
 public class Tester
 {
  public static void main(String[] args)
   {
    Binomial binom = new Binomial(args[0]);
    System.out.println(binom);
    binom.simplify();
    System.out.println(binom);
   }
 }
