
public class Timer {

	static private long startTime;
	static private long endTime;
	static private long duration;
		
	static protected void startTimer() {
		startTime = System.nanoTime();
	}
	
	static protected void endTimer() {
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; //divide by 1000000 to get milliseconds
	}
	
	static protected long getDuration() {
		return duration;
	}
	
	static protected void printTime() {
		System.out.println(duration + "ms");
	}
	
	static protected void printTimeSeconds() {
		System.out.println((double)duration/1000 + "s");
	}
	
}
