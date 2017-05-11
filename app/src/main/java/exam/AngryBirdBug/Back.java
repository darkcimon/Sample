package exam.AngryBirdBug;

import MyEngine.GameObject;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class Back
        extends GameObject
{
    float m_scaleX;
    float m_scaleY;

    public Back(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
    }

    public Back(Bitmap paramBitmap)
    {
        super(paramBitmap);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.m_scaleX = (paramCanvas.getWidth() / 480.0F);
        this.m_scaleY = (paramCanvas.getHeight() / 320.0F);
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(0.0F, 0.0F, this.m_Img.getWidth() * this.m_scaleX, this.m_Img.getHeight() * this.m_scaleY);
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
    }

    public void initData()
    {
        this.m_PosX = 0;
        this.m_PosY = 0;
    }

    public void setType(int paramInt) {}

    public void updateData() {}
}
