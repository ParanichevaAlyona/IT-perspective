package com.example.gamephysforchild;

public class LevelRay
{
    int sunx, suny;
    int flowerx, flowery;
    int countmir, countpl;
    int alpha; //угол поворота луча
    Place[] places;
    LevelRay(int sx, int sy, int fx, int fy, int cm, int cp, Place[] pl, int _alpha)
    {
        sunx = sx;
        suny = sy;
        flowerx = fx;
        flowery = fy;
        countmir = cm;
        countpl = cp;
        alpha = _alpha;
        places = new Place[countpl];
        for (int i = 0; i < countpl; i++)
            places[i] = pl[i];
    }
}
