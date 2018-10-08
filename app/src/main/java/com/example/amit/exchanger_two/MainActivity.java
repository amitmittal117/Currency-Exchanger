package com.example.amit.exchanger_two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button click;
    public static TextView data_viewed;
    public static TextView data_viewed_parsed;
    public static TextView fetched_url;
    public static TextView etunit;
    public static EditText etfrom;
    public static EditText etto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button)findViewById(R.id.button);
        data_viewed = (TextView) findViewById(R.id.fetcheddata);
        data_viewed_parsed = (TextView) findViewById(R.id.fetcheddataparsed);
        fetched_url = (TextView) findViewById(R.id.fetched_url);
        etfrom = (EditText)findViewById(R.id.etfrom);
        etto = (EditText)findViewById(R.id.etto);
        etunit = (EditText)findViewById(R.id.etunit);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData process = new fetchData();
                process.execute();

            }

        });




    }
}
