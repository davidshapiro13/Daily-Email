#!/usr/bin/env python
import pygame , sys, datetime
from datetime import date
from pygame.locals import *
pygame.init()
#Colors
RED = (255,0,0) ; BLUE = (0,0,255) ; GREEN = (0,128,0) ; BLACK = (0,0,0) ; WHITE = (255,255,255) ;
PINK = (255,0,255) ; LIME = (0,255,0) ; ORANGE = (255,165,0) ; YELLOW = (255,255,0) ; SALMON = (255,160,122)
ZONE = pygame.display.set_mode((600, 600))
now = datetime.datetime.now()
today = now.strftime("%m-%d-%Y")
while True:
    ZONE.fill(RED)
    FONT = pygame.font.Font('freesansbold.ttf', 40)
    TEXT = FONT.render('Good Morning David!', True, BLUE, RED)
    ZONE.blit(TEXT, (100, 150) )
    TEXT2 = FONT.render('Today is ' + str(today), True, BLUE, RED)
    ZONE.blit(TEXT2, (100, 210) )
    #Event capture statements go here
    pygame.display.update()
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()
