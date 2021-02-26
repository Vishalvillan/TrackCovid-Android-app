package com.example.trackcovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class Detail extends AppCompatActivity {

    private int position;
    TextView tvCases,tvRecovered,tvActive,tvTotalDeaths,tvTodaysDeath,tvAffectedCountry,tvCritical,tvTodaysCases;
    PieChart pieChart2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent=getIntent();
        position=intent.getIntExtra("position",0);
        tvCases=findViewById(R.id.tvCases);
        tvRecovered=findViewById(R.id.tvRecovered);
        tvActive=findViewById(R.id.tvActive);
        tvTotalDeaths=findViewById(R.id.tvtotalDeaths);
        tvTodaysDeath=findViewById(R.id.tvTodaysDeath);
        tvAffectedCountry=findViewById(R.id.tvaffectedCountry);
        tvCritical=findViewById(R.id.tvCritical);
        tvTodaysCases=findViewById(R.id.tvTodaysCases);
        pieChart2=findViewById(R.id.piechart2);


        tvAffectedCountry.setText(AffectedCountries.countryModelList.get(position).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(position).getCases());
        tvRecovered.setText(AffectedCountries.countryModelList.get(position).getRecovered());
        tvActive.setText(AffectedCountries.countryModelList.get(position).getActive());
        tvTotalDeaths.setText(AffectedCountries.countryModelList.get(position).getDeaths());
        tvTodaysDeath.setText(AffectedCountries.countryModelList.get(position).getTodayDeaths());
        tvCritical.setText(AffectedCountries.countryModelList.get(position).getCritical());
        tvTodaysCases.setText(AffectedCountries.countryModelList.get(position).getTodayCases());
        String act=AffectedCountries.countryModelList.get(position).getActive();
        String det=AffectedCountries.countryModelList.get(position).getDeaths();
        String rec=AffectedCountries.countryModelList.get(position).getRecovered();
        pieChart2.addPieSlice(new PieModel("Active",Integer.parseInt(act), Color.parseColor("#29B6F6")));
        pieChart2.addPieSlice(new PieModel("Total Deaths",Integer.parseInt(det), Color.parseColor("#EF5350")));
        pieChart2.addPieSlice(new PieModel("Recovered",Integer.parseInt(rec), Color.parseColor("#66BB6A")));
        pieChart2.setVisibility(View.VISIBLE);
        pieChart2.startAnimation();

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}