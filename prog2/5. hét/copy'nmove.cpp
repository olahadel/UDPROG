#include <iostream>
#include <utility>

using namespace std;

class Test
{
public:
    int *p_valt;
    int p_meret;

    Test ()     //az alapértelmezett konstruktor létrehoz egy  tömböt
        : p_valt( new int[ 64 ] )
        , p_meret( 64 )
    {};

    Test (int n)
        : p_valt( new int[ n ] )
        , p_meret( n )
    {};

    // copy constructor
    Test (const Test& masik)
        : p_valt( new int[ masik.p_meret  ] )
        , p_meret( masik.p_meret )
    {
        for ( int i = 0; i < p_meret; ++i )
        {
            p_valt[ i ] = masik.p_valt[ i ];
        }
        cout << "Copy constructor called." << endl;
    }

    // move constructor
    Test (Test&& masik)
        : p_valt( masik.p_valt )
        , p_meret( masik.p_meret )
    {
        masik.p_valt = NULL;
        masik.p_meret = 0;
        cout << "Move constructor called." << endl;
    }

    //  move assignment
    Test& operator = (Test&& masik) {
        // Self-assignment detection
		if (&masik == this)
			return *this;

		// Release any resource we're holding
		delete [] p_valt;

		// Transfer ownership of a.m_ptr to m_ptr
		p_valt = masik.p_valt;
        p_meret = masik.p_meret;

        masik.p_valt = NULL;
        masik.p_meret = 0;

        cout << "Move assignment called." << endl;

        return *this;
    }

    ~Test ()
    {
        delete [] p_valt;
        cout << "Destructor called." << endl;
    }

    void giveValue(int ertek){
        for ( int i = 0; i < p_meret; ++i )
        {
            p_valt[ i ] = ertek;
        }
    }

    void getValue() {
        cout << endl;

        if (p_valt == NULL) {
            cout << "\tA tomb ures." << endl;
        }
        else {
            for ( int i = 0; i < p_meret; ++i )
            {
                cout << "\tA tomb " << i << ". erteke: " << p_valt[ i ] << endl;
            }
        }
    }

};

int main()
{
    cout << "MASOLO SZEMANTIKA" << endl <<endl;
    Test *t1, *t2;
    t1 = new Test(1);
    t2 = new Test(2);

    //////////////////////////MÁSOLÓ SZEMANTIKA

    t1->giveValue(1);
    t2->giveValue(2);

    cout <<"t1 (eloszor letrehozott) erteke: ";
    t1->getValue();

    cout << "t2 erteke masolo ertekadas elott: ";
    t2->getValue();

    t2 = t1;  // calls assignment operator, same as "t2.operator=(t1);"     //másoló értékadás

    cout << "t2 erteke masolo ertekadas(t1) utan: ";
    t2->getValue();

    Test *t3;  // calls copy constructor, same as "Test t3(t1);"        //másoló konstruktor
    t3 = new Test(*t1);

    cout << "t3 erteke masolo konstruktor(t1) altali letrehozassal: ";
    t3->getValue();

    delete t1;
    delete t2;
    delete t3;

    //////////////////////////MOZGATÓ SZEMANTIKA

    cout << endl << "MOZGATO SZEMANTIKA" << endl <<endl;

    //  move constructor
    Test t4(4);
    t4.giveValue(4);
    cout <<"t4 erteke mozgato konstruktor alkalmazasa elott: ";
    t4.getValue();
    Test t5(move(t4));
    cout <<"t5 erteke mozgato konstruktor(t4) altali letrehozassal: ";
    t5.getValue();
    cout <<"t4 erteke mozgato konstruktor alkalmazasa utan: ";
    t4.getValue();

    //  move assignment
    Test t6(6);
    t6.giveValue(6);
    cout <<"t6 erteke mozgato ertekadas elott: ";
    t6.getValue();
    t6 = move(t5);
    cout <<"t6 erteke mozgato ertekadas utan: ";
    t6.getValue();
    cout <<"t5 erteke: ";
    t5.getValue();

    return 0;
}
