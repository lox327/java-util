import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;

public class AudioConverter {
	public void convertOne(String source, String target) throws IllegalArgumentException, InputFormatException, EncoderException {
		File src = new File(source);
		File targ = new File(target);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		
		Encoder encoder = new Encoder();
		encoder.encode(src, targ, attrs);
	}
	

	public void convertAll(String audioPath) throws IllegalArgumentException, InputFormatException, EncoderException {
		File folder = new File(audioPath);
		File[] listOfFiles = folder.listFiles();

		String source = null;
		String target = null;
		
	    for (int i = 0; i < listOfFiles.length; i++) {
	    	if (listOfFiles[i].isFile() && !listOfFiles[i].getName().contains(".mp3")) {
	    		source = audioPath + "\\" + listOfFiles[i].getName();
	    		target = audioPath + "\\" + listOfFiles[i].getName().replace("wav", "mp3");
	    		convertOne(source, target);
	    	}
	    }
	}

}
