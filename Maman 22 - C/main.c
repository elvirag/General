#include <stdio.h>
#include <stdlib.h>

#define BUFF 30

int main()
{
    char command[BUFF];
    int i;

    FOREVER
        if(scanf("%s",command==1))
            for (i = 0; cmd[i].func != NULL; i++)
                if (strcmp(command,cmd[i].name) == 0)
                    break;
            if (cmd[i].func == NULL)
                fprintf(sterr,"Command does not exist:%s\n",command);
            else(*(cmd[i].func))();
        }
    return 0;
}
