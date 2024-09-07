import java.util.ArrayList;
/**
 * Runs Daily Email - College Edition
 * @author David Shapiro
 * @version 2.0
 */
public class Runner implements General {

    /**
     * Main method for program
     * @param args to send to program
     */
    public static void main(String[] args)
    {
	WebScraper scraper = new WebScraper(WEBSITE_NAME);
        MusicPlayer player = new MusicPlayer();
        Recorder recorder = new Recorder();
        Sender sender = new Sender();
	ArrayList<String> customParts = scraper.getSpecialParts();
	scraper.reset();
	System.out.println("RESET");
	System.out.println(customParts);

	if (args.length == 0)
        {
		player.play(); //play a song
	}
	//Prerecording
        if (args.length == 1 && args[0].equals("prerecord"))
        {
                System.out.println("Prerecording! ");
                recorder.takePhoto(true);
                recorder.recordAudio(true);
        }
	else {
        switch (customParts.size())
        {
            case 0: //Regular email
	    System.out.println("ORDINARY EMAIL");
            recorder.takePhoto();
            recorder.recordAudio();

            sender.send();
            break;
            
            case 1:  //Custom Message
 	    System.out.println("Got this far");
            recorder.takePhoto();
            recorder.recordAudio();
            sender.send(customParts.get(0));
            
            break;

            case 2: //custom message and subject
		recorder.takePhoto();
		recorder.recordAudio();
            	sender.send(customParts.get(1), customParts.get(0));
            break;

            case 3: //message, image, and audio
            sender.send(customParts.get(0), customParts.get(1), customParts.get(2));
            break;
            
            case 4: //message, subject, image, audio
                recorder.takePhoto();
                recorder.recordAudio();
                sender.send(customParts.get(1), customParts.get(0), customParts.get(2), customParts.get(3));
            break;
            
            default:
            recorder.takePhoto();
            recorder.recordAudio();
            sender.send();
            break;
        }
}

}
}
