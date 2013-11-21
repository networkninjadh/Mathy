package com.App1.math;
/**
 *
 * @author damond
 * @date 03/20/13
 * Purpose: holds class representation of the B val of a binomial where Ax+Bx
 * is the binomial
 */
public class B
{
  int value;
  boolean positive;
  /**
   *
   * @param value
   * @param positive
   */
  B(int value,boolean positive)
  {
	  this.value = value;
	  if(positive)
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