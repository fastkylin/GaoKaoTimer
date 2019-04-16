package com.fastkylin.timer2;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class backActivity extends AppCompatActivity {
private TextView back;
private TextView tv0;
private TextView tv1;
private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        back=findViewById(R.id.back);
     tv0=findViewById(R.id.tv0);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv0","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv1","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv2","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv3","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv4","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv5","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv6","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("tv7","back");
                Intent intent=new Intent( backActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void savedata(String content, String filename) {
        if (fileIsExists("/Android/data/com.fastkylin.timer2/files/data/" + filename)) {
            String SD = Environment.getExternalStorageDirectory().getPath();
            File file = new File(SD + "/Android/data/com.fastkylin.timer2/files/data/" + filename);
            if (file.delete()) {
                Toast toast=Toast.makeText(backActivity.this,"设置成功",Toast.LENGTH_SHORT);
                toast.show();
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File bookdir = this.getExternalFilesDir("data");
                    String filepath = bookdir.getAbsolutePath() + "/" + filename;

                    try {
                        FileOutputStream fos = new FileOutputStream(filepath);
                        fos.write(content.getBytes("utf-8"));
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                finish();
            }
        } else {
            File bookdir = this.getExternalFilesDir("data");
            String filepath = bookdir.getAbsolutePath() + "/" + filename;

            try {
                FileOutputStream fos = new FileOutputStream(filepath);
                fos.write(content.getBytes("utf-8"));
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean fileIsExists(String sdpath) {
        String SD = Environment.getExternalStorageDirectory().getPath();
        try {
            File f = new File(SD + sdpath);
            if (f.exists()) {
                return true;
            }
        } catch (Exception e) {
            recreate();
        }
        return false;
    }



}
