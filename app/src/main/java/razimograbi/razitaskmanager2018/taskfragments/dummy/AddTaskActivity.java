package razimograbi.razitaskmanager2018.taskfragments.dummy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import razimograbi.razitaskmanager2018.R;

public class AddTaskActivity extends AppCompatActivity {
    private EditText Task_Title , Task_Text , Task_DueDate;
    private SeekBar skbImportant , skbNecessary;
    private Button btnsave , date_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Task_Title =  findViewById(R.id.title_id);
        Task_Text =  findViewById(R.id.text_id);
        Task_DueDate =  findViewById(R.id.duo_id);
        skbImportant =  findViewById(R.id.important_id);
        skbNecessary =  findViewById(R.id.nec_id);
        btnsave =  findViewById(R.id.save_btn_id);
        date_btn =  findViewById(R.id.date_pick_id);

    }

}
