gnome-terminal -e "./exemple/rac 127.0.0.1 12345 12345"  --window-with-profile=test
gnome-terminal -e "./exemple/noeud 127.0.0.1 12345 12344"  --window-with-profile=test
sleep 5
gnome-terminal -e "./exemple/noeud 127.0.0.1 12345 12343"  --window-with-profile=test
