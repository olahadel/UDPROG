
#ifndef TARGY_H
#define TARGY_H

#include <string>
#include <vector>



/**
  * class Targy
  * 
  */

class Targy
{
public:

  // Constructors/Destructors
  //  


  /**
   * Empty Constructor
   */
  Targy ();

  /**
   * Empty Destructor
   */
  virtual ~Targy ();

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
  void setOktato ()
  {
    void setOktato(Oktato oktato){
    	this.targy_oktato = oktato;
    }
  }


  /**
   */
  void setKredit ()
  {
    void setKredit(int kredit) {
    	this.targy_kredit = kredit;
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

  std::string targy_nev;
  std::string targy_kod;
  vector targy_hallgatok;
  int targy_kredit;
public:


  // Private attribute accessor methods
  //  

private:

public:


  // Private attribute accessor methods
  //  


  /**
   * Set the value of targy_nev
   * @param new_var the new value of targy_nev
   */
  void setTargy_nev (std::string new_var)   {
      targy_nev = new_var;
  }

  /**
   * Get the value of targy_nev
   * @return the value of targy_nev
   */
  std::string getTargy_nev ()   {
    return targy_nev;
  }

  /**
   * Set the value of targy_kod
   * @param new_var the new value of targy_kod
   */
  void setTargy_kod (std::string new_var)   {
      targy_kod = new_var;
  }

  /**
   * Get the value of targy_kod
   * @return the value of targy_kod
   */
  std::string getTargy_kod ()   {
    return targy_kod;
  }

  /**
   * Set the value of targy_hallgatok
   * @param new_var the new value of targy_hallgatok
   */
  void setTargy_hallgatok (vector new_var)   {
      targy_hallgatok = new_var;
  }

  /**
   * Get the value of targy_hallgatok
   * @return the value of targy_hallgatok
   */
  vector getTargy_hallgatok ()   {
    return targy_hallgatok;
  }

  /**
   * Set the value of targy_kredit
   * @param new_var the new value of targy_kredit
   */
  void setTargy_kredit (int new_var)   {
      targy_kredit = new_var;
  }

  /**
   * Get the value of targy_kredit
   * @return the value of targy_kredit
   */
  int getTargy_kredit ()   {
    return targy_kredit;
  }
private:


  void initAttributes () ;

};

#endif // TARGY_H
