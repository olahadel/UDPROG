package hu.IsziSoft;

import hu.IsziSoft.R.id;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class QubeActivity extends Activity implements OnSeekBarChangeListener, OnTouchListener{
   
	int penz=100;
	int tet=1;
	
	TextView ope;
	TextView max;
	SeekBar tetbar;		//csúszka
	TextView tetertek;
	ImageView kep;
	RadioGroup gombcsoport;
	RadioButton gomb1;
	RadioButton gomb2;
	RadioButton gomb3;
	RadioButton gomb4;
	RadioButton gomb5;
	RadioButton gomb6;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);		//mindig egy layout
        
        ope=(TextView)this.findViewById(id.labelOpertek);		//A user interface element that displays text to the user.
        max=(TextView)this.findViewById(id.labelMaxertek);
        tetertek=(TextView)this.findViewById(id.labelTetertek);
        
        gombcsoport=(RadioGroup)this.findViewById(id.radioGroup1);

        tetbar=(SeekBar)this.findViewById(id.tetBar);
        tetbar.setMax(99);
        tetbar.setOnSeekBarChangeListener(this);		//Sets a listener to receive notifications of changes to the SeekBar's progress level.
														// Also provides notifications of when the user starts and stops a touch gesture within the SeekBar.
        kep=(ImageView)findViewById(R.id.kockaKep);
		kep.setOnTouchListener(this);
        
		gomb1=(RadioButton)this.findViewById(id.radio1);
		gomb2=(RadioButton)this.findViewById(id.radio2);
		gomb3=(RadioButton)this.findViewById(id.radio3);
		gomb4=(RadioButton)this.findViewById(id.radio4);
		gomb5=(RadioButton)this.findViewById(id.radio5);
		gomb6=(RadioButton)this.findViewById(id.radio6);
    }

	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {		//Notification that the progress level has changed.
	
		try{
			tet=arg1+1;
			tetertek.setText(""+tet);
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {		//Notification that the user has started a touch gesture
		// TODO Auto-generated method stub
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {		//Called when a touch event is dispatched to a view.
    															// This allows listeners to get a chance to respond before the target view.
		int tipp;
		int veletlen=1;
		tipp=gombcsoport.getCheckedRadioButtonId();
						
		if(tipp==gomb1.getId()){
			tipp=1;
		}else if(tipp==gomb2.getId()){
			tipp=2;
		}else if(tipp==gomb3.getId()){
			tipp=3;
		}else if(tipp==gomb4.getId()){
			tipp=4;
		}else if(tipp==gomb5.getId()){
			tipp=5;
		}else if(tipp==gomb6.getId()){
			tipp=6;
		}
		
		System.out.println(tipp+" "+gomb1.getId());
		
/*		AnimationDrawable veletlenAnim=new AnimationDrawable();
		  veletlenAnim.setOneShot(true);	//Sets whether the animation should play once or repeat. (Pass true if the animation should only play once)
		  for(int i=1;i<10;i++){
			  veletlen=(int)(Math.random()*6)+1;
			  int varakoztat=30;
			  switch(veletlen){
			  case 1: veletlenAnim.addFrame(getResources().getDrawable(R.drawable.kocka1), varakoztat); break;	//Adds a frame to the animation
			  case 2: veletlenAnim.addFrame(getResources().getDrawable(R.drawable.kocka2), varakoztat); break;
			  case 3: veletlenAnim.addFrame(getResources().getDrawable(R.drawable.kocka3), varakoztat); break;
			  case 4: veletlenAnim.addFrame(getResources().getDrawable(R.drawable.kocka4), varakoztat); break;
			  case 5: veletlenAnim.addFrame(getResources().getDrawable(R.drawable.kocka5), varakoztat); break;
			  case 6: veletlenAnim.addFrame(getResources().getDrawable(R.drawable.kocka6), varakoztat); break;
			  }
		  }
		  kep.setImageDrawable(veletlenAnim);	//Sets a drawable as the content of this ImageView.
		  veletlenAnim.setVisible(true, true);	//Sets whether this AnimationDrawable is visible.
		*/														//when visible, true to force the animation to restart from the first frame

		veletlen=(int)(Math.random()*6)+1;

		switch(veletlen){
			case 1: kep.setImageDrawable(getResources().getDrawable(R.drawable.kocka1)); break;	//Adds a frame to the animation
			case 2: kep.setImageDrawable(getResources().getDrawable(R.drawable.kocka2)); break;
			case 3: kep.setImageDrawable(getResources().getDrawable(R.drawable.kocka3)); break;
			case 4: kep.setImageDrawable(getResources().getDrawable(R.drawable.kocka4)); break;
			case 5: kep.setImageDrawable(getResources().getDrawable(R.drawable.kocka5)); break;
			case 6: kep.setImageDrawable(getResources().getDrawable(R.drawable.kocka6)); break;
		}

		if(veletlen==tipp){
			  penz=penz+(tet*2);
		}else{
			  penz=penz-tet;				  
		}

		if(penz==0){
			  tet=0;
//			  tetbar.setEnabled(false);		//True if this view is enabled, false otherwise.
//			  kep.setEnabled(false);
			AlertDialog.Builder mess = new AlertDialog.Builder(QubeActivity.this);
			  mess.setMessage("Sajnáljuk, vesztettél :(");
			  mess.setTitle("Játék vége");
			  mess.setPositiveButton("Új Játék", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialogInterface, int i) {
					  penz = 100;
					  tet = 1;
					  tetbar.setMax(penz-1);

					  ope.setText(""+penz);
					  max.setText(""+penz); 		//két gombocska system exit
				  }
			  });
			  mess.setNegativeButton("Kilép", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialogInterface, int i) {
                      System.exit(-1);
				  }
			  });

            AlertDialog alertDialog = mess.create();

            alertDialog.show();
		}

        if(penz>=200){
            tet=0;
//			  tetbar.setEnabled(false);		//True if this view is enabled, false otherwise.
//			  kep.setEnabled(false);
            AlertDialog.Builder mess_win = new AlertDialog.Builder(QubeActivity.this);
            mess_win.setMessage("Gratulálunk, nyertél :)");
            mess_win.setTitle("Játék vége");
            mess_win.setPositiveButton("Új Játék", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    penz = 120;
                    tet = 1;
                    tetbar.setMax(penz-1);

                    ope.setText(""+penz);
                    max.setText(""+penz); 		//két gombocska system exit
                }
            });
            mess_win.setNegativeButton("Kilép", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(-1);
                }
            });

            AlertDialog alertDialog = mess_win.create();

            alertDialog.show();
        }
		  
		  ope.setText(""+penz);
		  tetbar.setMax(penz-1);
		  max.setText(""+penz);


		return false;
	}
}