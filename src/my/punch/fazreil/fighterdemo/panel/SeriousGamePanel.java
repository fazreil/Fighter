package my.punch.fazreil.fighterdemo.panel;

import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighterdemo.MainThread;
import my.punch.fazreil.fighterdemo.R;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

public class SeriousGamePanel extends GamePanel {

	private JackieChan jack = new JackieChan(
			BitmapFactory.decodeResource(getResources(), R.drawable.jackie_kick1)
			,160, 10
			,150, 150
			, 10, 7
			,false,this
			);
	
	public SeriousGamePanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		
		
		
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	@Override
	public void render(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		jack.draw(canvas);
		// display fps
		displayFps(canvas, avgFps);
	}
	
	@Override
	public void update() {
		jack.update(System.currentTimeMillis());
	}

}
