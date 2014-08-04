package my.punch.fazreil.fighter.listener;

import java.util.Random;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;
import my.punch.fazreil.fighter.Fighter;
import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.Move;
import my.punch.fazreil.fighter.SubZero;
import my.punch.fazreil.fighterdemo.R;
import my.punch.fazreil.fighterdemo.panel.SeriousGamePanel;

public class SeriousHeroHitListener implements HitListener {

	static SeriousGamePanel panel;
	public JackieChan goodGuy;
	public SubZero badGuy;
	private int[] moves = {
			R.drawable.jackie_kick1,
			R.drawable.jackie_kick2,
			R.drawable.jackie_punch1,
			R.drawable.jackie_punch2};
	private int[] frames = {
			7,4,4,6
	};
	
	public SeriousHeroHitListener(SeriousGamePanel panel, SubZero enemy)
	{
		this.panel = panel;
		this.badGuy = enemy;
	}
	
	@Override
	public void onCollision(Fighter badGuy, Fighter goodGuy) {
//		// TODO Auto-generated method stub
		this.goodGuy = (JackieChan)goodGuy;
		this.badGuy = (SubZero)badGuy;
		Log.d("collision", this.goodGuy.toString()+" collided with "+this.badGuy.toString());
		onHit();
//		this.goodGuy.removeCollisionListener(this.badGuy);
	}
	
	public void onHit(){
		this.badGuy.setWalking(false);
		drawHitAnimation();
		this.badGuy.setToDraw(false);
		this.goodGuy.removeCollisionListener(this.badGuy);
	}
	
	public void drawHitAnimation()
	{
		this.badGuy.setBitmap(BitmapFactory.decodeResource(panel.getResources(), R.drawable.subzero_beathigh));
		int move = (int) ((Math.random()*10)%moves.length);
		this.goodGuy.setBitmap(BitmapFactory.decodeResource(panel.getResources(), moves[move]));
		this.goodGuy.setFrameNr(frames[move]);
	}

	@Override
	public void onHit(Fighter fighter) {
		// TODO Auto-generated method stub
		fighter.setWalking(false);
		fighter.setBitmap(fighter.setFacing(BitmapFactory.decodeResource(panel.getResources(), R.drawable.subzero_beatmed), false));
		fighter.setFrameNr(4);
		//fighter.getMovePipeline().add(new Move(BitmapFactory.decodeResource(panel.getResources(), R.drawable.subzero_beatmed),SubZero.BEATMED_FRAME));
		int move = (int) ((Math.random()*10)%moves.length);
		panel.getJack().setBitmap(BitmapFactory.decodeResource(panel.getResources(), moves[move]));
		panel.getJack().setFrameNr(frames[move]);
		panel.getJack().setWalking(false);
		panel.getJack().getMovePipeline().add(new Move(BitmapFactory.decodeResource(panel.getResources(), moves[move]),frames[move]));
	}

	@Override
	public void onHit(int hit) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getActor() {
		// TODO Auto-generated method stub
		return this.badGuy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
