package com.fastkylin.timer2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.TextView;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {


    public TextView tv1;
    public TextView tv2;
    public TextView tv3;
    private TextView now_time;

    public Button btn_theme;
    public Button btn_exit;
    public Button btn_about;
    public Button btn_diytext;
    public Button btn_back;
    public Button btn_day;
    public Button btn_hour;
    public Button btn_mini;
    public Button btn_second;

    private LinearLayout back0;
    private LinearLayout back1;
    private LinearLayout back2;
    private LinearLayout back3;
    private LinearLayout main_back;

    private TextView simple;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        now_time=findViewById(R.id.now_time);

        btn_day = findViewById(R.id.btn_day);
        btn_hour = findViewById(R.id.btn_hour);
        btn_mini = findViewById(R.id.btn_mini);
        btn_second = findViewById(R.id.btn_sencond);
        btn_about = findViewById(R.id.btn_about);

        back0 = findViewById(R.id.back0);
        back1 = findViewById(R.id.back1);
        back2 = findViewById(R.id.back2);
        back3 = findViewById(R.id.back3);
        main_back = findViewById(R.id.Main_LeftLayout);


        btn_back = findViewById(R.id.btn_back);
        btn_theme = findViewById(R.id.btn_theme);
        btn_exit = findViewById(R.id.btn_exit);
        btn_diytext=findViewById(R.id.btn_diytext);
simple=findViewById(R.id.diy_text);

        linefresh();
        setOnclickListener();
        themeset();
        backset();
        yearset();
        textset();
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                linefresh();
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);


}


    public void setOnclickListener(){
        btn_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(400);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                ArrayList<Animator> animatorList = new ArrayList<Animator>();
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(  btn_theme, "ScaleX", 1f, 0.8f, 0.5f, 1f);
                animatorList.add(scaleXAnimator);
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(  btn_theme, "ScaleY", 1f, 0.8f, 0.5f, 1f);
                animatorList.add(scaleYAnimator);
                animatorSet.playTogether(animatorList);
                animatorSet.start();
                Intent intent=new Intent(MainActivity.this, com.fastkylin.timer2.themeActivity.class);
                startActivity(intent);
                finish();
            }
        });
btn_diytext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,com.fastkylin.timer2.diytextActivity.class);
        startActivity(intent);
        finish();
    }
});

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(400);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                ArrayList<Animator> animatorList = new ArrayList<Animator>();
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(tv3, "ScaleX", 1f, 0.8f, 0.5f, 1f);
                animatorList.add(scaleXAnimator);
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(tv3, "ScaleY", 1f, 0.8f, 0.5f, 1f);
                animatorList.add(scaleYAnimator);
                animatorSet.playTogether(animatorList);
                animatorSet.start();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.fastkylin.timer2.backActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_second.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Fight!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(400);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                ArrayList<Animator> animatorList = new ArrayList<Animator>();
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(btn_about, "ScaleX", 1f, 0.8f, 0.5f, 1f);
                animatorList.add(scaleXAnimator);
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(btn_about, "ScaleY", 1f, 0.8f, 0.5f, 1f);
                animatorList.add(scaleYAnimator);
                animatorSet.playTogether(animatorList);

                animatorSet.start();
         Intent intent=new Intent(MainActivity.this,aboutActivity.class);
         startActivity(intent);
         finish();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(40);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                ArrayList<Animator> animatorList = new ArrayList<Animator>();
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(btn_exit, "ScaleX", 1f, 0.8f, 0.5f, 0f);
                animatorList.add(scaleXAnimator);
                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(btn_exit, "ScaleY", 1f, 0.8f, 0.5f, 0f);
                animatorList.add(scaleYAnimator);
                animatorSet.playTogether(animatorList);
                animatorSet.start();
                finish();
            }
        });

        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(MainActivity.this,loaddata("content"),Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
    private void backset(){
        if(fileIsExists("/Android/data/com.fastkylin.timer2/files/data/back")) {
            String back=loaddata("back");
            switch (back){
                case "tv0":
                    back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back0));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back0));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back0));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back0));


                break;
                case "tv1":
                    tv1.setTextColor(this.getResources().getColor(R.color.mistyrose));
                    tv3.setTextColor(this.getResources().getColor(R.color.mistyrose));
                    back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back1));
              back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back1));
                back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back1));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back1));


                    break;
                case "tv2":back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back2));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back2));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back2));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back2));


                break;
                case "tv3": back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back3));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back3));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back3));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back3));

                break;
                case "tv4":back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back4));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back4));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back4));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back4));




                break;
                case "tv5":back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back5));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back5));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back5));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back5));

                break;
                case "tv6":back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back6));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back6));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back6));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back6));


                break;
                case "tv7": back0.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back7));
                    back1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back7));
                    back2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back7));
                    back3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_back7));

                break;
                default:break;
            }
        }

    }

    public void themeset(){
                if(fileIsExists("/Android/data/com.fastkylin.timer2/files/data/theme")) {
                    String theme=loaddata("theme");
                    switch (theme){
                        case "btn0":
                            btn_second.setBackgroundResource(R.drawable.btn_selector);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector);
                            btn_day.setBackgroundResource(R.drawable.btn_selector);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector);
                            btn_about.setBackgroundResource(R.drawable.btn_selector);
                            btn_back.setBackgroundResource(R.drawable.btn_selector);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector);
                        break;
                        case "btn1":
                            btn_about.setTextColor(this.getResources().getColor(R.color.greenyellow));
                            btn_exit.setTextColor(this.getResources().getColor(R.color.greenyellow));
                            btn_theme.setTextColor(this.getResources().getColor(R.color.greenyellow));
                            btn_back.setTextColor(this.getResources().getColor(R.color.greenyellow));
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector1);
                            btn_second.setBackgroundResource(R.drawable.btn_selector1);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector1);
                            btn_day.setBackgroundResource(R.drawable.btn_selector1);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector1);
                            btn_about.setBackgroundResource(R.drawable.btn_selector1);
                            btn_back.setBackgroundResource(R.drawable.btn_selector1);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector1);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector1);break;
                        case "btn2": btn_second.setBackgroundResource(R.drawable.btn_selector2);

                            btn_hour.setBackgroundResource(R.drawable.btn_selector2);
                            btn_day.setBackgroundResource(R.drawable.btn_selector2);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector2);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector2);
                            btn_about.setBackgroundResource(R.drawable.btn_selector2);
                            btn_back.setBackgroundResource(R.drawable.btn_selector2);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector2);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector2);break;
                        case "btn3": btn_second.setBackgroundResource(R.drawable.btn_selector3);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector3);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector3);
                            btn_day.setBackgroundResource(R.drawable.btn_selector3);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector3);
                            btn_about.setBackgroundResource(R.drawable.btn_selector3);
                            btn_back.setBackgroundResource(R.drawable.btn_selector3);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector3);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector3);break;
                        case "btn4": btn_second.setBackgroundResource(R.drawable.btn_selector4);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector4);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector4);
                            btn_day.setBackgroundResource(R.drawable.btn_selector4);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector4);
                            btn_about.setBackgroundResource(R.drawable.btn_selector4);
                            btn_second.setTextColor(this.getResources().getColor(R.color.yellow));
                            btn_back.setBackgroundResource(R.drawable.btn_selector4);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector4);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector4);break;
                        case "btn5": btn_second.setBackgroundResource(R.drawable.btn_selector5);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector5);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector5);
                            btn_day.setBackgroundResource(R.drawable.btn_selector5);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector5);
                            btn_about.setBackgroundResource(R.drawable.btn_selector5);
                            btn_back.setBackgroundResource(R.drawable.btn_selector5);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector5);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector5);break;
                        case "btn6": btn_second.setBackgroundResource(R.drawable.btn_selector6);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector6);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector6);
                            btn_day.setBackgroundResource(R.drawable.btn_selector6);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector6);
                            btn_about.setBackgroundResource(R.drawable.btn_selector6);
                            btn_back.setBackgroundResource(R.drawable.btn_selector6);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector6);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector6);break;
                        case "btn7": btn_second.setBackgroundResource(R.drawable.btn_selector7);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector7);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector7);
                            btn_day.setBackgroundResource(R.drawable.btn_selector7);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector7);
                            btn_about.setBackgroundResource(R.drawable.btn_selector7);
                            btn_back.setBackgroundResource(R.drawable.btn_selector7);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector7);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector7);break;
                        case "btn8": btn_second.setBackgroundResource(R.drawable.btn_selector8);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector8);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector8);
                            btn_day.setBackgroundResource(R.drawable.btn_selector8);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector8);
                            btn_about.setBackgroundResource(R.drawable.btn_selector8);
                            btn_back.setBackgroundResource(R.drawable.btn_selector8);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector8);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector8);break;
                        case "btn9": btn_second.setBackgroundResource(R.drawable.btn_selector9);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector9);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector9);
                            btn_day.setBackgroundResource(R.drawable.btn_selector9);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector9);
                            btn_about.setBackgroundResource(R.drawable.btn_selector9);
                            btn_back.setBackgroundResource(R.drawable.btn_selector9);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector9);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector9);break;
                        case "btn10": btn_second.setBackgroundResource(R.drawable.btn_selector10);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector10);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector10);
                            btn_day.setBackgroundResource(R.drawable.btn_selector10);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector10);
                            btn_about.setBackgroundResource(R.drawable.btn_selector10);
                            btn_back.setBackgroundResource(R.drawable.btn_selector10);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector10);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector10);break;
                        case "btn11": btn_second.setBackgroundResource(R.drawable.btn_selector11);
                            btn_diytext.setBackgroundResource(R.drawable.btn_selector11);
                            btn_hour.setBackgroundResource(R.drawable.btn_selector11);
                            btn_day.setBackgroundResource(R.drawable.btn_selector11);
                            btn_mini.setBackgroundResource(R.drawable.btn_selector11);
                            btn_about.setBackgroundResource(R.drawable.btn_selector11);
                            btn_back.setBackgroundResource(R.drawable.btn_selector11);
                            btn_exit.setBackgroundResource(R.drawable.btn_selector11);
                            btn_theme.setBackgroundResource(R.drawable.btn_selector11);break;
                        default:break;
                    }
                }
    }



    private void yearset(){
        btn_mini.setText(String.valueOf(59-gettime(5)));
        int day1=0;
        day1=day_diff(gettime(1),gettime(2),gettime(3),year(),6,7);
        if((day1==0&&gettime(4)>=9)||(day1==-1)||(day1==-2&&gettime(4)<=15)){
            tv1.setText(R.string.tv1_1);
            tv2.setText(R.string.none);
            tv3.setText(R.string.none);
            btn_second.setText(R.string.fighting);
            btn_second.setTextSize(50);
            btn_day.setText(R.string.plus);
            btn_hour.setText(R.string.oil);
            btn_mini.setText(R.string.singal);
        }
        else
        {
            tv1.setText(R.string.tv1);
            tv2.setText(String.valueOf(year()));
            tv3.setText(R.string.tv2);

        }

    }



    public void linefresh() {
        now_time.setText(gettime(1)+"年"+gettime(2)+"月"+gettime(3)+"日"+"  "+gettime(4)+":"+gettime(5)+":"+gettime(6));
int day1=0;
day1=day_diff(gettime(1),gettime(2),gettime(3),year(),6,7);
if((day1==0&&gettime(4)>=9)||(day1==-1)||(day1==-2&&gettime(4)<=15)){
    tv1.setText(R.string.tv1_1);
    tv2.setText(R.string.none);
    tv3.setText(R.string.none);
    btn_second.setText(R.string.fighting);
    btn_second.setTextSize(50);
    btn_day.setText(R.string.plus);
    btn_hour.setText(R.string.oil);
    btn_mini.setText(R.string.singal);
}



else {
    if (day1 == 0) {
        btn_day.setText(String.valueOf(day1));
    } else {
        btn_day.setText(String.valueOf(day1 - 1));
    }

    if (gettime(2) == 6 && gettime(3) == 7) {
        btn_hour.setText(String.valueOf(8 - gettime(4)));

    }
    else{
        if(gettime(4)>=0&&gettime(4)<=9){
            btn_day.setText(String.valueOf(day1));
            btn_hour.setText(String.valueOf(8 - gettime(4)));
        }else{
        btn_hour.setText(String.valueOf(9+23 - gettime(4)));
        }
    }


    if (gettime(6) == 0) {
        btn_mini.setText(String.valueOf(59 - gettime(5)));
    }
    btn_second.setText(String.valueOf(59 - gettime(6)));
    if (gettime(4) == 0) {
        yearset();
    }

    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.setDuration(400);
    animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    ArrayList<Animator> animatorList = new ArrayList<Animator>();
    ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(btn_second, "ScaleX", 1f, 0.95f, 0.9f, 0.95f, 1f);
    animatorList.add(scaleXAnimator);
    ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(btn_second, "ScaleY", 1f, 0.95f, 0.9f, 0.95f, 1f);
    animatorList.add(scaleYAnimator);
    animatorSet.playTogether(animatorList);
    animatorSet.start();
}

}


    private void textset(){
        if(  fileIsExists("/Android/data/com.fastkylin.timer2/files/data/size")){
            int str=Integer.parseInt(loaddata("size"));
            simple.setTextSize(str);

        }
        if(fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_A")&&fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_R")&&fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_G")&&fileIsExists("/Android/data/com.fastkylin.timer2/files/data/color_B")){


         int   color_A=Integer.parseInt(loaddata("color_A"));
         int    color_R=Integer.parseInt(loaddata("color_R"));
           int  color_G=Integer.parseInt(loaddata("color_G"));
         int    color_B=Integer.parseInt(loaddata("color_B"));
            simple.setTextColor(Color.argb(color_A, color_R, color_G, color_B));


        }
        if(fileIsExists("/Android/data/com.fastkylin.timer2/files/data/content")){
            simple.setText(loaddata("content"));
        }
    }



private int year(){
        int out=0;
        int month=gettime(2);
        int days=gettime(3);


        if(month>=6&&days>=9){
            out=gettime(1)+1;
        }
else{
            out=gettime(1);
        }
        return out;
}
    public int  gettime(int a) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date curDate = new Date(System.currentTimeMillis());
       String str = formatter.format(curDate);
      int temp=0;
        int year=0,month=0,days=0,hour=0,mini=0,second=0;
        for (int i = 0; i < str.length(); i++) {
            if (i >= 0 && i <= 3) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                 year = chartoint(str.charAt(i)) + 10 * year;
                }
            }

            if (i >= 4 && i <= 5) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                   month = chartoint(str.charAt(i)) + 10 * month;
                }
            }
            if (i >= 6 && i <= 7) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    days = chartoint(str.charAt(i)) + 10 *days;
                }
            }
            if (i >= 8 && i <= 9) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                  hour = chartoint(str.charAt(i)) + 10 * hour;
                }
            }

            if (i >= 10 && i <= 11) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                 mini = chartoint(str.charAt(i)) + 10 * mini;
                }
            }
            if (i >= 12 && i <= 13) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                 second = chartoint(str.charAt(i)) + 10 * second;
                }
            }
        }
        switch (a)
        {
            case 1:
                temp=year;break;
            case 2:
                temp=month;break;
            case 3:
                temp=days;break;
            case 4:
                temp=hour;break;
            case 5:
                temp=mini;break;
            case 6:
                temp=second;break;
            default:temp=0;break;
        }
        return temp;
    }

    public int chartoint(char ch) {
        int a = 0;
        switch (ch) {
            case '1':
            a=1;
            break;
            case '2':
                a= 2;
                break;
            case '3':
                a=3;
                break;
            case '4':
             a=4;
                break;
            case '5':
              a=5;
                break;
            case '6':
               a=6;
                break;
            case '7':
              a=7;
                break;
            case '8':
            a=8;
                break;
            case '9':
            a=9;
                break;
            case '0':
              a=0;
                break;
            default:
                break;

        }
        return a;
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.me);
        builder.setTitle("关于");
        builder.setMessage("遇到bug了？你可以反馈给我\n" +
                "Email:fastkylin@163.com\n" +
                "QQ576950022");

        builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setNegativeButton("向开发者反馈bug", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url="mqqwpa://im/chat?chat_type=wpa&uin=576950022";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
        Dialog dialog = builder.create();

        dialog.show();
    }


     public   int day_diff(int year_start, int month_start, int day_start, int year_end, int month_end, int day_end)
        {
            int y2, m2, d2;
            int y1, m1, d1;
            m1 = (month_start + 9) % 12;
            y1 = year_start - m1/10;
            d1 = 365*y1 + y1/4 - y1/100 + y1/400 + (m1*306 + 5)/10 + (day_start - 1);
            m2 = (month_end + 9) % 12;
            y2 = year_end - m2/10;
            d2 = 365*y2 + y2/4 - y2/100 + y2/400 + (m2*306 + 5)/10 + (day_end - 1);
            return (d2 - d1);
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
                Toast toast=Toast.makeText(MainActivity.this, R.string.delectok,Toast.LENGTH_SHORT);
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





