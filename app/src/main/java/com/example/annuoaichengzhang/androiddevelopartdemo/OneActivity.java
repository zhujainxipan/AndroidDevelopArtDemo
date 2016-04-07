package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // 线程池demo
        Runnable command = new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
            }
        };

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        fixedThreadPool.execute(command);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(command);

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
        scheduledThreadPool.schedule(command, 2000, TimeUnit.MILLISECONDS);
        scheduledThreadPool.scheduleAtFixedRate(command, 10, 1000, TimeUnit.MILLISECONDS);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(command);
    }

}
