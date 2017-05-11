package exam.AngryBirdBug;

import MyEngine.GameObject;
import MyEngine.myLog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class GameTitle
        extends GameObject
{
    float m_scaleX;
    float m_scaleY;
    Rect next;
    Paint paint = new Paint();
    int touchX;
    int touchY;

    public GameTitle(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
    }

    public GameTitle(Bitmap paramBitmap)
    {
        super(paramBitmap);
        this.next = new Rect(0, 0, 800, 480);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.m_scaleX = (paramCanvas.getWidth() / 527.0F);
        this.m_scaleY = (paramCanvas.getHeight() / 292.0F);
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(0.0F, 0.0F, this.m_Img.getWidth() * this.m_scaleX, this.m_Img.getHeight() * this.m_scaleY);
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
    }

    public void initData()
    {
        this.m_PosX = 0;
        this.m_PosY = 0;
    }

    public void setTouch(int paramInt1, int paramInt2)
    {
        this.touchX = paramInt1;
        this.touchY = paramInt2;
        myLog.e("title����  ��������...");
        AngryBirdBugActivity.game_state = 2;
    }

    public void setType(int paramInt) {}

    public void updateData() {}
}
