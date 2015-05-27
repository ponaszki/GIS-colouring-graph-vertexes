package model_new;

public class SetTimer {
	private long startTime;
	private long endTime;
	public SetTimer(){
		this.startTime = System.nanoTime();
	}
	public long getDuration(){
		this.endTime = System.nanoTime();
		long duration = (this.endTime - this.startTime);
		return duration;
	}
}
