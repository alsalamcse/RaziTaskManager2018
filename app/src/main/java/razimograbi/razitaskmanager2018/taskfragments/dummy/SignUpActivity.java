package razimograbi.razitaskmanager2018.taskfragments.dummy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import razimograbi.razitaskmanager2018.R;

public class SignUpActivity extends AppCompatActivity {
    EditText firstName , LastName , Phone , Email , Password;
    Button Save;

     FirebaseAuth auth; //to establish sign in sign up
     FirebaseUser user; //user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser(); // return if user has signed in  if not return null

        firstName = (EditText)findViewById(R.id.editText);
        LastName = (EditText)findViewById(R.id.editText2);
        Phone = (EditText)findViewById(R.id.PhoneId);
        Email = (EditText)findViewById(R.id.Email_Id);
        Password = (EditText)findViewById(R.id.Password_Id);
        Save = (Button) findViewById(R.id.SaveBtn);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if email and password isnt empty
                if (Email.getText().toString().length() > 4 && Password.getText().toString().length() > 4){
                    //add the email and the password to the firebase
                    createAccount(Email.getText().toString() , Password.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext() , "Error the password or email is valid" , Toast.LENGTH_SHORT);
                }
            }
        });
    }
    private void createAccount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }




}
