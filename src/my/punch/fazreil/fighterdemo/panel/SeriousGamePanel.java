package my.punch.fazreil.fighterdemo.panel;

import java.util.LinkedList;

import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.Move;
import my.punch.fazreil.fighter.SubZero;
import my.punch.fazreil.fighter.listener.SeriousHeroHitListener;
import my.punch.fazreil.fighterdemo.MainThread;
import my.punch.fazreil.fighterdemo.R;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

public class SeriousGamePanel extends GamePanel {

	private int enemyCount = 10;
	
	private LinkedList<SubZero> enemyList;
	
	private JackieChan jack = new JackieChan(
			BitmapFactory.decodeResource(getResources(), R.drawable.jackie_ready)
			,10, 10
			,150, 150
			, 10, 7
			,true,this
			);
	
	private SubZero subzero = new SubZero(
			BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk) 
			,200, 10
			,150, 150
			,10, 7, 
			false, this);
	
	public SeriousGamePanel(Context context) {
		super(context);
		jack.setDefaultMove(new Move(BitmapFactory.decodeResource(this.getResources(), JackieChan.READY),JackieChan.READY_FRAME));
		subzero.setDefaultMove(new Move(BitmapFactory.decodeResource(this.getResources(), SubZero.READY),SubZero.READY_FRAME));
		jack.addCollisionListener(new SeriousHeroHitListener(this,subzero));
		jack.setWalking(true);
		subzero.setWalking(true);
		
		getHolder().addCallback(this);
		// create the game loop thread
		thread = new MainThread(getHolder(), this);	
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	
	
	@Override
	public void render(Canvas canvas) {
		canvas.drawColor(Color.GREEN);
		jack.draw(canvas);
		subzero.draw(canvas);
		
	}
	
	@Override
	public void update() {
		jack.update(System.currentTimeMillis());
		subzero.update(System.currentTimeMillis());
	}



	public int getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}

	public JackieChan getJack() {
		return jack;
	}

	public void setJack(JackieChan jack) {
		this.jack = jack;
	}

	public SubZero getSubzero() {
		return subzero;
	}

	public void setSubzero(SubZero subzero) {
		this.subzero = subzero;
	}



	
	public LinkedList<SubZero> getEnemyList() {
		return enemyList;
	}



	
	public void setEnemyList(LinkedList<SubZero> enemyList) {
		this.enemyList = enemyList;
	}
	
}
