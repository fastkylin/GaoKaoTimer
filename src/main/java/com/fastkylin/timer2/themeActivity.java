package com.fastkylin.timer2;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class themeActivity extends AppCompatActivity {

    private TextView back;
   private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        back=findViewById(R.id.back);
       btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn10=findViewById(R.id.btn10);
        btn11=findViewById(R.id.btn11);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn0","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn1","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn2","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn3","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn4","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn5","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn6","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn7","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn8","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn9","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn10","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata("btn11","theme");
                Intent intent=new Intent( themeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public String loaddata(String filename) {
        String content = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File bookdir = this.getExternalFilesDir("data");
            String filepath = bookdir.getAbsolutePath() + "/" + filename;
            try {
                FileInputStream fis = new FileInputStream(filepath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                fis.close();
                baos.close();
                content = baos.toString();
                return content;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            finish();
        }
        return null;
    }



    public void savedata(String content, String filename) {
        if (fileIsExists(R.string.data + filename)) {
            String SD = Environment.getExternalStorageDirectory().getPath();
            File file = new File(SD + R.string.data + filename);
            if (file.delete()) {
                Toast toast=Toast.makeText(themeActivity.this, R.string.delectok,Toast.LENGTH_SHORT);
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
