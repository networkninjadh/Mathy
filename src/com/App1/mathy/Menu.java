package com.App1.mathy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Menu extends ListActivity
{
	String classes[] = {"Factor","Foil"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
	}
	@Override
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		super.onListItemClick(l, v, position, id);
		String str = classes[position];
		try{
		@SuppressWarnings("rawtypes")
		Class ourClass = Class.forName("com.project1.mathy."+str);
		Intent ourIntent = new Intent(Menu.this,ourClass);
		startActivity(ourIntent);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}