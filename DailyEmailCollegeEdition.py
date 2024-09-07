#Beginning on April 22 2020
#David Shapiro

from gpiozero import LED, Button
from time import sleep
from datetime import datetime
import os

print("Welcome to Daily Email -- College Edition ~ Created by David Shapiro");

regularEmailButton = Button(17)
noMusicButton = Button(22)
prerecordButton = Button(23)
justMusicButton = Button(27)
date = datetime.today().strftime('%Y.%m.%d')

os.system('javac -cp jsoup-1.13.1.jar: *.java');

def surge():
	os.system("./surgeWriter.sh")
def say(eventDay, musicOn, fileName):
	if fileName == "specialDays.txt":
		os.system("./speech.sh Hello. Today you are sending a special message. The subject is " + eventDay[1])
		os.system("./speech.sh Your message is " + eventDay[3])
	if fileName == "holidays.txt":
		os.system("./speech.sh Hello. Todays is a holiday. Today is " + eventDay[1])
		os.system("./speech.sh Your holiday message says " + eventDay[2])

	if (musicOn):
                os.system("./speech.sh Need to change what you were going to say? No problem! I will play a song while you think!")
	else:
                os.system("./speech.sh Hopefully you are ready because you chose to not have music.")
                os.system("./speech.sh If you need more time, switch of the raspberry pi and restart once you know what you will be saying")

def runSpeech(fileName, musicOn):
	line = []
	doc = []
	file = open(("txtFiles/" + fileName), "r")
	for part in file:
		line = part.split(",, ")
		doc.append(line)
	print (doc)
	print ("date " + date)
	for day in doc:
		if (day[0] == date):
			print("there is a holiday today " + fileName) 
			say(day, musicOn, fileName)
			file.close()
			return True			
	file.close()
	return False

def regularEmail(): #Need to add all runner options
	if not (runSpeech("specialDays.txt", True)): #not a special day
		runSpeech("holidays.txt", True)
	os.system('java -cp jsoup-1.13.1.jar: Runner')
	surge()
	sleep(30)
	os.system('sudo reboot')
def noMusic():
	if not (runSpeech("specialDays.txt", False)): #not a special day
		runSpeech("holidays.txt", False)
	os.system('java -cp jsoup-1.13.1.jar: Runner no') #ADD THE NO MUSIC PART
	surge()
	sleep(30)
	os.system('sudo reboot')
def prerecord():
	os.system('java -cp jsoup-1.13.1.jar: Runner prerecord') #TEST
	sleep(30)
	surge()
	os.system('sudo reboot')
def justMusic():
	os.system('java MusicRunner') 

while True:
        if regularEmailButton.is_pressed:
                print ("Regular Email")
                regularEmail()
                sleep(0.5)    
        if noMusicButton.is_pressed:
                print ("Regular Email but no Music")
                noMusic()
                sleep(0.5)
        if prerecordButton.is_pressed:
                print ("prerecording")
                prerecord()
                sleep(0.5) 
        if justMusicButton.is_pressed:
                print ("only play music")
                justMusic()
                sleep(0.5)
print("Process Complete- Have a great Day! Copyright April 2020");
