package MyEngine;

import android.graphics.Rect;
import android.graphics.RectF;

public class TotalCheck
{
    public static boolean Collision(Rect paramRect1, Rect paramRect2)
    {
        return paramRect1.intersect(paramRect2);
    }

    public static boolean Collision(RectF paramRectF1, RectF paramRectF2)
    {
        return paramRectF1.intersect(paramRectF2);
    }

    public static int Range(Rect paramRect1, Rect paramRect2)
    {
        return (int)Math.sqrt(Math.pow(Math.abs(paramRect1.left - paramRect2.left), 2.0D) + Math.pow(Math.abs(paramRect1.top - paramRect2.top), 2.0D));
    }
}
