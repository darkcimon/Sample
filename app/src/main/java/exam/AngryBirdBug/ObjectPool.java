package exam.AngryBirdBug;

import MyEngine.myLog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import exam.anitest.Attack;
import exam.anitest.Item;
import java.util.ArrayList;
import java.util.Random;

public class ObjectPool
{
    Bitmap attackImg;
    Bitmap itemImg;
    Back m_Back;
    Back m_Back1;
    BackCloud m_BackCloud;
    BackCloud m_BackCloud2;
    BackCloud m_BackCloud3;
    ScrollBack m_ScrollBack;
    ScrollBack m_ScrollBack2;
    ScrollGrass m_ScrollGrass;
    ScrollGrass m_ScrollGrass2;
    ScrollGrass m_ScrollGrass3;
    ScrollGrass m_ScrollGrass4;
    ScrollLongGrass m_ScrollLongGrass;
    ScrollLongGrass m_ScrollLongGrass2;
    ScrollLongGrass m_ScrollLongGrass3;
    ArrayList<Attack> m_arAttack;
    ArrayList<Item> m_arItem;
    Random r = new Random();
    Resources res;

    public ObjectPool(Resources paramResources)
    {
        this.res = paramResources;
        initBackRes();
        initBackRes2();
        this.m_arItem = new ArrayList();
        this.m_arAttack = new ArrayList();
        this.attackImg = BitmapFactory.decodeResource(paramResources, 2130837504);
        this.itemImg = BitmapFactory.decodeResource(paramResources, 2130837517);
    }

    public void SetObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {}

    void _addAttackObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
        myLog.e("IMG NUM= " + this.attackImg);
        Attack localAttack = new Attack(this.attackImg, 1, 4);
        localAttack.setData(paramInt2, paramInt3, paramInt4, paramInt1, paramInt7);
        localAttack.initData();
        if (paramInt1 == 55) {
            localAttack.setDieTime(System.currentTimeMillis() + 5000L);
        }
        if (paramInt1 == 53) {
            localAttack.setDieTime(System.currentTimeMillis() + 15000L);
        }
        if (paramInt1 == 52) {
            localAttack.setDieTime(System.currentTimeMillis() + 10000L);
        }
        this.m_arAttack.add(localAttack);
    }

    void _addItemObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
        myLog.e("ITEM_IMG NUM= " + this.itemImg);
        Item localItem = new Item(this.itemImg, 1, 4);
        localItem.setData(paramInt2, paramInt3, paramInt4, paramInt1, paramInt7);
        localItem.initData();
        this.m_arItem.add(localItem);
    }

    public void backInit()
    {
        this.m_Back.initData();
        this.m_ScrollBack.initData();
        this.m_ScrollBack2.initData();
        this.m_BackCloud.initData();
        this.m_BackCloud2.initData();
        this.m_BackCloud3.initData();
        this.m_BackCloud.setPos(400, 70);
        this.m_BackCloud2.setPos(200, 170);
        this.m_BackCloud3.setPos(600, 230);
        this.m_ScrollLongGrass.initData();
        this.m_ScrollLongGrass2.initData();
        this.m_ScrollLongGrass3.initData();
        this.m_ScrollGrass.initData();
        this.m_ScrollGrass2.initData();
        this.m_ScrollGrass3.initData();
        this.m_ScrollGrass4.initData();
    }

    public void backUpdate()
    {
        this.m_Back.updateData();
        this.m_ScrollBack.updateData();
        this.m_ScrollBack2.updateData();
        this.m_BackCloud.updateData();
        this.m_BackCloud2.updateData();
        this.m_BackCloud3.updateData();
        this.m_ScrollLongGrass.updateData();
        this.m_ScrollLongGrass2.updateData();
        this.m_ScrollLongGrass3.updateData();
        this.m_ScrollGrass.updateData();
        this.m_ScrollGrass2.updateData();
        this.m_ScrollGrass3.updateData();
        this.m_ScrollGrass4.updateData();
    }

    public void createObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
        myLog.e("creteObject");
        switch (paramInt1)
        {
            default:
                switch (paramInt1)
                {
                }
                break;
        }
        for (;;)
        {
            myLog.e("CREATE TYPE=  " + paramInt1);
//            return;
            _addAttackObject(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
            break;
//            _addItemObject(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
        }
    }

    public void drawImg(Canvas paramCanvas)
    {
        this.m_Back.drawImg(paramCanvas);
        this.m_ScrollBack.drawImg(paramCanvas);
        this.m_ScrollBack2.drawImg(paramCanvas);
        this.m_BackCloud.drawImg(paramCanvas);
        this.m_BackCloud2.drawImg(paramCanvas);
        this.m_BackCloud3.drawImg(paramCanvas);
        this.m_ScrollLongGrass.drawImg(paramCanvas);
        this.m_ScrollLongGrass2.drawImg(paramCanvas);
        this.m_ScrollLongGrass3.drawImg(paramCanvas);
        this.m_ScrollGrass.drawImg(paramCanvas);
        this.m_ScrollGrass2.drawImg(paramCanvas);
        this.m_ScrollGrass3.drawImg(paramCanvas);
        this.m_ScrollGrass4.drawImg(paramCanvas);
        int i = 0;
        if (i >= this.m_arItem.size()) {
            i = 0;
        }
        for (;;)
        {
            if (i >= this.m_arAttack.size())
            {
//                return;
                ((Item)this.m_arItem.get(i)).drawImg(paramCanvas);
                i += 1;
                break;
            }
            ((Attack)this.m_arAttack.get(i)).drawImg(paramCanvas);
            i += 1;
        }
    }

    public int getItemType(int paramInt)
    {
        return ((Item)this.m_arItem.get(paramInt)).getType();
    }

    public RectF getarAttackRectF(int paramInt)
    {
        return ((Attack)this.m_arAttack.get(paramInt)).getRectF();
    }

    public int getarAttackSize()
    {
        return this.m_arAttack.size();
    }

    public RectF getarItemRectF(int paramInt)
    {
        return ((Item)this.m_arItem.get(paramInt)).getRectF();
    }

    public int getarItemSize()
    {
        return this.m_arItem.size();
    }

    public void initBackRes()
    {
        this.m_Back = new Back(BitmapFactory.decodeResource(this.res, 2130837506));
        this.m_ScrollBack = new ScrollBack(BitmapFactory.decodeResource(this.res, 2130837505));
    }

    public void initBackRes2()
    {
        this.m_ScrollBack2 = new ScrollBack(BitmapFactory.decodeResource(this.res, 2130837505));
        this.m_ScrollBack.setType(0);
        this.m_ScrollBack2.setType(1);
        this.m_BackCloud = new BackCloud(BitmapFactory.decodeResource(this.res, 2130837532));
        this.m_BackCloud2 = new BackCloud(BitmapFactory.decodeResource(this.res, 2130837532));
        this.m_BackCloud3 = new BackCloud(BitmapFactory.decodeResource(this.res, 2130837532));
        this.m_ScrollLongGrass = new ScrollLongGrass(BitmapFactory.decodeResource(this.res, 2130837518));
        this.m_ScrollLongGrass2 = new ScrollLongGrass(BitmapFactory.decodeResource(this.res, 2130837518));
        this.m_ScrollLongGrass3 = new ScrollLongGrass(BitmapFactory.decodeResource(this.res, 2130837518));
        this.m_ScrollGrass = new ScrollGrass(BitmapFactory.decodeResource(this.res, 2130837531));
        this.m_ScrollGrass2 = new ScrollGrass(BitmapFactory.decodeResource(this.res, 2130837531));
        this.m_ScrollGrass3 = new ScrollGrass(BitmapFactory.decodeResource(this.res, 2130837531));
        this.m_ScrollGrass4 = new ScrollGrass(BitmapFactory.decodeResource(this.res, 2130837531));
        this.m_ScrollLongGrass.setType(0);
        this.m_ScrollLongGrass2.setType(1);
        this.m_ScrollLongGrass3.setType(2);
        this.m_ScrollGrass.setType(0);
        this.m_ScrollGrass2.setType(1);
        this.m_ScrollGrass3.setType(2);
        this.m_ScrollGrass4.setType(3);
    }

    public void initData()
    {
        backInit();
        int i = 0;
        if (i >= this.m_arItem.size()) {
            i = 0;
        }
        for (;;)
        {
            if (i >= this.m_arAttack.size())
            {
//                return;
                ((Item)this.m_arItem.get(i)).initData();
                i += 1;
                break;
            }
            ((Attack)this.m_arAttack.get(i)).initData();
            i += 1;
        }
    }

    public void resetData()
    {
        this.m_arItem.clear();
        this.m_arAttack.clear();
    }

    public void setAttackDie(int paramInt)
    {
        int j = ((Attack)this.m_arAttack.get(paramInt)).getDie();
        int i = j;
        if (j > 0) {
            i = j - 1;
        }
        ((Attack)this.m_arAttack.get(paramInt)).setDie(i);
    }

    public void setItemDie(int paramInt)
    {
        ((Item)this.m_arItem.get(paramInt)).setDie(0);
    }

    public void updateData()
    {
        backUpdate();
        int i = 0;
        if (i >= this.m_arItem.size())
        {
            i = 0;
            label19:
            if (i < this.m_arItem.size()) {
                if (((Item)this.m_arItem.get(i)).getDie() == 0)
                {
                    myLog.e("DIE ITEM", "restoreImg");
                    this.m_arItem.remove(i);
                }
                i += 1;
            }
            i = 0;
            label32:
            if (i < this.m_arAttack.size()) {
                ((Attack)this.m_arAttack.get(i)).updateData();
                i += 1;
                if (i < this.m_arAttack.size()) {
                    return;
                }
            }
            i = 0;
        }
        for (;;)
        {
            if (i >= this.m_arAttack.size())
            {
//                return;
                ((Item)this.m_arItem.get(i)).updateData();
                i += 1;
//                break;
                if (i < this.m_arItem.size()) {
                    if (((Item)this.m_arItem.get(i)).getDie() == 0)
                    {
//                        myLog.e("DIE ITEM", "restoreImg");
                        this.m_arItem.remove(i);
                    }
                    i += 1;
                }
                i = 0;
//                break;
                label120:
                ((Attack)this.m_arAttack.get(i)).updateData();
                i += 1;
                if (i < this.m_arAttack.size()) {
                    break;
                }
                break;
            }
            if (((Attack)this.m_arAttack.get(i)).getDie() == 0)
            {
                myLog.e("DIE ATTACK", "restoreImg");
                this.m_arAttack.remove(i);
            }
            i += 1;
        }
    }
}
