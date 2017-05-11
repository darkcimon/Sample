package exam.AngryBirdBug;

import MyEngine.FastView;
import MyEngine.GameObject;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class ScrollBack
        extends GameObject
{
    public static int Score;
    float m_scaleX;
    float m_scaleY;
    Paint paint = new Paint();
    float posXF;
    float posYF;
    float speed = 0.8F;
    int type;

    public ScrollBack(Bitmap paramBitmap)
    {
        super(paramBitmap);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.posXF -= this.speed;
        if (AngryBirdBugActivity.game_state == 3) {
            Score += 1;
        }
        this.m_scaleX = (paramCanvas.getWidth() / 480.0F);
        this.m_scaleY = (paramCanvas.getHeight() / 320.0F);
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(this.posXF, this.posYF, this.posXF + this.m_Img.getWidth() * this.m_scaleX, this.posYF + this.m_Img.getHeight() * this.m_scaleY);
        if (this.posXF <= -paramCanvas.getWidth()) {
            this.posXF = 799.0F;
        }
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
        this.paint.setTextSize(30.0F);
        this.paint.setColor(-12303292);
        this.paint.setAntiAlias(true);
        paramCanvas.drawText("SCORE : " + Score, 0.0F, 30.0F, this.paint);
        paramCanvas.drawText("LEVEL : " + FastView.level, 650.0F, 30.0F, this.paint);
    }

    public void initData()
    {
        if (this.type == 0)
        {
            setPos(0, 182);
            this.posXF = 0.0F;
            this.posYF = 182.0F;
        }
        if (this.type == 1)
        {
            setPos(785, 182);
            this.posXF = 799.0F;
            this.posYF = 182.0F;
        }
    }

    public void setType(int paramInt)
    {
        this.type = paramInt;
    }

    public void updateData() {}
}
