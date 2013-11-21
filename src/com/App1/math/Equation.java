package com.App1.math;
/**
 * 
 * @author damond howard
 * @version 1.00
 */
public abstract class Equation
{
  /**
   * 
   * @param terms
   */
  protected Equation(Term[] terms)
   {
   }
  /**
   * 
   * @param equation
   */
  protected Equation(String equation)
   {
   }
  /**
   * 
   * @param c
   * @return
   */
  public boolean isNum(char c)
   { 
     if(Character.isDigit(c))
       return true;
     else
       return false;
   }
  /**
   * 
   * @param num1
   * @param num2
   * @return
   */
  int commonFactor(int num1,int num2)
   {
    int bigNum,smallNum;
    if(num1 > num2)
     {
       bigNum   = num1;
       smallNum = num2; 
     } 
    else if(num2 > num1)
     {
       bigNum   = num2;
       smallNum = num1;
     }
    else
     return num1;
    if((bigNum % smallNum) == 0)
     {
      return smallNum;
     }
    else
     for(int x=bigNum-1;x>0;x--)
      {
       if((bigNum % x == 0) && (smallNum % x == 0))
       {
        return x;
       }
      }
     return -1;
   }
  public void simplify()
   {
   }
  public void foil()
   {
   }
  /**
   * 
   * @param num
   * @return
   */
  public boolean isWholeNum(double num)
   {
	return false;
   } 
  /**
   * 
   * @return
   */
  public boolean isDiffOfSquares()
   {
	return false;
   }
  public void factor()
   {
   }
  /**
   * 
   * @param x
   * @return
   */
  public double solveForY(double x)
   {
	return x;
   }
  /**
   * 
   * @param y
   * @return
   */
  public double solveForX(double y)
   {
	return y;
   }
  /**
   * 
   * @return
   */
  public String outPutResults()
   {
	return null;
   }
  public void setValues()
   {
   }
  /**
   * 
   */
  public String toString()
   {
	 String str = "" ;
	 return str;
   }
}