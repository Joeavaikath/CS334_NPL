//C program to illustrate pipe system call in C
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
char* msg1="Hello world";

int main(){
	
	char inbuf[20];
	int p[2],pid,nbytes;
	
	if(pipe(p) < 0)
		exit(1);
	
	if((pid = fork()) >0){
		
		close(p[0]);
		write(p[1],msg1,20);
		close(p[1]);
		wait(NULL);
	}
	else{
		close(p[1]);
		while((nbytes = read(p[0], inbuf, 20))>0)
			printf("*Child Process*: %s \n",inbuf);
		if(nbytes != 0)
			exit(2);
		close(p[0]);
		printf("Finished reading\n");
	}
	return 0;
}
