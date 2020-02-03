package com.example.donk.coolapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateMax(View view){
        String maxVal = "Error. Invalid Input";
        EditText weight = (EditText) findViewById(R.id.editText);
        EditText reps = (EditText) findViewById(R.id.editText2);
        TextView oneRepMax = (TextView) findViewById(R.id.output);

        String weightInput = weight.getText().toString();
        String repsInput = reps.getText().toString();

        try{
            int weightInt = Integer.valueOf(weightInput);
            int repsInt = Integer.valueOf(repsInput);

            int maxEpley = (int) Math.round(weightInt * (1 + repsInt / 30.0));
            int maxBrzycki = (int) Math.round(weightInt * 36.0/(37-repsInt));
            int maxMcGlothin = (int) Math.round(weightInt * 100/(101.3-2.67123 * repsInt));
            int maxLombardi = (int) Math.round(weightInt * Math.pow(repsInt,0.10));
            //int maxMayhew = (int) Math.round(weightInt * 100/(52.2+41.9*Math.exp(-0.055*repsInt)));
            int maxOConner = (int) Math.round(weightInt * (1+repsInt/40.0));
            int maxWathan = (int) Math.round(weightInt * 100/(48.8 + 53.8 * Math.exp(-0.075 * repsInt)));
            int maxMax = Math.max(Math.max(Math.max(Math.max(Math.max(maxBrzycki, maxEpley), maxLombardi), maxMcGlothin), maxOConner), maxWathan);
            int minMax = Math.min(Math.min(Math.min(Math.min(Math.min(maxBrzycki, maxEpley), maxLombardi), maxMcGlothin), maxOConner), maxWathan);

            maxVal = String.valueOf(minMax) + "-" + String.valueOf(maxMax);
        }

        catch(NumberFormatException e){
            return;
        }

        oneRepMax.setText(maxVal);
    }
}
