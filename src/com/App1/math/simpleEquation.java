package com.App1.math;

public class simpleEquation
{
 boolean isSimplified    = false;
 boolean isFactored      = false;
 boolean isDiffOfSquares = false;

 Term[] terms;
 
 public simpleEquation(Term[] terms)
 { 
  this.terms = new Term[terms.length];
  for(int i=0;i<terms.length;i++)
   {
    this.terms[i] = terms[i];
   }
 }
 
 public simpleEquation(int a,int b, int degreeA,int degreeB)
 {
 }
 
 public simpleEquation(String str)
 {
 }
 
 public char operation(String str)
 {
	return 0;
 }
 
 int commonFactor(int num1,int num2)
 {
	return num2;
 }
 
 public void simplify()
 {
 }
 
 public void Factor()
 {
 }
 
 public void Foil()
 {
 }
 
 public double solveForY(double x)
 {
	return x;
 }
 
 public double solveForX(double y)
 {
	return y;
 }
 
 void setValues(int a,int b,int dA,int dB)
 {
 }
 
 public String toString()
 {
	return null;
 }
}