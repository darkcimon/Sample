package exam.anitest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import MyEngine.Sprite;

public class Attack
        extends Sprite
{
    public static final int ATTACK_BIGBEE = 51;
    public static final int ATTACK_MISSILE = 50;
    public static final int ATTACK_RANDOM = 56;
    public static final int ATTACK_REDFLOWER = 55;
    public static final int ATTACK_ROUNDBUG = 52;
    public static final int ATTACK_SPECIAL = 54;
    public static final int ATTACK_WHITEFLOWER = 53;
    int die;
    public long dieTime;
    int dirX = 1;
    int dirY = 1;
    int type;

    public Attack(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
    }

    public boolean dieTimeOut(long paramLong)
    {
        return paramLong >= this.dieTime;
    }

    public void drawImg(Canvas paramCanvas)
    {
        super.drawImg(paramCanvas);
        paramCanvas.drawBitmap(this.m_Img, this.SrcRect[this.m_selectMotionNum][this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame], this.dst, null);
    }

    public int getDie()
    {
        return this.die;
    }

    public long getDieTime()
    {
        return this.dieTime;
    }

    public RectF getRectF()
    {
        return new RectF(this.dst);
    }

    public int getType()
    {
        return this.type;
    }

    public void initData()
    {
        switch (this.type)
        {
            default:
                return;
            case 50:
                createSprite(0, 4, 0, 0, 30, 30, 30);
                return;
            case 51:
                createSprite(0, 2, 0, 80, 84, 82, 50);
                return;
            case 52:
                createSprite(0, 4, 0, 380, 80, 80, 30);
                return;
            case 53:
                createSprite(0, 4, 0, 299, 77, 75, 30);
                return;
            case 54:
                createSprite(0, 2, 0, 30, 52, 48, 50);
                return;
        }
//        createSprite(0, 3, 0, 162, 139, 138, 40);
    }

    public void setData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
        setMotioNum(paramInt3);
        this.type = paramInt4;
        this.die = paramInt5;
        setPos(paramInt1, paramInt2);
    }

    public void setDie(int paramInt)
    {
        this.die = paramInt;
    }

    public void setDieTime(long paramLong)
    {
        this.dieTime = paramLong;
    }

    public void updateData()
    {
        switch (this.type)
        {
        }
        for (;;)
        {
            int i = this.m_SpriteData[this.m_selectMotionNum].m_spriteWidth;
            int j = this.m_SpriteData[this.m_selectMotionNum].m_spriteHeight;
            this.dst = new Rect(this.m_PosX, this.m_PosY, this.m_PosX + i, this.m_PosY + j);
//            return;
            this.m_PosX += 1;
            if (this.m_PosX > 850)
            {
                setDie(0);
//                continue;
                this.m_PosX += 10;
                if (this.m_PosX > 850)
                {
                    setDie(0);
//                    continue;
                    this.m_PosX += 20;
                    if (this.m_PosX > 850)
                    {
                        setDie(0);
//                        continue;
                        if (dieTimeOut(System.currentTimeMillis()))
                        {
                            setDie(0);
//                            continue;
                            if (dieTimeOut(System.currentTimeMillis())) {
                                setDie(0);
                            }
                            this.m_PosX -= this.dirX;
                            this.m_PosY -= this.dirY;
                            if ((this.m_PosX <= 0) && (this.dirX > 0)) {
                                this.dirX *= -1;
                            }
                            if ((this.m_PosX + 50 >= 800) && (this.dirX < 0)) {
                                this.dirX *= -1;
                            }
                            if ((this.m_PosY <= 0) || (this.m_PosY + 50 >= 480))
                            {
                                this.dirY *= -1;
//                                continue;
                                if (dieTimeOut(System.currentTimeMillis())) {
                                    setDie(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
