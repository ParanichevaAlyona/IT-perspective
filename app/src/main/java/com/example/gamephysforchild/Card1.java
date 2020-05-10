package com.example.gamephysforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
//import android.support.;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.Random;

public class Card1 extends AppCompatActivity
{
    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    public int viborLR;
    public int count = 0;
    ArrayFast array = new ArrayFast(); //сделать массив в котором первые 10(5) картинок 1 тематика(правильные), вторые - другая
    //ArrayHot array = new ArrayHot();
    //ArrayHeavy array = new ArrayHeavy();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрываем заголовок
        dialog.setContentView(R.layout.dialoglevel1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозр фон диалогового окна
        dialog.setCancelable(false); //окно не закрыть кнопкой назад

        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(Card1.this, GameLevelsChoice.class);// вернуться
                    startActivity(intent);
                    finish();
                }
                catch (Exception e) {}
                dialog.dismiss();
            }

        });

        //Кнопка продолжить
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.show();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogfinish);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозр фон диалогового окна
        dialogEnd.setCancelable(false); //окно не закрыть кнопкой назад

        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(Card1.this, GameLevelsChoice.class);// вернуться
                    startActivity(intent);
                    finish();
                }
                catch (Exception e) {}
                dialogEnd.dismiss();
            }

        });

        //Кнопка продолжить
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    Intent intent = new Intent(Card1.this, Card2.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){}
                dialogEnd.dismiss();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carduniver);

        //Номер уровня
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);

        //на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



        //кнопка назад
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Card1.this, GameLevelsChoice.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        //скругление углов
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        final int[] progress = {R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5};
        final Animation a = AnimationUtils.loadAnimation(Card1.this, R.anim.alpha);


        viborLR = random.nextInt(2);
        if (viborLR == 0)
        {
            numLeft = random.nextInt(10);
            numRight = random.nextInt(10) + 10;
        } else {
            numLeft = random.nextInt(10) + 10;
            numRight = random.nextInt(10);
        }
        img_left.setImageResource(array.images1[numLeft]);
        img_right.setImageResource(array.images1[numRight]);
        text_left.setText(array.texts1[numLeft]);
        text_right.setText(array.texts1[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    img_right.setEnabled(false);
                    if (numLeft < 10)
                        img_left.setImageResource(R.drawable.green);
                    else
                        img_left.setImageResource(R.drawable.red);
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    if (numLeft < 10)
                    {
                        if (count < 5)
                            count++;

                        for (int i = 0; i < 5; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0)
                        {
                            if (count == 1)
                                count = 0;
                            else
                                count = count - 2;
                        }
                        for (int i = 0; i < 5; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 5){ count = 0;
                    dialogEnd.show();}

		            else
                    {
                        viborLR = random.nextInt(2);
                        if (viborLR == 0)
                        {
                            numLeft = random.nextInt(10);
                            numRight = random.nextInt(10) + 10;
                        } else {
                            numLeft = random.nextInt(10) + 10;
                            numRight = random.nextInt(10);
                        }
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(a);
                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);
                        text_right.setText(array.texts1[numRight]);
                        img_right.setEnabled(true);
                    }
                }
                return true;
            }
        });
        img_right.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    img_left.setEnabled(false);
                    if (numRight < 10)
                        img_right.setImageResource(R.drawable.green);
                    else
                        img_right.setImageResource(R.drawable.red);
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    if (numRight < 10)
                    {
                        if (count < 5)
                            count++;

                        for (int i = 0; i < 5; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0)
                        {
                            if (count == 1)
                                count = 0;
                            else
                                count = count - 2;
                        }
                        for (int i = 0; i < 5; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count == 5){ count = 0;
                        dialogEnd.show();}
                    else
                    {
                        viborLR = random.nextInt(2);
                        if (viborLR == 0)
                        {
                            numLeft = random.nextInt(10);
                            numRight = random.nextInt(10) + 10;
                        } else {
                            numLeft = random.nextInt(10) + 10;
                            numRight = random.nextInt(10);
                        }
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(a);
                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);
                        text_right.setText(array.texts1[numRight]);
                        img_left.setEnabled(true);
                    }
                }


                return true;
            }
        });
    }
    //выход на страницу уровней
    @Override
    public void onBackPressed()
    {
        try
        {
            Intent intent = new Intent(Card1.this, GameLevelsChoice.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e) {}
    }

}
