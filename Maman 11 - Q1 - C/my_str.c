/*
 * my_str.c
 *
 *  Created on: 5 ???? 2014
 *      Author: elvirag
 */
#include <stdio.h>
#include <stdlib.h>

int suffix(char str[], char c){
	int seifaNum = 0;
	int i = 0, j =0;

	while (str[i] != '\0') // going over the whole string.
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

int main() // to fix with Ido :(
{

	int lenght = 100;
	int count = 0;  //to keep track of how many chars have been used
	char c; // to store the current char
	char * str = malloc(lenght * sizeof(char)); //suppose it's max of 100 chars.
	char seifabegining;


	printf("The program is in a forever loop. Please hit 'Enter' if you want to end the program.\n");
	while(1)
	{
		printf("Please enter your string. 'Enter' signifies end of string.\n");
		while((c = getchar()) != '\n'){ //keep reading until a newline
			if(count >= lenght)
				str = realloc(str, (lenght += 10) * sizeof(char)); //add room for 10 more chars
			str[count++] = c;
		}
		if (str == '\0'){
			exit(-1);
		}
		printf("Please enter the letter you want your seifas to end with:\n");
		scanf("%c", &seifabegining);
		printf("Number of seifas found was: %d\n",suffix( str[lenght], seifabegining));
	}
	free(str);
}

