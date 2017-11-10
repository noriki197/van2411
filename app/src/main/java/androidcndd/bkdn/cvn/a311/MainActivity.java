package androidcndd.bkdn.cvn.a311;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtntimetable;
    ImageButton imgbtncamera,imgbtndocument, imgbtnsetting;
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
        imgbtncamera = (ImageButton) findViewById(R.id.imgbtncamera);
        imgbtncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maintocamera = new Intent(MainActivity.this,Camera_chip.class);
                startActivity(maintocamera);
            }
        });
        imgbtndocument = (ImageButton) findViewById(R.id.imgbtnlist);
        imgbtndocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maintolist = new Intent(MainActivity.this,document_chip.class);
                startActivity(maintolist);
            }
        });
        imgbtnsetting = (ImageButton) findViewById(R.id.imgbtnsetting);
        imgbtnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maintosetting = new Intent(MainActivity.this,Month_Calendar.class);
                startActivity(maintosetting);
            }
        });
    }
}
