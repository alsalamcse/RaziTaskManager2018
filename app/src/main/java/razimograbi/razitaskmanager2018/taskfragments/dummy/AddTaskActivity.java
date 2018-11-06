package razimograbi.razitaskmanager2018.taskfragments.dummy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import razimograbi.razitaskmanager2018.MainTabsActivity;
import razimograbi.razitaskmanager2018.R;
import razimograbi.razitaskmanager2018.taskfragments.MyTasksFragment;

public class AddTaskActivity extends AppCompatActivity {
    private EditText Task_Title , Task_Text ;
    private SeekBar skbImportant , skbNecessary;
    private Button btnsave , date_btn;
    private TextView Task_date;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Task_Title =  findViewById(R.id.title_id);
        Task_Text =  findViewById(R.id.text_id);
        Task_date = findViewById(R.id.Date_View);
        skbImportant =  findViewById(R.id.important_id);
        skbNecessary =  findViewById(R.id.nec_id);
        btnsave =  findViewById(R.id.save_btn_id);
        date_btn =  findViewById(R.id.date_pick_id);

    }
    private void dataHandler() {
        boolean isOk = true; // if all the fields are felled properly
        String title = Task_Title.getText().toString();
        String text = Task_Text.getText().toString();
        String date = Task_date.getText().toString();
        if (title.length() < 1){
            Task_Title.setError("Missing Title");
            isOk = false;
        }
        if (text.length() < 1){
            Task_Text.setError("Missing Text");
            isOk = false;
        }
        if (date.length() < 1){
            Task_date.setError("choose a date");
            isOk = false;
        }

        if ((isOk)){
            Toast.makeText(getApplicationContext() , "It worked " , Toast.LENGTH_SHORT);

            MyTasksFragment myTasksFragment = new MyTasksFragment(title , text , date , skbImportant.getProgress() ,skbNecessary.getProgress() );
            Intent i = new Intent(getApplicationContext() , MainTabsActivity.class);
            startActivity(i);
        }
    }
    public void onClick(View v) {

        if (v == date_btn) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            Task_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, year, month, day);
            datePickerDialog.show();
        }
        if (v == btnsave){
            dataHandler();
        }

    }


}
