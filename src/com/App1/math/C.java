package com.App1.math;
/**
 *@author Damond Howard
 *@version 1.00
 *Purpose: holds class representation of C term in trinomial
 */
public class C
{
 int value;
 boolean positive;
 /**
  *@param value the numerical value of C
  *@param positive boolean value representing whether C is positive or not 
  */
 C(int value,boolean positive)
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
