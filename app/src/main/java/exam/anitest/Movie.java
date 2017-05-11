package exam.anitest;

import MyEngine.GameObject;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Movie
        extends GameObject
{
    int count = 0;
    long endTime = 0L;
    Bitmap[] img = new Bitmap[7];
    int index = -1;
    float m_scaleX;
    float m_scaleY;
    Rect next;
    String[] test = { " ", "���� ���� �� ��~ �� ��~ ����������", "��  ����  ����  ����  ����������  ������ ������", "����: RIO���� ������ �������� ��������~~", "������ �������� 100,000$�� �������� ������", "���� ������~ ������ ���� ������ ������...", "����~~  ��������  ����  ������ ��������!!", "������ ���� ����������~  ���� ����������~~" };
    int textSpeed = 0;
    long textSpeedEnd = 0L;
    int touchX;
    int touchY;

    public Movie(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
        this.img[0] = BitmapFactory.decodeResource(paramResources, 2130837520);
        this.img[1] = BitmapFactory.decodeResource(paramResources, 2130837521);
        this.img[2] = BitmapFactory.decodeResource(paramResources, 2130837522);
        this.img[3] = BitmapFactory.decodeResource(paramResources, 2130837523);
        this.img[4] = BitmapFactory.decodeResource(paramResources, 2130837524);
        this.img[5] = BitmapFactory.decodeResource(paramResources, 2130837525);
        this.img[6] = BitmapFactory.decodeResource(paramResources, 2130837526);
        this.next = new Rect(0, 0, 800, 680);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.m_scaleX = (paramCanvas.getWidth() / 489.0F);
        this.m_scaleY = (paramCanvas.getHeight() / 323.0F);
        paramCanvas.drawColor(-16777216);
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(0.0F, 0.0F, this.m_Img.getWidth() * this.m_scaleX, this.m_Img.getHeight() * this.m_scaleY);
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
        Paint localPaint = new Paint();
        localPaint.setColor(-1);
        localPaint.setTextSize(30.0F);
        paramCanvas.drawText(this.test[(this.index + 1)].substring(0, this.textSpeed), 100.0F, 470.0F, localPaint);
    }

    public void initData() {}

    public void movieTime(long paramLong)
    {
        if (paramLong >= this.textSpeedEnd + 200L)
        {
            if (this.textSpeed < this.test[(this.index + 1)].length()) {
                this.textSpeed += 1;
            }
            this.textSpeedEnd = paramLong;
        }
        if (paramLong >= this.endTime + 8000L)
        {
            if (this.index >= 6) {
                break label105;
            }
            this.index += 1;
            this.textSpeed = 0;
            this.m_Img = this.img[this.index];
            this.endTime = paramLong;
        }
        label105:
        while (this.index < 6) {
            return;
        }
        exam.AngryBirdBug.AngryBirdBugActivity.game_state = 1;
    }

    public void setTouch(int paramInt1, int paramInt2)
    {
        this.touchX = paramInt1;
        this.touchY = paramInt2;
    }

    public void updateData() {}
}
