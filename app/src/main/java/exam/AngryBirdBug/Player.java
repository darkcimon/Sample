package exam.AngryBirdBug;

import MyEngine.Sprite;
import MyEngine.Sprite.SpriteData;
import MyEngine.myLog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class Player
        extends Sprite
{
    public Player(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
        myLog.e("Player=  " + paramBitmap, "Player");
    }

    public void drawImg(Canvas paramCanvas)
    {
        super.drawImg(paramCanvas);
        int i = this.m_SpriteData[this.m_selectMotionNum].m_spriteWidth;
        int j = this.m_SpriteData[this.m_selectMotionNum].m_spriteHeight;
        this.dst = new Rect(this.m_PosX, this.m_PosY, this.m_PosX + i, this.m_PosY + j);
        paramCanvas.drawBitmap(this.m_Img, this.SrcRect[this.m_selectMotionNum][this.m_SpriteData[this.m_selectMotionNum].m_CurrentFrame], this.dst, null);
        if (AngryBirdBugActivity.SensorX >= paramCanvas.getWidth()) {
            AngryBirdBugActivity.SensorX = paramCanvas.getWidth();
        }
        if (AngryBirdBugActivity.SensorX <= 0.0F) {
            AngryBirdBugActivity.SensorX = 0.0F;
        }
        if (AngryBirdBugActivity.SensorY >= paramCanvas.getHeight()) {
            AngryBirdBugActivity.SensorY = paramCanvas.getHeight();
        }
        if (AngryBirdBugActivity.SensorY <= 0.0F) {
            AngryBirdBugActivity.SensorY = 0.0F;
        }
    }

    public Rect getPlayerRect()
    {
        return this.dst;
    }

    public RectF getPlayerRectF()
    {
        return new RectF(this.dst);
    }

    public void initData()
    {
        createSprite(0, 3, 0, 0, 48, 45, 1);
        createSprite(1, 3, 0, 45, 48, 45, 1);
    }

    public void setMove(float paramFloat1, float paramFloat2)
    {
        int i = this.m_SpriteData[this.m_selectMotionNum].m_spriteWidth;
        int j = this.m_SpriteData[this.m_selectMotionNum].m_spriteHeight;
        if (paramFloat1 > this.m_PosX + i)
        {
            this.m_selectMotionNum = 0;
            directX((int)((paramFloat1 - (this.m_PosX + i)) * 0.02D) + 2);
        }
        do
        {
            while (paramFloat2 > this.m_PosY + j)
            {
                directY((int)((paramFloat2 - (this.m_PosY + j)) * 0.02D) + 2);
                return;
                if (paramFloat1 < this.m_PosX)
                {
                    this.m_selectMotionNum = 1;
                    directX((int)((this.m_PosX - paramFloat1) * -0.02D) - 2);
                }
            }
        } while (paramFloat2 >= this.m_PosY);
        directY((int)((this.m_PosY - paramFloat2) * -0.02D) - 2);
    }

    public void updateData()
    {
        AngryBirdBugActivity.SensorX += -0.5F * AngryBirdBugActivity.X;
        AngryBirdBugActivity.SensorY += 0.5F * AngryBirdBugActivity.Y;
    }
}
