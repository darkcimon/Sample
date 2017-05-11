package exam.AngryBirdBug;

import MyEngine.GameObject;
import MyEngine.myLog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import exam.anitest.SelectControl;
import exam.sound.NoSoundButton;
import exam.sound.SoundButton;

public class GameMenu
        extends GameObject
{
    NoSoundButton m_NoSoundButton;
    SelectControl m_SelectControl;
    SoundButton m_SoundButton;
    float m_scaleX;
    float m_scaleY;
    Rect mouse;
    Rect quit;
    Rect ranking;
    Rect sensor;
    Rect start;
    int touchX;
    int touchY;

    public GameMenu(Resources paramResources, int paramInt)
    {
        super(paramResources, paramInt);
        this.m_SelectControl = new SelectControl(BitmapFactory.decodeResource(paramResources, 2130837513));
        this.m_SoundButton = new SoundButton(BitmapFactory.decodeResource(paramResources, 2130837533));
        this.m_NoSoundButton = new NoSoundButton(BitmapFactory.decodeResource(paramResources, 2130837519));
    }

    public GameMenu(Bitmap paramBitmap)
    {
        super(paramBitmap);
        this.start = new Rect(302, 248, 485, 339);
        this.quit = new Rect(701, 382, 786, 466);
        this.mouse = new Rect(194, 403, 263, 472);
        this.sensor = new Rect(522, 402, 600, 472);
        this.ranking = new Rect(14, 383, 97, 373);
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.src = new Rect(0, 0, this.m_Img.getWidth(), this.m_Img.getHeight());
        this.dstF = new RectF(0.0F, 0.0F, this.m_Img.getWidth(), this.m_Img.getHeight());
        paramCanvas.drawBitmap(this.m_Img, this.src, this.dstF, null);
        this.m_SelectControl.drawImg(paramCanvas);
        this.m_SoundButton.drawImg(paramCanvas);
        this.m_NoSoundButton.drawImg(paramCanvas);
    }

    public void initData()
    {
        this.m_PosX = 0;
        this.m_PosY = 0;
        this.m_SelectControl.initData();
        this.m_SoundButton.initData();
        this.m_NoSoundButton.initData();
    }

    public void setTouch(int paramInt1, int paramInt2)
    {
        this.touchX = paramInt1;
        this.touchY = paramInt2;
        if (this.start.contains(paramInt1, paramInt2))
        {
            setTouch(0, 0);
            myLog.e("����  ��������...");
            AngryBirdBugActivity.game_state = 3;
            setTouch(0, 0);
        }
        if (this.quit.contains(paramInt1, paramInt2))
        {
            myLog.e("quit  ��������...");
            AngryBirdBugActivity.game_state = 5;
        }
        if (this.mouse.contains(paramInt1, paramInt2))
        {
            myLog.e("mouse  ��������...");
            AngryBirdBugActivity.game_control = 10;
        }
        if (this.sensor.contains(paramInt1, paramInt2))
        {
            myLog.e("sensor  ��������...");
            AngryBirdBugActivity.game_control = 11;
        }
        if (this.ranking.contains(paramInt1, paramInt2))
        {
            myLog.e("ranking  ��������...");
            AngryBirdBugActivity.game_control = 7;
        }
    }

    public void updateData()
    {
        this.m_SelectControl.updateData();
        this.m_SoundButton.updateData();
        this.m_NoSoundButton.updateData();
    }
}
