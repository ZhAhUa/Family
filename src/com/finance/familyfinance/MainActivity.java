package com.finance.familyfinance;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent Intent= new Intent(this, IndexActivity.class); //你要转向的Activity   
        Timer timer = new Timer(); 
        TimerTask task = new TimerTask() {  
            @Override  
            public void run() {   
            startActivity(Intent); //执行  
             } 
         };
         timer.schedule(task, 1000 * 3); //3秒后
        // finish();
    }
}
