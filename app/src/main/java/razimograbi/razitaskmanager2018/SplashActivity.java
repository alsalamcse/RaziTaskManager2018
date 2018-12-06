package razimograbi.razitaskmanager2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import razimograbi.razitaskmanager2018.taskfragments.dummy.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    FirebaseUser user; //user
    FirebaseAuth auth; //to establish sign in sign up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser(); // return if user has signed in  if not return null

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

                sleep(2000);
                if (user != null) {
                    // User is signed in
                    Intent ii = new Intent(getApplicationContext() , MainTabsActivity.class);
                    startActivity(ii);
                } else {
                    // No user is signed in
                    Intent i = new Intent(getApplicationContext() , LoginActivity.class);
                    startActivity(i);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
