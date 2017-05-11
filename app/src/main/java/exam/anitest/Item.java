package exam.anitest;

import MyEngine.Sprite;
import MyEngine.Sprite.SpriteData;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class Item
        extends Sprite
{
    public static final int ITEM_BIGBEE = 1;
    public static final int ITEM_MISSILE = 0;
    public static final int ITEM_RANDOM = 6;
    public static final int ITEM_REDFLOWER = 5;
    public static final int ITEM_ROUNDBUG = 2;
    public static final int ITEM_SPECIAL = 4;
    public static final int ITEM_WHITEFLOWER = 3;
    double[] CosTBL = new double['?'];
    double[] SinTBL = new double['?'];
    int angle = 0;
    int die;
    int dirX = 1;
    int dirY = 1;
    int endX = 0;
    int endY = 0;
    int goX = 1;
    int goY = 0;
    Bitmap itemImg;
    int range = 100;
    int type;

    public Item(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
        paramInt1 = 0;
        for (;;)
        {
            if (paramInt1 >= 360) {
                return;
            }
            this.SinTBL[paramInt1] = Math.sin(paramInt1 * 0.0174532925D);
            this.CosTBL[paramInt1] = Math.cos(paramInt1 * 0.0174532925D);
            paramInt1 += 1;
        }
    }

    void _moveFour()
    {
        this.m_PosX -= 1;
    }

    void _moveOne()
    {
        if (this.m_PosX <= 750)
        {
            if ((this.m_PosX <= 0) || (this.m_PosX + 50 >= 800)) {
                this.dirX *= -1;
            }
            if ((this.m_PosY <= 0) || (this.m_PosY + 50 >= 480)) {
                this.dirY *= -1;
            }
            if (this.goX == 1)
            {
                this.endX = (this.m_PosX - this.range * this.dirX);
                if (this.endX < 0) {
                    this.endX = 0;
                }
                if (this.endX + 50 > 800) {
                    this.endX = 750;
                }
                this.goX += 1;
            }
            if (this.goY == 1)
            {
                this.endY = (this.m_PosY - this.range * this.dirY);
                if (this.endY < 0) {
                    this.endY = 0;
                }
                if (this.endY + 50 > 480) {
                    this.endY = 430;
                }
                this.goY += 1;
            }
            if (this.m_PosX != this.endX)
            {
                this.m_PosX -= this.dirX;
                this.goY = 0;
                if (this.m_PosY == this.endY) {
                    break label278;
                }
                this.m_PosY -= this.dirY;
                this.goX = 0;
            }
        }
        label278:
        while (this.m_PosX <= 750)
        {
            for (;;)
            {
                return;
                this.goY += 1;
            }
            this.goX += 1;
            return;
        }
        this.m_PosX -= 10;
    }

    void _moveThree()
    {
        this.m_PosX -= this.dirX;
        this.m_PosY -= this.dirY;
        if ((this.m_PosX <= 0) && (this.dirX > 0)) {
            this.dirX *= -1;
        }
        if ((this.m_PosX + 50 >= 800) && (this.dirX < 0)) {
            this.dirX *= -1;
        }
        if ((this.m_PosY <= 0) || (this.m_PosY + 50 >= 480)) {
            this.dirY *= -1;
        }
    }

    void _moveTwo()
    {
        if (this.angle < 358)
        {
            this.angle += 1;
            if (this.angle % 5 == 0) {
                this.m_dPosX -= 1.0D;
            }
        }
        for (;;)
        {
            this.m_dPosX += (float)this.CosTBL[this.angle] * 3.0F;
            this.m_dPosY += (float)this.SinTBL[this.angle] * 3.0F;
            return;
            this.angle = 0;
        }
    }

    public void directX(int paramInt)
    {
        super.directX(paramInt);
    }

    public void directY(int paramInt)
    {
        super.directY(paramInt);
    }

    public void drawImg(Canvas paramCanvas)
    {
        super.drawImg(paramCanvas);
        switch (this.type)
        {
            default:
                paramCanvas.drawBitmap(this.m_Img, this.SrcRect[this.m_selectMotionNum][this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame], this.dst, null);
                return;
        }
        paramCanvas.drawBitmap(this.m_Img, this.SrcRect[this.m_selectMotionNum][this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame], this.dstF, null);
    }

    public int getDie()
    {
        return this.die;
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
            case 0:
                createSprite(0, 4, 0, 0, 47, 48, 10);
                return;
            case 1:
                createSprite(0, 4, 0, 48, 47, 48, 10);
                return;
            case 2:
                createSprite(0, 4, 0, 96, 47, 48, 10);
                return;
            case 3:
                createSprite(0, 4, 0, 144, 47, 48, 10);
                return;
            case 4:
                createSprite(0, 4, 0, 192, 47, 48, 10);
                return;
            case 5:
                createSprite(0, 4, 0, 240, 47, 48, 10);
                return;
        }
        createSprite(0, 4, 0, 288, 47, 48, 10);
    }

    public void setData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
        setMotioNum(paramInt3);
        setType(paramInt4);
        setDie(paramInt5);
        if ((paramInt4 == 3) || (paramInt4 == 4))
        {
            this.m_dPosX = paramInt1;
            this.m_dPosY = paramInt2;
            return;
        }
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

    public void setType(int paramInt)
    {
        this.type = paramInt;
    }

    public void updateData()
    {
        switch (this.type)
        {
        }
        int i;
        int j;
        for (;;)
        {
            i = this.m_SpriteData[this.m_selectMotionNum].m_spriteWidth;
            j = this.m_SpriteData[this.m_selectMotionNum].m_spriteHeight;
            switch (this.type)
            {
                default:
                    this.dst = new Rect(this.m_PosX, this.m_PosY, this.m_PosX + i, this.m_PosY + j);
                    this.dstF = new RectF(this.dst);
                    return;
                _moveThree();
                continue;
                _moveOne();
                continue;
                _moveTwo();
                continue;
                _moveFour();
            }
        }
        this.dstF = new RectF((float)this.m_dPosX, (float)this.m_dPosY, (float)this.m_dPosX + i, (float)this.m_dPosY + j);
    }
}
