//STL map: Standard Template Library
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

vector<pair<string,int>> sort_map(map<string,int> &rank)
{
	vector<pair<string,int>> ordered;

	for (auto & i : rank) {
		if (i.second) {
			pair<string, int> p{ i.first, i.second };
			ordered.push_back(p);
		}
	}

	sort( begin(ordered), end(ordered),	[=](auto && p1, auto && p2) {		//[]-ban ha & van akkor referencia szerint kezeli a külsõ változókat; = esetén érték szerint
		return p1.second > p2.second;
	}
	);

	return ordered;
}

int main(){
	return 0;
}

//p1 és p2 pair-ek az ordered vectorbol
// && az rvalue ami nem kötõdik semmilyen azonosítóhoz, ezért csak ideiglenesen tárolt érték
// lambda kifejezés egy függvény, csak nem kell külön így megírni
