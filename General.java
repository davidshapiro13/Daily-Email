/**
 * General information to know
 * @author David Shapiro
 * @version 1.0
 */
public interface General {
    final String WEBSITE_NAME = "https://daily-email-college.surge.sh";
    final String musicPath = "musicFiles";
    
    final String memberPath = "txtFiles/members.txt";
    final String messagePath = "txtFiles/messages.txt";
    final String holidaysPath = "txtFiles/holidays.txt";
    final String greetingsPath = "txtFiles/greetings.txt";
    final String specialDayPath = "txtFiles/specialDays.txt";

    final String WEBSITE_PATH = "websiteFiles/index.html";
    
    final String cameraErrorPath = "audioFiles/CameraError.wav";
    final String emailErrorPath = "audioFiles/EmailError.wav";
    final String audioErrorPath = "audioFiles/AudioError.wav";
    final String musicErrorPath = "audioFiles/MusicError.wav";
    final String loadingErrorPath = "audioFiles/LoadingError.wav";
    
    final String smilePath = "audioFiles/Smile.wav";
    final String recordingPath = "audioFiles/Recording.wav";
    final String donePath = "audioFiles/Done.wav";
    final String windowPath = "audioFiles/Window.wav";
    final String prerecordPath = "audioFiles/Prerecord.wav";

    final String audioCommand = "python3 recorder.py";
                                
    final String photoCommand = "raspistill -o ";

    final String THIRTY_SECONDS = "30";
    final String TWENTY_SECONDS = "20";
    final String FIFTHTEEN_SECONDS = "15";
    
    final String PHOTO_FOLDER = "~/season2P/";
    final String AUDIO_FOLDER = "~/season2A/";
    final String PHOTO_FOLDER_NAME = "season2P";
    final String AUDIO_FOLDER_NAME = "season2A";
    final String SUBJECT = "Daily Email -- College Edition";

    final String audioExt = ".wav";
    final String photoExt = ".jpg";

    final String birthdayMessage = "Happy Birthday! I hope you have a wonderful" + 
                                   " day and treat yourself to something special! Are you one? Are you two?" +
				   " Are you three... Are you [INSERT YOUR AGE HERE]. YAY!";
    final String birthdayGreeting = "Happy Birthday";
    final String signature = " Website: https://dailyemaildss.wordpress.com -Raspberry Pi"; 
    final String HOLIDAY_GREETING = "Happy ";
    
    final int MESSAGES = 0;
    final int GREETINGS = 1;
    final int HOLIDAYS = 2;
}
