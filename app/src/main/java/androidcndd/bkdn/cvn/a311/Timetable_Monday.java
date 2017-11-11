package androidcndd.bkdn.cvn.a311;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;

public class Timetable_Monday extends AppCompatActivity {
    //khai bao cac bien
    //
    int vitri=0,id=0,idnew=0;
    String cvMonDay,tgMonDay,ddMonDay;
    //dialog them cong viec
    Dialog dialog_ThemCV;
    EditText edtThemCV_Dialog_ThemCV,edtThemTG_Dialog_ThemCV,edtThemDD_Dialog_ThemCV;
    Button btnAdd_Dialog_ThemCV,btnHuy_Dialog_ThemCV;

    //cac thanh phan trong giao dien
    ImageButton btnAddMonday_timetable;
    ListView lvMonday_timetable;
    ArrayList<CongViec> arrayListMonday_timetable;
    CongViecAdapter adapterMonday_timetable;

    //dialog option listview
    Dialog dialog_optionlv;
    ImageButton imgbtnedit_Dialog_optionlv,imgbtndelete_Dialog_optionlv,imgbtnremind_Dialog_optionlv,imgbtndocument_Dialog_optionlv;

    //dialog capnhat cong viec
    Dialog dialog_capnhatcongviec;
    EditText edtCapNhatCV_Dialog_CNCV,edtCapNhatTG_Dialog_CNCV,edtCapNhatDD_Dialog_CNCV;
    Button btnCapNhat_Dialog_CNCV,btnHuy_Dialog_CNCV;

    //dialog thme nhac nho
    Dialog dialog_themnhacnho;
    TimePicker timePicker;
    Button btnOK_dialogthemnhacnho,btnHuy_dialogthemnhacnho;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;


    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable__monday);

        Create();
        Event();
    }

    private void Event() {
        //hien dialog them cong viec-->them cong viec
        btnAddMonday_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_ThemCV.show();
            }
        });
        //them cong viec vao tung dong cua list view
        btnAdd_Dialog_ThemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvMonDay = edtThemCV_Dialog_ThemCV.getText().toString();
                tgMonDay = edtThemTG_Dialog_ThemCV.getText().toString();
                ddMonDay = edtThemDD_Dialog_ThemCV.getText().toString();
                arrayListMonday_timetable.add(new CongViec(id,cvMonDay,tgMonDay,ddMonDay));
                adapterMonday_timetable.notifyDataSetChanged();
                lvMonday_timetable.setAdapter(adapterMonday_timetable);

                db.querydata("INSERT INTO ListMonday VALUES('"+vitri+"','"+cvMonDay+"','"+tgMonDay+"','"+ddMonDay+"')");
                dialog_ThemCV.dismiss();
                edtThemCV_Dialog_ThemCV.setText("");
                edtThemTG_Dialog_ThemCV.setText("");
                edtThemDD_Dialog_ThemCV.setText("");
                vitri++;
            }
        });
        //tat dialog them cong viec
        btnHuy_Dialog_ThemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_ThemCV.dismiss();
            }
        });


        //nhan giu tren listview --> tuy chon
        lvMonday_timetable.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long k) {
                id=position;
                dialog_optionlv.show();
                return false;
            }
        });
        //xoa 1 dong khoi listview
        imgbtndelete_Dialog_optionlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListMonday_timetable.remove(id);
                adapterMonday_timetable.notifyDataSetChanged();
                lvMonday_timetable.setAdapter(adapterMonday_timetable);
                db.querydata("DELETE FROM ListMonday WHERE id = '"+id+"'");
                dialog_optionlv.dismiss();
            }
        });
        //chinh sua noi dung 1 dong
        imgbtnedit_Dialog_optionlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_capnhatcongviec.show();
                dialog_optionlv.dismiss();
                //cap nhat
                btnCapNhat_Dialog_CNCV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cvMonDay = edtCapNhatCV_Dialog_CNCV.getText().toString();
                        tgMonDay = edtCapNhatTG_Dialog_CNCV.getText().toString();
                        ddMonDay = edtCapNhatDD_Dialog_CNCV.getText().toString();

                        arrayListMonday_timetable.set(id,new CongViec(id,cvMonDay,tgMonDay,ddMonDay));
                        adapterMonday_timetable.notifyDataSetChanged();
                        lvMonday_timetable.setAdapter(adapterMonday_timetable);

                        db.querydata("UPDATE ListMonday SET congviec='"+cvMonDay+"',thoigian = '"+tgMonDay+"',diadiem = '"+ddMonDay+"'WHERE id = '"+id+"'");
                        edtCapNhatCV_Dialog_CNCV.setText("");
                        edtCapNhatTG_Dialog_CNCV.setText("");
                        edtCapNhatDD_Dialog_CNCV.setText("");
                        dialog_capnhatcongviec.dismiss();
                    }
                });
                btnHuy_Dialog_CNCV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog_capnhatcongviec.dismiss();
                    }
                });
            }
        });

        imgbtnremind_Dialog_optionlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Timetable_Monday.this,NoticeActivity.class);
                startActivity(intent);
                dialog_optionlv.dismiss();
            }
        });

    }

    private void Create() {
        //dialog them cong viec
        dialog_ThemCV = new Dialog(Timetable_Monday.this);
        dialog_ThemCV.setContentView(R.layout.dialog_themcongviec);
        dialog_ThemCV.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //edt
        edtThemCV_Dialog_ThemCV = (EditText) dialog_ThemCV.findViewById(R.id.edtthemcongviec_Dialog_THEMCONGVIEC);
        edtThemTG_Dialog_ThemCV = (EditText) dialog_ThemCV.findViewById(R.id.edtthemthoigian_Dialog_THEMCONGVIEC);
        edtThemDD_Dialog_ThemCV = (EditText) dialog_ThemCV.findViewById(R.id.edtthemdiadiem_Dialog_THEMCONGVIEC);
        //btn
        btnAdd_Dialog_ThemCV = (Button) dialog_ThemCV.findViewById(R.id.btnthem_Dialog_THEMCONGVIEC);
        btnHuy_Dialog_ThemCV = (Button) dialog_ThemCV.findViewById(R.id.btnhuy_Dialog_THEMCONGVIEC);

        //dialog option listview
        dialog_optionlv = new Dialog(Timetable_Monday.this);
        dialog_optionlv.setContentView(R.layout.dialog_optionlistview);
        dialog_optionlv.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //imgbtn
        imgbtndelete_Dialog_optionlv = (ImageButton) dialog_optionlv.findViewById(R.id.imgbtndelete_dialogoptionlv);
        imgbtnedit_Dialog_optionlv = (ImageButton) dialog_optionlv.findViewById(R.id.imgbtnedit_dialogoptionlv);
        imgbtnremind_Dialog_optionlv = (ImageButton) dialog_optionlv.findViewById(R.id.imgbtnremind_dialogoptionlv);

        //dialog capnhat cong viec
        dialog_capnhatcongviec = new Dialog(Timetable_Monday.this);
        dialog_capnhatcongviec.setContentView(R.layout.dialog_capnhatcongviec);
        dialog_capnhatcongviec.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //edt
        edtCapNhatCV_Dialog_CNCV = (EditText) dialog_capnhatcongviec.findViewById(R.id.edtcapnhatcongviec_Dialog_CNCONGVIEC);
        edtCapNhatTG_Dialog_CNCV = (EditText) dialog_capnhatcongviec.findViewById(R.id.edtcapnhatthoigian_Dialog_CNCONGVIEC);
        edtCapNhatDD_Dialog_CNCV = (EditText) dialog_capnhatcongviec.findViewById(R.id.edtcapnhatdiadiem_Dialog_CNCONGVIEC);
        //btn
        btnCapNhat_Dialog_CNCV = (Button) dialog_capnhatcongviec.findViewById(R.id.btncapnhat_Dialog_CNCONGVIEC);
        btnHuy_Dialog_CNCV = (Button) dialog_capnhatcongviec.findViewById(R.id.btnhuy_Dialog_CNCONGVIEC);

        //giao dien
        arrayListMonday_timetable = new ArrayList<>();
        adapterMonday_timetable = new CongViecAdapter(this,R.layout.dong_listview,arrayListMonday_timetable);
        lvMonday_timetable = (ListView) findViewById(R.id.lvMonday_timetable);
        btnAddMonday_timetable = (ImageButton) findViewById(R.id.btnAddMonday_timetable);

        //dialog them nhac nho
        dialog_themnhacnho = new Dialog(Timetable_Monday.this);
        dialog_themnhacnho.setContentView(R.layout.dialog_themnhacnho);
        dialog_themnhacnho.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePicker = (TimePicker) dialog_themnhacnho.findViewById(R.id.tp_dialogthemnhacnho);
        btnOK_dialogthemnhacnho = (Button) dialog_themnhacnho.findViewById(R.id.btnOK_dialogthemnhacnho);
        btnHuy_dialogthemnhacnho = (Button) dialog_themnhacnho.findViewById(R.id.btnHUY_dialogthemnhacnho);

        db = new MyDBHelper(Timetable_Monday.this,"quanlycongviec",null,1);
        db.querydata("CREATE TABLE IF NOT EXISTS ListMonday(id INTEGER PRIMARY KEY,congviec VARCHAR,thoigian VARCHAR,diadiem VARCHAR)");

        Cursor cursor = db.getdata("SELECT * FROM ListMonday");
        arrayListMonday_timetable.clear();

        while(cursor.moveToNext())
        {

            cvMonDay = cursor.getString(1);
            tgMonDay = cursor.getString(2);
            ddMonDay = cursor.getString(3);
            id = cursor.getInt(0);
            if(!(cvMonDay.equals("")&&tgMonDay.equals("")&&ddMonDay.equals("")))
            {
                arrayListMonday_timetable.add(new CongViec(idnew, cvMonDay, tgMonDay, ddMonDay));
                adapterMonday_timetable.notifyDataSetChanged();
                lvMonday_timetable.setAdapter(adapterMonday_timetable);
                idnew++;
            }
        }
        db.querydata("DELETE FROM ListMonday");
        cursor.moveToFirst();
        while(vitri!=idnew)
        {
            cvMonDay=arrayListMonday_timetable.get(vitri).getCongviec();
            tgMonDay=arrayListMonday_timetable.get(vitri).getThoigian();
            ddMonDay=arrayListMonday_timetable.get(vitri).getDiadiem();
            id=arrayListMonday_timetable.get(vitri).getId();
            db.querydata("INSERT INTO ListMonday VALUES('"+id+"','"+cvMonDay+"','"+tgMonDay+"','"+ddMonDay+"')");
            vitri=id;
            vitri++;

        }

    }
}
