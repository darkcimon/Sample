package exam.AngryBirdBug;

import MyEngine.GameObject;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class BackCloud
        extends GameObject
{
    float m_scaleX;
    float m_scaleY;
    int speed = 1;
    int type;

    public BackCloud(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
    }

    public BackCloud(Bitmap paramBitmap)
    {
        super(paramBitmap);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.m_PosX -= this.speed;
        this.src.set(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(this.m_PosX, this.m_PosY, this.m_PosX + this.m_Img.getWidth() * 2, this.m_PosY + this.m_Img.getHeight());
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
        if (this.m_PosX <= -this.m_Img.getWidth() * 2) {
            this.m_PosX = paramCanvas.getWidth();
        }
    }

    public void initData() {}

    public void updateData() {}
}
