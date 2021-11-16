package com.example.proyecton2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Clases.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoview = findViewById(R.id.vw);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoview.setVideoURI(uri);

        videoview.start();
    }

    public void Task(View view)
    {
        try
        {
            for (int i = 0; i <= 10; i++)
            {
                Thread.sleep(2200);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void Insu(View view)
    {
        Intent i = new Intent(getBaseContext(), Insumos_act.class);
        startActivity(i);
    }
}