import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;
import java.io.IOException;

public class AudioConvert {
	public void convertOne(String source, String target) throws IllegalArgumentException, InputFormatException, EncoderException, IOException {
		GetPropValues prop = new GetPropValues();
		File src = new File(source);
		File targ = new File(target);
		AudioAttributes audio = new AudioAttributes();
		
		audio.setCodec(prop.getProp("codec"));
		audio.setBitRate(new Integer(prop.getProp("bitrate")));
		audio.setChannels(new Integer(prop.getProp("channels")));
		audio.setSamplingRate(new Integer(prop.getProp("samplerate")));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat(prop.getProp("format"));
		attrs.setAudioAttributes(audio);
		
		Encoder encoder = new Encoder();
		encoder.encode(src, targ, attrs);
	}
	

	public void convertAllToMp3(String audioPath) throws IllegalArgumentException, InputFormatException, EncoderException, IOException {
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
	
	public void convertAllToWav(String audioPath) throws IllegalArgumentException, InputFormatException, EncoderException, IOException {
		File folder = new File(audioPath);
		File[] listOfFiles = folder.listFiles();

		String source = null;
		String target = null;
		
	    for (int i = 0; i < listOfFiles.length; i++) {
	    	if (listOfFiles[i].isFile() && !listOfFiles[i].getName().contains(".wav")) {
	    		source = audioPath + "\\" + listOfFiles[i].getName();
	    		target = audioPath + "\\" + listOfFiles[i].getName().replace("mp3", "wav");
	    		convertOne(source, target);
	    	}
	    }
	}
	
	public void convertAll(String audioPath, String targetFormat) throws IllegalArgumentException, InputFormatException, EncoderException, IOException {
		File folder = new File(audioPath);
		File[] listOfFiles = folder.listFiles();

		String source = null;
		String target = null;
		
	    for (int i = 0; i < listOfFiles.length; i++) {
	    	if (listOfFiles[i].isFile() && !listOfFiles[i].getName().contains(targetFormat)) {
	    		source = audioPath + "\\" + listOfFiles[i].getName();
	    		target = audioPath + "\\" + listOfFiles[i].getName().replace("wav", targetFormat);
	    		convertOne(source, target);
	    	}
	    }
	}
}
