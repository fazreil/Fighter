package my.punch.fazreil.fighter;

import my.punch.fazreil.fighterdemo.R;
import my.punch.fazreil.fighterdemo.panel.GamePanel;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SubZero extends Fighter{

	public static final int WALKING = R.drawable.subzero_walk;
	public static final int WALKING_FRAME = 7;
	public static final int READY = R.drawable.subzero_walk;
	public static final int READY_FRAME = 7;
	public static final int BEATHIGH = R.drawable.subzero_beathigh;
	public static final int BEATHIGH_FRAME = 4;
	public static final int BEATMED = R.drawable.subzero_beatmed;
	public static final int BEATMED_FRAME = 4;
	public static final int BEATLOW = R.drawable.subzero_beatlow;
	public static final int BEATLOW_FRAME = 5;

	public SubZero(Bitmap decodeResource, int i, int j, int k, int l, int m,
			int n, boolean b, GamePanel panel) {
		// TODO Auto-generated constructor stub
		super(decodeResource,i,j,k,l,m,n,b,panel);
		NAME = "Sub Zero";
		super.collisionPoint = 70;
	}

	@Override
	public void setToWalk(Resources res){
		this.bitmap = setFacing(BitmapFactory.decodeResource(res, WALKING),isFacingRight);
		this.setFrameNr(WALKING_FRAME);
		this.isFacingRight=false;
	}
}
