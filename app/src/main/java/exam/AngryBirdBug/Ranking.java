package exam.AngryBirdBug;

import MyEngine.FastView;
import MyEngine.GameObject;
import MyEngine.myLog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Ranking
        extends GameObject
{
    int count = 0;
    float m_scaleX;
    float m_scaleY;
    Paint paint = new Paint();
    Rect quit;
    String[] str = { "     ", "    " };
    int touchX;
    int touchY;

    public Ranking(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
    }

    public Ranking(Bitmap paramBitmap)
    {
        super(paramBitmap);
        this.quit = new Rect(481, 391, 536, 447);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(0.0F, 0.0F, this.m_Img.getWidth(), this.m_Img.getHeight());
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
        Object localObject = FastView.m_MyDBControl._openData();
        int i = 0;
        Object[] localObjectArr = {};
        if (localObject != null)
        {
            localObjectArr = ((String)localObject).split(" ");
            this.paint.setColor(Paint.DEV_KERN_TEXT_FLAG);
            this.paint.setTextSize(17.0F);
            paramCanvas.drawText("   ����           ����           ����      ����", 280.0F, 121.0F, this.paint);
            i = 0;
        }
        for (;;)
        {
            if (i >= localObjectArr.length / 3)
            {
                this.count = 0;
                return;
            }
            this.count += 1;
            int j = i * 3;
            if (this.count <= 12) {
                settingText(localObjectArr[j] + this.str[0] + localObjectArr[(j + 1)] + this.str[1] + localObjectArr[(j + 2)], i * 20 + 145, this.paint, paramCanvas);
            }
            i += 1;
        }
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
        if (this.quit.contains(paramInt1, paramInt2))
        {
            myLog.e("ranking quit  ��������...");
            AngryBirdBugActivity.game_state = 2;
        }
    }

    void settingText(String paramString, int paramInt, Paint paramPaint, Canvas paramCanvas)
    {
        paramPaint.setColor(Paint.DITHER_FLAG);
        paramPaint.setTextSize(18.0F);
        paramCanvas.drawText(paramString, 275.0F, paramInt, paramPaint);
    }

    public void updateData() {}
}
