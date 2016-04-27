package com.example.annuoaichengzhang.androiddevelopartdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.annuoaichengzhang.aidlserver.aidl.IPerson;

/**
 * Created by niehongtao on 16/4/27.
 */
public class AIDLActivity extends Activity{

    private Button bindBtn;
    private Button greetBtn;
    private Button unbindBtn;

    private IPerson person;
    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("ServiceConnection", "onServiceConnected() called");
            person = IPerson.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //This is called when the connection with the service has been unexpectedly disconnected,
            //that is, its process crashed. Because it is running in our same process, we should never see this happen.
            Log.i("ServiceConnection", "onServiceDisconnected() called");
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bindBtn = (Button) findViewById(R.id.bindBtn);
        bindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.AIDLService");
                bindService(intent, conn, Context.BIND_AUTO_CREATE);

                bindBtn.setEnabled(false);
                greetBtn.setEnabled(true);
                unbindBtn.setEnabled(true);
            }
        });

        greetBtn = (Button) findViewById(R.id.greetBtn);
        greetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String retVal = person.greet("scott");
                    Toast.makeText(AIDLActivity.this, retVal, Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    Toast.makeText(AIDLActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        unbindBtn = (Button) findViewById(R.id.unbindBtn);
        unbindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);

                bindBtn.setEnabled(true);
                greetBtn.setEnabled(false);
                unbindBtn.setEnabled(false);
            }
        });
    }
}