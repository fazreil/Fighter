package my.punch.fazreil.fighter.listener;

import android.util.Log;
import my.punch.fazreil.fighter.Fighter;
import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;
import my.punch.fazreil.fighterdemo.panel.InteractionTestGamePanel;

public class ActionInitiation implements HitListener {
	
	Fighter potentialFighterGettingHit;
	static InteractionTestGamePanel panel;
	Fighter goodGuy;
	Fighter badGuy;
	
	public ActionInitiation(InteractionTestGamePanel panel, Fighter fighter){
		ActionInitiation.panel = panel;
		this.potentialFighterGettingHit = fighter;
		fighter.setSeen(true);
	}
	
	@Override
	public void onCollision(Fighter badGuy, Fighter goodGuy) {
		this.goodGuy=goodGuy;
		this.badGuy=badGuy;
		goodGuy.removeCollisionListener(badGuy);
		Log.d("HIT", "Hit: "+panel.getHitCounter());
//		Toast.makeText(panel.getContext(), "Hit:"+panel.getHitCounter(), Toast.LENGTH_SHORT).show();
		//TODO draw out combo based on hitCounter
		int animationFrames = drawCombo(panel.getHitCounter(),(JackieChan)goodGuy,(SubZero)badGuy);
		badGuy.setCoolingPeriod(badGuy.getFramePeriod());
		if(this.potentialFighterGettingHit == badGuy)
		{
			Log.d("HIT", "removing from badguys list:"+potentialFighterGettingHit.toString());
			panel.getBadGuys().remove(potentialFighterGettingHit);
			Log.d("HIT", "remved from badguys list:"+potentialFighterGettingHit.toString());
			onHit(potentialFighterGettingHit);
			potentialFighterGettingHit.setOnComboAnimation(true);
			potentialFighterGettingHit.setComboAnimationFrame(animationFrames);
			potentialFighterGettingHit.activity();
		}
		else{
			//maybe another badguy.
		}
		goodGuy.activity();
		panel.setHitCounter(0);
	}

	@Override
	public void onHit(Fighter fighter) {
		fighter = panel.getTea().beatHigh((SubZero)fighter);
		fighter.setFrameNr(goodGuy.getFrameNr());
		fighter.setWalking(true);
		fighter.setFacing(fighter.getBitmap(), false);
				//new TouchEventActions(panel.getContext()).beatHigh((SubZero)fighter);
	}
	
	@Override
	public void onHit(int hit)
	{
		
	}
	
	public int drawCombo(int comboCount, JackieChan jackie, SubZero subzero)
	{
		jackie.setOnComboAnimation(true);
		jackie = panel.getTea().kick2(jackie);
		jackie.setComboAnimationFrame(jackie.getFrameNr());
		jackie.setWalking(true);
		return jackie.getFrameNr();
	}

	@Override
	public Object getActor() {
		return potentialFighterGettingHit;
	}
	
	public Fighter getPotentialFighterGettingHit()
	{
		return potentialFighterGettingHit;
	}

	public void setPotentialFighterGettingHit(Fighter potentialFighterGettingHit){
		this.potentialFighterGettingHit = potentialFighterGettingHit;
	}
}
