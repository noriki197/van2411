package androidcndd.bkdn.cvn.a311;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PC on 15-Sep-17.
 */

public class CongViecAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<CongViec> CongViecList;


    public CongViecAdapter(Context context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        CongViecList = congViecList;
    }

    @Override
    public int getCount() {
        return CongViecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView tvCongViec = (TextView) convertView.findViewById(R.id.tvCongViec);
        tvCongViec.setText(CongViecList.get(position).getCongviec());
        TextView tvThoiGian  = (TextView) convertView.findViewById(R.id.tvThoiGian);
        tvThoiGian.setText(CongViecList.get(position).getThoigian());
        TextView tvDiaDiem = (TextView) convertView.findViewById(R.id.tvDiaDiem);
        tvDiaDiem.setText(CongViecList.get(position).getDiadiem());

        return convertView;
    }


}
