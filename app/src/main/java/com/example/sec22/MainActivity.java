package com.example.sec22;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @SuppressLint("MissingInflatedId")
    public void log(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.custom_dialog,null);
        builder.setView(dialogView);

        EditText UserN=dialogView.findViewById(R.id.name);
        EditText pass=dialogView.findViewById(R.id.password);

        builder.setPositiveButton("login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String userN=UserN.getText().toString();
                String password=pass.getText().toString();

                if (userN.equals("admin")&&password.equals("admin")){
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("user name",userN);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Error..refill info!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("cancel",null);
        builder.create().show();
    }
}