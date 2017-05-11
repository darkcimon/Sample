package exam.AngryBirdBug;

import MyEngine.Sprite;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Mob
        extends Sprite
{
    public static final int MOB_PIG1 = 0;
    public static final int MOB_PIG2 = 1;
    int die = 1;
    int direct = 2;
    int hp;
    int mp;
    boolean show;
    int type;

    public Mob(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
        super(paramBitmap, paramInt1, paramInt2);
    }

    public void drawImg(Canvas paramCanvas)
    {
        super.drawImg(paramCanvas);
    }

    public void initData() {}

    public void initPos(int paramInt1, int paramInt2, int paramInt3) {}

    public void move(Rect paramRect) {}

    public void setDie(int paramInt)
    {
        this.die = paramInt;
    }

    public void setHp(int paramInt)
    {
        this.hp = paramInt;
    }

    public void setMp(int paramInt)
    {
        this.mp = paramInt;
    }

    public void setShow(boolean paramBoolean)
    {
        this.show = paramBoolean;
    }

    public void setType(int paramInt) {}

    public void updateData() {}
}
