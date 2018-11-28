
#ifndef OKTATO_H
#define OKTATO_H

#include <string>
#include <vector>



/**
  * class Oktato
  * 
  */

class Oktato
{
public:

  // Constructors/Destructors
  //  


  /**
   * Empty Constructor
   */
  Oktato ();

  /**
   * Empty Destructor
   */
  virtual ~Oktato ();

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
  void targyat_oktat ()
  {
    void targyat_oktat(Targy targy) {
    	this.okt_targyak.push_back(targy);
    }
  }

protected:

  // Static Protected attributes
  //  

  // Protected attributes
  //  

public:


  // Protected attribute accessor methods
  //  

protected:

public:


  // Protected attribute accessor methods
  //  

protected:


private:

  // Static Private attributes
  //  

  // Private attributes
  //  

  std::string okt_nev;
  vector<Targy> okt_targyak;
public:


  // Private attribute accessor methods
  //  

private:

public:


  // Private attribute accessor methods
  //  


  /**
   * Set the value of okt_nev
   * @param new_var the new value of okt_nev
   */
  void setOkt_nev (std::string new_var)   {
      okt_nev = new_var;
  }

  /**
   * Get the value of okt_nev
   * @return the value of okt_nev
   */
  std::string getOkt_nev ()   {
    return okt_nev;
  }

  /**
   * Set the value of okt_targyak
   * @param new_var the new value of okt_targyak
   */
  void setOkt_targyak (vector<Targy> new_var)   {
      okt_targyak = new_var;
  }

  /**
   * Get the value of okt_targyak
   * @return the value of okt_targyak
   */
  vector<Targy> getOkt_targyak ()   {
    return okt_targyak;
  }
private:


  void initAttributes () ;

};

#endif // OKTATO_H
