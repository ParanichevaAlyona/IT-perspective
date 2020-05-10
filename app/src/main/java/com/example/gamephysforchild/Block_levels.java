package com.example.gamephysforchild;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Block_levels extends AppCompatActivity
{
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрываем заголовок
        dialog.setContentView(R.layout.dialogstart);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозр фон диалогового окна
        dialog.setCancelable(false); //окно не закрыть кнопкой назад

        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Block_levels.this, MainActivity.class);// вернуться
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog.dismiss();
            }

        });

        //Кнопка продолжить
        Button btncontinue = (Button) dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.block_levels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //кнопка назад
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(Block_levels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e) {}
            }
        });

        //кнопка перехода на первый уровень
        ImageView textView1 = (ImageView)findViewById(R.id.img_choice);
        textView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(Block_levels.this, GameLevelsChoice.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){}
            }
        });

        ImageView textView2 = (ImageView)findViewById(R.id.img_light);
        textView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent2 = new Intent(Block_levels.this, GameLevelsLight.class);
                    startActivity(intent2);
                    finish();
                }
                catch (Exception e){}
            }
        });
    }
    //выход на страницу старта
    @Override
    public void onBackPressed()
    {
        try
        {
            Intent intent = new Intent(Block_levels.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e)
        {}
    }
}
