package cn.edu.gdmec.s07131032.contextmenudemo;

import android.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	final static int CONTEXT_MENU_1 = Menu.FIRST;
	final static int CONTEXT_MENU_2 = Menu.FIRST;
	final static int CONTEXT_MENU_3 = Menu.FIRST;
	TextView myTv;
	EditText myED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTv = (TextView) findViewById(R.id.textView1);
        myED = (EditText) findViewById(R.id.editText1);
        registerForContextMenu(myTv);
        
        
    }


    @Override
	public boolean onContextItemSelected(MenuItem item) {
		myTv.setText("你点击了快捷菜单的"+item.getTitle()+"菜单项");
		switch(item.getItemId()){
		case CONTEXT_MENU_1:
			myED.setText("点击的是第一个快捷菜单");
			break;
		}
		return super.onContextItemSelected(item);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("快捷菜单");
		menu.add(0,CONTEXT_MENU_1,0,"菜单子项");
		menu.add(0,CONTEXT_MENU_2,1,"菜单子项");
		menu.add(0,CONTEXT_MENU_3,2,"菜单子项");
	}
    
}
