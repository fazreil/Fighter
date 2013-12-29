package my.punch.fazreil.fighterdemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import my.punch.fazreil.fighter.JackieChan;

public class TouchEventActions extends MainGamePanel{

	public TouchEventActions(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public JackieChan transform(JackieChan jc)
	{
		Log.d("TouchEventActions","transform");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_ready2));
		return jc;
	}
	
	public JackieChan stand(JackieChan jc)
	{
		Log.d("TouchEventActions","stand");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_ready));
		jc.setWalking(false);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan walk(JackieChan jc)
	{
		Log.d("TouchEventActions","walk");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_walk));
		jc.setWalking(true);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan punch1(JackieChan jc)
	{
		Log.d("TouchEventActions","punch1");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_punch1));
		jc.setWalking(false);
		jc.setFrameNr(4);
		return jc;
	}
	
	public JackieChan punch2(JackieChan jc)
	{
		Log.d("TouchEventActions","punch2");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_punch2));
		jc.setWalking(false);
		jc.setFrameNr(6);
		return jc;
	}
	
	public JackieChan kick1(JackieChan jc)
	{
		Log.d("TouchEventActions","kick1");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_kick1));
		jc.setWalking(false);
		jc.setFrameNr(7);
		return jc;
	}
	
	public JackieChan kick2(JackieChan jc)
	{
		Log.d("TouchEventActions","kick2");
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_kick2));
		jc.setWalking(false);
		jc.setFrameNr(4);
		return jc;
	}
	
	

}
