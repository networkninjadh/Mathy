package com.App1.mathy;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	 MediaPlayer splash;
	 @Override
	public void onCreate(Bundle savedInstanceState)
	{
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.splash);
		 splash = MediaPlayer.create(Splash.this, R.raw.opening);
		 splash.start();
		 Thread timer = new Thread()
		 {
			public void run()
			{
				try
				{
					sleep(4000);
				}
				catch(InterruptedException e)
				{
				    e.printStackTrace();	
				}
				finally
				{
					Intent intent = new Intent("com.project1.mathy.MENU");
					startActivity(intent);
				}
			}
		 };
		 timer.start();
	}
@Override
public void onPause()
  {
	super.onPause();
	splash.release();
	finish();
  }
}