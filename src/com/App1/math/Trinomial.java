package com.App1.math;
/**
 *@author Damond Howard
 * date 03/20/13
 * Purpose: Stores the class representation on a trinomial and provides fnctions
 * for simplifying factoring and converting it to a string
 */
public class Trinomial 
{
  //boolean values used to determine the state of the trinomial
  boolean isSimplified = false;
  boolean isFactored = false;
  int degreeA,degreeB,degreeC;
  A a;
  B b;
  C c;
  //string values for simplifying the trinomial
  String outVal,outValX,inValA,inValXA,inValB,inValXB,inValC,inValXC;
  /**
   *@param a the first numerical value of the trinomial
   *@param b the second numerical value of the trinomial
   *@param c the final numerical value of the trinomial
   *@param degreeA the power that a is raised to
   *@param degreeB the power that b is raised to 
   *@param degreeC the power that c is raised to
   */
  Trinomial(int a,int b,int c,int degreeA,int degreeB,int degreeC) 
   {
    this.a = new A(a,true);
    this.b = new B(b,true);
    this.c = new C(c,true);
    this.degreeA = degreeA;
    this.degreeB = degreeB;
    this.degreeC = degreeC;
   }
  /**
   *@param str String value representing a trinomial
   */
  Trinomial(String str)
   {
    int operators = 0; //keeps track of the amount of operators found
    this.a = new A(1,true);
    this.b = new B(1,true);
    this.c = new C(1,true);
    int x = 0;
    while(x<str.length())
     {
      if(x==0)
        {
      if(str.charAt(x) == '+')
        this.a.positive = true;
       else if(str.charAt(x) == '-')
        this.a.positive = false;
        }
       else if(operators == 0)
      {
        {
       if(str.charAt(x)=='+')
         {
          operators++;
          this.b.positive = true;
          str = str.substring(0,x) + "," + str.substring(x,str.length());
         }
       else if(str.charAt(x) == '-')
         {
          operators++;
          this.b.positive = false;
          str = str.substring(0,x) + "," + str.substring(x,str.length());
         }
        }
      }
       else if(operators == 1)
       {
        if(str.charAt(x)=='+')
         {
          this.c.positive = true;
          str = str.substring(0,x) + "," + str.substring(x,str.length());
         } 
        else if(str.charAt(x) =='-')
         {
          this.c.positive = false;
          str = str.substring(0,x) + "," + str.substring(x,str.length());
         }
       }
      x++;
     }  
     String delim1 = "[x^]+";
     //String delim2 = "[x]+";
     String delim3 = "[+|-]";
     String[] strToken = str.split(",");
     String[] As = strToken[0].split(delim1);
     String[] Bs = strToken[1].split(delim1);
	 String[] Cs = strToken[2].split(delim3);
     this.a.value = Integer.parseInt(As[0]);
     this.b.value = Integer.parseInt(Bs[0]);
     this.c.value = Integer.parseInt(Cs[0]); 
   }
  /**
   *
   *@param num1 a number
   *@param num2 another number
   *@param num3 yet another number
   *@return int the greatest common factor of the three numbers
   */
  int commonFactor(int num1,int num2, int num3)
   {
    if(num1 == num2 && num2 == num3)
     return num1;
    int bigNum,smallNum,midNum;
    if(num1 > num2 && num1 > num3)
    {
      bigNum = num1;
      midNum = num2;
      smallNum = num3;
    }
    else if(num2 > num1 && num2 > num3)
    {
      bigNum = num2;
      midNum = num1;
      smallNum = num3;
    }
    else if(num3 > num1 && num3 > num2)
    {
      bigNum = num3;
      midNum = num1;
      smallNum = num2;
    }
    else if(num1 > num3 && num3 > num2)
    {
        bigNum = num1;
        midNum = num3;
        smallNum = num2;
    }
    else if(num2 > num3 && num3 > num1)
    {
        bigNum = num2;
        midNum = num3;
        smallNum = num1;
    }
    else    
    {
        bigNum = num3;
        midNum = num2;
        smallNum = num1;
    }
     if(bigNum % smallNum == 0 && midNum % smallNum == 0)
       return smallNum;
    for(int i = bigNum+1;i>0;i--)
    {
        if(bigNum % i == 0 && midNum % i == 0 && smallNum % i == 0)
        return i;
    }
    return -1;
   }
   /**
    * simplifies a trinomial then sets isSimplified to true
    */
    void simplify()
    {
        //todo simplify the trinomial
    }
    /**
     *factors the trinomial then sets isFactored to true
     */
    void factorTri()
    {
        //factor the trinomial using 
    }
   /**
   *@param a the first numberical value of the trinomial
   *@param b the second numerical value of the trinomial
   *@param c the final numerical value of the trinomial
   *@param degreeA the power that a is raised to
   *@param degreeB the powe that b is raised to 
   *@param degreeC the power that c is raised to
   */
    void setValues(int a,int b,int c,int degreeA,int degreeB,int degreeC)
    {
     this.a.value = a;
     this.b.value = b;
     this.c.value = c;
     this.degreeA = degreeA;
     this.degreeB = degreeB;
     this.degreeC = degreeC;
    }
    /**
     * @return str
     */
    public String toString()
    {
     String astr="",bstr="",cstr="";
     if(this.a.value > 0)
     astr = "+ax^"+degreeA;
     else
	 astr = "-ax^"+degreeA;
     if(this.b.value > 0)
	 bstr = "+bx";
     else
	 bstr = "-bx";
     if(this.c.value > 0)
	 cstr = "+c";
     else
	 cstr = "-c";
     return astr + bstr + cstr;
	}
}
