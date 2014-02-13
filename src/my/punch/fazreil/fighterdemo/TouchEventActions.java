package my.punch.fazreil.fighterdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.util.Log;
import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;
import my.punch.fazreil.fighterdemo.panel.GamePanel;

public class TouchEventActions extends GamePanel{

	public TouchEventActions(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public Bitmap setFacing(Bitmap bitmap, boolean isFacingRight)
	{
		if(!isFacingRight)
		{
			bitmap = flip(bitmap);
		}
		return bitmap;
	}
	
	Bitmap flip(Bitmap src)
	{
	    Matrix m = new Matrix();
	    m.preScale(-1, 1);
	    Bitmap dst = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), m, false);
	    dst.setDensity(DisplayMetrics.DENSITY_DEFAULT);
	    return dst;
	}
	
	public JackieChan transform(JackieChan jc)
	{
		Log.d("TouchEventActions","transform");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.TRANSFORM),jc.isFacingRight()));
		return jc;
	}
	
	public JackieChan stand(JackieChan jc)
	{
		Log.d("TouchEventActions","stand");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.READY),jc.isFacingRight()));
		jc.setWalking(false);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan walk(JackieChan jc)
	{
		Log.d("TouchEventActions","walk");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.WALKING),jc.isFacingRight()));
		jc.setWalking(true);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan punch1(JackieChan jc)
	{
		Log.d("TouchEventActions","punch1");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.PUNCH1),jc.isFacingRight()));
		jc.setWalking(false);
		jc.setFrameNr(4);
		return jc;
	}
	
	public JackieChan punch2(JackieChan jc)
	{
		Log.d("TouchEventActions","punch2");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.PUNCH2),jc.isFacingRight()));
		jc.setWalking(false);
		jc.setFrameNr(6);
		return jc;
	}
	
	public JackieChan kick1(JackieChan jc)
	{
		Log.d("TouchEventActions","kick1");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.KICK1),jc.isFacingRight()));
		jc.setWalking(false);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan kick2(JackieChan jc)
	{
		Log.d("TouchEventActions","kick2");
		jc.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), jc.KICK2),jc.isFacingRight()));
		jc.setWalking(false);
		jc.setFrameNr(4);
		return jc;
	}
	
	public SubZero stand(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-stand");
		sz.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), sz.READY),sz.isFacingRight()));
		sz.setWalking(false);
		sz.setFrameNr(7);
		return sz;
	}
	
	public SubZero walk(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-stand");
		sz.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), sz.READY),sz.isFacingRight()));
		sz.setWalking(false);
		sz.setFrameNr(7);
		return sz;
	}
	
	public SubZero beatHigh(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-beatHigh");
		sz.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), sz.BEATHIGH),sz.isFacingRight()));
		sz.setWalking(false);
		sz.setFrameNr(4);
		return sz;
	}
	
	public SubZero beatMed(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-beatMed");
		sz.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), sz.BEATMED),sz.isFacingRight()));
		sz.setWalking(false);
		sz.setFrameNr(4);
		return sz;
	}
	
	public SubZero beatLow(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-beatLow");
		sz.setBitmap(setFacing(BitmapFactory.decodeResource(getContext().getResources(), sz.BEATLOW),sz.isFacingRight()));
		sz.setWalking(false);
		sz.setFrameNr(5);
		return sz;
	}
	
	

}
