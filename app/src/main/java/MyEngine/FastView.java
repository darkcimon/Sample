package MyEngine;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Toast;
import exam.AngryBirdBug.AngryBirdBugActivity;
import exam.AngryBirdBug.Feather;
import exam.AngryBirdBug.GameMenu;
import exam.AngryBirdBug.GameTitle;
import exam.AngryBirdBug.MyDBControl;
import exam.AngryBirdBug.ObjectPool;
import exam.AngryBirdBug.ObjectPool2;
import exam.AngryBirdBug.Player;
import exam.AngryBirdBug.Ranking;
import exam.AngryBirdBug.ScrollBack;
import exam.anitest.GamePause;
import exam.anitest.GameResult;
import exam.anitest.Movie;
import exam.sound.Sound;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class FastView
        extends SurfaceView
        implements Callback
{
    public static int level = 0;
    public static MyDBControl m_MyDBControl;
    final int DIFFICULT = 1000;
    int count = 0;
    SimpleDateFormat data;
    FastThread m_FastThread;
    GameMenu m_GameMenu;
    GamePause m_GamePause;
    GameResult m_GameResult;
    GameTitle m_GameTitle;
    Movie m_Movie;
    ObjectPool m_ObjectPool;
    ObjectPool2 m_ObjectPool2;
    Player m_Player;
    Ranking m_Ranking;
    Sound m_Sound;
    SurfaceHolder m_SurfaceHolder = getHolder();
    int m_touchAction;
    Random r = new Random();
    Random rand = new Random();
    int soundcount = 1;
    Toast toast;
    Date today;
    int touchX;
    int touchY;
    Vibrator vibe;

    public FastView(Context paramContext)
    {
        super(paramContext);
        this.m_SurfaceHolder.addCallback(this);
        this.m_FastThread = new FastThread(this.m_SurfaceHolder, this);
        AngryBirdBugActivity.game_state = 0;
        AngryBirdBugActivity.game_control = 11;
        AngryBirdBugActivity.game_sound = 61;
        this.m_Movie = new Movie(getResources(), 2130837520);
        this.m_GameTitle = new GameTitle(getResources(), 2130837534);
        this.m_Player = new Player(BitmapFactory.decodeResource(getResources(), 2130837507), 2, 3);
        this.m_ObjectPool = new ObjectPool(getResources());
        this.m_ObjectPool2 = new ObjectPool2(getResources());
        this.m_GameMenu = new GameMenu(getResources(), 2130837510);
        this.m_Ranking = new Ranking(getResources(), 2130837514);
        this.m_GameResult = new GameResult(BitmapFactory.decodeResource(getResources(), 2130837530));
        this.m_GamePause = new GamePause(BitmapFactory.decodeResource(getResources(), 2130837512));
        this.vibe = ((Vibrator)paramContext.getSystemService(Context.VIBRATOR_SERVICE));
        this.m_Sound = new Sound(paramContext);
        m_MyDBControl = new MyDBControl(paramContext);
        highscore(paramContext);
        this.today = new Date();
        this.data = new SimpleDateFormat("MM-dd-hh:mm");
        initData();
    }

    public void _FeatherObject(RectF paramRectF)
    {
        this.m_ObjectPool2.createFeather((int)paramRectF.left, (int)paramRectF.top, 0, 1);
    }

    public void _attackObjCreate(int paramInt, RectF paramRectF)
    {
        switch (paramInt)
        {
            default:
                return;
            case 0:
                this.m_ObjectPool.createObject(50, -10, (int)paramRectF.top + 25, 0, 0, 0, 1);
                this.m_ObjectPool.createObject(50, -50, (int)paramRectF.top - 25, 0, 0, 0, 1);
                this.m_ObjectPool.createObject(50, -50, (int)paramRectF.top + 75, 0, 0, 0, 1);
                return;
            case 4:
                this.m_ObjectPool.createObject(54, -10, (int)paramRectF.top + 50, 0, 0, 0, 10);
                this.m_ObjectPool.createObject(54, -10, (int)paramRectF.top - 50, 0, 0, 0, 10);
                this.m_ObjectPool.createObject(54, -10, (int)paramRectF.top, 0, 0, 0, 10);
                return;
            case 1:
                this.m_ObjectPool.createObject(51, (int)paramRectF.left, (int)paramRectF.top, 0, 0, 0, 10000);
                return;
            case 5:
                this.m_ObjectPool.createObject(55, (int)paramRectF.left, (int)paramRectF.top, 0, 0, 0, 10000);
                return;
            case 3:
                this.m_ObjectPool.createObject(53, this.m_Player.GetX(), this.m_Player.GetY(), 0, 0, 0, 10);
                return;
            case 6:
                _randomAttackCreate(paramRectF);
                _randomAttackCreate(paramRectF);
                return;
        }
//        this.m_ObjectPool.createObject(52, (int)paramRectF.left, (int)paramRectF.top, 0, 0, 0, 10000);
    }

    public void _attackObject(int paramInt, RectF paramRectF)
    {
        _attackObjCreate(this.m_ObjectPool.getItemType(paramInt), paramRectF);
        this.m_ObjectPool.setItemDie(paramInt);
    }

    public void _effectObject(RectF paramRectF)
    {
        this.m_ObjectPool2._addEffectObject((int)paramRectF.left, (int)paramRectF.top, 0, 0, 0, 1);
    }

    public void _itemCreate()
    {
        int i = -1;
        if (createStart())
        {
            int j = level;
            i = j;
            if (j > 6) {
                i = 6;
            }
            i = this.r.nextInt(i + 1);
            myLog.e("������ ����=  " + i);
        }
        switch (i)
        {
            default:
                return;
            case 0:
                this.m_ObjectPool.createObject(0, this.rand.nextInt(100) + 800, this.rand.nextInt(400), 0, 0, 0, 1);
                return;
            case 1:
                this.m_ObjectPool.createObject(1, 844, this.rand.nextInt(300) + 100, 0, 0, 0, 1);
                return;
            case 2:
                this.m_ObjectPool.createObject(5, this.rand.nextInt(100) + 800, this.rand.nextInt(100), 0, 0, 0, 1);
                return;
            case 3:
                this.m_ObjectPool.createObject(4, this.rand.nextInt(100) + 800, this.rand.nextInt(200), 0, 0, 0, 1);
                return;
            case 4:
                this.m_ObjectPool.createObject(2, this.rand.nextInt(100) + 800, this.rand.nextInt(100), 0, 0, 0, 1);
                return;
            case 5:
                this.m_ObjectPool.createObject(3, this.rand.nextInt(100) + 800, this.rand.nextInt(100), 0, 0, 0, 1);
                return;
        }
//        this.m_ObjectPool.createObject(6, this.rand.nextInt(100) + 800, this.rand.nextInt(400), 0, 0, 0, 1);
    }

    public void _mobCreate()
    {
        int i = 0;
        if (createStart())
        {
            this.m_ObjectPool2.SetObject(0, this.rand.nextInt(750) + 750, this.rand.nextInt(430), 0, 100, 100, true);
            this.m_ObjectPool2.SetObject(0, this.rand.nextInt(750) + 750, this.rand.nextInt(430), 0, 100, 100, true);
            this.m_ObjectPool2.SetObject(0, this.rand.nextInt(750) + 750, this.rand.nextInt(430), 0, 100, 100, true);
            this.m_ObjectPool2.SetObject(0, this.rand.nextInt(750) + 750, this.rand.nextInt(430), 0, 100, 100, true);
            this.m_ObjectPool2.SetObject(0, this.rand.nextInt(750) + 750, this.rand.nextInt(430), 0, 100, 100, true);
            i = 0;
        }
        for (;;)
        {
            if (i >= level * 3) {
                return;
            }
            this.m_ObjectPool2.SetObject(1, this.rand.nextInt(750) + 750, this.rand.nextInt(430), 0, 100, 100, true);
            i += 1;
        }
    }

    public void _randomAttackCreate(RectF paramRectF)
    {
        _attackObjCreate(this.rand.nextInt(5), paramRectF);
    }

    public boolean createStart()
    {
        if (ScrollBack.Score <= 200) {}
        for (int i = 100; this.count % i == 0; i = 1000 - level * 10) {
            return true;
        }
        return false;
    }

    public void drawScreen(Canvas paramCanvas)
    {
        if (AngryBirdBugActivity.game_state == 0) {
            this.m_Movie.drawImg(paramCanvas);
        }
        if (AngryBirdBugActivity.game_state == 1) {
            this.m_GameTitle.drawImg(paramCanvas);
        }
        if (AngryBirdBugActivity.game_state == 2)
        {
            this.m_ObjectPool.drawImg(paramCanvas);
            this.m_GameMenu.drawImg(paramCanvas);
        }
        if (AngryBirdBugActivity.game_state == 7)
        {
            this.m_ObjectPool.drawImg(paramCanvas);
            this.m_Ranking.drawImg(paramCanvas);
        }
        if (AngryBirdBugActivity.game_state == 3)
        {
            this.m_ObjectPool.drawImg(paramCanvas);
            this.m_ObjectPool2.drawImg(paramCanvas);
            this.m_Player.drawImg(paramCanvas);
        }
        if (AngryBirdBugActivity.game_state == 6)
        {
            this.m_ObjectPool.drawImg(paramCanvas);
            this.m_ObjectPool2.drawImg(paramCanvas);
            this.m_GamePause.drawImg(paramCanvas);
        }
        if (AngryBirdBugActivity.game_state == 8)
        {
            this.m_ObjectPool.drawImg(paramCanvas);
            this.m_ObjectPool2.drawImg(paramCanvas);
            this.m_GameResult.drawImg(paramCanvas);
        }
    }

    public void highscore(Context paramContext)
    {
        Object localObject = m_MyDBControl._openData();
        if (localObject != null)
        {
            Object[] localObjectArr = ((String)localObject).split(" ");
            this.toast = Toast.makeText(paramContext, "두번째 : " + String.valueOf(localObjectArr[1]) + "  세번쨰: " + String.valueOf(localObjectArr[2]), Toast.LENGTH_SHORT);
        }
    }

    public void initData()
    {
        myLog.e("initData", "initData");
        this.m_Movie.initData();
        this.m_GameTitle.initData();
        this.m_Player.initData();
        this.m_ObjectPool.initData();
        this.m_ObjectPool2.initData();
        if (AngryBirdBugActivity.game_state == 8)
        {
            this.toast.setGravity(48, 0, 0);
            this.toast.show();
        }
    }

    public void onPause()
    {
        onRestart();
    }

    public void onRestart()
    {
        this.m_GamePause.setTouch(0, 0);
        AngryBirdBugActivity.game_state = 6;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
        this.touchX = ((int)paramMotionEvent.getX());
        this.touchY = ((int)paramMotionEvent.getY());
        this.m_touchAction = paramMotionEvent.getAction();
        if ((AngryBirdBugActivity.game_state == 0) && (this.m_touchAction == 1))
        {
            AngryBirdBugActivity.game_state = 1;
            this.m_Sound.SoundPoolPlay(Sound.select);
        }
        if ((AngryBirdBugActivity.game_state == 1) && (this.m_touchAction == 0))
        {
            AngryBirdBugActivity.game_state = 2;
            this.m_Sound.SoundPoolPlay(Sound.select);
        }
        if (AngryBirdBugActivity.game_state == 6)
        {
            this.m_GamePause.setTouch(this.touchX, this.touchY);
            if ((this.touchX >= 260) && (this.touchX <= 370) && (this.touchY >= 175) && (this.touchY <= 280)) {
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
            if ((this.touchX >= 430) && (this.touchX <= 540) && (this.touchY >= 175) && (this.touchY <= 280)) {
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
        }
        if ((AngryBirdBugActivity.game_state == 2) && (this.m_touchAction == 1))
        {
            if ((this.touchX >= 302) && (this.touchX <= 485) && (this.touchY >= 248) && (this.touchY <= 339))
            {
                this.m_Player.setPos(0, 240);
                this.m_ObjectPool.resetData();
                this.m_ObjectPool2.resetData();
                ScrollBack.Score = 0;
                level = 0;
                initData();
                AngryBirdBugActivity.game_state = 3;
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
            if ((this.touchX >= 701) && (this.touchX <= 786) && (this.touchY >= 382) && (this.touchY <= 466)) {
                AngryBirdBugActivity.game_state = 5;
            }
            if ((this.touchX >= 194) && (this.touchX <= 263) && (this.touchY >= 403) && (this.touchY <= 472))
            {
                AngryBirdBugActivity.game_control = 10;
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
            if ((this.touchX >= 522) && (this.touchX <= 600) && (this.touchY >= 402) && (this.touchY <= 472))
            {
                AngryBirdBugActivity.game_control = 11;
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
            if ((this.touchX >= 14) && (this.touchX <= 97) && (this.touchY >= 383) && (this.touchY <= 468))
            {
                AngryBirdBugActivity.game_state = 7;
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
            if ((this.touchX >= 25) && (this.touchX <= 92) && (this.touchY >= 300) && (this.touchY <= 372))
            {
                this.soundcount += 1;
                if (this.soundcount % 2 == 1) {
                    AngryBirdBugActivity.game_sound = 61;
                }
                if (this.soundcount % 2 == 0) {
                    AngryBirdBugActivity.game_sound = 62;
                }
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
        }
        if ((AngryBirdBugActivity.game_state == 8) && (this.m_touchAction == 1))
        {
            if ((this.touchX >= 251) && (this.touchX <= 430) && (this.touchY >= 190) && (this.touchY <= 380))
            {
                this.m_Player.setPos(0, 240);
                this.m_ObjectPool.resetData();
                this.m_ObjectPool2.resetData();
                ScrollBack.Score = 0;
                level = 0;
                initData();
                AngryBirdBugActivity.game_state = 3;
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
            if ((this.touchX >= 459) && (this.touchX <= 547) && (this.touchY >= 291) && (this.touchY <= 380))
            {
                AngryBirdBugActivity.game_state = 2;
                this.m_Sound.SoundPoolPlay(Sound.select);
            }
        }
        if ((AngryBirdBugActivity.game_state == 7) && (this.touchX >= 481) && (this.touchX <= 536) && (this.touchY >= 391) && (this.touchY <= 447))
        {
            AngryBirdBugActivity.game_state = 2;
            this.m_Sound.SoundPoolPlay(Sound.select);
        }
        return true;
    }

    public void releaseData()
    {
        this.m_FastThread.setisLoop(false);
        int j = 1;
        int i = j;
        if (this.m_FastThread == null)
        {
            if (!this.m_FastThread.isAlive()) {
                return;
            }
            i = j;
        }
        for (;;)
        {
            if (i == 0) {
                label35:
                return;
            }
            try
            {
                this.m_FastThread.join();
                i = 0;
                j = 0;
                Log.e("������ ����", "������ ����");
                i = j;
            }
            catch (InterruptedException localInterruptedException)
            {
                Log.e("", localInterruptedException.getMessage());
            }
        }
    }

    public void result()
    {
        this.m_GameResult.setTouch(0, 0);
        AngryBirdBugActivity.game_state = 8;
        int i = 0;
        for (;;)
        {
            if (i >= 10)
            {
                this.m_ObjectPool2.SetObject(1, this.rand.nextInt(750), this.rand.nextInt(430), 0, 100, 100, true);
                return;
            }
            this.m_ObjectPool2.SetObject(0, this.rand.nextInt(750), this.rand.nextInt(430), 0, 100, 100, true);
            i += 1;
        }
    }

    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}

    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
        this.m_FastThread.start();
        this.m_FastThread.setisLoop(true);
    }

    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
        releaseData();
    }

    public void updateData()
    {
        this.count += 1;
        if (AngryBirdBugActivity.game_state == 0)
        {
            this.m_Movie.movieTime(System.currentTimeMillis());
            this.m_Sound.m_Movie_Back_Play();
        }
        if (AngryBirdBugActivity.game_state == 1)
        {
            this.m_GameTitle.updateData();
            this.m_Sound.m_Movie_Back_Pause();
            this.m_Sound.m_Title_Back_Play();
        }
        if (AngryBirdBugActivity.game_state == 2)
        {
            this.m_ObjectPool.updateData();
            this.m_GameMenu.updateData();
            this.m_Sound.m_Title_Back_Pause();
            this.m_Sound.m_Back_Play();
        }
        if (AngryBirdBugActivity.game_state == 7)
        {
            this.m_ObjectPool.updateData();
            this.m_Ranking.updateData();
        }
        int i;
        if (AngryBirdBugActivity.game_state == 3)
        {
            if (ScrollBack.Score % 365 == 0)
            {
                _FeatherObject(this.m_Player.getPlayerRectF());
                this.m_Sound.SoundPoolPlay(Sound.feather);
                if (AngryBirdBugActivity.game_control == 10)
                {
                    i = 0;
                    if (i < this.m_ObjectPool2.getarFeatherSize()) {
                        goLabel458N533();
                    }
                }
                if (AngryBirdBugActivity.game_control == 11)
                {
                    i = 0;
                    label187:
                    if (i < this.m_ObjectPool2.getarFeatherSize()) {
                        goLabel458N533();
                    }
                }
            }
            i = level;
            if ((level < 10) && (ScrollBack.Score > i * 4000 + 1000))
            {
                this.m_Sound.SoundPoolPlay(Sound.levelup);
                level += 1;
            }
            this.m_Sound.m_Back_Pause();
            this.m_Sound.m_Back_Play();
            this.m_Player.updateData();
            if (AngryBirdBugActivity.game_control == 11) {
                this.m_Player.setMove(AngryBirdBugActivity.SensorX, AngryBirdBugActivity.SensorY);
            }
            if (AngryBirdBugActivity.game_control == 10) {
                this.m_Player.setMove(this.touchX, this.touchY);
            }
            _mobCreate();
            _itemCreate();
            this.m_ObjectPool.updateData();
            this.m_ObjectPool2.updateData();
            myLog.e(String.valueOf(this.m_ObjectPool.getarItemSize()));
        }
    }

    private void goLabel669(){
        int i  =0;
        if (TotalCheck.Collision(this.m_Player.getPlayerRectF(), this.m_ObjectPool2.getarPigRectF(i)))
        {
            myLog.e("Pig Collision");
            if (m_MyDBControl != null) {
                m_MyDBControl._saveData(this.data.format(this.today), ScrollBack.Score, level);
            }
            this.m_Sound.SoundPoolPlay(Sound.reddie1);
            this.vibe.vibrate(300L);
            result();
        }
    }
    private void goLabel458N533(){
        int i = 0;
        RectF localRectF;
        for (;;)
        {
            if (i >= this.m_ObjectPool.getarItemSize())
            {
                i = 0;
                if (i < this.m_ObjectPool2.getarPigSize()) {
                    goLabel669();
                }
                if (AngryBirdBugActivity.game_state == 5)
                {
                    this.m_Sound.m_Back_Pause();
                    System.exit(0);
                }
                if (AngryBirdBugActivity.game_state == 6)
                {
                    this.m_Sound.m_Back_Pause();
                    this.m_Sound.m_Die_Play();
                    this.m_GamePause.updateData();
                }
                if (AngryBirdBugActivity.game_state == 8)
                {
                    this.m_Sound.m_Back_Pause();
                    this.m_Sound.m_Die_Play();
                    this.m_GameResult.updateData();
                }

                ((Feather)this.m_ObjectPool2.arFeather.get(i)).SetFeatherSpeedX((int)(this.touchX - this.m_Player.getPlayerRectF().left));
                ((Feather)this.m_ObjectPool2.arFeather.get(i)).SetFeatherSpeedY((int)(this.touchY - this.m_Player.getPlayerRectF().top));
                i += 1;

                ((Feather)this.m_ObjectPool2.arFeather.get(i)).SetFeatherSpeedX((int)(AngryBirdBugActivity.SensorX - this.m_Player.getPlayerRectF().left));
                ((Feather)this.m_ObjectPool2.arFeather.get(i)).SetFeatherSpeedY((int)(AngryBirdBugActivity.SensorY - this.m_Player.getPlayerRectF().top));
                i += 1;
                goLabel187();
            }
            Boolean bool = TotalCheck.Collision(this.m_Player.getPlayerRectF(), this.m_ObjectPool.getarItemRectF(i));
            localRectF = this.m_ObjectPool.getarItemRectF(i);
            if (bool)
            {
                this.m_Sound.SoundPoolPlay(Sound.eatitem);
                _attackObject(i, localRectF);
                this.m_ObjectPool.setItemDie(i);
            }
            i += 1;
        }
    }

    private void goLabel187(){

    }

    private void goLabel751(){
        int j = 0;
        int i = 0;
        RectF localRectF;
        if (j >= this.m_ObjectPool.getarAttackSize()) {
            j = 0;
        }

        for (;;)
        {
            if (j >= this.m_ObjectPool2.getarFeatherSize())
            {
                i += 1;

                localRectF = this.m_ObjectPool2.getarPigRectF(i);
                if (TotalCheck.Collision(this.m_ObjectPool.getarAttackRectF(j), this.m_ObjectPool2.getarPigRectF(i)))
                {
                    ScrollBack.Score += 10;
                    if (this.m_ObjectPool2.getarPigType(i) == 0) {
                        this.m_Sound.SoundPoolPlay(Sound.pigdie1);
                    }
                    if (this.m_ObjectPool2.getarPigType(i) == 1) {
                        this.m_Sound.SoundPoolPlay(Sound.pigdie2);
                    }
                    this.m_ObjectPool.setAttackDie(j);
                    this.m_ObjectPool2.setPigDie(i);
                    _effectObject(localRectF);
                }
                j += 1;
                goLabel751();
            }
            Boolean bool = TotalCheck.Collision(this.m_ObjectPool2.getarFeatherRectF(j), this.m_ObjectPool2.getarPigRectF(i));
            localRectF = this.m_ObjectPool2.getarPigRectF(i);
            if (bool)
            {
                ScrollBack.Score += 10;
                if (this.m_ObjectPool2.getarPigType(i) == 0) {
                    this.m_Sound.SoundPoolPlay(Sound.pigdie1);
                }
                if (this.m_ObjectPool2.getarPigType(i) == 1) {
                    this.m_Sound.SoundPoolPlay(Sound.pigdie2);
                }
                this.m_ObjectPool2.setPigDie(i);
                this.m_ObjectPool2.setFeatherDie(j);
                _effectObject(localRectF);
            }
            j += 1;
        }
    }
}
