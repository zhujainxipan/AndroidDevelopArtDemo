package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class TwoActivity extends AppCompatActivity {

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
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
        System.out.println("TwoActivity_main" + Thread.currentThread().getName());

        // 这里写下handlerthread的demo
        mHandlerThread = new HandlerThread("mylooper");
        mHandlerThread.start();
        mHandler = new MyHander(mHandlerThread.getLooper());

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.post(mRunnable);
            }
        });
    }


    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Log.d("TwoActivity_1", Thread.currentThread().getName()+"");
                Log.d("TwoActivity_2", "Test HandlerThread...");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRunnable);
    }


    public class MyHander extends Handler {

        public MyHander(Looper looper) {
            super(looper);
        }

        // 这个方法不会执行，因为这里用的是runnable
        @Override
        public void handleMessage(Message msg) {
            //打印线程的名称
            System.out.println("TwoActivity_3" + Thread.currentThread().getName());
            super.handleMessage(msg);
        }
    }
}
