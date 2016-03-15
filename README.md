BroadcastReceiverTest
====

TestBroadcastReceiver.java
----

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

MainActivity.java
----

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

Copyright and license
----
Copyright (c) 2016 yoggy

Released under the [MIT license](LICENSE.txt)