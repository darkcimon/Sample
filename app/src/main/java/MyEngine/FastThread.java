package MyEngine;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class FastThread
        extends Thread
{
    boolean isLoop;
    FastView m_FastView;
    SurfaceHolder m_SurfaceHolder;
    Canvas m_fastCanvas;

    FastThread(SurfaceHolder paramSurfaceHolder, FastView paramFastView)
    {
        this.m_SurfaceHolder = paramSurfaceHolder;
        this.m_FastView = paramFastView;
        this.isLoop = false;
        this.m_fastCanvas = null;
        myLog.e("FastThread ����", "FastThread ����");
    }

    public void run()
    {
        for (;;)
        {
            if (!this.isLoop) {
                return;
            }
            this.m_fastCanvas = this.m_SurfaceHolder.lockCanvas(null);
            this.m_FastView.updateData();
            this.m_FastView.drawScreen(this.m_fastCanvas);
            this.m_SurfaceHolder.unlockCanvasAndPost(this.m_fastCanvas);
        }
    }

    void setisLoop(boolean paramBoolean)
    {
        this.isLoop = paramBoolean;
    }
}
