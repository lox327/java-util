public class Timer {

	private long startTime;
	private long endTime;
	private long duration;
	
	/** Start the timer */	
	protected void startTimer() {
		startTime = System.nanoTime();
	}
	
	/** Stop the timer */	
	protected void endTimer() {
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; //divide by 1000000 to get milliseconds
	}
	
	/** Returns the duration
     	* If Value is Zero, Return Zero Value String Such as N/A or Included
     	* @return duration of cycle time in ms
     	*/ 
	protected long getDuration() {
		return duration;
	}
	
	/** Returns the duration
     	* If Value is Zero, Return Zero Value String Such as N/A or Included
     	* @return duration of cycle time in s
     	*/ 
	protected double getDurationSeconds() {
		return (double)duration/1000;
	}
	
	/** Prints the duration in ms*/
	protected void printTime() {
		System.out.println(duration + "ms");
	}
	
	/** Prints the duration in s*/
	protected void printTimeSeconds() {
		System.out.println((double)duration/1000 + "s");
	}
	
}
