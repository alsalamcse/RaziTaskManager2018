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
                dataHandler();

            }
        });
    }

    /**
     * get email and password from the field and try to create new user
     */

    private void dataHandler() {
        boolean isOk = true; // if all the fields are felled properly
        String name = firstName.getText().toString();
        String last = LastName.getText().toString();
        String password = Password.getText().toString();
        String phone  = Phone.getText().toString();
        String email = Email.getText().toString();
        if (email.length() < 4 && email.indexOf('@')<0 && email.indexOf('.')<0){
            Email.setError("Wrong Email");
            isOk = false;
        }
        if (password.length() < 7){
            Password.setError("Have to be at least 7 chars");
            isOk = false;
        }
        if (phone.length() < 10){
            Phone.setError("Wrong number");
            isOk = false;
        }
        if ((isOk)){
            createAccount(email , password);
        }
    }

    /**
     * create firebase using email and password
     * @param email user email
     * @param passw user password
     */
    private void createAccount(String email, String passw) {
        // waits for a respond from the server
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() { //request
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) { //response
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
