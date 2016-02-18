import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;


public class ConvertAudio {

	/**
	 * @param args
	 * @throws EncoderException 
	 */
	public static void main(String[] args) throws EncoderException {
		File source = new File("C:\\work\\custCSE_h\\MarioWav\\WebContent\\audio2\\bass.wav");
		File target = new File("C:\\work\\custCSE_h\\MarioWav\\WebContent\\audio2\\bass.mp3");
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		
		Encoder encoder = new Encoder();
		encoder.encode(source, target, attrs);

	}

}
