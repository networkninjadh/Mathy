//parse takes a string equation parses it and returns an array of terms


package com.App1.math;
//import java.util.regex.*;
public class Parse 
{
	protected boolean isTerm;
	protected boolean isEquation;
	
	protected Parse(String str)
	{
		if(str == "term")
			isTerm = true;
		else if(str == "equation")
			isEquation = true;
	}
	 
	protected String[] seperate()
	{
	  String[] listOfTerms = null;
	  return listOfTerms;
	}

}