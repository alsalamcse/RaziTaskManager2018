package razimograbi.razitaskmanager2018.taskfragments.dummy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import razimograbi.razitaskmanager2018.R;

public class LoginActivity extends AppCompatActivity {
    EditText emailText , passwordText;
    Button loginButton , signUpBtn;
    FirebaseAuth auth; //to establish sign in sign up
    FirebaseUser user; //user

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser(); // return if user has signed in  if not return null

        emailText = (EditText) findViewById(R.id.input_email);
        passwordText = (EditText)findViewById(R.id.input_password);
        loginButton = (Button)findViewById(R.id.btn_login);
        signUpBtn = (Button) findViewById(R.id.signUp);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

    }


    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    // Intent intent=new Intent(LogInActivity.this,MainFCMActivity.class);
                    //   startActivity(intent);
                    //  finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }



}
