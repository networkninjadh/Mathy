package com.App1.mathy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

//import org.math.plot.*;

public class Graph extends Activity 
{
  double[] x = {1,2,3,4,5,6,7,8,9,10};
  double[] y = {0,1,2,3,4,5,6,7,8,9};
  @Override
  public void onCreate(Bundle savedInstanceState) 
   {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.graph);
   }
  @Override
  public boolean onCreateOptionsMenu(Menu menu) 
   {
	  getMenuInflater().inflate(R.menu.graph, menu);
	  return true;
   }
}

