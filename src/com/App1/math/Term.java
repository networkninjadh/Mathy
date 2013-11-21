package com.App1.math;
/**
 * @author damond
 */
public class Term 
{
  protected double value;
  protected int degree;
  protected boolean positive;
  protected boolean attachOperator;
	/**
	 * 
	 * @param term
	 */
	protected Term(String term)
	{
	 Parse parser = new Parse(term);
	 String[] partsOfTerm = parser.seperate();
	 if(partsOfTerm[0] == "+")
	   {
	    this.positive = true;		
	   }
	 else if(partsOfTerm[0] == "-")
	   {
	    this.positive = false;
	   }
	    value =  Integer.parseInt(partsOfTerm[1]);
	}
	/**
	 * 
	 * @param value
	 */
	protected Term(double value)
	{
	  if(value > 0)
	     this.positive = true;
	  else if(value < 0)
	     this.positive = false;
	     this.value    = value;
	}
        protected Term(double value,int degree)
        {
          this.value = value;
          this.degree = degree;
        }
	/**
	 * 
	 * @param value
	 * @param positive
	 */
	protected Term(double value,boolean positive)
	{
          this.value = value;
	  this.positive = positive;
	}
	/**
	 * 
	 * @param value
	 * @param positive
	 * @param attachOperator
	 */
	protected Term(double value,boolean positive,boolean attachOperator)
	{
	 this.value = value;
	 this.positive = positive;
	 this.attachOperator = attachOperator;
	}
        /**
         *
         * @return double 
         */
        protected double getval()
        {
         return this.value;
        }
        /**
         *
         * @return int
         */
        protected int getDegree()
        {
         return this.degree;
        }
	/**
	 * 
	 */
    public String toString()
    {
       if(attachOperator == true)
       {
    	if(positive == true)
    	{
    	 return "+"+value;
    	}
    	else if(positive == false)
    	{
    	 return ""+value;
    	}
       }
       else if(attachOperator == false)
       {
    	 if(positive == true)
    	  {
    	   return ""+value;   
    	  }
    	 else if(positive == false)
    	  {
           return ""+value;
    	  }
       }
	return null;
    }
}
