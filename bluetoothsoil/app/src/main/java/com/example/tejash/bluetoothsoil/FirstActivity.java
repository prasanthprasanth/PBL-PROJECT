package com.example.tejash.bluetoothsoil;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends Activity {
    SharedPreferences sharePrefSettings;
    Button next, btnOff,admin;
    TextView txtArduino, txtString, txtStringLength, sensorView0, sensorView1, sensorView2, sensorView3;
    Handler bluetoothIn;
public static String flag="flag";
    // String for MAC address
    private static String address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        //Link the buttons and textViews to respective views
        next = (Button) findViewById(R.id.buttonOn);
        admin = (Button) findViewById(R.id.button11);





         sharePrefSettings = getSharedPreferences("flag", 0);
        //sharePrefSettings.edit().putString("configed", "TRUE").commit();

        next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String flag="flag";
                Intent intent = new Intent(getApplication(), DeviceListActivity.class);
                sharePrefSettings.edit().putString("flag", "0").commit();
                startActivity(intent);
                finish();
            }
        });
        admin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String flag="flag";
                Intent intent = new Intent(getApplication(), DeviceListActivity.class);
                sharePrefSettings.edit().putString("flag", "1").commit();
                startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause()
    {
        super.onPause();

    }




}
