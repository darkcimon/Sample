package exam.sound;

import MyEngine.GameObject;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import exam.AngryBirdBug.AngryBirdBugActivity;

public class NoSoundButton
        extends GameObject
{
    public NoSoundButton(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
    }

    public NoSoundButton(Bitmap paramBitmap)
    {
        super(paramBitmap);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.src.set(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(this.m_PosX, this.m_PosY, this.m_PosX + this.m_Img.getWidth(), this.m_PosY + this.m_Img.getHeight());
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
    }

    public void initData() {}

    public void updateData()
    {
        if (AngryBirdBugActivity.game_sound == 61) {
            setPos(25, 480);
        }
        if (AngryBirdBugActivity.game_sound == 62) {
            setPos(25, 290);
        }
    }
}
