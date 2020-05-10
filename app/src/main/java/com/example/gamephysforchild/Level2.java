package com.example.gamephysforchild;

import androidx.appcompat.app.AppCompatActivity;

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
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.res.Resources;
import android.graphics.Paint;

public class Level2 extends AppCompatActivity
{
    Dialog dialogEnd;
    public int a = -1;
    public int b = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
                    Intent intent = new Intent(Level2.this, GameLevelsLight.class);// вернуться
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
                    Intent intent = new Intent(Level2.this, GameLevelsLight.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){}
                dialogEnd.dismiss();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //кнопка назад
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(Level2.this, GameLevelsLight.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e) {}
            }
        });

        Place[] places;
        places = new Place[4];


        places[0] = new Place(30, 160, false, 90);
        places[1] = new Place(50, 160, false, 270);
        places[2] = new Place(30, 135, true, 0);
        places[3] = new Place(80, 110, true, 0);

        LevelRay lr = new LevelRay(80, 160, 30, 85, 2, 4, places, 153);

        ImageView iv = (ImageView)findViewById(R.id.background);
        Bitmap bm = Bitmap.createBitmap(100, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);

        boolean fin = false;
        boolean flag;
        int tmpal;
        boolean tmpbool;

        final ImageView img0 = (ImageView)findViewById(R.id.place1);
        final ImageView img1 = (ImageView)findViewById(R.id.place2);
        final ImageView img2 = (ImageView)findViewById(R.id.place3);
        final ImageView img3 = (ImageView)findViewById(R.id.place4);

        int width = 95;
        int height = 180;
        int top = 45;
        int left = 5;

        Resources res = this.getResources();
        Bitmap plor = BitmapFactory.decodeResource(res, R.drawable.place);
        Bitmap miror = BitmapFactory.decodeResource(res, R.drawable.zerkalol);

        Bitmap back1or = BitmapFactory.decodeResource(res, R.drawable.fon5);
        Bitmap back2or = BitmapFactory.decodeResource(res, R.drawable.fon4);

        Bitmap flowor = BitmapFactory.decodeResource(res, R.drawable.cvetzavyal1);
        Bitmap konor = BitmapFactory.decodeResource(res, R.drawable.cvetozhil1);
        Bitmap lampor = BitmapFactory.decodeResource(res, R.drawable.idea_1);

        Paint mPaint = new Paint();
        int wpl = plor.getWidth() / 10;
        int hpl = plor.getHeight() / 10;
        int wmir = miror.getWidth() / 15;
        int hmir = miror.getHeight() / 15;
        int wf = flowor.getWidth() / 15;
        int hf = flowor.getHeight() / 15;
        int wlam = lampor.getWidth() / 20;
        int hlam = lampor.getHeight() / 20;
        int wb = back1or.getWidth() / 10;
        int hb = back1or.getHeight() / 10;
        int wb2 = back1or.getWidth() / 14;
        int hb2 = back1or.getHeight() / 17;

        Bitmap pl = Bitmap.createScaledBitmap(plor, wpl, hpl, false);
        Bitmap mir = Bitmap.createScaledBitmap(miror, wmir, hmir, false);

        Bitmap flow = Bitmap.createScaledBitmap(flowor, wf, hf, false);
        Bitmap kon = Bitmap.createScaledBitmap(konor, wf, hf, false);
        Bitmap lamp = Bitmap.createScaledBitmap(lampor, wlam, hlam, false);
        Bitmap back1 = Bitmap.createScaledBitmap(back1or, wb, hb, false);
        Bitmap back2 = Bitmap.createScaledBitmap(back2or, wb2, hb2, false);

        canvas.drawBitmap(back1,0,0, mPaint);
        canvas.drawBitmap(back2,5,45, mPaint);
        mPaint.setColor(Color.YELLOW);//луч - цвет и ширина
        mPaint.setStrokeWidth(3);
        //Выводим изображения
        canvas.drawBitmap(flow, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
        canvas.drawBitmap(lamp, lr.sunx - wlam / 2, lr.suny - hlam / 2, mPaint);
        for (int i = 0; i < lr.countpl; i++)
        {
            if (lr.places[i].GetIsEmpty())
                canvas.drawBitmap(pl, lr.places[i].x - wpl / 2, lr.places[i].y - hpl / 2, mPaint);
            else
            {
                Matrix matrix = new Matrix();
                matrix.postRotate(lr.places[i].alpha, lr.places[i].x - wmir / 2, lr.places[i].y - hmir  /2);
                canvas.drawBitmap(mir, matrix, mPaint);
            }
        }

        int x1, x2, y1, y2;
        x1 = lr.sunx;
        y1 = lr.suny;

        int count = 0;
        int alpha = lr.alpha;
        double tg = Math.tan(Math.toRadians(alpha));
        flag = true;
        while ((count < 10) && (flag))
        {
            x2 = x1;
            y2 = y1;
            count++;//счетчик отражений
            if (alpha >= 0 && alpha < 90)
            {
                if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                        (lr.flowerx > x1) && (lr.flowery < y1))
                {
                    x2 = lr.flowerx;
                    y2 = lr.flowery;
                    //отрисовка луча
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                    fin = true;
                    break;
                }
                for (int i = 0; i < lr.countpl; i++)
                {
                    if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                            (lr.places[i].x > x1) && (lr.places[i].y < y1))
                    {
                        x2 = lr.places[i].x;
                        y2 = lr.places[i].y;
                        //отрисовка линии
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        if ((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 180 + alpha))
                        {
                            alpha = (2 * lr.places[i].alpha - alpha + 180 * ((lr.places[i].alpha - alpha) / 90)) % 360;
                            tg = Math.tan(Math.toRadians(alpha));
                        }
                        else
                            fin = flag = false;
                        break;
                    }
                }
                if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                {
                    if (width * (-1) * tg + tg * x1 + y1 < top)
                    {
                        y2 = top;
                        double tmp = (tg * x1 + y1 - top) / tg;
                        x2 = (int)tmp;
                    }
                    else
                    {
                        x2 = width;
                        double tmp = width * (-1) * tg + tg * x1 + y1;
                        y2 = (int)tmp;
                    }
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    fin = false;
                    break;
                }
                x1 = x2;
                y1 = y2;
            }
            else if ((alpha >= 90) && (alpha < 180))
            {
                if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                        (lr.flowerx < x1) && (lr.flowery < y1))
                {
                    x2 = lr.flowerx;
                    y2 = lr.flowery;
                    //отрисовка луча
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                    fin = true;
                    break;
                }
                for (int i = 0; i < lr.countpl; i++)
                {
                    if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                            (lr.places[i].x < x1) && (lr.places[i].y < y1))
                    {
                        x2 = lr.places[i].x;
                        y2 = lr.places[i].y;
                        //отрисовка линии
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        if ((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 180 + alpha))
                        {
                            alpha = (2 * lr.places[i].alpha - alpha) % 360;
                            tg = Math.tan(Math.toRadians(alpha));
                        }
                        else
                            fin = flag = false;
                        break;
                    }
                }
                if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                {
                    if (tg * x1 + y1 < top)
                    {
                        y2 = top;
                        double tmp = (tg * x1 + y1 - top) / tg;
                        x2 = (int)tmp;
                    }
                    else
                    {
                        x2 = left;
                        double tmp = tg * (x1 - left) + y1;
                        y2 = (int)tmp;
                    }
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    fin = false;
                    break;
                }
                x1 = x2;
                y1 = y2;
            }
            else if ((alpha >= 180) && (alpha < 270))
            {
                if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                        (lr.flowerx < x1) && (lr.flowery > y1))
                {
                    x2 = lr.flowerx;
                    y2 = lr.flowery;
                    //отрисовка луча
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                    fin = true;
                    break;
                }
                for (int i = 0; i < lr.countpl; i++)
                {
                    if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                            (lr.places[i].x < x1) && (lr.places[i].y > y1))
                    {
                        x2 = lr.places[i].x;
                        y2 = lr.places[i].y;
                        //отрисовка линии
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        if (((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 360)) || ((lr.places[i].alpha > 0) && (lr.places[i].alpha < alpha - 180)))
                        {
                            alpha = (1080 - 2 * lr.places[i].alpha - alpha) % 360;
                            tg = Math.tan(Math.toRadians(alpha));
                        }
                        else
                            fin = flag = false;
                        break;
                    }
                }
                if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                {
                    if (tg * x1 + y1 >= height)
                    {
                        y2 = height;
                        double tmp = (tg * x1 + y1 - height) / tg;
                        x2 = (int)tmp;
                    }
                    else
                    {
                        x2 = left;
                        double tmp = tg * (x1 - left) + y1;
                        y2 = (int)tmp;
                    }
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    fin = false;
                    break;
                }
                x1 = x2;
                y1 = y2;
            }
            else if ((alpha >= 270) && (alpha < 360))
            {
                if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                        (lr.flowerx > x1) && (lr.flowery > y1))
                {
                    x2 = lr.flowerx;
                    y2 = lr.flowery;
                    //отрисовка луча
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                    fin = true;
                    break;
                }
                for (int i = 0; i < lr.countpl; i++)
                {
                    if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                            (lr.places[i].x > x1) && (lr.places[i].y > y1))
                    {
                        x2 = lr.places[i].x;
                        y2 = lr.places[i].y;
                        //отрисовка линии
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        if (((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 360)) || ((lr.places[i].alpha > 0) && (lr.places[i].alpha < alpha - 180)))
                        {
                            alpha = (2 * lr.places[i].alpha - alpha + 180) % 360;
                            tg = Math.tan(Math.toRadians(alpha));
                        }
                        else
                            fin = flag = false;
                        break;
                    }
                }
                if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                {
                    if (width * (-1) * tg + tg * x1 + y1 >= height)
                    {
                        y2 = height;
                        double tmp = (tg * x1 + y1 - height) / tg;
                        x2 = (int)tmp;
                    }
                    else
                    {
                        x2 = width;
                        double tmp = width * (-1) * tg + tg * x1 + y1;
                        y2 = (int)tmp;
                    }
                    canvas.drawLine(x1, y1, x2, y2, mPaint);
                    fin = false;
                    break;
                }
                x1 = x2;
                y1 = y2;
            }
        }
        fin = false;
        iv.setImageBitmap(bm);//вывод полученного изображения*/

        while(!fin) {
            //обработка нажатий на картинки
            img0.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    //касание лунки
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        int c = 0;
                        if ((a == -1) && (b == -1))
                            a = c;
                        else if ((a != -1) && (b == -1))
                            b = c;
                        else if ((a != -1) && (b != -1)) {
                            a = b;
                            b = c;
                        }
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отпустил картинку
                    }
                    return true;
                }
            });
            img1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    //касание лунки
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        int c = 1;
                        if ((a == -1) && (b == -1))
                            a = c;
                        else if ((a != -1) && (b == -1))
                            b = c;
                        else if ((a != -1) && (b != -1)) {
                            a = b;
                            b = c;
                        }
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отпустил картинку
                    }
                    return true;
                }
            });
            img2.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    //касание лунки
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        int c = 2;
                        if ((a == -1) && (b == -1))
                            a = c;
                        else if ((a != -1) && (b == -1))
                            b = c;
                        else if ((a != -1) && (b != -1)) {
                            a = b;
                            b = c;
                        }
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отпустил картинку
                    }
                    return true;
                }
            });
            img3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    //касание лунки
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        int c = 3;
                        if ((a == -1) && (b == -1))
                            a = c;
                        else if ((a != -1) && (b == -1))
                            b = c;
                        else if ((a != -1) && (b != -1)) {
                            a = b;
                            b = c;
                        }
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отпустил картинку
                    }
                    return true;
                }
            });
            if ((a != -1) && (b != -1) && (a != b)) {
                tmpbool = lr.places[a].isEmpty;
                lr.places[a].isEmpty = lr.places[b].isEmpty;
                lr.places[b].isEmpty = tmpbool;
                tmpal = lr.places[a].alpha;
                lr.places[a].alpha = lr.places[b].alpha;
                lr.places[b].alpha = tmpal;
            }

            canvas.drawBitmap(back1, 0, 0, mPaint);
            canvas.drawBitmap(back2, 5, 45, mPaint);
            mPaint.setColor(Color.YELLOW);//луч - цвет и ширина
            mPaint.setStrokeWidth(3);
            //Выводим изображения
            canvas.drawBitmap(flow, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
            canvas.drawBitmap(lamp, lr.sunx - wlam / 2, lr.suny - hlam / 2, mPaint);
            for (int i = 0; i < lr.countpl; i++) {
                if (lr.places[i].GetIsEmpty())
                    canvas.drawBitmap(pl, lr.places[i].x - wpl / 2, lr.places[i].y - hpl / 2, mPaint);
                else {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(lr.places[i].alpha, lr.places[i].x - wmir / 2, lr.places[i].y - hmir  /2);
                    canvas.drawBitmap(mir, matrix, mPaint);
                }
            }
            x1 = lr.sunx;
            y1 = lr.suny;

            count = 0;
            alpha = lr.alpha;
            tg = Math.tan(Math.toRadians(alpha));
            flag = true;
            while ((count < 10) && (flag)) {
                x2 = x1;
                y2 = y1;
                count++;//счетчик отражений
                if (alpha >= 0 && alpha < 90) {
                    if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                            (lr.flowerx > x1) && (lr.flowery < y1)) {
                        x2 = lr.flowerx;
                        y2 = lr.flowery;
                        //отрисовка луча
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                        fin = true;
                        break;
                    }
                    for (int i = 0; i < lr.countpl; i++) {
                        if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                                (lr.places[i].x > x1) && (lr.places[i].y < y1)) {
                            x2 = lr.places[i].x;
                            y2 = lr.places[i].y;
                            //отрисовка линии
                            canvas.drawLine(x1, y1, x2, y2, mPaint);
                            if ((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 180 + alpha)) {
                                alpha = (2 * lr.places[i].alpha - alpha + 180 * ((lr.places[i].alpha - alpha) / 90)) % 360;
                                tg = Math.tan(Math.toRadians(alpha));
                            } else
                                fin = flag = false;
                            break;
                        }
                    }
                    if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                    {
                        if (width * (-1) * tg + tg * x1 + y1 < top) {
                            y2 = top;
                            double tmp = (tg * x1 + y1 - top) / tg;
                            x2 = (int) tmp;
                        } else {
                            x2 = width;
                            double tmp = width * (-1) * tg + tg * x1 + y1;
                            y2 = (int) tmp;
                        }
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        fin = false;
                        break;
                    }
                    x1 = x2;
                    y1 = y2;
                } else if ((alpha >= 90) && (alpha < 180)) {
                    if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                            (lr.flowerx < x1) && (lr.flowery < y1)) {
                        x2 = lr.flowerx;
                        y2 = lr.flowery;
                        //отрисовка луча
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                        fin = true;
                        break;
                    }
                    for (int i = 0; i < lr.countpl; i++) {
                        if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                                (lr.places[i].x < x1) && (lr.places[i].y < y1)) {
                            x2 = lr.places[i].x;
                            y2 = lr.places[i].y;
                            //отрисовка линии
                            canvas.drawLine(x1, y1, x2, y2, mPaint);
                            if ((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 180 + alpha)) {
                                alpha = (2 * lr.places[i].alpha - alpha) % 360;
                                tg = Math.tan(Math.toRadians(alpha));
                            } else
                                fin = flag = false;
                            break;
                        }
                    }
                    if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                    {
                        if (tg * x1 + y1 < top) {
                            y2 = top;
                            double tmp = (tg * x1 + y1 - top) / tg;
                            x2 = (int) tmp;
                        } else {
                            x2 = left;
                            double tmp = tg * (x1 - left) + y1;
                            y2 = (int) tmp;
                        }
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        fin = false;
                        break;
                    }
                    x1 = x2;
                    y1 = y2;
                } else if ((alpha >= 180) && (alpha < 270)) {
                    if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                            (lr.flowerx < x1) && (lr.flowery > y1)) {
                        x2 = lr.flowerx;
                        y2 = lr.flowery;
                        //отрисовка луча
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                        fin = true;
                        break;
                    }
                    for (int i = 0; i < lr.countpl; i++) {
                        if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                                (lr.places[i].x < x1) && (lr.places[i].y > y1)) {
                            x2 = lr.places[i].x;
                            y2 = lr.places[i].y;
                            //отрисовка линии
                            canvas.drawLine(x1, y1, x2, y2, mPaint);
                            if (((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 360)) || ((lr.places[i].alpha > 0) && (lr.places[i].alpha < alpha - 180))) {
                                alpha = (1080 - 2 * lr.places[i].alpha - alpha) % 360;
                                tg = Math.tan(Math.toRadians(alpha));
                            } else
                                fin = flag = false;
                            break;
                        }
                    }
                    if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                    {
                        if (tg * x1 + y1 >= height) {
                            y2 = height;
                            double tmp = (tg * x1 + y1 - height) / tg;
                            x2 = (int) tmp;
                        } else {
                            x2 = left;
                            double tmp = tg * (x1 - left) + y1;
                            y2 = (int) tmp;
                        }
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        fin = false;
                        break;
                    }
                    x1 = x2;
                    y1 = y2;
                } else if ((alpha >= 270) && (alpha < 360)) {
                    if ((lr.flowery == lr.flowerx * (-1) * tg + tg * x1 + y1) &&
                            (lr.flowerx > x1) && (lr.flowery > y1)) {
                        x2 = lr.flowerx;
                        y2 = lr.flowery;
                        //отрисовка луча
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        canvas.drawBitmap(kon, lr.flowerx - wf / 2, lr.flowery - hf / 2, mPaint);
                        fin = true;
                        break;
                    }
                    for (int i = 0; i < lr.countpl; i++) {
                        if ((!lr.places[i].isEmpty) && (lr.places[i].y == lr.places[i].x * (-1) * tg + tg * x1 + y1) &&
                                (lr.places[i].x > x1) && (lr.places[i].y > y1)) {
                            x2 = lr.places[i].x;
                            y2 = lr.places[i].y;
                            //отрисовка линии
                            canvas.drawLine(x1, y1, x2, y2, mPaint);
                            if (((lr.places[i].alpha > alpha) && (lr.places[i].alpha < 360)) || ((lr.places[i].alpha > 0) && (lr.places[i].alpha < alpha - 180))) {
                                alpha = (2 * lr.places[i].alpha - alpha + 180) % 360;
                                tg = Math.tan(Math.toRadians(alpha));
                            } else
                                fin = flag = false;
                            break;
                        }
                    }
                    if ((x2 == x1) && (y2 == y1))//луч не встретился с зеркалами
                    {
                        if (width * (-1) * tg + tg * x1 + y1 >= height) {
                            y2 = height;
                            double tmp = (tg * x1 + y1 - height) / tg;
                            x2 = (int) tmp;
                        } else {
                            x2 = width;
                            double tmp = width * (-1) * tg + tg * x1 + y1;
                            y2 = (int) tmp;
                        }
                        canvas.drawLine(x1, y1, x2, y2, mPaint);
                        fin = false;
                        break;
                    }
                    x1 = x2;
                    y1 = y2;
                }
            }
            fin = false;
            iv.setImageBitmap(bm);
        }
        dialogEnd.show();
    }
}
