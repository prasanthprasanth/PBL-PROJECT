package com.example.tejash.bluetoothsoil;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;

public class admin extends Activity  {
    SharedPreferences sharePrefSettings;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,add1,add2,add3,add4 ;
    EditText soiln,crop3,crop1,crop2,red,green,blue,tv1,tv2,tv3,tv12,tv22,tv32,tv13,tv23,tv33,tv14,tv24,tv34,tv15,tv25,tv35,tv16,tv26,tv36,tv17,tv27,tv37,tv18,tv28,tv38,tv19,tv29,tv39,tv110,tv210,tv310;
    //Handler bluetoothIn;

    // String for MAC address
    //private static String address;
    Handler bluetoothIn;
    int flag=0;

    final int handlerState = 0;                        //used to identify handler message
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder recDataString = new StringBuilder();

    private ConnectedThread mConnectedThread;

    // SPP UUID service - this should work for most devices
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // String for MAC address
    private static String address;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.admin);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b10 = (Button) findViewById(R.id.button10);
        add1 = (Button) findViewById(R.id.add1);
        add2 = (Button) findViewById(R.id.add2);
        add3 = (Button) findViewById(R.id.add3);
        add4 = (Button) findViewById(R.id.add4);

        tv1 = (EditText) findViewById(R.id.textView);
        tv2 = (EditText) findViewById(R.id.textView2);
        tv3 = (EditText) findViewById(R.id.textView3);

        tv12 = (EditText) findViewById(R.id.textView02);
        tv22 = (EditText) findViewById(R.id.textView22);
        tv32 = (EditText) findViewById(R.id.textView32);
        tv13 = (EditText) findViewById(R.id.textView03);
        tv23 = (EditText) findViewById(R.id.textView23);
        tv33 = (EditText) findViewById(R.id.textView33);
        tv14 = (EditText) findViewById(R.id.textView04);
        tv24 = (EditText) findViewById(R.id.textView24);
        tv34 = (EditText) findViewById(R.id.textView34);
        tv15 = (EditText) findViewById(R.id.textView05);
        tv25 = (EditText) findViewById(R.id.textView25);
        tv35 = (EditText) findViewById(R.id.textView35);
        tv16 = (EditText) findViewById(R.id.textView06);
        tv26 = (EditText) findViewById(R.id.textView26);
        tv36 = (EditText) findViewById(R.id.textView36);
        tv17 = (EditText) findViewById(R.id.textView07);
        tv27 = (EditText) findViewById(R.id.textView27);
        tv37 = (EditText) findViewById(R.id.textView37);
        tv18 = (EditText) findViewById(R.id.textView08);
        tv28 = (EditText) findViewById(R.id.textView28);
        tv38 = (EditText) findViewById(R.id.textView38);
        tv19 = (EditText) findViewById(R.id.textView09);
        tv29 = (EditText) findViewById(R.id.textView29);
        tv39 = (EditText) findViewById(R.id.textView39);
        tv110 = (EditText) findViewById(R.id.textView010);
        tv210 = (EditText) findViewById(R.id.textView210);
        tv310 = (EditText) findViewById(R.id.textView310);
        crop1 = (EditText) findViewById(R.id.rede);
        crop2 = (EditText) findViewById(R.id.greene);
        crop3 = (EditText) findViewById(R.id.bluee);
        soiln = (EditText) findViewById(R.id.soil);





        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
        //add.setEnabled(false);
       // avg.setEnabled(false);


/*
        sharePrefSettings = getSharedPreferences("add4", 0);
        String rmin=sharePrefSettings.getString("redmin", "0");
        String rmax=sharePrefSettings.getString("redmax", "0");

        String gmin=sharePrefSettings.getString("greenmin", "0");
        String gmax=sharePrefSettings.getString("greenmax", "0");

        String bmin=sharePrefSettings.getString("bluemin", "0");
        String bmax=sharePrefSettings.getString("bluemax", "0");


        String sn=sharePrefSettings.getString("soilname", "0");
        String c1=sharePrefSettings.getString("crop1", "0");
        String c2=sharePrefSettings.getString("crop2", "0");
        String c3=sharePrefSettings.getString("crop3", "0");



        tv1.setText(rmin);
        tv2.setText(rmax);

        tv12.setText(gmin);
        tv22.setText(gmax);

        tv13.setText(bmin);
        tv23.setText(bmax);

        soiln.setText(sn);
        crop1.setText(c1);
        crop2.setText(c2);
        crop3.setText(c3);
*/

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag = 1;

                mConnectedThread.write("0");
                b2.setEnabled(true);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag = 2;

                mConnectedThread.write("0");
                b3.setEnabled(true);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=3;

                mConnectedThread.write("0");
                b4.setEnabled(true);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=4;

                mConnectedThread.write("0");
                b5.setEnabled(true);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=5;

                mConnectedThread.write("0");
                b6.setEnabled(true);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=6;

                mConnectedThread.write("0");
                b7.setEnabled(true);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=7;

                mConnectedThread.write("0");
                b8.setEnabled(true);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=8;

                mConnectedThread.write("0");
                b9.setEnabled(true);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=9;

                mConnectedThread.write("0");
                b10.setEnabled(true);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                flag=10;

                mConnectedThread.write("0");
                //avg.setEnabled(true);
            }
        });
        //sharePrefSettings = getSharedPreferences("add1", 0);
        add1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sharePrefSettings = getSharedPreferences("add1", 0);
                int min=0,max=0;
                Integer r[]= new Integer[10];
                Integer g[]= new Integer[10];
                Integer b[]= new Integer[10];
                int i=0;
               // for(int i=2;i<=10;i++)
                    r[i++]=Integer.parseInt(tv1.getText().toString());
                r[i++]=Integer.parseInt(tv12.getText().toString());
                r[i++]=Integer.parseInt(tv13.getText().toString());
                r[i++]=Integer.parseInt(tv14.getText().toString());
                r[i++]=Integer.parseInt(tv15.getText().toString());
                r[i++]=Integer.parseInt(tv16.getText().toString());
                r[i++]=Integer.parseInt(tv17.getText().toString());
                r[i++]=Integer.parseInt(tv18.getText().toString());
                r[i++]=Integer.parseInt(tv19.getText().toString());
                r[i++]=Integer.parseInt(tv110.getText().toString());
                
                i=0;
                g[i++]=Integer.parseInt(tv2.getText().toString());
                g[i++]=Integer.parseInt(tv22.getText().toString());
                g[i++]=Integer.parseInt(tv23.getText().toString());
                g[i++]=Integer.parseInt(tv24.getText().toString());
                g[i++]=Integer.parseInt(tv25.getText().toString());
                g[i++]=Integer.parseInt(tv26.getText().toString());
                g[i++]=Integer.parseInt(tv27.getText().toString());
                g[i++]=Integer.parseInt(tv28.getText().toString());
                g[i++]=Integer.parseInt(tv29.getText().toString());
                g[i++]=Integer.parseInt(tv210.getText().toString());

                i=0;
                b[i++]=Integer.parseInt(tv3.getText().toString());
                b[i++]=Integer.parseInt(tv32.getText().toString());
                b[i++]=Integer.parseInt(tv33.getText().toString());
                b[i++]=Integer.parseInt(tv34.getText().toString());
                b[i++]=Integer.parseInt(tv35.getText().toString());
                b[i++]=Integer.parseInt(tv36.getText().toString());
                b[i++]=Integer.parseInt(tv37.getText().toString());
                b[i++]=Integer.parseInt(tv38.getText().toString());
                b[i++]=Integer.parseInt(tv39.getText().toString());
                b[i++]=Integer.parseInt(tv310.getText().toString());

                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);

                sharePrefSettings = getSharedPreferences("add1", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add2", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add3", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add4", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();



                //crop1.setText("" + r[0] + " " + g[0] + " " + b[0]);
                //crop2.setText("" + r[9] + " " + g[9] + " " + b[9]);


                sharePrefSettings.edit().putString("redmin", (--r[0]).toString()).commit();
                sharePrefSettings.edit().putString("redmax", (++r[9]).toString()).commit();

                sharePrefSettings.edit().putString("greenmin", (--g[0]).toString()).commit();
                sharePrefSettings.edit().putString("greenmax", (++g[9]).toString()).commit();

                sharePrefSettings.edit().putString("bluemin", (--b[0]).toString()).commit();
                sharePrefSettings.edit().putString("bluemax", (++b[9]).toString()).commit();

                sharePrefSettings.edit().putString("soilname", soiln.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop1", crop1.getText().toString()).commit();

                sharePrefSettings.edit().putString("crop2", crop2.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop3", crop3.getText().toString()).commit();

                Toast.makeText(getApplicationContext(),"The values are added SUCCESSFULLY..!",Toast.LENGTH_SHORT).show();
            }
        });





        add2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int min=0,max=0;
                sharePrefSettings = getSharedPreferences("add2", 0);
                Integer r[]= new Integer[10];
                Integer g[]= new Integer[10];
                Integer b[]= new Integer[10];
                int i=0;
                // for(int i=2;i<=10;i++)
                r[i++]=Integer.parseInt(tv1.getText().toString());
                r[i++]=Integer.parseInt(tv12.getText().toString());
                r[i++]=Integer.parseInt(tv13.getText().toString());
                r[i++]=Integer.parseInt(tv14.getText().toString());
                r[i++]=Integer.parseInt(tv15.getText().toString());
                r[i++]=Integer.parseInt(tv16.getText().toString());
                r[i++]=Integer.parseInt(tv17.getText().toString());
                r[i++]=Integer.parseInt(tv18.getText().toString());
                r[i++]=Integer.parseInt(tv19.getText().toString());
                r[i++]=Integer.parseInt(tv110.getText().toString());

                i=0;
                g[i++]=Integer.parseInt(tv2.getText().toString());
                g[i++]=Integer.parseInt(tv22.getText().toString());
                g[i++]=Integer.parseInt(tv23.getText().toString());
                g[i++]=Integer.parseInt(tv24.getText().toString());
                g[i++]=Integer.parseInt(tv25.getText().toString());
                g[i++]=Integer.parseInt(tv26.getText().toString());
                g[i++]=Integer.parseInt(tv27.getText().toString());
                g[i++]=Integer.parseInt(tv28.getText().toString());
                g[i++]=Integer.parseInt(tv29.getText().toString());
                g[i++]=Integer.parseInt(tv210.getText().toString());

                i=0;
                b[i++]=Integer.parseInt(tv3.getText().toString());
                b[i++]=Integer.parseInt(tv32.getText().toString());
                b[i++]=Integer.parseInt(tv33.getText().toString());
                b[i++]=Integer.parseInt(tv34.getText().toString());
                b[i++]=Integer.parseInt(tv35.getText().toString());
                b[i++]=Integer.parseInt(tv36.getText().toString());
                b[i++]=Integer.parseInt(tv37.getText().toString());
                b[i++]=Integer.parseInt(tv38.getText().toString());
                b[i++]=Integer.parseInt(tv39.getText().toString());
                b[i++]=Integer.parseInt(tv310.getText().toString());

                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);

                sharePrefSettings = getSharedPreferences("add1", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add2", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add3", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add4", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();



                //crop1.setText("" + r[0] + " " + g[0] + " " + b[0]);
                //crop2.setText("" + r[9] + " " + g[9] + " " + b[9]);


                sharePrefSettings.edit().putString("redmin", (--r[0]).toString()).commit();
                sharePrefSettings.edit().putString("redmax", (++r[9]).toString()).commit();

                sharePrefSettings.edit().putString("greenmin", (--g[0]).toString()).commit();
                sharePrefSettings.edit().putString("greenmax", (++g[9]).toString()).commit();

                sharePrefSettings.edit().putString("bluemin", (--b[0]).toString()).commit();
                sharePrefSettings.edit().putString("bluemax", (++b[9]).toString()).commit();

                sharePrefSettings.edit().putString("soilname", soiln.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop1", crop1.getText().toString()).commit();

                sharePrefSettings.edit().putString("crop2", crop2.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop3", crop3.getText().toString()).commit();

                Toast.makeText(getApplicationContext(), "The values are added SUCCESSFULLY..!", Toast.LENGTH_SHORT).show();
            }
        });



        add3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sharePrefSettings = getSharedPreferences("add3", 0);
                int min=0,max=0;
                Integer r[]= new Integer[10];
                Integer g[]= new Integer[10];
                Integer b[]= new Integer[10];
                int i=0;
                // for(int i=2;i<=10;i++)
                r[i++]=Integer.parseInt(tv1.getText().toString());
                r[i++]=Integer.parseInt(tv12.getText().toString());
                r[i++]=Integer.parseInt(tv13.getText().toString());
                r[i++]=Integer.parseInt(tv14.getText().toString());
                r[i++]=Integer.parseInt(tv15.getText().toString());
                r[i++]=Integer.parseInt(tv16.getText().toString());
                r[i++]=Integer.parseInt(tv17.getText().toString());
                r[i++]=Integer.parseInt(tv18.getText().toString());
                r[i++]=Integer.parseInt(tv19.getText().toString());
                r[i++]=Integer.parseInt(tv110.getText().toString());

                i=0;
                g[i++]=Integer.parseInt(tv2.getText().toString());
                g[i++]=Integer.parseInt(tv22.getText().toString());
                g[i++]=Integer.parseInt(tv23.getText().toString());
                g[i++]=Integer.parseInt(tv24.getText().toString());
                g[i++]=Integer.parseInt(tv25.getText().toString());
                g[i++]=Integer.parseInt(tv26.getText().toString());
                g[i++]=Integer.parseInt(tv27.getText().toString());
                g[i++]=Integer.parseInt(tv28.getText().toString());
                g[i++]=Integer.parseInt(tv29.getText().toString());
                g[i++]=Integer.parseInt(tv210.getText().toString());

                i=0;
                b[i++]=Integer.parseInt(tv3.getText().toString());
                b[i++]=Integer.parseInt(tv32.getText().toString());
                b[i++]=Integer.parseInt(tv33.getText().toString());
                b[i++]=Integer.parseInt(tv34.getText().toString());
                b[i++]=Integer.parseInt(tv35.getText().toString());
                b[i++]=Integer.parseInt(tv36.getText().toString());
                b[i++]=Integer.parseInt(tv37.getText().toString());
                b[i++]=Integer.parseInt(tv38.getText().toString());
                b[i++]=Integer.parseInt(tv39.getText().toString());
                b[i++]=Integer.parseInt(tv310.getText().toString());

                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);

                //crop1.setText("" + r[0] + " " + g[0] + " " + b[0]);
                //crop2.setText("" + r[9] + " " + g[9] + " " + b[9]);
                sharePrefSettings = getSharedPreferences("add1", 0);
if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add2", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add3", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add4", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();


                sharePrefSettings.edit().putString("redmin", (--r[0]).toString()).commit();
                sharePrefSettings.edit().putString("redmax", (++r[9]).toString()).commit();

                sharePrefSettings.edit().putString("greenmin", (--g[0]).toString()).commit();
                sharePrefSettings.edit().putString("greenmax", (++g[9]).toString()).commit();

                sharePrefSettings.edit().putString("bluemin", (--b[0]).toString()).commit();
                sharePrefSettings.edit().putString("bluemax", (++b[9]).toString()).commit();

                sharePrefSettings.edit().putString("soilname", soiln.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop1", crop1.getText().toString()).commit();

                sharePrefSettings.edit().putString("crop2", crop2.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop3", crop3.getText().toString()).commit();

                Toast.makeText(getApplicationContext(), "The values are added SUCCESSFULLY..!", Toast.LENGTH_SHORT).show();
            }
        });


        sharePrefSettings = getSharedPreferences("add4", 0);
        add4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int min=0,max=0;
                Integer r[]= new Integer[10];
                Integer g[]= new Integer[10];
                Integer b[]= new Integer[10];
                int i=0;
                // for(int i=2;i<=10;i++)
                r[i++]=Integer.parseInt(tv1.getText().toString());
                r[i++]=Integer.parseInt(tv12.getText().toString());
                r[i++]=Integer.parseInt(tv13.getText().toString());
                r[i++]=Integer.parseInt(tv14.getText().toString());
                r[i++]=Integer.parseInt(tv15.getText().toString());
                r[i++]=Integer.parseInt(tv16.getText().toString());
                r[i++]=Integer.parseInt(tv17.getText().toString());
                r[i++]=Integer.parseInt(tv18.getText().toString());
                r[i++]=Integer.parseInt(tv19.getText().toString());
                r[i++]=Integer.parseInt(tv110.getText().toString());

                i=0;
                g[i++]=Integer.parseInt(tv2.getText().toString());
                g[i++]=Integer.parseInt(tv22.getText().toString());
                g[i++]=Integer.parseInt(tv23.getText().toString());
                g[i++]=Integer.parseInt(tv24.getText().toString());
                g[i++]=Integer.parseInt(tv25.getText().toString());
                g[i++]=Integer.parseInt(tv26.getText().toString());
                g[i++]=Integer.parseInt(tv27.getText().toString());
                g[i++]=Integer.parseInt(tv28.getText().toString());
                g[i++]=Integer.parseInt(tv29.getText().toString());
                g[i++]=Integer.parseInt(tv210.getText().toString());

                i=0;
                b[i++]=Integer.parseInt(tv3.getText().toString());
                b[i++]=Integer.parseInt(tv32.getText().toString());
                b[i++]=Integer.parseInt(tv33.getText().toString());
                b[i++]=Integer.parseInt(tv34.getText().toString());
                b[i++]=Integer.parseInt(tv35.getText().toString());
                b[i++]=Integer.parseInt(tv36.getText().toString());
                b[i++]=Integer.parseInt(tv37.getText().toString());
                b[i++]=Integer.parseInt(tv38.getText().toString());
                b[i++]=Integer.parseInt(tv39.getText().toString());
                b[i++]=Integer.parseInt(tv310.getText().toString());

                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);

                //crop1.setText("" + r[0] + " " + g[0] + " " + b[0]);
                sharePrefSettings = getSharedPreferences("add1", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add2", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add3", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();

                sharePrefSettings = getSharedPreferences("add4", 0);
                if(soiln.getText().toString().equalsIgnoreCase(sharePrefSettings.getString("soilname", "0")))
                    Toast.makeText(getApplication(),"duplicate data..",Toast.LENGTH_LONG).show();


                //crop2.setText("" + r[9] + " " + g[9] + " " + b[9]);


                sharePrefSettings.edit().putString("redmin", (--r[0]).toString()).commit();
                sharePrefSettings.edit().putString("redmax", (++r[9]).toString()).commit();

                sharePrefSettings.edit().putString("greenmin", (--g[0]).toString()).commit();
                sharePrefSettings.edit().putString("greenmax", (++g[9]).toString()).commit();

                sharePrefSettings.edit().putString("bluemin", (--b[0]).toString()).commit();
                sharePrefSettings.edit().putString("bluemax", (++b[9]).toString()).commit();

                sharePrefSettings.edit().putString("soilname", soiln.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop1", crop1.getText().toString()).commit();

                sharePrefSettings.edit().putString("crop2", crop2.getText().toString()).commit();
                sharePrefSettings.edit().putString("crop3", crop3.getText().toString()).commit();

                Toast.makeText(getApplicationContext(), "The values are added SUCCESSFULLY..!", Toast.LENGTH_SHORT).show();
            }
        });
        //Link the buttons and textViews to respective views

        bluetoothIn = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.what == handlerState) {                                     //if message is what we want
                    String readMessage = (String) msg.obj;                                                                // msg.arg1 = bytes from connect thread
                    recDataString.append(readMessage);                                      //keep appending to string until ~
                    int endOfLineIndex = recDataString.indexOf("~");                    // determine the end-of-line
                    if (endOfLineIndex > 0) {                                           // make sure there data before ~
                        String dataInPrint = recDataString.substring(0, endOfLineIndex);    // extract string
                      //  txtString.setText("Data Received = " + dataInPrint);
                        int dataLength = dataInPrint.length();                          //get length of data received
                       // txtStringLength.setText("String Length = " + String.valueOf(dataLength));

                        if(flag==1) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv1.setText(sensor0);    //update the textviews with sensor values
                                tv2.setText(sensor1);
                                tv3.setText(sensor2);

                                // sensorView3.setText("");
                            }
                        }
                        if(flag==2) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv12.setText(sensor0);    //update the textviews with sensor values
                                tv22.setText(sensor1);
                                tv32.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        } if(flag==3) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv13.setText(sensor0);    //update the textviews with sensor values
                                tv23.setText(sensor1);
                                tv33.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }
                        if(flag==4) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv14.setText(sensor0);    //update the textviews with sensor values
                                tv24.setText(sensor1);
                                tv34.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }
                        if(flag==5) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv15.setText(sensor0);    //update the textviews with sensor values
                                tv25.setText(sensor1);
                                tv35.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }
                        if(flag==6) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv16.setText(sensor0);    //update the textviews with sensor values
                                tv26.setText(sensor1);
                                tv36.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }
                        if(flag==7) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv17.setText(sensor0);    //update the textviews with sensor values
                                tv27.setText(sensor1);
                                tv37.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }
                        if(flag==8) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv18.setText(sensor0);    //update the textviews with sensor values
                                tv28.setText(sensor1);
                                tv38.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }
                        if(flag==9) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv19.setText(sensor0);    //update the textviews with sensor values
                                tv29.setText(sensor1);
                                tv39.setText(sensor2);
                                // sensorView3.setText("");
                            }
                        }

                        if(flag==10) {
                            if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                            {
                                String sensor0 = recDataString.substring(1, recDataString.indexOf("r"));             //get sensor value from string between indices 1-5
                                String sensor1 = recDataString.substring(recDataString.indexOf("r")+1, recDataString.indexOf("g"));             //same again...
                                String sensor2 = recDataString.substring(recDataString.indexOf("g")+1, recDataString.indexOf("b"));
                                //String sensor3 = recDataString.substring(16, 20);

                                tv110.setText(sensor0);    //update the textviews with sensor values
                                tv210.setText(sensor1);
                                tv310.setText(sensor2);
                               // red.setEditableFactory(true);
                            /*    red.setEnabled(true);
                                green.setEnabled(true);
                                blue.setEnabled(true);*/
                                // sensorView3.setText("");
                            }
                        }
                        flag=0;
                        recDataString.delete(0, recDataString.length());                    //clear all string data
                        // strIncom =" ";
                        dataInPrint = " ";


                    }
                }
            }
        };

        btAdapter = BluetoothAdapter.getDefaultAdapter();       // get Bluetooth adapter
        checkBTState();
    }



    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {

        return  device.createRfcommSocketToServiceRecord(BTMODULEUUID);
        //creates secure outgoing connecetion with BT device using UUID
    }
    @Override
    public void onResume() {
        super.onResume();

        //Get MAC address from DeviceListActivity via intent
        Intent intent = getIntent();

        //Get the MAC address from the DeviceListActivty via EXTRA
        address = intent.getStringExtra(DeviceListActivity.EXTRA_DEVICE_ADDRESS);

        //create device and set the MAC address
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "Socket creation failed", Toast.LENGTH_LONG).show();
        }
        // Establish the Bluetooth socket connection.
        try
        {
            btSocket.connect();
        } catch (IOException e) {
            try
            {
                btSocket.close();
            } catch (IOException e2)
            {
                //insert code to deal with this
            }
        }
        mConnectedThread = new ConnectedThread(btSocket);
        mConnectedThread.start();

        //I send a character when resuming.beginning transmission to check device is connected
        //If it is not an exception will be thrown in the write method and finish() will be called
        mConnectedThread.write("x");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        try
        {
            //Don't leave Bluetooth sockets open when leaving activity
            btSocket.close();
        } catch (IOException e2) {
            //insert code to deal with this
        }
    }
    //Checks that the Android device Bluetooth is available and prompts to be turned on if off
    private void checkBTState() {

        if(btAdapter==null) {
            Toast.makeText(getBaseContext(), "Device does not support bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (btAdapter.isEnabled()) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    //create new class for connect thread
    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        //creation of the connect thread
        public ConnectedThread(BluetoothSocket socket) {
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            try {
                //Create I/O streams for connection
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[256];
            int bytes;

            // Keep looping to listen for received messages
            while (true) {
                try {
                    bytes = mmInStream.read(buffer);            //read bytes from input buffer
                    String readMessage = new String(buffer, 0, bytes);
                    // Send the obtained bytes to the UI Activity via handler
                    bluetoothIn.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
                } catch (IOException e) {
                    break;
                }
            }
        }
        //write method
        public void write(String input) {
            byte[] msgBuffer = input.getBytes();           //converts entered String into bytes
            try {
                mmOutStream.write(msgBuffer);                //write bytes over BT connection via outstream
            } catch (IOException e) {
                //if you cannot write, close the application
                Toast.makeText(getBaseContext(), "Connection Failure", Toast.LENGTH_LONG).show();
                finish();

            }
        }
    }


}
