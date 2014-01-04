/**
 * 
 */
package my.punch.fazreil.fighterdemo;

import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * original author impaler
 * modified by @author fab
 * This is the main surface that handles the ontouch events and draws
 * the image to the screen.
 */
public class GamePanel extends SurfaceView implements
		SurfaceHolder.Callback {

	private static final String TAG = GamePanel.class.getSimpleName();
	
	protected MainThread thread;
//	private JackieChan jc;
//	private SubZero subZero;
//	private int moveCounter=0;

	// the fps to be displayed
	protected String avgFps;
	public void setAvgFps(String avgFps) {
		this.avgFps = avgFps;
	}

	public GamePanel(Context context) {
		super(context);
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// at this point the surface is created and
		// we can safely start the game loop
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "Surface is being destroyed");
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

	protected void displayFps(Canvas canvas, String fps) {
		if (canvas != null && fps != null) {
			Paint paint = new Paint();
			paint.setARGB(255, 255, 255, 255);
			canvas.drawText(fps, this.getWidth() - 50, 20, paint);
		}
	}
	
	public void render(Canvas canvas) {
		
	}
	
	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() {
		
	}

}
