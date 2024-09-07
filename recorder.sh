arecord --device=hw:1,0 -d 10000 --format S16_LE --rate 44100 -c1 $1 &
