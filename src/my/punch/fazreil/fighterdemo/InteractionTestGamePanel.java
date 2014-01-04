package my.punch.fazreil.fighterdemo;

import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

public class InteractionTestGamePanel extends GamePanel {

	private JackieChan jackie;
	private SubZero subZero;
	
	public InteractionTestGamePanel(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		jackie = new JackieChan(
				BitmapFactory.decodeResource(getResources(), R.drawable.jackie_ready) 
				, 10, 10	// initial position
				, 150, 150	// width and height of sprite
				, 10, 7     // FPS and number of frames in the animation
				, true);
		
		subZero = new SubZero(
				BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk)
				,160, 10
				,150, 150
				, 10, 7
				,false);
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	@Override
	public void render(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		subZero.draw(canvas);
		jackie.draw(canvas);
		// display fps
		displayFps(canvas, avgFps);
	}
	
	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	@Override
	public void update() {
		jackie.update(System.currentTimeMillis());
		subZero.update(System.currentTimeMillis());
	}

}
