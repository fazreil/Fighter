package my.punch.fazreil.fighter;

import my.punch.fazreil.fighterdemo.R;
import android.graphics.Bitmap;
import android.graphics.Rect;

public class SubZero extends Fighter{

	public final int WALKING = R.drawable.subzero_walk;
	public final int READY = R.drawable.subzero_walk;
	public final int BEATHIGH = R.drawable.subzero_beathigh;
	public final int BEATMED = R.drawable.subzero_beatmed;
	public final int BEATLOW = R.drawable.subzero_beatlow;

	public SubZero(Bitmap decodeResource, int i, int j, int k, int l, int m,
			int n, boolean b) {
		// TODO Auto-generated constructor stub
		super(decodeResource,i,j,k,l,m,n,b);
		NAME = "Sub Zero";
	}
}
