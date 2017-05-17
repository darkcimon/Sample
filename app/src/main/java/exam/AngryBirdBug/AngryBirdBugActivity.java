package exam.AngryBirdBug;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.WindowManager;

import java.util.List;

import MyEngine.FastView;
import MyEngine.myLog;

public class AngryBirdBugActivity extends Activity implements SensorEventListener
{
    public static final int GAME_END = 4;
    public static final int GAME_FINISH = 5;
    public static final int GAME_INIT = 2;
    public static final int GAME_INIT_MOVIE = 0;
    public static final int GAME_MAIN = 3;
    public static final int GAME_MOUSE = 10;
    public static final int GAME_NOSOUND = 62;
    public static final int GAME_PAUSE = 6;
    public static final int GAME_RANKING = 7;
    public static final int GAME_RESULT = 8;
    public static final int GAME_SENSOR = 11;
    public static final int GAME_SOUND = 61;
    public static final int GAME_TITLE = 1;
    public static float SensorX;
    public static float SensorY;
    public static float X;
    public static float Y;
    public static FastView fv;
    public static int game_control = 9;
    public static int game_sound = 60;
    public static int game_state = 0;
    static String t1;
    static String t2;
    static String t3;
    static String t4;
    static String t5;
    static String t6;
    private Sensor accelerometer;
    private Sensor orientation;
    private SensorManager sensorManager;
    private TickHandler tickHandler;
    private float[] values = new float[6];
    WakeLock wl;

    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}

    public void onBackPressed()
    {
        if (game_state == 3)
        {
            myLog.e("onBackPressed");
            fv.onPause();
        }
        if (game_state == 7) {
            game_state = 2;
        }
        if (game_state == 8) {
            game_state = 2;
        }
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(1);
//        Window win = getWindow();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        fv = new FastView(this);
        setContentView(fv);
        this.sensorManager = ((SensorManager)getSystemService(SENSOR_SERVICE));
//        paramBundle.putBundle("sensor",this.sensorManager);
        List<Sensor> type1 = this.sensorManager.getSensorList(1);
        if (type1.size() > 0) {
            this.accelerometer = ((Sensor)type1.get(0));
        }
        List<Sensor> type3 = this.sensorManager.getSensorList(3);
        if (type3.size() > 0) {
            this.orientation = ((Sensor)type3.get(0));
        }
        this.wl = ((PowerManager)getSystemService(POWER_SERVICE)).newWakeLock(26, "My tag");
        this.wl.acquire();
    }

    protected void onResume()
    {
        super.onResume();
        if (this.accelerometer != null) {
            this.sensorManager.registerListener(this, this.accelerometer, 0);
        }
        if (this.orientation != null) {
            this.sensorManager.registerListener(this, this.orientation, 0);
        }
        this.tickHandler = new TickHandler();
        this.tickHandler.sleep(0L);
    }

    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
        if (paramSensorEvent.sensor == this.accelerometer)
        {
            this.values[0] = paramSensorEvent.values[0];
            this.values[1] = paramSensorEvent.values[1];
            this.values[2] = paramSensorEvent.values[2];
        }
        if (paramSensorEvent.sensor == this.orientation)
        {
            this.values[3] = paramSensorEvent.values[0];
            this.values[4] = paramSensorEvent.values[1];
            X = paramSensorEvent.values[1];
            this.values[5] = paramSensorEvent.values[2];
            Y = paramSensorEvent.values[2];
        }
    }

    protected void onStop()
    {
        super.onStop();
        this.sensorManager.unregisterListener(this);
        this.tickHandler = null;
    }

    public class TickHandler
            extends Handler
    {
        public TickHandler() {}

        public void handleMessage(Message paramMessage)
        {
            AngryBirdBugActivity.t1 = "X�� ������: " + AngryBirdBugActivity.this.values[0];
            AngryBirdBugActivity.t2 = "Y�� ������: " + AngryBirdBugActivity.this.values[1];
            AngryBirdBugActivity.t3 = "Z�� ������: " + AngryBirdBugActivity.this.values[2];
            AngryBirdBugActivity.t4 = "����: " + AngryBirdBugActivity.this.values[3];
            AngryBirdBugActivity.t5 = "����: " + AngryBirdBugActivity.this.values[4];
            AngryBirdBugActivity.t6 = "��: " + AngryBirdBugActivity.this.values[5];
            if (AngryBirdBugActivity.this.tickHandler != null) {
                AngryBirdBugActivity.this.tickHandler.sleep(200L);
            }
        }

        public void sleep(long paramLong)
        {
            removeMessages(0);
            sendMessageDelayed(obtainMessage(0), paramLong);
        }
    }
}
