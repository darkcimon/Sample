package exam.sound;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RequiresApi;

import exam.AngryBirdBug.AngryBirdBugActivity;

public class Sound
{
    public static int eatitem;
    public static int feather;
    public static int levelup;
    public static int pigdie1;
    public static int pigdie2;
    public static int reddie1;
    public static int select;
    public MediaPlayer m_Back;
    public MediaPlayer m_Die;
    public MediaPlayer m_Movie_Back;
    public SoundPool m_SoundPool;
    public MediaPlayer m_Title_Back;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Sound(Context paramContext)
    {
        this.m_Title_Back = MediaPlayer.create(paramContext, 2130968580);
        this.m_Back = MediaPlayer.create(paramContext, 2130968586);
        this.m_Movie_Back = MediaPlayer.create(paramContext, 2130968578);
        this.m_Die = MediaPlayer.create(paramContext, 2130968579);
        this.m_SoundPool = new SoundPool.Builder().setMaxStreams(10).build();
        pigdie1 = this.m_SoundPool.load(paramContext, 2130968583, 1);
        pigdie2 = this.m_SoundPool.load(paramContext, 2130968582, 1);
        reddie1 = this.m_SoundPool.load(paramContext, 2130968585, 1);
        eatitem = this.m_SoundPool.load(paramContext, 2130968576, 1);
        select = this.m_SoundPool.load(paramContext, 2130968581, 1);
        levelup = this.m_SoundPool.load(paramContext, 2130968577, 1);
        feather = this.m_SoundPool.load(paramContext, 2130968584, 1);
    }

    public void SoundPoolPlay(int paramInt)
    {
        if (AngryBirdBugActivity.game_sound == 61) {
            this.m_SoundPool.play(paramInt, 1.0F, 1.0F, 1, 0, 0.0F);
        }
        if (AngryBirdBugActivity.game_sound == 62) {
            this.m_SoundPool.pause(paramInt);
        }
    }

    public void m_Back_Pause()
    {
        this.m_Back.pause();
    }

    public void m_Back_Play()
    {
        if (AngryBirdBugActivity.game_sound == 61)
        {
            this.m_Back.start();
            this.m_Back.setLooping(true);
        }
        if (AngryBirdBugActivity.game_sound == 62) {
            this.m_Back.pause();
        }
    }

    public void m_Back_Release()
    {
        if (this.m_Back != null) {
            this.m_Back.release();
        }
    }

    public void m_Die_Pause()
    {
        this.m_Die.pause();
    }

    public void m_Die_Play()
    {
        if (AngryBirdBugActivity.game_sound == 61)
        {
            this.m_Die.setLooping(false);
            this.m_Die.start();
        }
        if (AngryBirdBugActivity.game_sound == 62) {
            this.m_Die.pause();
        }
    }

    public void m_Die_Release()
    {
        this.m_Die.release();
    }

    public void m_Movie_Back_Pause()
    {
        this.m_Movie_Back.pause();
    }

    public void m_Movie_Back_Play()
    {
        if (AngryBirdBugActivity.game_sound == 61)
        {
            this.m_Movie_Back.start();
            this.m_Movie_Back.setLooping(true);
        }
        if (AngryBirdBugActivity.game_sound == 62) {
            this.m_Movie_Back.pause();
        }
    }

    public void m_Movie_Back_Release()
    {
        this.m_Movie_Back.release();
    }

    public void m_Title_Back_Pause()
    {
        this.m_Title_Back.pause();
    }

    public void m_Title_Back_Play()
    {
        if (AngryBirdBugActivity.game_sound == 61)
        {
            this.m_Title_Back.start();
            this.m_Title_Back.setLooping(true);
        }
        if (AngryBirdBugActivity.game_sound == 62) {
            this.m_Title_Back.pause();
        }
    }

    public void m_Title_Back_Release()
    {
        this.m_Title_Back.release();
    }
}
