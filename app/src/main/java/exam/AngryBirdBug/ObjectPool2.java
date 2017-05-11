package exam.AngryBirdBug;

import MyEngine.myLog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import exam.anitest.Effect;
import java.util.ArrayList;

public class ObjectPool2
{
    public static final int MOB_PIG1 = 0;
    public static final int MOB_PIG2 = 1;
    Bitmap FeatherImg;
    ArrayList<Effect> arEffect;
    public ArrayList<Feather> arFeather;
    ArrayList<Pig> arPig;
    Bitmap effectImg;
    Bitmap pigImg;
    Resources res;
    Pig localPig;

    public ObjectPool2(Resources paramResources)
    {
        this.res = paramResources;
        this.arPig = new ArrayList();
        this.arEffect = new ArrayList();
        this.arFeather = new ArrayList();
        this.pigImg = BitmapFactory.decodeResource(paramResources, 2130837528);
        this.effectImg = BitmapFactory.decodeResource(paramResources, 2130837508);
        this.FeatherImg = BitmapFactory.decodeResource(paramResources, 2130837509);
    }

    public void SetObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
        switch (paramInt1)
        {
            default:
                localPig = new Pig(this.pigImg, 1, 3);
                this.arPig.add(localPig);
                localPig.setType(1);
                localPig.initData();
                localPig.setPos(paramInt2, paramInt3);
                localPig.setMotioNum(paramInt4);
                localPig.setHp(paramInt5);
                localPig.setMp(paramInt6);
                localPig.setShow(paramBoolean);
                return;
            case 0:
                localPig = new Pig(this.pigImg, 1, 3);
                this.arPig.add(localPig);
                localPig.setType(0);
                localPig.initData();
                localPig.setPos(paramInt2, paramInt3);
                localPig.setMotioNum(paramInt4);
                localPig.setHp(paramInt5);
                localPig.setMp(paramInt6);
                localPig.setShow(paramBoolean);
                return;
        }

    }

    public void _addEffectObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
        myLog.e("IMG NUM= " + this.effectImg);
        Effect localEffect = new Effect(this.effectImg, 1, 5);
        localEffect.setData(paramInt1, paramInt2, paramInt3, paramInt6);
        localEffect.initData();
        localEffect.setEffectDieTime(System.currentTimeMillis() + 1000L);
        this.arEffect.add(localEffect);
    }

    public void createFeather(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        Feather localFeather = new Feather(this.FeatherImg, 1, 9);
        localFeather.setData(paramInt1, paramInt2, paramInt3, paramInt4);
        localFeather.initData();
        localFeather.setPos(paramInt1, paramInt2);
        this.arFeather.add(localFeather);
    }

    public void createObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
        switch (paramInt1)
        {
            default:
                localPig = new Pig(this.pigImg, 1, 3);
                this.arPig.add(localPig);
                localPig.setType(1);
                localPig.initData();
                localPig.setPos(paramInt2, paramInt3);
                localPig.setMotioNum(paramInt4);
                localPig.setHp(paramInt5);
                localPig.setMp(paramInt6);
                localPig.setDie(paramInt7);
                return;
            case 0:
                localPig = new Pig(this.pigImg, 1, 3);
                this.arPig.add(localPig);
                localPig.setType(0);
                localPig.initData();
                localPig.setPos(paramInt2, paramInt3);
                localPig.setMotioNum(paramInt4);
                localPig.setHp(paramInt5);
                localPig.setMp(paramInt6);
                localPig.setDie(paramInt7);
                return;
        }

    }

    public void drawImg(Canvas paramCanvas)
    {
        int i = 0;
        if (i >= this.arPig.size())
        {
            i = 0;
            label15:
            if (i < this.arEffect.size()) {
                return;
            }
            i = 0;
        }
        for (;;)
        {
            if (i >= this.arFeather.size())
            {
//                return;
                ((Pig)this.arPig.get(i)).drawImg(paramCanvas);
                i += 1;
//                break;
                label62:
                ((Effect)this.arEffect.get(i)).drawImg(paramCanvas);
                i += 1;
                return;
            }
            ((Feather)this.arFeather.get(i)).drawImg(paramCanvas);
            i += 1;
        }
    }

    public RectF getarEffectRectF(int paramInt)
    {
        return ((Effect)this.arEffect.get(paramInt)).getRectF();
    }

    public int getarEffectSize()
    {
        return this.arEffect.size();
    }

    public RectF getarFeatherRectF(int paramInt)
    {
        return ((Feather)this.arFeather.get(paramInt)).getRectF();
    }

    public int getarFeatherSize()
    {
        return this.arFeather.size();
    }

    public RectF getarPigRectF(int paramInt)
    {
        return ((Pig)this.arPig.get(paramInt)).getRectF();
    }

    public int getarPigSize()
    {
        return this.arPig.size();
    }

    public int getarPigType(int paramInt)
    {
        return ((Pig)this.arPig.get(paramInt)).type;
    }

    public void initData()
    {
        int i = 0;
        if (i >= this.arPig.size())
        {
            i = 0;
            label15:
            if (i < this.arEffect.size()) {
                return;
            }
            i = 0;
        }
        for (;;)
        {
            if (i >= this.arFeather.size())
            {
//                return;
                ((Pig)this.arPig.get(i)).initData();
                i += 1;
//                break;
                label61:
                ((Effect)this.arEffect.get(i)).initData();
                i += 1;
                return;
            }
            ((Feather)this.arFeather.get(i)).initData();
            i += 1;
        }
    }

    public void resetData()
    {
        this.arPig.clear();
        this.arEffect.clear();
        this.arFeather.clear();
    }

    public void setEffectDie(int paramInt)
    {
        ((Effect)this.arEffect.get(paramInt)).setDie(0);
    }

    public void setFeatherDie(int paramInt)
    {
        ((Feather)this.arFeather.get(paramInt)).setDie(0);
    }

    public void setPigDie(int paramInt)
    {
        ((Pig)this.arPig.get(paramInt)).setDie(0);
    }

    public void updateData()
    {
        int i = 0;
        if (i >= this.arPig.size())
        {
            i = 0;
            label15:
            if (i < this.arPig.size()) {
                return;
            }
            i = 0;
            label28:
            if (i < this.arEffect.size()) {
                return;
            }
            i = 0;
            label41:
            if (i < this.arEffect.size()) {
                return;
            }
            i = 0;
            label54:
            if (i < this.arFeather.size()) {
                return;
            }
            i = 0;
            label67:
            if (i < this.arFeather.size()) {
                return;
            }
            i = 0;
        }
        for (;;)
        {
            if (i >= this.arFeather.size())
            {
//                return;
                ((Pig)this.arPig.get(i)).updateData();
                i += 1;
//                break;
                label113:
                if (((Pig)this.arPig.get(i)).getDie() == 0)
                {
                    myLog.e("DIE MOB");
                    this.arPig.remove(i);
                }
                i += 1;
//                break;
                label151:
                ((Effect)this.arEffect.get(i)).updateData();
                i += 1;
//                break;
                label172:
                if (((Effect)this.arEffect.get(i)).getDie() == 0)
                {
                    myLog.e("DIE EFFECT");
                    this.arEffect.remove(i);
                }
                i += 1;
//                break;
                label210:
                ((Feather)this.arFeather.get(i)).updateData();
                i += 1;
//                break;
                label231:
                if (((Feather)this.arFeather.get(i)).getDie() == 0)
                {
                    myLog.e("DIE FEATHER");
                    this.arFeather.remove(i);
                }
                i += 1;
                break;
            }
            if (((Feather)this.arFeather.get(i)).GetX() == -50)
            {
                myLog.e("DIE FEATHER");
                this.arFeather.remove(i);
            }
            i += 1;
        }
    }
}
