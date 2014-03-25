/*
 * my_str.c
 *
 *  Created on: 5 ???? 2014
 *      Author: elvirag
 */
#include <stdio.h>
#include <stdlib.h>

int suffix(char str[], char c);


int suffix(char str[], char c){
	int seifaNum = 0;
	int i = 0, j =0;

	printf("\n");

	while (str [i] != '\0')
	{
		if (str[i] == c)
		{
			seifaNum++; //progressing the number of Seifas found
			j = i; //marking the start of the seifa.
			while (str[j] != '\0') // going over only the part of the string that starts from the index we have found.
			{
				printf("%c",str[j]);
				j++;
			}
			printf("\n");
		}
		i++;
	}

	return seifaNum;
}

int main()
{

	int lenght = 100;
	int count = 0;  //to keep track of how many chars have been used
	char c; // to store the current char
	char * str;

	str = calloc(lenght, sizeof(char)); //suppose it's max of 100 chars.
	if ( str == NULL)
		return  -1;
	char seifabegining;


	printf("The program is in a forever loop. Please hit 'Enter' if you want to end the program.\n");
	while(1)
	{
		printf("Please enter your string. 'Enter' signifies end of string.\n");
		while((c = getchar()) != '\n')//keep reading until a newline
		{
			if(count >= lenght)
			{
				lenght += 10;
				str = realloc(str, lenght * sizeof(char)); //add room for 10 more chars
			}

			str[count++] = c;
		}
		if (str[0] == '\0'){ //checking if first char is end of string
			printf("You have hit 'Enter'. Exiting the program...");
			exit(-1);
		}
		printf("Please enter the letter you want your seifas to end with:\n");
		char newline; //this is the newline, we don't want it.
		if(scanf("%c%c", &seifabegining, &newline));//we don't need it and we don't want warninigs

		printf("\nNumber of seifas found was: %d\n\n",suffix( str, seifabegining));
		str = calloc(lenght, sizeof(char));
		count = 0;
	}
}

