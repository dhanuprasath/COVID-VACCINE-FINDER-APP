package com.example.covidvaccine;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    ImageButton profile, settings, findvaccine, information;
    Context context;
    ImageView nointernet;
    TextView nointernettxt;
    FloatingActionButton sharebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile = findViewById(R.id.userprofile);
        settings = findViewById(R.id.Settings);
        findvaccine = findViewById(R.id.findvaccine);
        information = findViewById(R.id.Information);
        nointernet = findViewById(R.id.nointernet);
        nointernettxt = findViewById(R.id.nointernettxt);
        sharebtn = findViewById(R.id.btn);

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   Intent intent = new Intent(Intent.ACTION_SEND);
                   intent.setType("text/plain");
                   intent.putExtra(Intent.EXTRA_SUBJECT,"share demo");
                   String shareMessage="https://drive.google.com/file/d/1oOn-Hk-iGgHHmSCFbMPmM3jec-cr_xX3/view?usp=sharing"+ BuildConfig.APPLICATION_ID+"\n\n";
                   intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                   startActivity(Intent.createChooser(intent,"share by"));
               }catch (Exception e){
                   Toast.makeText(Home.this,"Error accurred",Toast.LENGTH_LONG).show();
               }
            }
        });


        // internet permission

        if (!isConnected()) {
            nointernet.setVisibility(View.VISIBLE);
            nointernettxt.setVisibility(View.VISIBLE);
            Toast.makeText(Home.this, "No Internet Access", Toast.LENGTH_LONG).show();
        } else {

            nointernet.setVisibility(View.GONE);
            nointernettxt.setVisibility(View.GONE);
        }


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Settings.class));
                finish();
            }
        });


        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Information.class));
                finish();
            }
        });

        findvaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),search.class));
                Toast.makeText(Home.this,"Please Search With Districts",Toast.LENGTH_LONG).show();
                finish();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), profile.class));
                finish();
            }
        });
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}