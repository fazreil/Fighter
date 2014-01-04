package my.punch.fazreil.fighterdemo;

import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

public class MoveTestGamePanel extends GamePanel {

	private JackieChan jc;
	private SubZero subZero;
	private int moveCounter=0;
	// the fps to be displayed

	
	public MoveTestGamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		
		subZero = new SubZero(
				BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk)
				,160, 10
				,150, 150
				, 10, 7
				,false
				);

		// create JackieChan and load bitmap
		jc = new JackieChan(
				BitmapFactory.decodeResource(getResources(), R.drawable.jackie_ready) 
				, 10, 10	// initial position
				, 150, 150	// width and height of sprite
				, 10, 7     // FPS and number of frames in the animation
				, true);
		
		
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			jc = new TouchEventActions(getContext()).walk(jc);
			subZero = new TouchEventActions(getContext()).stand(subZero);
			jc.setWalking(true);
			subZero.setWalking(true);
	
		}
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
	
			if(moveCounter<4){
				moveCounter++;
			}
			else{
				moveCounter=0;
			}
			switch(moveCounter)
			{
				case(0):
				{
					jc = new TouchEventActions(getContext()).stand(jc);
					subZero = new TouchEventActions(getContext()).stand(subZero);
					break;
				}
				case(1):
				{
					jc = new TouchEventActions(getContext()).punch1(jc);
					subZero = new TouchEventActions(getContext()).beatHigh(subZero);
					break;
				}
				case(2):
				{
					jc = new TouchEventActions(getContext()).punch2(jc);
					subZero = new TouchEventActions(getContext()).beatMed(subZero);
					break;
				}
				case(3):
				{
					jc = new TouchEventActions(getContext()).kick1(jc);
					subZero = new TouchEventActions(getContext()).beatLow(subZero);
					break;
				}
				case(4):
				{
					jc = new TouchEventActions(getContext()).kick2(jc);
					subZero = new TouchEventActions(getContext()).beatMed(subZero);
					break;
				}
			}
		}
		return true;
	}
	
	@Override
	public void render(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		subZero.draw(canvas);
		jc.draw(canvas);
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
		jc.update(System.currentTimeMillis());
		subZero.update(System.currentTimeMillis());
	}
	

}
