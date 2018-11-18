//STL map: Standard Template Library
#include <iostream>
#include <vector>

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

	sort( begin(ordered), end(ordered),	[=](auto && p1, auto && p2) {		//[]-ban ha & van akkor referencia szerint kezeli a k�ls� v�ltoz�kat; = eset�n �rt�k szerint
		return p1.second > p2.second;
	}
	);

	return ordered;
}

int main{
	return 0;
}

//p1 �s p2 pair-ek az ordered vectorbol
// && az rvalue ami nem k�t�dik semmilyen azonos�t�hoz, ez�rt csak ideiglenesen t�rolt �rt�k
// lambda kifejez�s egy f�ggv�ny, csak nem kell k�l�n �gy meg�rni