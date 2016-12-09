package com.example.daseul1.myapplication5;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;

    RadioButton r1, r2, r3;
    LinearLayout linear1, linear2, linear3;
    ImageView img;
    Button b1, b2;
    TextView t1, t2, t3;
    RadioGroup os;
    Switch s1;
    double num1, num2, num3, result, price1, price2, price3;
    double result3,rd, rd1, rd2,rd3,rd4,rd5;
    int exit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        r1 = (RadioButton) findViewById(R.id.radioButton3);
        r2 = (RadioButton) findViewById(R.id.radioButton4);
        r3 = (RadioButton) findViewById(R.id.radioButton);
        img = (ImageView) findViewById(R.id.imageView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        t1 = (TextView) findViewById(R.id.textView4);
        t2 = (TextView) findViewById(R.id.textView5);
        t3 = (TextView) findViewById(R.id.textView6);
        os = (RadioGroup) findViewById(R.id.RadioGroup);
        s1= (Switch) findViewById(R.id.switch1);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linear1.setVisibility(View.VISIBLE);
                } else {
                    linear1.setVisibility(View.INVISIBLE);
                }
            }

        });


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Integer.parseInt(e1.getText().toString());
                num2 = Integer.parseInt(e2.getText().toString());
                num3 = Integer.parseInt(e3.getText().toString());
                result = num1 + num2 + num3;
                price1 = num1 * 15000;
                price2 = num2 * 12000;
                price3 = num3 * 8000;
                result3 = price1 + price2 + price3;


                rd = result3 * 0.5;
                rd1 = result3 * 0.1;
                rd2 = result3 * 0.2;
                rd3 = result3 - rd;
                rd4 = result3 - rd1;
                rd5 = result3 - rd2;

                if (os.getCheckedRadioButtonId() == R.id.radioButton3) {
                    t2.setText(":discount price " + rd);
                } else if (os.getCheckedRadioButtonId() == R.id.radioButton4) {
                    t2.setText("discount price: " + rd1);
                }
                else if (os.getCheckedRadioButtonId() == R.id.radioButton) {
                    t2.setText("discount price: " + rd2);
                }

                if (os.getCheckedRadioButtonId() == R.id.radioButton3) {
                    t3.setText("extended price: " + rd3);
                } else if (os.getCheckedRadioButtonId() == R.id.radioButton4) {
                    t3.setText("extended price: " + rd4);
                }
                else if (os.getCheckedRadioButtonId() == R.id.radioButton) {
                    t3.setText("extended price: " + rd5);
                }


                t1.setText("" + result);

                if (os.getCheckedRadioButtonId() == R.id.radioButton3) {
                    img.setImageResource(R.drawable.c);
                } else if (os.getCheckedRadioButtonId() == R.id.radioButton4) {
                    img.setImageResource(R.drawable.x);
                }
                else if (os.getCheckedRadioButtonId() == R.id.radioButton) {
                    img.setImageResource(R.drawable.z);
                }




            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
