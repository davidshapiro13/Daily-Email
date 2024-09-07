import sys
import os
length = len(sys.argv)
print(sys.argv)
command = 'echo "' + sys.argv[1] + '" | mail -s' + ' "' + sys.argv[2] + '" ' + sys.argv[3] + " -A " + sys.argv[4] + " -A " + sys.argv[5]
if length > 6:
	for x in range (6, length):
		command = command + " -A " + sys.argv[x]
print(command)
os.system(command)
