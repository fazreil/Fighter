package my.punch.fazreil.fighter;

import android.graphics.Bitmap;

public class Move {

	private Bitmap moveBitmap;
	private int moveFrame;
	
	public Move(){
		
	}
	
	public Move(Bitmap bitMap, int moveFrame){
		this.moveBitmap = bitMap;
		this.moveFrame = moveFrame;
	}
	
	public Bitmap getMoveBitmap() {
		return moveBitmap;
	}
	public void setMoveBitmap(Bitmap moveBitmap) {
		this.moveBitmap = moveBitmap;
	}
	public int getMoveFrame() {
		return moveFrame;
	}
	public void setMoveFrame(int moveFrame) {
		this.moveFrame = moveFrame;
	}
}
