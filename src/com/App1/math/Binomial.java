package com.App1.math;

/**
*@author Damond Howard
*@version 1.00
*@date date 03/20/13
*Purpose: Stores the Class representation of a Binomial it provides functions
*for simplifying it factoriing it and converting it to a  string that can be
*printed to the screen
*/
public class Binomial
 {
   //boolean values used to determine the state of data within the class
   boolean isSimplified    = false;
   boolean isFactored      = false;
   boolean isDiffOfSquares = false;
   //degree to witch a and b are raised
   int degreeA,degreeB;
   //Objects to represent a and b
   A a;
   B b;
   String outValA,outValX,inValA,inValXA,inValB,inValXB;
   //outValX,inValA,inValueXA,inValB,inValXB;
   //if the binomial is simplified then the string will be outVal+outValX+"("+inValA+inValXA+inValB+inValXB+")";
   /**
    * @param a the first numerical value of a binomial
    * @param b the second numerical value of a binomial
    * @param degreeA the degree of a
    * @param degreeB the degree of b
    */
   Binomial(int a,int b,int degreeA,int degreeB)
    {
     //default value is positive 
     boolean apositive = true; 
     boolean bpositive = true;
     this.a = new A(a,apositive);
     this.b = new B(b,bpositive);
     this.degreeA = degreeA;
     this.degreeB = degreeB;
    }
   /**
    * @param str a string representation of a binomial to be converted to Binomial class representation
    */
   public  Binomial(String str)
    {
     this.a = new A(1,true);
     this.b = new B(1,true);
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
       else
       {
       if(str.charAt(x) == '+')
       {
         this.b.positive = true;
         str = str.substring(0,x) + "," + str.substring(x,str.length());
         x = str.length();
       }
       else if(str.charAt(x) == '-')
       {
         this.b.positive = false;
         str = str.substring(0,x) + "," + str.substring(x,str.length());
         x = str.length();
       }
       }
       x++;
       } 
       String delim = "[x^]+";
       String[] strToken = str.split(",");
       String[] As = strToken[0].split(delim);
       String[] Bs = strToken[1].split(delim);
       //this is for error checking
       for(int i=0;i<As[0].length();i++)
       if(As[0].charAt(i) == '+')
       this.a.value = Integer.parseInt(As[0].substring(x+1,As[0].length()));
       //error checking stops here
       this.a.value = Integer.parseInt(As[0]);
       this.b.value = Integer.parseInt(Bs[0]);
       degreeA = Integer.parseInt(As[1]);
       degreeB = Integer.parseInt(Bs[1]);
         //code to try
         /* Pattern P = Pattern.compile("(([1-9]+)(x|X)?\\^([1-9]+)([+-])([1-9]+)(x|X)?\\^([1-9]+)(([1-9]+)([1-9]+)(x|X)?\\^([1-9]+)))");
         Matcher M = P.matcher(str);
         while(M.find()){
    	 System.out.println(M.group(0));
    	 System.out.println(M.group(1));
    	 System.out.println(M.group(2));
    	 System.out.println(M.group(3));
    	 System.out.println(M.group(4));
    	 System.out.println(M.group(5));
    	 System.out.println(M.group(6));
     }
     */
   }
  /* public String[] Parse2(String str)
    {
     String[] Results;
     Pattern P = Pattern.compile("(([1-9]+)(x|X)?\\^([1-9]+)([+-])([1-9]+)(x|X)?\\^([1-9]+)(([1-9]+)([1-9]+)(x|X)?\\^([1-9]+)))");
     Matcher M = P.matcher(str);
     O(M.group(0));
     O(M.group(1));
     O(M.group(2));
    }*/
   public char operation(String str)
    {
      char c;
      if(this.a.positive)
	 {
           c = '+';
	 } 
      else
           c = '-'; 
      return c;
    }
    public void O(String o)
     {
      System.out.println(o);
     }
   /**
    * @param num1 a number
    * @param num2 another number
    * @return the greatest common factor of the two numbers
    */
    int commonFactor(int num1,int num2)
    {
    	int bigNum,smallNum;
    	if(num1 > num2)
    	{
           bigNum = num1;
    	   smallNum = num2;
   	}
    	else if(num2 > num1)
    	{
    	   bigNum = num2;
    	   smallNum = num1;
    	}
    	else return num1;
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
   /**
    *@param char
    *@return boolean true or false value representing whether it is a number or not
    */
    public boolean isNum(char c)
       {
        //test to see if a char is a number
        if(Character.isDigit(c))
        {
	 return true;
	}
	else 
         return false;
       }
    /**
     * simplifies a polynomial
     */
    public void simplify()
    {
     //To-do: function must simplify a binomial based of the values stored in the class
     //have outside value and inside value create a  new string in the form 3x(5x+1)   from 15x^2+3x
        if(isSimplified == true)
           {;}
            else  if(degreeA == degreeB)
            {
             outValX = "";
             if(degreeB == 1)
             {
              inValA = this.a.value + this.b.value + "x";
             }
             else
             inValA = this.a.value + this.b.value + "x^" + degreeB;
             }
             else if(degreeA != degreeB)
             {
              if(this.commonFactor(this.a.value,this.b.value) == 1)
              {
                outValA = "";
              }
              else
              outValA = ""+this.commonFactor(this.a.value,this.b.value);
              if(this.commonFactor(degreeA,degreeB) == 1)
              {
                outValX = "x";
              }
               else
              outValX = "x^"+this.commonFactor(degreeA,degreeB);
              if(this.a.value / this.commonFactor(this.a.value,this.b.value) == 1)
              {
                inValA = "";
              }
              else
              inValA =  ""+(this.a.value / this.commonFactor(this.a.value,this.b.value));
              if(degreeA - this.commonFactor(degreeA,degreeB) == 1)
              {
               inValXA = "x";
              } 
              else if(degreeA - this.commonFactor(degreeA,degreeB) == 0)
              {
              inValXA = "";
              }
              else
              inValXA = "x^"+(degreeA - this.commonFactor(degreeA,degreeB));
              if(degreeB - this.commonFactor(degreeA,degreeB) == 1)
              {
               inValXB = "x";
              }
              else if(degreeB - this.commonFactor(degreeA,degreeB) == 0)
              {
               inValXB = "";
              }
              else
              inValXB = "x^"+(degreeB - this.commonFactor(degreeA,degreeB));
              if(this.b.value / this.commonFactor(this.a.value,this.b.value) == 1)
              {
               inValB = "+1";
              }
              else
              {
              if(this.b.value < 0)
               inValB = ""+(this.b.value / this.commonFactor(this.a.value,this.b.value));
               else
              inValB = ""+(this.a.value / this.commonFactor(this.a.value,this.b.value));
              //  inValB = "+"+(this.b.value / this.commonFactor(this.a.value,this.b.value));
              //this.b.value / should be this.a.value if the bigger number is the second number
              //tested this is not true common factor function needs to be edited to be able to return a negative
              //number
              }
            }
    	isSimplified = true;
    }
   public void foil()
    {
     isSimplified = false;
    }
    public boolean isWholeNum(double num)
    {
    	int x = (int)num;
    	if((num - x) == 0)
    	{
    	return true;
    	}
    	else 
    	return false;
    }
    public boolean isDiffOfSquares()
     { 
    	if((degreeA % 2 == 0) && (this.b.positive == false) && isWholeNum((Math.sqrt(this.b.value))))
    	{
         return true;
    	}
    	else
         return false;
     }
     public void  factor()
	{
       if(isDiffOfSquares())
         {
           /*if the binomial can be factored using diff of squares
           must print out all steps
           
                           Example
                          36x^4-6x^2
                   -6x^2=0          -6x^2+1=0
                   x^2=0/-6         -6x^2=-1
                   x=sqrt(0/-6)      x^2=-1/-6
                   x=0               x=+-sqrt(-1/-6)
                                    x=.40824829
           */       
         }
         else
         {
          //if the binomial cannot be factore using diff of squares
         }
		isFactored = true;
                //return null;
		//check if it is simplified and if it can be factored
		//To-do: function must factor the binomial using several methods and then convert to a string
	}
     /**
      * @param x value to solve the equation for
      * @return y value corresponding to x
      */
     public double solveForY(double x)
     {
    	 double y;
    	 y = this.a.value * Math.pow(x, degreeA) + this.b.value * Math.pow(x,degreeB);
    	 return y;
     }
     public double solveForX(double y)
     {
    	 //TODO create a method that solves for y
         //to solve for y simply reverse every operation 
         //sample equation
         // y = this.a.value * Math.pow(x,degreeA) + this.b.value * Math.pow(x,degreeB);
         double x = 0.0;
         return x;
     }
     public String outPutResults()
     {   
    	 //TODO code that generates steps to factor binomial
    	 String str = "";
    	 return str;
     }
	void setValues(int a,int b,int dA,int dB)
	{
	 this.a.value = a;
	 this.b.value = b;
         this.degreeA = dA;
         this.degreeB = dB;
	}
	/**
	 * @return string representation of the current state of the binomial
	 */
	public String toString()
	{
          //Use stringBuffer in my toString class so that I can change outVal
	  if(isSimplified == false)
	    {
	     String astr="",bstr="";
	     if(this.a.value > 0)
	       astr = "+"+this.a+"x^"+degreeA;
	     else
               astr = this.a+"x^"+degreeA;
	     if(this.b.value > 0)
	       bstr = "+"+this.b+"x";
	     else
	       bstr = this.b+"x";
                return astr + bstr;
	    }
	  else if (isSimplified == true)
	    {
             if(degreeA == degreeB)
              {
               return outValX+"("+inValA+")";
              }
            String str = outValA+outValX+"("+inValA+inValXA+inValB+inValXB+")";
	       return str;
	   }
	      else if(isFactored  == true)
          {
           //toStringMethod for a factored Binomial
           //create new variables that represent the factored binomial 1 String variable to keep up with each term 
           //add the terms together return the new String
           return null;
          }
           //else return the input String
           return null;
	}
}