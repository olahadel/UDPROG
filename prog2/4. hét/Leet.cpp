#include <iostream>
#include <vector>

using namespace std;

int main(){

vector<char> text;
vector<string> leet;

//beolvasás csak kisbetûs ékezet nélküli szövegre
cout<<"Kerem irja be a szoveget: ";

string be;
getline(cin,be);  //getline

for (int i=0; i<be.size(); i++){
    text.push_back(be[i]);
}

for (int i=0; i<text.size(); i++) {
    if (text[i] == 'a') leet.push_back("4");
    if (text[i] == 'b') leet.push_back("8");
    if (text[i] == 'c') leet.push_back("(");
    if (text[i] == 'd') leet.push_back("|]");
    if (text[i] == 'e') leet.push_back("3");
    if (text[i] == 'f') leet.push_back("|\"");
    if (text[i] == 'g') leet.push_back("6");
    if (text[i] == 'h') leet.push_back("#");
    if (text[i] == 'i') leet.push_back("!");
    if (text[i] == 'j') leet.push_back("_|");
    if (text[i] == 'k') leet.push_back("|<");
    if (text[i] == 'l') leet.push_back("|_");
    if (text[i] == 'm') leet.push_back("|V|");
    if (text[i] == 'n') leet.push_back("(\\)");
    if (text[i] == 'o') leet.push_back("0");
    if (text[i] == 'p') leet.push_back("|0");
    if (text[i] == 'q') leet.push_back("(,)");
    if (text[i] == 'r') leet.push_back("|2");
    if (text[i] == 's') leet.push_back("$");
    if (text[i] == 't') leet.push_back("']'");
    if (text[i] == 'u') leet.push_back("(_)");
    if (text[i] == 'v') leet.push_back("\\/");
    if (text[i] == 'w') leet.push_back("'//");
    if (text[i] == 'x') leet.push_back("%");
    if (text[i] == 'y') leet.push_back("'/");
    if (text[i] == 'z') leet.push_back("\"/_");

    if (text[i] == ' ') leet.push_back(" ");
}

cout<<endl<<"Leet szoveg: ";

for (int i=0; i<leet.size(); i++){
    cout<<leet[i];
}

cout<<endl;

}

