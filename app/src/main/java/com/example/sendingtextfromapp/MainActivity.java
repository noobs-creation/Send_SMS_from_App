package com.example.sendingtextfromapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] listOfPermissions = {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS};
        ActivityCompat.requestPermissions(MainActivity.this, listOfPermissions, PackageManager.PERMISSION_GRANTED);
        editTextMessage = findViewById(R.id.editTextMessage);
        editTextNumber = findViewById(R.id.editTextNumber);

    }

    public void sendSMS(View view){
        String message = editTextMessage.getText().toString();
        String number = editTextNumber.getText().toString();

        SmsManager mysmsManager = SmsManager.getDefault();
        mysmsManager.sendTextMessage(number, null, message, null, null);
    }
}
