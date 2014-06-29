package my.punch.fazreil.fighter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import my.punch.fazreil.fighter.listener.HitListener;
import my.punch.fazreil.fighterdemo.panel.GamePanel;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;

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
	protected int collisionPoint;

	protected int spawnX; //original sprite spawn point x coordinate
	protected int spawnY; //original sprite spawn point y coordinate
	protected int x; // the X coordinate of the object (top left of the image)
	protected int y; // the Y coordinate of the object (top left of the image)
	
	protected boolean onComboAnimation = false;
	protected int comboAnimationFrame = 0;
	
	protected int coolingPeriod = 0;

	private boolean seen = false;
	
	private Move defaultMove;
	
	protected GamePanel panel;
	
	protected boolean isWalking = false;
	protected LinkedList<Move> movePipeline;
	
	private List<HitListener> listeners = new ArrayList<HitListener>();

	public Fighter() {
		
	}

	public Fighter(Bitmap bitmap, int x, int y, int width, int height,
			int fps, int frameCount, boolean isFacingRight, GamePanel panel) {
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
		this.panel = panel;
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
	
	public void update(long gameTime) {
//		if(!movePipeline.isEmpty()){
//			Move currentMove = movePipeline.getFirst();
//			movePipeline.removeFirst();
//			setBitmap(currentMove.getMoveBitmap());
//			setFrameNr(currentMove.getMoveFrame());
//		}
//		else{
//			setBitmap(getDefaultMove().getMoveBitmap());
//			setFrameNr(getDefaultMove().getMoveFrame());
//		}
		if (gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			
			activity();
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
	
	public void activity()
	{
		walk();
		this.setSeen(true);
		
	}
	
	public void walk()
	{
		if(isWalking)
		{
			if(Math.abs(spawnX-getX())<300)
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
				if(onComboAnimation)
				{
					setX(getX());
					comboAnimationFrame--;
					if(comboAnimationFrame<0)
					{
						onComboAnimation = false;
					}
				}
				else
				{
					resetToSpawnPoint();
				}
			}
		}
	}
	
	public void beat(){
		
	}
	
	public void resetToSpawnPoint()
	{
		setToWalk(panel.getResources());
		setX(spawnX);
	}
	
	public void setToWalk(Resources res){
		
	}
	
	public void addCollisionListener(HitListener hitlistener)
	{
		listeners.add(hitlistener);
	}
	
	public void removeCollisionListener(Fighter fighter)
	{
		for(HitListener listener : listeners)
		{
			if(listener.getActor() == fighter)
			{
				listeners.remove(listener);fighter.setSeen(false);
			}
		}
	}
	
	public List<HitListener> getCollisionListener()
	{
		return listeners;
	}
	
	public void isCollide()
	{
		for(HitListener listener : listeners)
		{
			Fighter actor = (Fighter)listener.getActor();
			//if(this.isWalking())
			{
				if(getX()+collisionPoint>actor.getX())
				{
					listener.onCollision(actor,this);
				}
			}
		}
	}
	
	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		Rect destRect = new Rect(getX(), getY(), getX() + spriteWidth, getY()
				+ spriteHeight);
		canvas.drawBitmap(bitmap, sourceRect, destRect, null);
	}
	
	public int getComboAnimationFrame() {
		return comboAnimationFrame;
	}

	public void setComboAnimationFrame(int comboAnimationFrame) {
		this.comboAnimationFrame = comboAnimationFrame;
	}
	
	public boolean isOnComboAnimation() {
		return onComboAnimation;
	}

	public void setOnComboAnimation(boolean onComboAnimation) {
		this.onComboAnimation = onComboAnimation;
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
	
	
	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public int getCoolingPeriod() {
		return coolingPeriod;
	}

	public void setCoolingPeriod(int coolingPeriod) {
		this.coolingPeriod = coolingPeriod;
	}
	
	public void decCoolingPeriod()
	{
		this.coolingPeriod = this.coolingPeriod -1;
	}
	
	public LinkedList<Move> getMovePipeline(){
		return movePipeline;
	}
	
	public void setMovePipeline(LinkedList<Move> movePipeline){
		this.movePipeline = movePipeline;
	}
	
	public void removeMoveFromPipeline(){
		if(movePipeline.size()>1)
		{
			movePipeline.removeFirst();
		}
	}
	
	public Move getDefaultMove(){
		return defaultMove;
	} 
	
	public void setDefaultMove(Move defaultMove){
		this.defaultMove = defaultMove;
	}
}
