#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>

/**
This problem can be easily solved by executing the C program below at a self-defined path.
*/ 
int main(int argc, char **argv) { 
	// Access auth file in ../../problems/ec9da1496f80c8248197ba564097cebb
	FILE* authf = fopen("../../problems/ec9da1496f80c8248197ba564097cebb/auth","r");

	if (authf == NULL) {
		printf("could not find auth file in ../../problems/ec9da1496f80c8248197ba564097cebb/\n");
		return 0;
	}

	char auth[8];
	fgets(auth, 8, authf);
	fclose(authf);

	if (strcmp(auth, "no") != 0) {
		FILE* flagf;
		flagf = fopen("/problems/ec9da1496f80c8248197ba564097cebb/flag","r");

		char flag[64];
		fgets(flag, 64, flagf);
		printf("Oh. Well the auth file doesn't say no anymore so... Here's the flag: %s",flag);
		fclose(flagf);
	} else {
		printf("auth file says no. So no. Just... no.\n");
	}

	return 0;
}