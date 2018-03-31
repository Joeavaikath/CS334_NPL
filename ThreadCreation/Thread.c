#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
int i,thread_id; 
void *myThreadFun(void *variables)//Thread Function
{
    sleep(1);
    printf("Printing HelloWorld from Thread \n");
    thread_id=pthread_self();
    printf("\nThread ID is: %d\n",thread_id);
    return NULL;
}
  
int main()
{
    pthread_t tid[2];
    printf("\nFrom the main program");
    printf("Before Thread\n");
    for(i=0;i<2;i++){
	pthread_create(&tid[i], NULL, myThreadFun, NULL);
        }
    pthread_join(tid[0], NULL);
    pthread_join(tid[1], NULL);
    printf("After Thread\n");
    printf("\nFrom the main program");
    exit(0);
}
