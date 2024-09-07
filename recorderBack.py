import os
from gpiozero import Button
stopButton = Button(17)

os.system("./recorder.sh " + audioFileName + " &")
recording = True
while recording:
	if stopButton.is_pressed:
		os.system("kill %1")
		recording = False
 
