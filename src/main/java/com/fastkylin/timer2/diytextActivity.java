package com.fastkylin.timer2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import com.fastkylin.timer2.MainActivity;

public class diytextActivity extends AppCompatActivity {
    private TextView back;
    private SeekBar seekBartextsize;
    private SeekBar Alpha;
    private SeekBar Red;
    private SeekBar Green;
    private SeekBar Blue;
    private TextView simple;
 private int size;

 private int color_A=0;
private Button save;
    private int color_R=0;
    private int color_B=0;
    private int color_G=0;
    private String content="null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diytext);
        simple=findViewById(R.id.simple);
        seekBartextsize=findViewById(R.id.seekBar1);
        Alpha=findViewById(R.id.Alpha);
        Red=findViewById(R.id.Red);
        Green=findViewById(R.id.Green);
        Blue=findViewById(R.id.Blue);
        save=findViewById(R.id.save);
        setup();
simple.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final EditText inputServer = new EditText(diytextActivity.this);
        AlertDialog.Builder builder = new AlertDialog.Builder(diytextActivity.this);
        builder.setTitle(R.string.content).setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                .setNegativeButton(R.string.ok, null);
        builder.setPositiveButton(R.string.cancle, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                content=inputServer.getText().toString();
                simple.setText( inputServer.getText().toString());
            }
        });
        builder.show();
    }
});
        Alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
;
color_A=progress;
                simple.setTextColor(Color.argb(color_A, color_R, color_G, color_B)); ;
                ;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                color_R=progress;
                simple.setTextColor(Color.argb(color_A, color_R, color_G, color_B)); ;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                color_G=progress;
                simple.setTextColor(Color.argb(color_A, color_R, color_G, color_B)); ;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                color_B=progress;
                simple.setTextColor(Color.argb(color_A, color_R, color_G, color_B));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBartextsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                size=progress;
                simple.setTextSize(size);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(diytextActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savedata(String.valueOf(size),"size");
                savedata(String.valueOf(color_A),"color_A");
                savedata(String.valueOf(color_R),"color_R");
                savedata(String.valueOf(color_G),"color_G");
                savedata(String.valueOf(color_B),"color_B");
                savedata(content,"content");
                Toast toast=Toast.makeText(diytextActivity.this, R.string.saveok,Toast.LENGTH_SHORT);
                toast.show();
                Intent intent =new Intent(diytextActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
    private void setup(){
     if(  fileIsExists("/Android/data/com.fastkylin.timer2/files/data/size")){
         int str=Integer.parseInt(loaddata("size"));
         size =str;
          simple.setTextSize(str);
          seekBartextsize.setProgress(str);
        }
        if(fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_A")&&fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_R")&&fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_G")&&fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_B")){
          color_A=Integer.parseInt(loaddata("color_A"));
         color_R=Integer.parseInt(loaddata("color_R"));
         color_G=Integer.parseInt(loaddata("color_G"));
          color_B=Integer.parseInt(loaddata("color_B"));
            simple.setTextColor(Color.argb(color_A, color_R, color_G, color_B));
            Blue.setProgress(color_B);
            Green.setProgress(color_G);
            Red.setProgress(color_R);
            Alpha.setProgress(color_A);

        }
if(fileIsExists("/Android/data/com.fastkylin.timer2/files/data/content")){
         content=loaddata("content");
         simple.setText(loaddata("content"));
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
                Toast toast=Toast.makeText(diytextActivity.this, R.string.delectok,Toast.LENGTH_SHORT);
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
}
