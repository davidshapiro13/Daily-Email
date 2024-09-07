import os
from os import system

#Created by David
#July 2019
#David says hi!

print("Starting conversion");

items = os.listdir()

for file in items:
	name = file.split(".")[0]
	os.system("ffmpeg -i " + name + ".mp3 " + name + ".wav")
print("All Done!") 
