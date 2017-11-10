package androidcndd.bkdn.cvn.a311;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TimeTable extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        TabHost tabHost = getTabHost();


        final TabHost.TabSpec Monday = tabHost.newTabSpec("monday");
        Monday.setIndicator("",getResources().getDrawable(R.drawable.imgmonday));
        Intent mondayintent = new Intent(this,Timetable_Monday.class);
        Monday.setContent(mondayintent);
        tabHost.addTab(Monday);

        final TabHost.TabSpec Tuesday = tabHost.newTabSpec("tuesday");
        Tuesday.setIndicator("",getResources().getDrawable(R.drawable.imgtuesday));
        Intent tuesdayintent = new Intent(this,Timetable_tuesday.class);
        Tuesday.setContent(tuesdayintent);
        tabHost.addTab(Tuesday);

        final TabHost.TabSpec Wednesday = tabHost.newTabSpec("wednesday");
        Wednesday.setIndicator("",getResources().getDrawable(R.drawable.imgwednesday));
        Intent wednesdayintent = new Intent(this,Timetable_Wednesday.class);
        Wednesday.setContent(wednesdayintent);
        tabHost.addTab(Wednesday);

        final TabHost.TabSpec Thursday = tabHost.newTabSpec("thursday");
        Thursday.setIndicator("",getResources().getDrawable(R.drawable.imgthursday));
        Intent thursdayintent = new Intent(this,Timetable_Thursday.class);
        Thursday.setContent(thursdayintent);
        tabHost.addTab(Thursday);

        final TabHost.TabSpec Friday = tabHost.newTabSpec("friday");
        Friday.setIndicator("",getResources().getDrawable(R.drawable.imgfriday));
        Intent fridayintent = new Intent(this,Timetable_Friday.class);
        Friday.setContent(fridayintent);
        tabHost.addTab(Friday);

        final TabHost.TabSpec Saturday = tabHost.newTabSpec("saturday");
        Saturday.setIndicator("",getResources().getDrawable(R.drawable.imgsaturday));
        Intent saturdayintent = new Intent(this,Timetable_Saturday.class);
        Saturday.setContent(saturdayintent);
        tabHost.addTab(Saturday);

        final TabHost.TabSpec Sunday = tabHost.newTabSpec("sunday");
        Sunday.setIndicator("",getResources().getDrawable(R.drawable.imgsunday256));
        Intent sundayintent = new Intent(this,Timetable_Sunday.class);
        Sunday.setContent(sundayintent);
        tabHost.addTab(Sunday);
    }
}
