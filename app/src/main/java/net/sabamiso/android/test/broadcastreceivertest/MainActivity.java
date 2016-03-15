package net.sabamiso.android.test.broadcastreceivertest;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import junit.framework.Test;

public class MainActivity extends Activity implements TestBroadcastReceiver.Observer{

    TestBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register broadcast receiver
        TestBroadcastReceiver receiver = new TestBroadcastReceiver(this);
        IntentFilter filter = new IntentFilter("test.TEST_BROADCAST_RECEIVER");
        registerReceiver(receiver, filter);

        // send boradcast
        // $ adb shell am broadcast -a test.TEST_BROADCAST_RECEIVER
    }

    @Override
    public void onReceiveBroadcast() {
        Toast.makeText(this, "onReceiveBroadcast()", Toast.LENGTH_LONG).show();
    }
}
