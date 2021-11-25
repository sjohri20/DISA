#include<stdio.h>
#include<string.h>
#include<math.h>
#include <stdlib.h>
int main()
{
FILE *fptr;
int ws,ss,Ck,i=0,j,k,l,a,pos;
double Cg;
scanf("%d %d",&ws,&ss);
//printf("hello!");
//ws=input()#window size
//ss=input()#shift size
//N=len(s)#length of genomic sequence
char s[ws];
int len;
char filename[15];
char ch;

printf("Enter the filename to be opened \n");
scanf("%s", filename);
FILE *f = fopen("file1.txt", "w");
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
for(a=0;a<2250;a++)
{

for(i=0+a*ss;i<ws+a*ss;i++)

    {
	//printf ("%c", ch);
        s[i-a*ss]=ch;
 if(s[i-a*ss]=='G')
{
//printf("i=%d and si=%c\n",i-a*ss,s[i-a*ss]);
  s[i-a*ss]=1;
//printf("i=%d and si=%d\n",i-a*ss,s[i-a*ss]);
}
 else
{
//printf("i=%d and si=%c\n",i-a*ss,s[i-a*ss]);
  s[i-a*ss]=-1;

//printf("i=%d and si=%d\n",i-a*ss,s[i-a*ss]);
}
 ch = fgetc(fptr);

 }


len=i;
//printf("len=%d\n",len);
//for i in range(0,N-ws+1,+ss):

    Cg=0;
    for(k=1;k<ws;k++)
    {
        Ck=0;
        for (l=1;l<ws-k+1;l++)
        {
            Ck=Ck+(s[l-1])*(s[l+k-1]);
 		

        }
	//printf("ck=%d\n",Ck);
        Cg=Cg+(double)((fabs(Ck))/(ws-k));
	//printf("Cg=%fand k=%d\n",Cg,k);

      }
     //printf("Cg=%f\n",Cg);

   // printf("%f\n",(Cg+0.0)/(ws-1));
    fprintf(f, "%f\n",(Cg+0.0)/(ws-1));
pos = ftell(fptr);
//printf("pos=%d\n",pos);
fseek(fptr, -ws+ss-1, SEEK_CUR);
pos = ftell(fptr);
//printf("pos=%d\n",pos);
ch = fgetc(fptr);
 //fseek(fptr, a*ss, SEEK_SET); 
//printf("shifted=%c\n",ch);
 
}

   
//raw_input()
 fclose(fptr);

fclose(f);
  return 0;
}      
      
        

