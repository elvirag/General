/*
 * magic.c
 *
 *  Created on: 31 ???? 2014
 *      Author: elvirag
 */

#include <stdio.h>
#include <stdlib.h>

#define N 5 /**/
typedef enum {
	FALSE = 0, TRUE
} boolean;

/*All my functions declarations*/
void input(); /**/
void print(int * magic); /**/
boolean test_cube(int * magic); /**/

void print(int * magic) {
	int row, col;

	for (row = 0; row < N; row++) {
		for (col = 0; col < N; col++)
			printf("%6d", *(magic + row * N + col));
		printf("\n");
	}
}

//void input() {
//	int row, col;
//
//	for (row = 0; row < N; row++) {
//		for (col = 0; col < N; col++)
//			scanff("%c", &(magic + row * N + col));
//		printf("\n");
//	}
//}

/*Well, I can test the sums of the rows and columns right after one run of the for loop,
 * but the diagonals require to run all over the matrix first.*/
boolean test_cube(int * magic) {
	int row, col;
	int sum_row, sum_col, sum_diag1 = 0, sum_diag2 = 0;

	for (row = 0; row < N; row++) {
		sum_row = 0, sum_col = 0;
		for (col = 0; col < N; col++) {
//			printf("\nmagic[%d][%d] = %d", row, col, *(magic + row * N + col)); TODO
			sum_row += *(magic + row * N + col); /*sums the rows, one at a time*/
			sum_col += *(magic + row + col * N); /*sums the columns, one at a time*/
			if (row == col) /*sums the regular diagonal*/
				sum_diag1 += *(magic + row * N + col);
			if (row + col == N - 1) /*sums the opposite diagonal*/
				sum_diag2 += *(magic + row * N + col);
		}

//		printf("sum_row = %d\n", sum_row);TODO
//		printf("sum_col = %d\n", sum_col);
		if (sum_row != sum_col)
			return FALSE;

	}

//	printf("sum_row = %d\n", sum_row);TODO
//	printf("sum_col = %d\n", sum_col);
//	printf("sum_diag1 = %d\n", sum_diag1);
//	printf("sum_diag2 = %d\n", sum_diag2);

	if (sum_col != sum_diag1 || sum_diag1 != sum_diag2)
		return FALSE;

	return TRUE;
}

int main() {

	int magic[N][N] = { { 15, 8, 1, 24, 17 }, { 16, 14, 7, 5, 23 }, { 22, 20,
			13, 6, 4 }, { 3, 21, 19, 12, 10 }, { 9, 2, 25, 18, 11 } };

	//input();
	print(*(magic));
	if (test_cube(*(magic))) {
		printf("\nThis cube is indeed magic!!!");
	} else
		printf("\nThis cube is NOT magic!!!"); /*add some regex magic here*/
	//free(magic);
	return 0;
}
