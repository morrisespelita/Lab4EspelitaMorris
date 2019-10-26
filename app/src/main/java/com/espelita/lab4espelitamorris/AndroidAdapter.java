package com.espelita.lab4espelitamorris;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AndroidAdapter extends ArrayAdapter<Companies> {

    private Context context;
    private int resource;

    public AndroidAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Companies> objects){
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent){
        int logo = getItem(i).getLogo();
        String cName = getItem(i).getCompName();
        String cCountry = getItem(i).getCompCountry();
        String cCEO = getItem(i).getCompCEO();
        String cIndustry = getItem(i).getCompIndustry();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);
        ImageView img = convertView.findViewById(R.id.ivLogo);
        TextView compName = convertView.findViewById(R.id.tvName);
        TextView compCountry = convertView.findViewById(R.id.tvCountry);
        TextView compCEO = convertView.findViewById(R.id.tvCEO);
        TextView compIndustry = convertView.findViewById(R.id.tvIndustry);

        img.setImageResource(logo);
        compName.setText(cName);
        compCountry.setText(cCountry);
        compIndustry.setText(cIndustry);
        compCEO.setText(cCEO);

        return convertView;
    }
}
