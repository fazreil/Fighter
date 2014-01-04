package my.punch.fazreil.fighter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

public class Fighter{
	
	protected String NAME = "Default Fighter";
	
	protected Paint p;

	protected Bitmap bitmap; // the animation sequence
	protected Rect sourceRect; // the rectangle to be drawn from the animation
								// bitmap
	protected int frameNr; // number of frames in animation
	protected int currentFrame; // the current frame
	protected long frameTicker; // the time of the last frame update
	protected int framePeriod; // milliseconds between each frame (1000/fps)

	protected int spriteWidth; // the width of the sprite to calculate the cut out
								// rectangle
	protected int spriteHeight; // the height of the sprite
	protected boolean isFacingRight = true;

	protected int spawnX; //original sprite spawn point x coordinate
	protected int spawnY; //original sprite spawn point y coordinate
	protected int x; // the X coordinate of the object (top left of the image)
	protected int y; // the Y coordinate of the object (top left of the image)
	
	protected boolean isWalking = false;

	public Fighter() {
		
	}

	public Fighter(Bitmap bitmap, int x, int y, int width, int height,
			int fps, int frameCount, boolean isFacingRight) {
		this.x = x;
		this.spawnX = x;
		this.y = y;
		this.spawnY = y;
		currentFrame = 0;
		frameNr = frameCount;
		spriteWidth = bitmap.getWidth() / frameCount;
		spriteHeight = bitmap.getHeight();
		sourceRect = new Rect(0, 0, spriteWidth, spriteHeight);
		framePeriod = 1000 / fps;
		frameTicker = 0l;
		this.isFacingRight = isFacingRight;
		this.bitmap = setFacing(bitmap,isFacingRight);
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

	public String toString()
	{
		return NAME;
	}
	
	// the update method for JackieChan
	public void update(long gameTime) {
		if (gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			if(isWalking)
			{
				if(Math.abs(spawnX-getX())<120)
				{
					if(isFacingRight())
					{
						setX(getX()+10);
					}
					else
					{
						setX(getX()-10);
					}
					
				}
				else
				{
					setX(spawnX);
				}
			}
			
			// increment the frame
			
			currentFrame++;
			if (currentFrame >= frameNr) {
				currentFrame = 0;
			}
		}
		if(isFacingRight)
		{
			// define the rectangle to cut out sprite
			this.sourceRect.left = currentFrame * spriteWidth;
		}
		else
		{
			// define the rectangle to cut out sprite
			this.sourceRect.left = ((frameNr -1) - currentFrame) * spriteWidth;
		}
		this.sourceRect.right = this.sourceRect.left + spriteWidth;
	}

	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		Rect destRect = new Rect(getX(), getY(), getX() + spriteWidth, getY()
				+ spriteHeight);
		canvas.drawBitmap(bitmap, sourceRect, destRect, null);

		//facing left or right
		if(!isFacingRight)
		{
			p = new Paint();
			p.setColor(Color.RED);
			String display = this.toString()+" facing right";
			canvas.drawText(display, 0, display.length(), 0, 150, p);
		}
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public Rect getSourceRect() {
		return sourceRect;
	}

	public void setSourceRect(Rect sourceRect) {
		this.sourceRect = sourceRect;
	}

	public int getFrameNr() {
		return frameNr;
	}

	public void setFrameNr(int frameNr) {
		this.frameNr = frameNr;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public long getFrameTicker() {
		return frameTicker;
	}

	public void setFrameTicker(long frameTicker) {
		this.frameTicker = frameTicker;
	}

	public int getFramePeriod() {
		return framePeriod;
	}

	public void setFramePeriod(int framePeriod) {
		this.framePeriod = framePeriod;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isWalking() {
		return isWalking;
	}

	public void setWalking(boolean isWalking) {
		this.isWalking = isWalking;
	}

	public boolean isFacingRight() {
		return isFacingRight;
	}

	public void setFacingRight(boolean isFacingRight) {
		this.isFacingRight = isFacingRight;
	}
	
	
	

}
