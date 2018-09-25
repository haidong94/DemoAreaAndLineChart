package com.example.dong.demoareaandlinechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(3f, 0));
        dataset1.add(new Entry(4f, 1));
        dataset1.add(new Entry(5f, 2));
        dataset1.add(new Entry(6f, 3));
        dataset1.add(new Entry(7f, 4));
        dataset1.add(new Entry(8f, 5));
        dataset1.add(new Entry(9f, 6));

//float[] dataIn = {
//      3f, 4f, 5f, 6f, 7f, 8f, 9f
//};

//values for datainput Dataset2 at your axisone positions
        ArrayList<Entry> dataset2 = new ArrayList<Entry>();
        dataset2.add(new Entry(3f, 3));
        dataset2.add(new Entry(4f, 4));
        dataset2.add(new Entry(5f, 5));
        dataset2.add(new Entry(6f, 6));
        dataset2.add(new Entry(7f, 7));
        dataset2.add(new Entry(8f, 8));
        dataset2.add(new Entry(9f, 9));


        ArrayList<Entry> dataset3 = new ArrayList<Entry>();
        dataset3.add(new Entry(3f, 5));
        dataset3.add(new Entry(4f, 6));
        dataset3.add(new Entry(5f, 7));
        dataset3.add(new Entry(6f, 8));
        dataset3.add(new Entry(7f, 9));
        dataset3.add(new Entry(8f, 10));
        dataset3.add(new Entry(9f, 11));


        ArrayList<Entry> dataset4 = new ArrayList<Entry>();
        dataset4.add(new Entry(3f, 1));
        dataset4.add(new Entry(4f, 3));
        dataset4.add(new Entry(5f, 5));
        dataset4.add(new Entry(6f, 7));
        dataset4.add(new Entry(7f, 9));
        dataset4.add(new Entry(8f, 8));
        dataset4.add(new Entry(9f, 7));


        chart = findViewById(R.id.chart);

        LineData chartData = new LineData();

        LineDataSet set1 = new LineDataSet(dataset1, "aa");
        set1.setDrawValues(false);
        set1.setDrawCircles(false);
        set1.setFillColor(Color.BLUE);
        set1.setDrawFilled(true);
        chartData.addDataSet(set1);


        LineDataSet set2 = new LineDataSet(dataset2, "bb");
        set2.setDrawValues(false);
        set2.setDrawCircles(false);
        set2.setFillColor(Color.RED);
        set2.setDrawFilled(true);
        chartData.addDataSet(set2);

        LineDataSet set3 = new LineDataSet(dataset3, "bb");
        set3.setDrawValues(false);
        set3.setDrawCircles(false);
//        set3.setFillColor(Color.BLUE);
//        set3.setDrawFilled(true);
        chartData.addDataSet(set3);


        LineDataSet set4 = new LineDataSet(dataset4, "bb");
        chartData.addDataSet(set4);



        set1.setFillFormatter(new MyFillFormatter(set2));
        chart.setRenderer(new MyLineLegendRenderer(chart, chart.getAnimator(), chart.getViewPortHandler()));

        set2.setFillFormatter(new MyFillFormatter(set3));
        chart.setRenderer(new MyLineLegendRenderer(chart, chart.getAnimator(), chart.getViewPortHandler()));
        chart.setData(chartData);

        chart.invalidate();
        chart.setScaleEnabled(false);
    }
}
