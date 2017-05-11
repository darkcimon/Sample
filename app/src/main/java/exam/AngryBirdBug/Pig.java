package exam.AngryBirdBug;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class Pig
        extends Mob
{
    int LeftEnd = 0;
    int RightEnd = 0;
    int dx = 2;
    int dy = 2;

    public Pig(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
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
        if (this.type == 0) {
            createSprite(0, 3, 0, 0, 48, 46, 1);
        }
        if (this.type == 1) {
            createSprite(0, 3, 0, 47, 48, 46, 1);
        }
    }

    public void initPos(int paramInt1, int paramInt2, int paramInt3)
    {
        setPos(paramInt1, paramInt2);
        this.RightEnd = (GetX() + 47);
        this.LeftEnd = (GetX() - 47);
        this.direct = paramInt3;
    }

    public void setType(int paramInt)
    {
        this.type = paramInt;
    }

    public void updateData()
    {
        if (this.type == 0)
        {
            this.m_PosX -= this.direct;
            if ((this.m_PosX <= this.RightEnd) && (this.m_PosX == this.RightEnd)) {
                this.direct *= -1;
            }
            if ((this.m_PosX <= this.LeftEnd) && (this.m_PosX == this.LeftEnd)) {
                this.direct *= -1;
            }
        }
        if (this.type == 1)
        {
            if (this.m_PosX > 750) {
                this.m_PosX -= this.direct;
            }
            this.m_PosX -= this.dx;
            this.m_PosY -= this.dy;
            if ((this.m_PosX <= 0) || (this.m_PosX >= 750)) {
                this.dx *= -1;
            }
            if ((this.m_PosY <= 0) || (this.m_PosY >= 430)) {
                this.dy *= -1;
            }
        }
    }
}
