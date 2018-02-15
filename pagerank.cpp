#include <iostream>
#include <cmath>
using namespace std;
double tavolsag(double A[], double B[], int x)
{
	double osszeg=0;	
	for(int i=0; i<x; i++)
	{
		osszeg+=(A[i]-B[i])*(A[i]-B[i]);
	}
	return sqrt(osszeg);
}
void kiir(double M[], int y)
{
	for(int i=0; i<y; i++)
	{
		cout<<M[i]<<" ";
	}
}
main()
{
double L[4][4]={
	{0.0, 0.0, 1.0/3.0, 0.0},
	{1.0,1.0/2.0, 1.0/3.0, 1.0},
	{0.0, 1.0/2.0, 0.0, 0.0},
	{0.0, 0.0, 1.0/3.0, 0.0}};
double PR[4]={0.0, 0.0, 0.0, 0.0};
double PRv[4]={1.0/4.0, 1.0/4.0, 1.0/4.0, 1.0/4.0};

int i, j;
for(;;)
{
	for (i=0; i<4; i++)
	{
		PR[i]=0.0;
		for(j=0; j<4;j++)
		{
			PR[i]+=(L[i][j]*PRv[j]);
		}
	}	
	if (tavolsag(PR, PRv, 4) <0.0000000001)
		break;
	for(i=0;i<4;i++)
	{
		PRv[i]=PR[i];
	}
}
kiir(PR,4);
return 0;
}
