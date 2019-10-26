package com.espelita.lab4espelitamorris;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] companyNames, companyCountries,companyCEOS, companyIndustries, companyDescriptions;
    int[] logos ={R.drawable.icbc, R.drawable.jpmorgan, R.drawable.chinaconstruction, R.drawable.agricultural, R.drawable.bankofamerica, R.drawable.apple,
    R.drawable.pingan, R.drawable.bankofchina, R.drawable.royaldutch, R.drawable.wellsfargo, R.drawable.exxonmobil, R.drawable.att, R.drawable.samsung, R.drawable.citigroup};

    ArrayList<Companies> companies = new ArrayList<>();

    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        companyNames = getResources().getStringArray(R.array.companyName);
        companyCountries = getResources().getStringArray(R.array.companyCountry);
        companyCEOS = getResources().getStringArray(R.array.companyCEO);
        companyIndustries = getResources().getStringArray(R.array.companyIndustry);
        companyDescriptions = getResources().getStringArray(R.array.companyDescription);

        for (int i=0; i < companyNames.length; i++){
            companies.add(i, new Companies(logos[i], companyNames[i], companyCountries[i],companyCEOS[i],companyIndustries[i],companyDescriptions[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.comp,companies);

        listCompanies = findViewById(R.id.lvComp);
        listCompanies.setAdapter(adapter);
        listCompanies.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logos[i]);
        dialog.setTitle(companyNames[i]);
        dialog.setMessage(companyDescriptions[i]);
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                Toast.makeText(MainActivity.this, companyNames[i] + "is located in " + companyCountries[i] + ".", Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}
