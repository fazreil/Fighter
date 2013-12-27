package my.punch.fazreil.fighterdemo;

import android.content.Context;
import android.graphics.BitmapFactory;

public class TouchEventActions extends MainGamePanel{

	public TouchEventActions(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public JackieChan transform(JackieChan jc)
	{
		jc.setBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.jackie_ready2));
		
		return jc;
	}

}
