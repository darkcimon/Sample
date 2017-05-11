package MyEngine;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class myLog
{
    public static boolean DUBUG = true;

    public static void Toast(Context paramContext, String paramString)
    {
        if (DUBUG) {
            Toast.makeText(paramContext, paramString, Toast.LENGTH_SHORT).show();
        }
    }

    public static void Toast(Context paramContext, String paramString, int paramInt)
    {
        if (DUBUG) {
            Toast.makeText(paramContext, paramString, paramInt).show();
        }
    }

    public static void e(String paramString)
    {
        if (DUBUG) {
            Log.e("MyLog", paramString);
        }
    }

    public static void e(String paramString1, String paramString2)
    {
        if (DUBUG) {
            Log.e(paramString1, paramString2);
        }
    }
}
