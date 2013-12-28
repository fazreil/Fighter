package my.punch.fazreil.fighter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class JackieChan extends Fighter {

	final String NAME = "JackieChan";
	
	public JackieChan() {

	}

	public JackieChan(Bitmap bitmap, int x, int y, int width, int height,
			int fps, int frameCount) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		currentFrame = 0;
		frameNr = frameCount;
		spriteWidth = bitmap.getWidth() / frameCount;
		spriteHeight = bitmap.getHeight();
		sourceRect = new Rect(0, 0, spriteWidth, spriteHeight);
		framePeriod = 1000 / fps;
		frameTicker = 0l;
	}

	// the update method for JackieChan
	public void update(long gameTime) {
		if (gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			// increment the frame
			currentFrame++;
			if (currentFrame >= frameNr) {
				currentFrame = 0;
			}
		}
		// define the rectangle to cut out sprite
		this.sourceRect.left = currentFrame * spriteWidth;
		this.sourceRect.right = this.sourceRect.left + spriteWidth;
	}

	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		Rect destRect = new Rect(getX(), getY(), getX() + spriteWidth, getY()
				+ spriteHeight);
		canvas.drawBitmap(bitmap, sourceRect, destRect, null);
//		canvas.drawBitmap(bitmap, 20, 150, null);
		Paint paint = new Paint();
		paint.setARGB(50, 0, 255, 0);
//		canvas.drawRect(20 + (currentFrame * destRect.width()), 150, 20
//				+ (currentFrame * destRect.width()) + destRect.width(),
//				150 + destRect.height(), paint);
	}
}
