package my.punch.fazreil.fighter;

import my.punch.fazreil.fighterdemo.R;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class JackieChan extends Fighter{

	public final int KICK1 = R.drawable.jackie_kick1;
	public final int KICK2 = R.drawable.jackie_kick2;
	public final int WALKING = R.drawable.jackie_walk;
	public final int READY = R.drawable.jackie_ready;
	public final int PUNCH1 = R.drawable.jackie_punch1;
	public final int PUNCH2 = R.drawable.jackie_punch2;
	public final int TRANSFORM = R.drawable.jackie_ready2;

	public JackieChan(Bitmap decodeResource, int i, int j, int k, int l, int m,
			int n, boolean b) {
		// TODO Auto-generated constructor stub
		super(decodeResource,i,j,k,l,m,n,b);
		NAME = "Jackie Chan";
	}
}
