package my.punch.fazreil.fighter;

import java.util.EventListener;

public interface HitListener extends EventListener{

	public void onCollision(Fighter badGuy, Fighter goodGuy);
	
	public void onHit(Fighter fighter);
	
	public void onHit(int hit);
	
	public Object getActor();
}
