package com.App1.math;
/**
 * @author Damond Howard
 * @date 03/20/13
 * @version 1.00
 * Purpose: holds class representation of a binomial where Ax+Bx is the binomial
 */

public class A
{
  int value;
  boolean positive;
  /**
   * @param value the numerical value of a
   * @param positve  whether a is positive or not
   */
  A(int  value,boolean positve)
  {
    this.value = value;
     if(positve)
       {
        this.positive = true;
       }
	 else
       {
	this.positive = false;
       }
  }
 @Override
 public String toString()
    {
      String str = ""+value;
      return str;
    }
}