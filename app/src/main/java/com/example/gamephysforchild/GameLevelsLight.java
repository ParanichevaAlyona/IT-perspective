package com.example.gamephysforchild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class GameLevelsLight extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

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
                    Intent intent = new Intent(GameLevelsLight.this, Block_levels.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e) {}
            }
        });

        //кнопка перехода на первый уровень
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    //Intent intent = new Intent(GameLevelsChoice.this, Level1.class);
                    Intent intent = new Intent(GameLevelsLight.this, Level1.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){}
            }
        });

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent2 = new Intent(GameLevelsLight.this, Level2.class);
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
            Intent intent = new Intent(GameLevelsLight.this, Block_levels.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e)
        {

        }
    }
}
