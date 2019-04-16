package com.fastkylin.timer2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class aboutActivity extends AppCompatActivity {
    private TextView back;
    private Button github;
    private Button chatonqq;
    private Button score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        back=findViewById(R.id.back);
        github=findViewById(R.id.github);
        score=findViewById(R.id.score);
        chatonqq=findViewById(R.id.chatonqq);


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/timer2/android-app-timer2");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        chatonqq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             try{ String url="mqqwpa://im/chat?chat_type=wpa&uin=576950022";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
            catch (Exception e) {
                Toast.makeText(aboutActivity.this, R.string.about_noqq, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse("market://details?id="+getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(aboutActivity.this, R.string.about_nomarket, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(aboutActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
