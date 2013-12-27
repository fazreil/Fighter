package my.punch.fazreil.fighterdemo;

import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MainGamePanel(this));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public static class FighterView extends View
	{

		private Paint p;
		private Bitmap bitmap;
		private Bitmap fighterBitmap;
		private Bitmap fighterFrames[];
		private static int fighterState;
		
		
		public FighterView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			p = new Paint();
			InputStream is = getContext().getResources().openRawResource(R.drawable.jackie_ready);
			bitmap = BitmapFactory.decodeStream(is); 
			fighterBitmap = Bitmap.createBitmap(bitmap,0,0,150,7*150);
			fighterFrames=extractFrames(bitmap, 7);
			fighterState = 1;
			
		}
		
		public Bitmap[] extractFrames(Bitmap src, int frames)
		{
			Bitmap returnFrames[] = new Bitmap[frames];
			
			for(int i=0; i<frames; i++)
			{
				int offset = 150*i;
				returnFrames[i] = Bitmap.createBitmap(src, offset, 0, 150, 150);
			}
			return returnFrames;
		}
		
		@Override 
		protected void onDraw(Canvas canvas) {
			
			canvas.drawColor(Color.WHITE);
			p.setColor(Color.BLUE);
	        p.setTextSize(100);
	        canvas.drawBitmap(fighterFrames[fighterState], 10, 10, p);
			
		}		
	}

}
