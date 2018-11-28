
#ifndef HALLGATO_H
#define HALLGATO_H

#include <string>
#include <vector>



/**
  * class Hallgato
  * 
  */

class Hallgato
{
public:

  // Constructors/Destructors
  //  


  /**
   * Empty Constructor
   */
  Hallgato ();

  /**
   * Empty Destructor
   */
  virtual ~Hallgato ();

  // Static Public attributes
  //  

  // Public attributes
  //  


  // Public attribute accessor methods
  //  


  // Public attribute accessor methods
  //  



  /**
   */
  void targy_felvesz ()
  {
    void targy_felvesz(Targy a) {
    	hall_targyak.push_back(a);
    }
  }


  /**
   */
  void targy_lead ()
  {
    void targy_lead(Targy targy){
    	for (int i=0; i<hall_targyak.size(); i++) {
    		if (hall_targyak[i] == targy){
    			erase(hall_targyak[i]);
    			break;
    		}
    	}
    }
  }


  /**
   */
  void kredit_sum ()
  {
    void kredit_sum(){
    	for (auto i : hall_targyak) {
    		hall_osszkredit += hall_targyak[i].targy_kredit;
    	}
    }
  }

protected:

  // Static Protected attributes
  //  

  // Protected attributes
  //  

  std::string hall_nev;
public:


  // Protected attribute accessor methods
  //  

protected:

public:


  // Protected attribute accessor methods
  //  


  /**
   * Set the value of hall_nev
   * @param new_var the new value of hall_nev
   */
  void setHall_nev (std::string new_var)   {
      hall_nev = new_var;
  }

  /**
   * Get the value of hall_nev
   * @return the value of hall_nev
   */
  std::string getHall_nev ()   {
    return hall_nev;
  }
protected:


private:

  // Static Private attributes
  //  

  // Private attributes
  //  

  std::string hall_kod;
  vector<Targy> hall_targyak;
  int hall_osszkerdit;
public:


  // Private attribute accessor methods
  //  

private:

public:


  // Private attribute accessor methods
  //  


  /**
   * Set the value of hall_kod
   * @param new_var the new value of hall_kod
   */
  void setHall_kod (std::string new_var)   {
      hall_kod = new_var;
  }

  /**
   * Get the value of hall_kod
   * @return the value of hall_kod
   */
  std::string getHall_kod ()   {
    return hall_kod;
  }

  /**
   * Set the value of hall_targyak
   * @param new_var the new value of hall_targyak
   */
  void setHall_targyak (vector<Targy> new_var)   {
      hall_targyak = new_var;
  }

  /**
   * Get the value of hall_targyak
   * @return the value of hall_targyak
   */
  vector<Targy> getHall_targyak ()   {
    return hall_targyak;
  }

  /**
   * Set the value of hall_osszkerdit
   * @param new_var the new value of hall_osszkerdit
   */
  void setHall_osszkerdit (int new_var)   {
      hall_osszkerdit = new_var;
  }

  /**
   * Get the value of hall_osszkerdit
   * @return the value of hall_osszkerdit
   */
  int getHall_osszkerdit ()   {
    return hall_osszkerdit;
  }
private:


  void initAttributes () ;

};

#endif // HALLGATO_H
