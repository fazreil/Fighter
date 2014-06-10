package my.punch.fazreil.fighter.listener;

import java.util.EventListener;

import my.punch.fazreil.fighter.Fighter;

public interface HitListener extends EventListener{

	public void onCollision(Fighter badGuy, Fighter goodGuy);
	
	public void onHit(Fighter fighter);
	
	public void onHit(int hit);
	
	public Object getActor();
}
