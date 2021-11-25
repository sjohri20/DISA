#include<stdio.h>
#include<string.h>
#include<math.h>
#include<complex.h>
#include <stdlib.h>
#include <tgmath.h>
double abs1(double complex z)
{
double a,b,c;
a=(creal(z)*creal(z));
b=(cimag(z)*cimag(z));
c= sqrt(a+b);
return c;
}

int main()
{
FILE *fptr;
int ws,ss,i=0,j,k,l,a,pos;
double Cg;
double complex Ck,z;
scanf("%d %d",&ws,&ss);

FILE *f = fopen("file.txt", "w");
if (f == NULL)
{
    printf("Error opening file!\n");
    exit(1);
}

/* print some text */



char s[ws];
double complex str[ws];
int len;
char filename[15];
char ch;

printf("Enter the filename to be opened \n");
scanf("%s", filename);

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
        s[i-a*ss]=ch;
 	if(s[i-a*ss]=='G')
	{
		//printf("i=%d and si=%c\n",i-a*ss,str[i-a*ss]);
  		str[i-a*ss]=1;
		//printf("i=%d and si=%d\n",i-a*ss,str[i-a*ss]);
	} 
	else if(s[i-a*ss]=='A')
	{
		//printf("i=%d and si=%c\n",i-a*ss,str[i-a*ss]);
   		str[i-a*ss]=1*I;
		//printf("i=%d and si=%f\n", i, cimag(str[i-a*ss]));
	}
 	else if(s[i-a*ss]=='T')
	{
		//printf("i=%d and si=%c\n",i-a*ss,str[i-a*ss]);
  		str[i-a*ss]=-1.0*I;
		//printf("i=%d and si=%f\n", i, cimag(str[i]));
	}
 	else if (s[i-a*ss]=='C')
	{
		//printf("i=%d and si=%c\n",i-a*ss,str[i-a*ss]);
   		str[i-a*ss]=-1;
		//printf("i=%d and si=%d\n",i-a*ss,str[i-a*ss]);
	}
	ch = fgetc(fptr);

    }


len=i;
Cg=0;
    for(k=1;k<ws;k++)
    {
        Ck=0;
        for (l=1;l<ws-k+1;l++)
        {
            z=((double complex)(str[l-1])*(double complex)(str[l+k-1]));
	    Ck=Ck+z;
        }
	//printf("%f + i%f\n", creal(Ck), cimag(Ck));
        Cg=Cg+(abs1(Ck)/(ws-k));
	//printf("Cg=%fand k=%d\n",Cg,k);

     }
//printf("Cg=%f\n",Cg);
//printf("%f\n",(Cg+0.0)/(ws-1));
fprintf(f, "%f\n",(Cg+0.0)/(ws-1) );
pos = ftell(fptr);

fseek(fptr, -ws+ss-1, SEEK_CUR);
pos = ftell(fptr);

ch = fgetc(fptr);
 
}
fclose(fptr);

fclose(f);
return 0;
}      
