package my.punch.fazreil.fighterdemo.panel;

import java.util.LinkedList;

import my.punch.fazreil.fighter.Fighter;
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
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class SeriousGamePanel extends GamePanel {

	private int enemyCount = 10;
	
	private LinkedList enemyList = new LinkedList();
	private int hitCounter = 0;
	
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
	
	private SubZero[] subZeroArray = {
			new SubZero(BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk),100, 10,150, 150,10, 7,false, this),
			new SubZero(BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk),200, 10,150, 150,10, 7,false, this),
			new SubZero(BitmapFactory.decodeResource(getResources(), R.drawable.subzero_walk),300, 10,150, 150,10, 7,false, this)
			};
	
	public SeriousGamePanel(Context context) {
		super(context);
//		jack.setDefaultMove(new Move(BitmapFactory.decodeResource(this.getResources(), JackieChan.READY),JackieChan.READY_FRAME));
//		subzero.setDefaultMove(new Move(BitmapFactory.decodeResource(this.getResources(), SubZero.READY),SubZero.READY_FRAME));
		addEnemyList(subZeroArray);
		addCollisionListenerCollection(jack, enemyList);
		subZeroArray[0].setWalking(true);
		subZeroArray[1].setWalking(true);
		subZeroArray[2].setWalking(true);
		
		getHolder().addCallback(this);
		// create the game loop thread
		thread = new MainThread(getHolder(), this);	
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	private void addEnemyList(SubZero[] list){
		for(int i=0;i<list.length;i++){
			this.enemyList.add(list[i]);
		}
	}
	
	private void addCollisionListenerCollection(Fighter fighter,LinkedList list)
	{
		for(int i=0;i<list.size();i++){
			fighter.addCollisionListener(new SeriousHeroHitListener(this, (SubZero) list.get(i)));
		}
	}
	
	@Override
	public void render(Canvas canvas) {
		canvas.drawColor(Color.RED);
		//spawn jack when multiple subzero can be drawn
		jack.draw(canvas);
		//subzero.draw(canvas);
		drawEnemies(subZeroArray,canvas);		
	}
	
	private void drawEnemies(Fighter[] fighters,Canvas canvas){
		for(int i=0;i<fighters.length;i++)
		{
			if(fighters[i].isToDraw())
			{
				fighters[i].draw(canvas);
			}
		}
	}
	
	@Override
	public void update() {
		jack.update(System.currentTimeMillis());
		subzero.update(System.currentTimeMillis());
		subZeroArray[0].update(System.currentTimeMillis());
		subZeroArray[1].update(System.currentTimeMillis());
		subZeroArray[2].update(System.currentTimeMillis());
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{ 
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			hitCounter++;
			Log.d("TEA","touched: "+hitCounter);
			//stopStart();
		}
		return true;
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
