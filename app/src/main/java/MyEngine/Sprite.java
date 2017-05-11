package MyEngine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import java.lang.reflect.Array;

public class Sprite
        extends GameObject
{
    protected Rect[][] SrcRect;
    protected int m_MotiontNum;
    protected int m_MotiontNumFrame = 0;
    protected SpriteData[] m_SpriteData;
    protected int m_TotalFrame = 0;
    protected int m_TotalMotionNum;
    protected int m_selectMotionNum = 0;

    public Sprite(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap);
        this.m_TotalMotionNum = paramInt1;
        this.m_TotalFrame = paramInt2;
        this.SrcRect = ((Rect[][])Array.newInstance(Rect.class, new int[] { paramInt1, paramInt2 }));
        this.m_SpriteData = new SpriteData[paramInt1];
    }

    public void _animationSprite(long paramLong)
    {
        if (this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame < this.m_SpriteData[this.m_selectMotionNum].m_EndMotionNumFrame - 1)
        {
            if (paramLong >= this.m_SpriteData[this.m_selectMotionNum].m_AniCheck + 1000 / this.m_SpriteData[this.m_selectMotionNum].m_AniSpeed)
            {
                SpriteData localSpriteData = this.m_SpriteData[this.m_selectMotionNum];
                localSpriteData.m_CurrentFrame += 1;
                this.m_SpriteData[this.m_selectMotionNum].m_AniCheck = paramLong;
            }
            return;
        }
        this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame = 0;
    }

    public void createSprite(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
        if (paramInt1 >= this.m_TotalMotionNum)
        {
            myLog.e("������ ���� ����");
            myLog.e("������ m_MotionNum= " + paramInt1, "m_TotalMotionNum= " + this.m_TotalMotionNum);
        }
        for (;;)
        {
//            return;
            if (paramInt2 > this.m_TotalFrame)
            {
                myLog.e("");
                myLog.e("m_MotionNumFrame= " + paramInt2 , " m_TotalFrame= "+ this.m_TotalFrame);
                return;
            }
            if ((paramInt1 >= 0) && (paramInt2 >= 0))
            {
//                this.m_MotiontNum = paramInt1;
//                this.m_MotiontNumFrame = paramInt2;
                this.m_SpriteData[paramInt1] = new SpriteData(paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
                paramInt3 = 0;
                while (paramInt3 < paramInt2)
                {
                    paramInt4 = this.m_SpriteData[paramInt1].m_spriteLeft + this.m_SpriteData[paramInt1].m_spriteWidth * paramInt3;
                    paramInt5 = this.m_SpriteData[paramInt1].m_spriteTop;
                    this.SrcRect[paramInt1][paramInt3] = new Rect(paramInt4, paramInt5, this.m_SpriteData[paramInt1].m_spriteWidth + paramInt4, this.m_SpriteData[paramInt1].m_spriteHeight + paramInt5);
                    paramInt3 += 1;
                }
            }
        }
    }

    public void directX(int paramInt)
    {
        this.m_PosX += paramInt;
    }

    public void directY(int paramInt)
    {
        this.m_PosY += paramInt;
    }

    public void drawImg(Canvas paramCanvas)
    {
        _animationSprite(System.currentTimeMillis());
    }

    public void initData() {}

    public void setMotioNum(int paramInt)
    {
        if (this.m_TotalMotionNum >= paramInt)
        {
            this.m_selectMotionNum = paramInt;
            return;
        }
        myLog.e("������ ���� ����");
    }

    public void updateData() {}

    protected class SpriteData
    {
        public long m_AniCheck;
        public int m_AniSpeed;
        public int m_CurrentFrame;
        public int m_EndMotionNumFrame;
        public int m_spriteHeight;
        public int m_spriteLeft;
        public int m_spriteTop;
        public int m_spriteWidth;

        public SpriteData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
            this.m_spriteLeft = paramInt1;
            this.m_spriteTop = paramInt2;
            this.m_spriteWidth = paramInt3;
            this.m_spriteHeight = paramInt4;
            this.m_AniSpeed = paramInt5;
            this.m_CurrentFrame = 0;
            this.m_AniCheck = 0L;
            this.m_EndMotionNumFrame = Sprite.this.m_MotiontNumFrame;
        }
    }
}
