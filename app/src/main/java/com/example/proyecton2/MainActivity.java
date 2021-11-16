package com.example.proyecton2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import Clases.Administrador;
import Clases.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msje;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador();
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.nomuser);
        pass = findViewById(R.id.contuser);
        msje = findViewById(R.id.msj);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.iniciosesion);
        msje.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);
        barra.getIndeterminateDrawable().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Task().execute();

            }
        });
    }


    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++)
                {
                    Thread.sleep(2200);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();
            String userObj = adm.getUser().trim();
            String userPass = adm.getPass().trim();

            switch (usuario)
            {
                case "Cristian":
                    if (usuario.equals(userObj) && contrasena.equals(userPass))
                    {
                        //inicio de sesión
                        msje.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if (!usuario.equals("") && contrasena.equals(""))
                    {
                        msje.setVisibility(View.VISIBLE);
                        msje.setText("Los campos estan vacios, favor de ingresar nuevamente");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(userPass))
                    {
                        msje.setVisibility(View.VISIBLE);
                        msje.setText("Los campos estan incorrectos, ingrese nuevamente");
                    }
                    break;
            }
        }
    }


    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }

    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

    public void Info()
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}