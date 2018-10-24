package razimograbi.razitaskmanager2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import razimograbi.razitaskmanager2018.taskfragments.dummy.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        MyThread myThread = new MyThread();
        myThread.start();
        super.onResume();
    }

    public class MyThread extends Thread{
        @Override
        public void run() {
            try {
                sleep(1500);
                Intent i = new Intent(getApplicationContext() , LoginActivity.class);
                startActivity(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
