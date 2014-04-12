/*
 * magic.c
 *
 *  Created on: 1 April 2014
 *      Author: elvirag
 */

#include <stdio.h>
#include <stdlib.h>

#define N 3 /*Defining the dimension of the magic square*/

typedef enum {
	FALSE = 0, TRUE = 1
} boolean;

/*All my functions declarations*/
int * input(); /*The function that gets the input*/
void print(int * magic); /*The function that prints*/
boolean test_cube(int * magic); /*The function that tests the magic!*/

/*
 * Printing the matrix
 * */
void print(int * magic) {
	int row, col;

	for (row = 0; row < N; row++) {
		for (col = 0; col < N; col++)
			printf("%6d", *(magic + row * N + col));
		printf("\n");
	}
}

/*Scanning the input*/
int * input() {
	char garbage;
	int row, col;
	int counter = 0;/*Counts number of parameters scanned so I won't have to hit Enter each time*/
	int * magic = calloc(N * N, sizeof(int)); /*Initializing the array with zeroes*/

	for (row = 0; row < N; row++)
		for (col = 0; col < N; col++)
			counter += scanf("%d", (magic + row * N + col)); /*Counting my parameters*/

	/*This portion of code is needed so the numbers scanned won't just go to the next magic square.*/
	scanf("%c", &garbage);
	if (garbage != '\n')
		counter++;

	/*In case of too many parameters*/
	if (counter > N * N) {
		printf(
				"You have inputed too many parameters.\nThe program will now quit.\n");
		exit(0);
	}
	/*In case of too less parameters*/
	if (counter < N * N) {
		printf(
				"You have inputed too few parameters.\nThe program will now quit.\n");
		exit(0);
	}

	return magic;
}

/*Well, I can test the sums of the rows and columns right after one run of the for loop,
 * but the diagonals require to run all over the matrix first.*/
boolean test_cube(int * magic) {
	int row, col;
	int sum_row, sum_col, sum_diag1 = 0, sum_diag2 = 0;

	for (row = 0; row < N; row++) {
		sum_row = 0, sum_col = 0;
		for (col = 0; col < N; col++) {
			sum_row += *(magic + row * N + col); /*sums the rows, one at a time*/
			sum_col += *(magic + row + col * N); /*sums the columns, one at a time*/
			if (row == col) /*sums the regular diagonal*/
				sum_diag1 += *(magic + row * N + col);
			if (row + col == N - 1) /*sums the opposite diagonal*/
				sum_diag2 += *(magic + row * N + col);
		}

		if (sum_row != sum_col)
			return FALSE;

	}

	if (sum_col != sum_diag1 || sum_diag1 != sum_diag2)
		return FALSE;

	return TRUE;
}

int main() {
	int *p = NULL;

	do {
		print(p = input());

		if (test_cube(p))
			printf("\nThis cube is indeed magic!!!\n\n");
		else
			printf("\nThis cube is NOT magic!!!\n\n");

		p = NULL;
	} while (1);

}

