all: doll
FLAGS = -Wall  -g -pedantic -ansi

doll:
	gcc $(FLAGS)  doll.c -o doll
	chmod +x doll

clean:
	rm -f *.o 
	rm -f *~
	rm doll
