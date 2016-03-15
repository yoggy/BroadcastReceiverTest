package net.sabamiso.android.test.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class TestBroadcastReceiver extends BroadcastReceiver {
    Observer observer;

    TestBroadcastReceiver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (observer != null) {
            observer.onReceiveBroadcast();
        }
    }

    interface Observer {
        void onReceiveBroadcast();
    }
}
