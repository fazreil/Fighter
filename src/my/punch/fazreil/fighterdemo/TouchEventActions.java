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
		return jc;
	}
	
	

}
