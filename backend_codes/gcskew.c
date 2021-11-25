#include<stdio.h>
#include<string.h>
#include<math.h>
#include <stdlib.h>
int main()
{
FILE *fptr;
int ws,ss,Ck,i=0,j,k,l,a,pos=0,count1=0,count2=0;
float value=0.0;
double Cg=0.0;
scanf("%d %d",&ws,&ss);
//printf("hello!");
//ws=input()#window size
//ss=input()#shift size
//N=len(s)#length of genomic sequence
char s[ws];
int len=0;
char filename[15];
char ch;

printf("Enter the filename to be opened \n");
scanf("%s", filename);
FILE *f = fopen("file2.txt", "w");
if (f == NULL)
{
    printf("Error opening file!\n");
    exit(1);
}

/*  open the file for reading */
fptr = fopen(filename, "r");
if (fptr == NULL)
   {
	printf("Cannot open file \n");
	exit(0);

   }

ch = fgetc(fptr);
for(a=0;a<450;a++)
{
count1=0;
count2=0;

 for(i=0+a*ss;i<ws+a*ss;i++)

    {
	//printf ("%c\n", ch);
        s[i-a*ss]=ch;
 	if(s[i-a*ss]=='G')
	{
	count1++;
	//printf("count1=%d\n",count1);
	}
 	else if(s[i-a*ss]=='C')
	{
	count2++;
	//printf("count2=%d\n",count2);
	}
		 
	ch = fgetc(fptr);
   }
//printf("%f\n",(count2-count1+0.0)/(count2+count1));

fprintf(f, "%f\n",(count2-count1+0.0)/(count2+count1) );
pos = ftell(fptr);

fseek(fptr, -ws+ss-1, SEEK_CUR);
pos = ftell(fptr);

ch = fgetc(fptr);
 
}


return 0;
}      
      
        

