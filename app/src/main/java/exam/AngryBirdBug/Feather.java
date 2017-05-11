package exam.AngryBirdBug;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import MyEngine.Sprite;

public class Feather
        extends Sprite
{
    int Xspeed;
    float Xspeedf = 2.4F;
    int Yspeed;
    int die;
    float m_scaleX;
    float m_scaleY;

    public Feather(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
    }

    public void SetFeatherSpeedX(int paramInt)
    {
        this.Xspeed = paramInt;
    }

    public void SetFeatherSpeedY(int paramInt)
    {
        this.Yspeed = paramInt;
    }

    public void drawImg(Canvas paramCanvas)
    {
        super.drawImg(paramCanvas);
        int i = this.m_SpriteData[this.m_selectMotionNum].m_spriteWidth;
        int j = this.m_SpriteData[this.m_selectMotionNum].m_spriteHeight;
        this.dst = new Rect(this.m_PosX, this.m_PosY, this.m_PosX + i, this.m_PosY + j);
        paramCanvas.drawBitmap(this.m_Img, this.SrcRect[this.m_selectMotionNum][this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame], this.dst, null);
    }

    public int getDie()
    {
        return this.die;
    }

    public RectF getRectF()
    {
        return new RectF(this.dst);
    }

    public void initData()
    {
        createSprite(0, 9, 0, 0, 13, 33, 30);
    }

    public void setData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        setMotioNum(paramInt3);
        this.die = paramInt4;
        setPos(paramInt1, paramInt2);
    }

    public void setDie(int paramInt)
    {
        this.die = paramInt;
    }

    public void setMotioNum(int paramInt)
    {
        super.setMotioNum(paramInt);
    }

    public void updateData()
    {
        if (this.m_PosY <= 450)
        {
            this.m_PosX = ((int)(this.m_PosX + (this.Xspeed * 0.007D - 1.0D)));
            this.m_PosY = ((int)(this.m_PosY + (this.Yspeed * 0.007D + 1.5D)));
        }
        if ((this.m_PosY >= 450) || (this.m_PosX <= 0)) {
            this.m_PosX = ((int)(this.m_PosX - this.Xspeedf));
        }
    }
}
