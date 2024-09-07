import os
import sys
from gpiozero import Button
audioFileName = sys.argv[1]
stopButton = Button(17)
print(audioFileName)
os.system("./recorder.sh " + audioFileName + " &")
recording = True
while recording:
	if stopButton.is_pressed:
		os.system("pkill -f arecord")
		recording = False
 
