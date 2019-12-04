package com.example.daltdd.class_arraylist;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daltdd.R;
import com.example.daltdd.class_Firebaes.DSThongTinXe;

import java.util.ArrayList;

public class arraylistview extends BaseAdapter {

    private TextView gio, ngay, tenxe, soghe,gia, benxe;
    private ImageButton imback, imnext;
    private ImageView imbac;
    public arraylistview(Context context, ArrayList<DSThongTinXe> dsThongTinXes) {
        this.context = context;
        this.dsThongTinXes = dsThongTinXes;
    }

    Context context;
    ArrayList<DSThongTinXe> dsThongTinXes;
    @Override
    public int getCount() {
        return dsThongTinXes.size();
    }

    @Override
    public Object getItem(int position) {
        return dsThongTinXes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = Inflater.inflate(R.layout.listview_thongtinxe, null);
        DSThongTinXe dsThongTinXe = dsThongTinXes.get(position);
        gio = convertView.findViewById(R.id.gio);
        gia = convertView.findViewById(R.id.gia);
        ngay = convertView.findViewById(R.id.ngay1);
        soghe = convertView.findViewById(R.id.soghe);
        tenxe = convertView.findViewById(R.id.tenxe);
        benxe = convertView.findViewById(R.id.benxe);

        gio.setText(dsThongTinXe.getGio());
        gia.setText(dsThongTinXe.getGia()+ "vnd");
        ngay.setText(dsThongTinXe.getNgay());
        soghe.setText("Gường nằm " + dsThongTinXe.getSoGhe()+" chỗ");
        tenxe.setText(dsThongTinXe.getTeXe());
        benxe.setText(dsThongTinXe.getBenXe());

        return convertView;
    }
}
