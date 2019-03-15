import java.io.*;
import java.util.*;
import java.math.*;
public class elgamalds
{

static double r,c1,c2;
static int m,p,d,e1,e2,c=0;
public static int modulo(int a,int b)//..........>
{
int i=1,c=-1;
if(a<0&&b>0)
{
while(c<0)
{
c=b*i+a;
i++;
}
}
else
c=a%b;
return c;
}
public static int solexucldalgo(long b,long n)
{
int mi=1;                
long r,r1,r2,t,t1,t2,q;
r1=n;
r2=b;
t1=0;
t2=1;
while(r2>0)
{
q=r1/r2;
r=r1-q*r2;
r1=r2;
r2=r;
t=t1-q*t2;
t1=t2;
t2=t;
}
if(r1==1)
{
int s1,s2;
s1=(int)t1;
s2=(int)n;
mi=modulo(s1,s2);
}
return mi;
}                    //multiplicative inverse........<|

public static int addinv(int a,int b)
{
int ret=0;
for(int i=0;modulo((a+i),b)!=0;i++)
ret= i;
return ret;
}

public static int gcd(int n1,int n2)   //..........>
{
int i,g=1;
for(i=1;i<=n1&&i<=n2;i++)
{
if(n1%i==0&&n2%i==0)
g=i;
}
return g;
}
public static int phif(int a)
{
int p=0;
for(int i=1;i<a;i++)
{
if(gcd(i,a)==1)
p+=1;
}
return p;
}              //......GCD<|

public static int[] gr(int a)
{
int i,j;
for(i=1;i<a;i++)
{	
if(gcd(a,i)==1)
c+=1;
}
int g[]=new int[c];
for(j=0,i=1;i<a;i++)
{
if(gcd(a,i)==1)
{
g[j]=i;
j++;
}
}
return g;
}

public static int[] primitiveroot(int g[])  ///......>
{
int b=1,i=0,j=0,k=0;
int gt[]=new int[c],prt[]=new int[c];
while(k<c)
{
int t=(int)g[k];
for(int z=1;z<=i;z++)
{
b*=b;	
}
gt[i]=modulo(b,p);
i++;
if(Arrays.equals(g,gt))
{
prt[j]=g[i];
j++;
k++;
}
}
for (i=0; i<j; i++)
{
System.out.print(prt[i]);	
}
return prt;
}             //premitive root calculator....<|

public static double powermod(double x,double y,double z)
{                    //power mod calc
double r=1;
for(int i=0;i<y;i++)
r=((r*x)%z);
return r;	
}

public static void encrpt(int m,int e1,int e2,int p)
{
double c,x,y;
Random rand=new Random();
int r1= rand.nextInt(10)+1;
x=e1;
//r=r1;
y=p;	
c1=powermod(e1,r,y);
x=e2;
c=powermod(x,r,p);
c2=modulo((m-d*(int)c1)*
solexucldalgo((long)r,(long)(p-1)),(p-1));
System.out.println("Random r is: " +r);
System.out.println("Signed message are s1: " +c1 +" s2: " +c2);
System.out.println("Transmiting msg:-----_____...");
System.out.println("s1, s2, m : " +c1 +" " +c2 +" " +m);
decrpt(c1,c2,m);
}

public static void decrpt(double c1,double c2,int m)
{
int pt,p1,p2;
int c2t=(int)c2;
p1=(int)powermod(e1,m,p);
p2=(int)modulo((int)powermod(e2,c1,p)*
(int)powermod(c1,c2,p),p);
System.out.println("v1: " +p1 +" " +"v2: " +p2);
if(p1==p2)
System.out.println("Message is accepted by reciver");
else
System.out.println("Message is NOT accepted by reciver");	
}

public static void main(String[] args) 
{
int i;
int g[]=new int[c];
int gp[]=new int[c];
Scanner sc=new Scanner(System.in);
System.out.print("Enter prim no P: ");
p=sc.nextInt();
g=gr(p);
System.out.println("Enter d such that 1<d<p-2");
System.out.print("d is member of: ");
for(i=0;i<c;i++)
System.out.print(g[i] +" ");
System.out.print("d: ");
d=sc.nextInt();
System.out.print("Select e1 is a primitve root of g: ");
e1=sc.nextInt();
System.out.print("Enter massage: ");
m=sc.nextInt();
System.out.print("Enter r: ");
r=sc.nextDouble();
double e1t,dt,pt;
e1t=(double)e1;
dt=(double)d;
pt=(double)p;
double e2t=powermod(e1,d,p);
e2=(int)e2t;
encrpt(m,e1,e2,p);
primitiveroot(g);     //p 11 d 3 e1 2 r 4 m 7 c1c2 5 6 
}

}
//p ramesh kumar paikra
