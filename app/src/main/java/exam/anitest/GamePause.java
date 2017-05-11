package exam.anitest;

import MyEngine.GameObject;
import MyEngine.myLog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class GamePause
        extends GameObject
{
    Rect quit = new Rect(430, 175, 540, 280);
    Rect reStart = new Rect(260, 175, 370, 280);
    int touchX;
    int touchY;

    public GamePause(Bitmap paramBitmap)
    {
        super(paramBitmap);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.m_PosX = 250;
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dst = new Rect(this.m_PosX, this.m_PosY, this.m_PosX + this.m_Img.getWidth(), this.m_PosY + this.m_Img.getHeight());
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dst, null);
    }

    public void initData() {}

    public void setTouch(int paramInt1, int paramInt2)
    {
        this.touchX = paramInt1;
        this.touchY = paramInt2;
    }

    public void updateData()
    {
        if (this.reStart.contains(this.touchX, this.touchY))
        {
            myLog.e("reStart  ��������...");
            exam.AngryBirdBug.AngryBirdBugActivity.game_state = 3;
        }
        if (this.quit.contains(this.touchX, this.touchY))
        {
            myLog.e("quit  ��������...");
            exam.AngryBirdBug.AngryBirdBugActivity.game_state = 2;
        }
    }
}
