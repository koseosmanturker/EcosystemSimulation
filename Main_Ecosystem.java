import java.security.SecureRandom;

public class Main_Ecosystem {
	
	public static final int width = 100;
	public static final int nFish = 43;
	public static final int nBear = 11;
	public static final int NumberOfIteration = 7;
	static SecureRandom random = new SecureRandom();
	
	
	public static String toString(Animal[] r) {
		
		String res = "";
		
		for(int x = 0; x < width; x++) {
				
				if(r[x] == null) {
					res += ".";
				}
				else if(r[x] instanceof Fish) {
					res += "F";
				}
				else if(r[x] instanceof Bear) {
					res += "B";
				}
				
		}
		return res;

	}
	
	public static Animal[] move(Animal[] r) {
		
		for(int x = 0; x < width; x++) {
			
			boolean chance = random.nextBoolean();
			if(r[x] != null) {
				if(chance) {
					
					int move = random.nextInt(3) - 1;
					if(move != 0) {   //if it can move
						if((x + move) < width && (x + move) >= 0) {		//if the index which it will move is inside of the array
								
							if(r[x] instanceof Fish && r[x + move] instanceof Fish) {
								boolean flag = true;
								while(flag) {
									int index = random.nextInt(width);
									if(r[index] == null) {
										r[index] = new Fish();
										flag = false;		
									}
								}
							}
								
							if(r[x] instanceof Bear && r[x + move] instanceof Bear) {
								boolean flag = true;
								while(flag) {
									int index = random.nextInt(width);
									if(r[index] == null) {
										r[index] = new Bear();
										flag = false;
									}
								}
							}	
							
							
							if(r[x] instanceof Bear && r[x + move] instanceof Fish) {
								r[x + move] = r[x];
								r[x] = null;
							}
							if(r[x] instanceof Fish && r[x + move] instanceof Bear) {
								r[x] = null;
							}
							
						}// if statement for index check
						
					}//move statement
						
				}// if statement for (Can animal move?)
				
			}//if statement for null
		
		}//for
		return r;
		
	}
		
	
	
	
	public static void main(String[] args) {
		
		Animal[] river = new Animal[width];
		

		int fishCounter = 0;
		while(fishCounter < nFish) {
			
			int i = random.nextInt(width);
			
			if(river[i] == null) {
				river[i] = new Fish();
				fishCounter++;
			}
		
		}
		

		int bearCounter = 0;
		while(bearCounter < nBear) {
			
			int j = random.nextInt(width);
			
			if(river[j] == null) {
				river[j] = new Bear();
				bearCounter++;
			}
		
		}
		
		System.out.println(toString(river));
		for(int ite = 1; ite < NumberOfIteration; ite++) {
			
			river = move(river);
			System.out.println(toString(river));
		}

		
	}

}
