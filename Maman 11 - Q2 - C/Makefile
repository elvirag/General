all: con my_add
FLAGS = -Wall  -g -pedantic -ansi

con:
	gcc $(FLAGS)  con.c -o con
	chmod +x con

my_add:
	gcc $(FLAGS)  my_add.c -o my_add
	chmod +x my_add	

clean:
	rm -f *.o 
	rm -f *~
	rm my_add
	rm con
