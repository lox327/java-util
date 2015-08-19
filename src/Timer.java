public class Timer {

	private long startTime;
	private long endTime;
	private long duration;
		
	protected void startTimer() {
		startTime = System.nanoTime();
	}
	
	protected void endTimer() {
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; //divide by 1000000 to get milliseconds
	}
	
	protected long getDuration() {
		return duration;
	}
	
	protected double getDurationSeconds() {
		return (double)duration/1000;
	}
	
	protected void printTime() {
		System.out.println(duration + "ms");
	}
	
	protected void printTimeSeconds() {
		System.out.println((double)duration/1000 + "s");
	}
	
}
