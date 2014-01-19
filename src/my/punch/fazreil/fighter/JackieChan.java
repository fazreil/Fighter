package my.punch.fazreil.fighter;

import my.punch.fazreil.fighterdemo.GamePanel;
import my.punch.fazreil.fighterdemo.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class JackieChan extends Fighter{

	public final int KICK1 = R.drawable.jackie_kick1;
	public final int KICK1_FRAME = 7;
	public final int KICK2 = R.drawable.jackie_kick2;
	public final int KICK2_FRAME = 4;
	public final int WALKING = R.drawable.jackie_walk;
	public final int WALKING_FRAME = 7;
	public final int READY = R.drawable.jackie_ready;
	public final int READY_FRAME = 7;
	public final int PUNCH1 = R.drawable.jackie_punch1;
	public final int PUNCH1_FRAME = 4;
	public final int PUNCH2 = R.drawable.jackie_punch2;
	public final int PUNCH2_FRAME = 6;
	public final int TRANSFORM = R.drawable.jackie_ready2;
	public final int TRANSFORM_FRAME = 0;

	public JackieChan(Bitmap decodeResource, int i, int j, int k, int l, int m,
			int n, boolean b, GamePanel panel) {
		super(decodeResource,i,j,k,l,m,n,b,panel);
		NAME = "Jackie Chan";
		super.collisionPoint= 70;
	}
	
	@Override
	public void activity()
	{
		isCollide();
		walk();
	}
	
	@Override
	public void setToWalk(Resources res){
		this.bitmap = BitmapFactory.decodeResource(res, WALKING);
		this.setFrameNr(WALKING_FRAME);
	}
}
