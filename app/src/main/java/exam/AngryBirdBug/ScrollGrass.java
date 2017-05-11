package exam.AngryBirdBug;

import MyEngine.GameObject;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class ScrollGrass
        extends GameObject
{
    float m_scaleX;
    float m_scaleY;
    float posXF;
    float posYF;
    float speed = 2.4F;
    int type;

    public ScrollGrass(Bitmap paramBitmap)
    {
        super(paramBitmap);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.posXF -= this.speed;
        this.m_scaleX = (paramCanvas.getWidth() / 480.0F);
        this.m_scaleY = (paramCanvas.getHeight() / 320.0F);
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(this.posXF, this.posYF, this.posXF + this.m_Img.getWidth() * this.m_scaleX, this.posYF + this.m_Img.getHeight() * this.m_scaleY);
        if (this.posXF <= -this.m_Img.getWidth() * this.m_scaleX) {
            this.posXF = (this.m_Img.getWidth() * this.m_scaleX * 2.0F);
        }
        if (this.posXF <= -this.m_Img.getWidth() * this.m_scaleX) {
            this.posXF = (this.m_Img.getWidth() * this.m_scaleX * 2.0F);
        }
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
    }

    public void initData()
    {
        if (this.type == 0)
        {
            this.posXF = 0.0F;
            this.posYF = 435.0F;
        }
        if (this.type == 1)
        {
            this.posXF = 556.6666F;
            this.posYF = 435.0F;
        }
        if (this.type == 2)
        {
            this.posXF = 1113.3333F;
            this.posYF = 435.0F;
        }
        if (this.type == 3)
        {
            this.posXF = 1669.9999F;
            this.posYF = 435.0F;
        }
    }

    public void setType(int paramInt)
    {
        this.type = paramInt;
    }

    public void updateData() {}
}
