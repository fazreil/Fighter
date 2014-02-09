package my.punch.fazreil.fighterdemo;

import java.util.ArrayList;

import my.punch.fazreil.fighter.ActionInitiation;
import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;

public class InteractionTestGamePanel extends GamePanel {

	private JackieChan jackie;
	private SubZero subZero;
	private int hitCounter = 0;
	public TouchEventActions tea = new TouchEventActions(getContext());

	public InteractionTestGamePanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		
		goodGuys = new ArrayList();
		badGuys = new ArrayList();
		
		// TODO Auto-generated constructor stub
		jackie = new JackieChan(
				BitmapFactory.decodeResource(getResources(), R.drawable.jackie_ready) 
				, 10, 10	// initial position
				, 150, 150	// width and height of sprite
				, 10, 7     // FPS and number of frames in the animation
				, true, this);
		jackie = new TouchEventActions(getContext()).walk(jackie);
		jackie.setWalking(true);
		
		subZero = new SubZero(
				BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk)
				,250, 10
				,150, 150
				, 10, 7
				,false, this);
		subZero.setWalking(true);
		
		badGuys.add(subZero);
		jackie.addCollisionListener(new ActionInitiation(this,subZero));
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{ 
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d("TEA","touched");
			//stopStart();
			hitCounter++;
		}
		return true;
	}
	
	public void stopStart(){

		if(jackie.isWalking())
		{
			jackie = new TouchEventActions(getContext()).stand(jackie);
			jackie.setWalking(false);
		}
		else
		{
			jackie = new TouchEventActions(getContext()).walk(jackie);
			jackie.setWalking(true);
		}
		
		if(subZero.isWalking())
		{
			subZero=new TouchEventActions(getContext()).stand(subZero);
			subZero.setWalking(false);
		}
		else
		{
			subZero=new TouchEventActions(getContext()).walk(subZero);
			subZero.setWalking(true);
		}
	}
	
	public void resetPosition(){
		jackie = new JackieChan(
				BitmapFactory.decodeResource(getResources(), R.drawable.jackie_ready) 
				, 10, 10	// initial position
				, 150, 150	// width and height of sprite
				, 10, 7     // FPS and number of frames in the animation
				, true, this);
		jackie = new TouchEventActions(getContext()).walk(jackie);
		jackie.setWalking(true);
		
		subZero = new SubZero(
				BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk)
				,250, 10
				,150, 150
				, 10, 7
				,false, this);
		subZero.setWalking(true);
		
		badGuys.add(subZero);
		jackie.addCollisionListener(new ActionInitiation(this,subZero));
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
	
	public int getHitCounter() {
		return hitCounter;
	}

	public void setHitCounter(int hitCounter) {
		this.hitCounter = hitCounter;
	}

	public TouchEventActions getTea() {
		return tea;
	}

	public void setTea(TouchEventActions tea) {
		this.tea = tea;
	}
	
	

}
