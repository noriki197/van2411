package androidcndd.bkdn.cvn.a311;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtntimetable;
    ImageButton imgbtncamera,imgbtndocument, imgbtncalendar_dv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//
        imgbtntimetable = (ImageButton) findViewById(R.id.imgbtntimetable);
        imgbtntimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maintotimetable = new Intent(MainActivity.this,TimeTable.class);
                startActivity(maintotimetable);
            }
        });
        imgbtncalendar_dv = (ImageButton) findViewById(R.id.imgbtn_calendar_dv);
        imgbtncalendar_dv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maintosetting = new Intent(MainActivity.this,Month_Calendar.class);
                startActivity(maintosetting);
            }
        });
    }
}
