#include "stdafx.h"
#include <iostream>
#include <boost/filesystem.hpp>
//#include <boost/filesystem/path.hpp>
//#include <boost/range/iterator_range.hpp>

using namespace std;
namespace bs = boost::filesystem;

bool hasEnding(string const &fullString, string const &ending) {
	if (fullString.length() >= ending.length()) {		//ha a teljes string legalább olyan hosszú, mint az ending
		return (0 == fullString.compare(fullString.length() - ending.length(), ending.length(), ending));		//0-át adjon vissza, ha a fullstring=(melyik pozíciótól, hány karaktert nézzen, mivel hasonlítsa össze)
	}
	else {
		return false;
	}
}

void bejar(bs::path p) {
	bs::recursive_directory_iterator end_itr;
	string ending = ".java";		//ez jelöli, hogy milyen végződésű bejegyzéseket keresünk
	int counter = 0;

	for (bs::recursive_directory_iterator itr(p); itr != end_itr; itr++)
	{
		string current_entry = itr->path().string();
		size_t found = current_entry.find_last_of("\\");	//size_type for array indexing and loop counting
		size_t found2 = current_entry.find_last_of(".");
		size_t len = found2 - found - 1;

		if (bs::is_regular_file(itr->path()) && hasEnding(current_entry, ending)) {			
			cout << "\t" << current_entry.substr(found+1, len) << endl;		//substr(honnan, milyen hosszan)
			counter++;
		}
		/*else if (bs::is_directory(itr->path())) {
			cout << "\nDIR " << current_entry << endl;
		}
		/*else {
			cout << "Nincs ilyen elem\n";
		}*/
	}
	cout << "\nKeresesnek megfelelo bejegyzesek szama: " << counter << endl;
}

int main()
{
	/*
	bs::ofstream("valami.txt");
	//rename("valami.txt", "barmi.txt");

	cout << bs::absolute("valami.txt") << endl;
	//cout << bs::canonical("valami.txt");	//nem formai, hanem egyedi elérési út

	cout << bs::exists("valami.txt") << endl;
	cout << bs::is_directory("valami.txt") << endl;

	// LISTFILES: list all files in current directory.----------------------
	//You could put any file path in here, e.g. "/home/me/mwah" to list that directory
	//"E:\Multimédia\Dokumentum\PTI\3.félév\prog2\6. het\Boost\Boost");
	bs::path p(".");

	bs::directory_iterator end_itr;

	// cycle through the directory
	for (bs::directory_iterator itr(p); itr != end_itr; ++itr)
	{
		// If it's not a directory, list it. If you want to list directories too, just remove this check.
		if (bs::is_regular_file(itr->path())) {
			// assign current file name to current_file and echo it out to the console.
			string current_file = itr->path().string();
			cout << current_file << endl;
		}
	}
	//-----------------------------------------------------------------------
	*/

	bs::path p("E:\\Multimedia\\Dokumentum\\PTI\\3.felev\\prog2\\5. het\\Boost\\java_jdk_src");
	//bs::path p("E:\\Multimedia\\Dokumentum\\PTI\\3.felev\\prog2\\5. het\\Boost\\Boost");
	
	bejar(p);

    return 0;
}

