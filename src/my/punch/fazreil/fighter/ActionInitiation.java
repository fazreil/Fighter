package my.punch.fazreil.fighter;

import android.util.Log;
import my.punch.fazreil.fighterdemo.InteractionTestGamePanel;
import my.punch.fazreil.fighterdemo.TouchEventActions;

public class ActionInitiation implements HitListener {
	
	Fighter potentialFighterGettingHit;
	static InteractionTestGamePanel panel;
	Fighter goodGuy;
	Fighter badGuy;
	
	public ActionInitiation(InteractionTestGamePanel panel, Fighter fighter){
		ActionInitiation.panel = panel;
		this.potentialFighterGettingHit = fighter;
	}
	
	@Override
	public void onCollision(Fighter badGuy, Fighter goodGuy) {
		this.goodGuy=goodGuy;
		this.badGuy=badGuy;
		goodGuy.removeCollisionListener(badGuy);
		Log.d("HIT", "Hit: "+panel.getHitCounter());
		//TODO draw out combo based on hitCounter
		int animationFrames = drawCombo(panel.getHitCounter(),(JackieChan)goodGuy,(SubZero)badGuy);
		if(this.potentialFighterGettingHit == badGuy)
		{
			panel.getBadGuys().remove(potentialFighterGettingHit);
			Log.d("HIT", potentialFighterGettingHit.toString());
			onHit(potentialFighterGettingHit);
			potentialFighterGettingHit.setOnComboAnimation(true);
			potentialFighterGettingHit.setComboAnimationFrame(animationFrames);
			potentialFighterGettingHit.activity();
		}
		goodGuy.activity();
		panel.setHitCounter(0);
	}

	@Override
	public void onHit(Fighter fighter) {
		fighter = panel.getTea().beatHigh((SubZero)fighter);
		fighter.setFrameNr(goodGuy.getFrameNr());
		fighter.setWalking(true);
		fighter.setFacing(fighter.bitmap, false);
				//new TouchEventActions(panel.getContext()).beatHigh((SubZero)fighter);
	}
	
	@Override
	public void onHit(int hit)
	{
		
	}
	
	public int drawCombo(int comboCount, JackieChan jackie, SubZero subzero)
	{
		jackie.onComboAnimation = true;
		jackie = panel.getTea().kick2(jackie);
		jackie.setComboAnimationFrame(jackie.getFrameNr());
		jackie.setWalking(true);
		return jackie.getFrameNr();
	}

	@Override
	public Object getActor() {
		return potentialFighterGettingHit;
	}
	
	

}
