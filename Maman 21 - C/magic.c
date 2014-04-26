/*
 * magic.c
 *
 *  Created on: 1 April 2014
 *      Author: Elvira Gandelman
 *      ID:     307032623
 */

#include <stdio.h>
#include <stdlib.h>

#define N 3 /*Defining the dimension of the magic square*/

typedef enum {
	FALSE = 0, TRUE = 1
} boolean;

/*All my functions declarations*/
int * input(); /*The function that gets the input and checks it*/
void print(int * magic); /*The function that prints*/
boolean test_cube(int * magic); /*The function that tests the magic!*/
void prog_exit();/*So I don't have to repeat myself in the strings.*/

/*Scanning the input*/
int * input() {
	char garbage;
	int row, col;
	int member = 0; /*Counts the members of the array so I can know we have it all filled*/
	int counter = 0, scans = 0;/*Counts number of parameters scanned & parameters successfully scanned*/
	int * magic = calloc(N * N, sizeof(int)); /*Initializing the array with zeroes*/
	boolean * check_array = calloc(N * N, sizeof(int)); /*Initializing the array with zeroes*/

	for (row = 0; row < N; row++)
		for (col = 0; col < N; col++) {
			counter += scanf("%d", (magic + row * N + col)); /*Counting my parameters*/
			scans++;
			if (scans != counter) {
				printf(
						"You have input some characters that are not integers!\n");
				prog_exit();
				return NULL;
			} else if (1
					> *(magic + row * N + col)|| *(magic + row * N + col) > N * N) {
				printf("%d is not in the range specified.",
						*(magic + row * N + col));
				prog_exit();
				return NULL;

			} else if (*(check_array + *(magic + row * N + col) - 1) == TRUE) {
				printf("\nThis member (%d) already exists in the cube,"
						"\nPlease don't repeat numbers in the magic cube!\n",
						*(magic + row * N + col));
				prog_exit();
				return NULL;
			} else {
				*(check_array + *(magic + row * N + col) - 1) = TRUE;
				member++;
			}
		}
	if (member != N * N){
		printf(
				/*Not supposed to get here. If I have all the length of legal characters within the range and no thing repeats, this is not logical that this sequence may exist!*/
				"Some of the numbers in the sequence needed (1 - N^2) are missing.\n");
		prog_exit();
		return NULL;
	}
	/*This portion of code is needed so the numbers scanned won't just go to the next magic square.*/
	scanf("%c", &garbage);
	if (garbage != '\n')
		counter++;

	/*In case of too many parameters*/
	if (counter > N * N) {
		printf("You have inputed too many parameters.\n");
		prog_exit();
		return NULL;
	}
	/*In case of too less parameters*/
	if (counter < N * N) {
		printf("You have inputed too few parameters.\n");
		prog_exit();
		return NULL;
	}
	return magic;
}



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

void prog_exit() {
	printf("\nProgram will now quit.\n");
	exit(0);
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

