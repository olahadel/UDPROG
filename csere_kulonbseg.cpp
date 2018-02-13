#include <iostream>
using namespace std;
int main()
{
int a=0, b=0;
cout<<"Adja meg 'a' erteket:";
cin>>a;
cout<<"Adja meg 'b' erteket:";
cin>>b;
a=a+b;
b=a-b;
a=a-b;
cout<<endl<<"Csere:"<<endl<<"a:"<<a<<endl<<"b:"<<b;
}
