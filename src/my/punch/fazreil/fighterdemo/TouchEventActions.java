package my.punch.fazreil.fighterdemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import my.punch.fazreil.fighter.JackieChan;
import my.punch.fazreil.fighter.SubZero;

public class TouchEventActions extends MainGamePanel{

	public TouchEventActions(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public JackieChan transform(JackieChan jc)
	{
		Log.d("TouchEventActions","transform");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.TRANSFORM));
		return jc;
	}
	
	public JackieChan stand(JackieChan jc)
	{
		Log.d("TouchEventActions","stand");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.READY));
		jc.setWalking(false);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan walk(JackieChan jc)
	{
		Log.d("TouchEventActions","walk");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.WALKING));
		jc.setWalking(true);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan punch1(JackieChan jc)
	{
		Log.d("TouchEventActions","punch1");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.PUNCH1));
		jc.setWalking(false);
		jc.setFrameNr(4);
		return jc;
	}
	
	public JackieChan punch2(JackieChan jc)
	{
		Log.d("TouchEventActions","punch2");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.PUNCH2));
		jc.setWalking(false);
		jc.setFrameNr(6);
		return jc;
	}
	
	public JackieChan kick1(JackieChan jc)
	{
		Log.d("TouchEventActions","kick1");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.KICK1));
		jc.setWalking(false);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan kick2(JackieChan jc)
	{
		Log.d("TouchEventActions","kick2");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), jc.KICK2));
		jc.setWalking(false);
		jc.setFrameNr(4);
		return jc;
	}
	
	public SubZero stand(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-stand");
		sz.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), sz.READY));
		sz.setWalking(false);
		sz.setFrameNr(7);
		return sz;
	}
	
	public SubZero beatHigh(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-beatHigh");
		sz.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), sz.BEATHIGH));
		sz.setWalking(false);
		sz.setFrameNr(4);
		return sz;
	}
	
	public SubZero beatMed(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-beatMed");
		sz.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), sz.BEATMED));
		sz.setWalking(false);
		sz.setFrameNr(4);
		return sz;
	}
	
	public SubZero beatLow(SubZero sz)
	{
		Log.d("TouchEventActions","subzero-beatLow");
		sz.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), sz.BEATLOW));
		sz.setWalking(false);
		sz.setFrameNr(5);
		return sz;
	}
	
	

}
