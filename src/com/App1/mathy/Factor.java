package com.App1.mathy;

import  com.App1.math.*;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.Intent;
public class Factor extends Activity
{
 //variables for strings and widgets//
 Button    btnfactor;
 Button    btngraph;
 EditText  txtEquation;
 TextView  txtoutput1;
 TextView  txtoutput2;
 Binomial  binom;
 String    strfactored;
 String    strsimplified;
 String    strequation;
 @Override
 public void onCreate(Bundle bundle)
  {
   super.onCreate(bundle);
   setContentView(R.layout.factor);
   txtoutput1  = (TextView)findViewById(R.id.textView1);
   txtoutput2  = (TextView)findViewById(R.id.textView2);
   txtEquation = (EditText)findViewById(R.id.editText1);
   btngraph = (Button)findViewById(R.id.button2);
   btngraph.setOnClickListener(new OnClickListener()
    {
     @Override
     public void onClick(View v)
      {
       //code to graph
       graph();
      }
    });
  btnfactor = (Button)findViewById(R.id.button1);
  btnfactor.setOnClickListener(new OnClickListener()
   {
    @Override
    public void onClick(View v)
    {
     //code to factor
     simplify();
	}
   });
  }
  Thread thread = new Thread()
   {
    public void run()
     { 	
      binom = new Binomial(strequation);
      binom.simplify();
      System.out.println(binom);
      strsimplified = binom.toString();
     }
   };
  public void simplify()
   {
    strequation = txtEquation.getText().toString();
    txtoutput1.setText(strequation);
    thread.start();
    try 
     {
      thread.join();
      txtEquation.setText("");
     } catch (InterruptedException e) { e.printStackTrace();}
        txtEquation.setText("");
        txtoutput2.setText(strsimplified);
	}
   public void graph()
    {   
     Intent intent = new Intent(this,Graph.class);
     intent.putExtra("numbers", addArray(PointsX(),PointsY()));
     startActivity(intent); 
    }
    public double[] PointsX()
    {
      //TODO fill an array of all x points that will be used to make Y points
      double[] array = null;
      return array;
    }
    public double[] PointsY()
    {
    	//TODO fill an array of all y points using the equation and x points
    	double[] array = null;
    	return array;
    }
    double[] addArray(double[] A,double[] B)
    {
    	double[] result = new double[A.length + B.length];
    	System.arraycopy(A, 0, result, 0, A.length);
    	System.arraycopy(B, 0, result, A.length, B.length);
    	return result;
    }
   @Override
   public boolean onCreateOptionsMenu(Menu menu)
    {
     // Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.factor, menu);
     return true;
    }
}