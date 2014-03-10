/*
 * doll.c
 *
 *  Created on: 11 ???? 2014
 *      Author: elvirag
 */

#include <stdio.h>
#include <stdlib.h>

#define MAX_CHARS 1024

int main() //not sure if works, have to run in ubuntu
{
	float dollar = 0.0, sums = 0.0;

	printf("Type the dollar exchange rate today, followed by amounts you want to convert to ILS:\nExample:\n3.58 10 13 19\n");
	printf("$                IS\n");
	printf("_                __\n");

	scanf("%f", &dollar);
	while (scanf("%f", &sums) > 0)
		printf("%-10.2f       %-10.2f\n", sums, sums*dollar);
	return 0;

}
