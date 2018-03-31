#include<stdio.h>
#include<string.h>
#include<sys/types.h>

#define MAX_COUNT 10
#define BUF_SIZE  100

void main(){

	pid_t pid;
	int i;
	char buf[BUF_SIZE];

	pid=fork();
	if(pid<0)
		printf("\nProcess creation failed");
	else if(pid==0)
		printf("\nThis is child process, with pid=%d\n",getpid());
	else
		printf("\nThis is parent process, with pid=%d\n",getpid());
}
