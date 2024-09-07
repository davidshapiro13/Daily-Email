import java.io.File;

/**
 * Records audio and photo
 * @author David Shapiro
 * @version 1.0
 */
public class Recorder implements General {
    Utility u = new Utility();

    String filePathPhoto;
    String filePathAudio;

    /**
     * Constructor for recorder
     */
    public Recorder()
    {
        //Save general file path
        filePathPhoto = System.getProperty("user.home") + "/" + PHOTO_FOLDER_NAME + "/";
        filePathAudio = System.getProperty("user.home") + "/" + AUDIO_FOLDER_NAME + "/";
    }

    /**
     * Takes picture
     */
    public void takePhoto()
    {
        //Shell command
        String command = photoCommand + filePathPhoto + u.getDate() + photoExt; 
        try
        {
            u.playWav(new File(smilePath));
            Process process = Runtime.getRuntime().exec(command);
        }
        catch (Exception e)
        {
            u.playWav(new File(cameraErrorPath));
        }
    }

    /**
     * Uses pretaken photo
     * @param is photo prerecorded
     */
    public void takePhoto(boolean preRecord)
    {
        String command = photoCommand + filePathPhoto + "CHANGE" + photoExt; 
        try
        {
            u.playWav(new File(smilePath));
            Process process = Runtime.getRuntime().exec(command);
        }
        catch (Exception e)
        {
            u.playWav(new File(cameraErrorPath));
        }

        u.sleep(5);
    }

    /**
     * Records audio
     */
    public void recordAudio()
    {
        String title = filePathAudio + u.getDate() + audioExt;
        String command = audioCommand + " " + title;

        try
        {
            u.playWav(new File(recordingPath));
            Process process = Runtime.getRuntime().exec(command);
	    process.waitFor();

            u.playWav(new File(donePath));
        }
        catch (Exception e)
        {
            u.playWav(new File(audioErrorPath));
        }
    }

    /**
     * Uses prerecorded audio
     */
    public void recordAudio(boolean preRecord)
    {
        String title = filePathAudio + "CHANGE" + audioExt;
        String command = audioCommand + THIRTY_SECONDS + title;

        try
        {
            u.playWav(new File(recordingPath));
            Process process = Runtime.getRuntime().exec(command);
            u.sleep(30);
            u.playWav(new File(donePath));
            u.playWav(new File(prerecordPath));
        }
        catch (Exception e)
        {
            u.playWav(new File(audioErrorPath));
        }
    }

}
