
public class Blueberry {

	public static void main(String[] args) {
		int blueCount = 0;
		int berryCount = 0;
		int blueBCount = 0;
		for(int n = 1; n <= 50; n++){
			if(n % 6 == 0){
				blueBCount++;
				System.out.println(n + " Blueberry");
			}
			else if(n % 2 == 0){
				blueCount++;
				System.out.println(n + " Blue");
			}
			else if (n % 3 == 0){
				berryCount++;
				System.out.println(n + " Berry");
			}
			else
				System.out.println(n);
		}
		System.out.println();
		System.out.println("Blue count: " + blueCount);
		System.out.println("Berry count: " + berryCount);
		System.out.println("Blueberry count: " + blueBCount);
	}

}