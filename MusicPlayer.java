import java.io.File;

/**
 * Plays music on raspberry pi
 * @author David Shapiro
 * @version 1.0
 */
public class MusicPlayer implements General {
    File[] listOfSongs;
    Utility u = new Utility();
    
    /**
     * Constructor for Music Player
     */
    public MusicPlayer()
    {
        //load songs
        try
        {
            File folder = new File(musicPath);
            listOfSongs = folder.listFiles();
        }
        catch (Exception e)
        {
            u.playWav(new File(loadingErrorPath));
            listOfSongs = null;
        }
    }
    
    /**
     * Plays a random song
     */
    public void play()
    { 
        int songNum = (int)(Math.random() * listOfSongs.length);
        File song = listOfSongs[songNum]; 
	//song = new File("musicFiles/alf.wav");
        double time = 10;
        
        u.playWav(song);
    }
}
