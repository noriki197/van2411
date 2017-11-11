package androidcndd.bkdn.cvn.a311;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by PC on 05-Nov-17.
 */

public class AlarmListAdapter extends BaseAdapter{
    public static String TAG = AlarmListAdapter.class.getSimpleName();
    private Context mContext;
    private List<AlarmModel> mAlarms;

    //constructor
    public AlarmListAdapter(Context mContext, List<AlarmModel> mAlarms) {
        this.mContext = mContext;
        this.mAlarms = mAlarms;
    }

    public void setAlarms(List<AlarmModel> mAlarms)
    {
        this.mAlarms = mAlarms;
    }

    @Override
    public int getCount() {
        if (mAlarms != null)
        {
            return mAlarms.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        if (mAlarms != null) {
            return mAlarms.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        if (mAlarms != null)
        {
            return mAlarms.get(i).getId();
        }
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewholder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.alarm_list_item, null, false);

            viewholder = new ViewHolder();
            viewholder.txtTime = (TextView) view.findViewById(R.id.alarm_item_time);
            viewholder.txtName = (TextView) view.findViewById(R.id.alarm_item_name);
            viewholder.btnToggle = (ToggleButton) view.findViewById(R.id.alarm_item_toogle);
            viewholder.txtDayofweek = (TextView) view.findViewById(R.id.alarm_item_dayofweek);

            view.setTag(viewholder);

        }
        else
        {
            viewholder = (ViewHolder) view.getTag();
        }
        final AlarmModel model = (AlarmModel) getItem(i);
        viewholder.txtTime.setText(String.format("%02d : %02d", model.getTimeHour(), model.getTimeMinute()));
        viewholder.txtName.setText(model.getName());

        String string = "";
        String dayofweek[] = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        boolean bl;
        for (int k = 0 ;k<7;k++) {
            bl = model.getRepeatingDay(k);
            if(bl==true)
            {
                string=string+" "+dayofweek[k];
            }
        }
        viewholder.txtDayofweek.setText(string);

        viewholder.btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                ((NoticeActivity) mContext).setAlarmEnabled(Long.valueOf(model.id), isChecked);
            }
        });
        viewholder.btnToggle.setChecked(model.isEnabled);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NoticeActivity)mContext).startAlarmDetailsActivity(Long.valueOf(model.id));
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ((NoticeActivity)mContext).deleteAlarm(model.id);
                return true;
            }
        });

        return view;
    }
    private void updateTextColor(TextView view, boolean isOn){
        if (isOn) {
            view.setTextColor(Color.GREEN);
        } else {
            view.setTextColor(Color.BLACK);
        }
    }

    private class ViewHolder {
        TextView txtTime;
        TextView txtName;
        ToggleButton btnToggle;
        TextView txtDayofweek;
    }
}
