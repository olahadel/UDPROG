public class Gagyi {

	public static void main(String[] args) {
		
		Integer x = 128;
		Integer t = 128;
		
		if(x <= t && x >= t && x != t) {
			System.out.println("1. x = " + x + " t = " + t);
		}	
		
		x = 4;
		t = 4;
		
		if(x <= t && x >= t && x != t) {
			System.out.println("2. x = " + x + " t = " + t);
		}
		
		x = new Integer(4);
		t = new Integer(4);
		
		if(x <= t && x >= t && x != t) {
			System.out.println("3. Belép x = " + x + " t = " + t);
		}
	}
}