package exam.anitest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import MyEngine.Sprite;

public class Effect
        extends Sprite
{
    long EffectDieTime;
    int die;

    public Effect(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
    }

    public boolean dieTimeOut(long paramLong)
    {
        return paramLong >= this.EffectDieTime;
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

    public long getEffectDieTime()
    {
        return this.EffectDieTime;
    }

    public RectF getRectF()
    {
        return new RectF(this.dst);
    }

    public void initData()
    {
        createSprite(0, 5, 0, 0, 63, 62, 5);
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

    public void setEffectDieTime(long paramLong)
    {
        this.EffectDieTime = paramLong;
    }

    public void setMotioNum(int paramInt)
    {
        super.setMotioNum(paramInt);
    }

    public void updateData()
    {
        if (dieTimeOut(System.currentTimeMillis())) {
            setDie(0);
        }
    }
}
