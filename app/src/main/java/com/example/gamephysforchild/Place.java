package com.example.gamephysforchild;

public class Place
{
    public int x, y, alpha; //координаты  угол поворота
    public boolean isEmpty;
    public Place(int _x, int _y, boolean _isEmpty, int _alpha)
    {
        x = _x;
        y = _y;
        isEmpty = _isEmpty;
        alpha = _alpha;
    }
    public void Set(int _x, int _y, boolean _isEmpty, int _alpha)
    {
        x = _x;
        y = _y;
        isEmpty = _isEmpty;
        alpha = _alpha;
    }

    int Getx() {return x;}
    int Gety() {return y;}
    int Getalpha() {return alpha;}
    boolean GetIsEmpty() {return isEmpty;}
}