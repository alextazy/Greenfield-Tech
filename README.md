# Greenfield-Tech

Running instructions:

Enter a search-words in Line 15 in "Program.java"

Make sure that there is a valid "words.txt" file (its possible to change the path in Line 10 in "Program.java")

==========================================================

Problems with the current state:

*Doesn't work with negative weight edges

Possible Solution:
Using Ford-Bellman algorithm instead of Dijkstra

*For each search-word the algorithm will re-run from the beginning
i.e for k search-words the time-complexity                      
will be K(E+ VLOGV) {E=edegs, V=Vertex}.
For big k its can cause a problem time-complexity wise.

Possible Solution:
Add suitable fields and modify dijkstra algorithm 
so after a single run we can get our required information in O(1)
