package MyEngine;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public abstract class GameObject
{
    protected Rect dst = new Rect();
    protected RectF dstF;
    protected Bitmap m_Img;
    protected int m_PosX = 0;
    protected int m_PosY = 0;
    protected double m_dPosX;
    protected double m_dPosY;
    protected Rect src = new Rect();
    protected RectF srcF;

    public GameObject(Resources paramResources, int paramInt)
    {
        this.m_Img = BitmapFactory.decodeResource(paramResources, paramInt);
    }

    public GameObject(Bitmap paramBitmap)
    {
        this.m_Img = paramBitmap;
    }

    public int GetX()
    {
        return this.m_PosX;
    }

    public int GetY()
    {
        return this.m_PosY;
    }

    public abstract void drawImg(Canvas paramCanvas);

    public Bitmap getBitmap()
    {
        return this.m_Img;
    }

    public Rect getRect()
    {
        return this.dst;
    }

    public RectF getRectF()
    {
        return this.dstF;
    }

    public abstract void initData();

    public void restoreImg()
    {
        this.m_Img.recycle();
        this.m_Img = null;
    }

    public void setPos(int paramInt1, int paramInt2)
    {
        this.m_PosX = paramInt1;
        this.m_PosY = paramInt2;
    }

    public abstract void updateData();
}
