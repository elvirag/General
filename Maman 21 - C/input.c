/*
 * input.c
 *
 *  Created on: 1 ???? 2014
 *      Author: elvirag
 */

#include <stdio.h>
#include <stdlib.h>

#define N 5 /**/
typedef enum {
	FALSE = 0, TRUE
} boolean;

/*All my functions declarations*/
int * input(); /**/
void print(int * magic); /**/


void print(int * magic) {
	int row, col;

	for (row = 0; row < N; row++) {
		for (col = 0; col < N; col++)
			printf("%6d", *(magic + row * N + col));
		printf("\n");
	}
}

int * input() {
	int row, col;
	int * magic = malloc( N * N * sizeof(int)); /*Initializing the array*/

	for (row = 0; row < N; row++)
		for (col = 0; col < N; col++)
			scanf("%d", (magic + row *N + col));

	return magic;
}

int main(){


	do{
		print(input());
	}
	while (1);

	return 0;
}
