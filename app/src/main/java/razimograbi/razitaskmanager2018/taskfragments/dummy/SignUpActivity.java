package razimograbi.razitaskmanager2018.taskfragments.dummy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import razimograbi.razitaskmanager2018.R;

public class SignUpActivity extends AppCompatActivity {
    EditText firstName , LastName , Phone , Email , Password;
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName = (EditText)findViewById(R.id.editText);
        LastName = (EditText)findViewById(R.id.editText2);
        Phone = (EditText)findViewById(R.id.PhoneId);
        Email = (EditText)findViewById(R.id.Email_Id);
        Password = (EditText)findViewById(R.id.Password_Id);
        Save = (Button) findViewById(R.id.SaveBtn);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
