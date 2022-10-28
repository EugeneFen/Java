public class Main {
    public static void main(String[] args) {
	
	DiverseArray a = new DiverseArray();
	int[] five = {1,3,2,7,3};
	int[][] ten = new int[5][4];
	int[][] mat1 = new int[5][4];
	int[] sixs = new int[4];
	System.out.println(a.arraySum(five));
	System.out.println();
	
	ten[0][0]=1; ten[1][0]=3; ten[2][0]=2; ten[3][0]=7; ten[4][0]=3;
	ten[0][1]=10; ten[1][1]=10; ten[2][1]=4; ten[3][1]=6; ten[4][1]=2;
	ten[0][2]=5; ten[1][2]=3; ten[2][2]=5; ten[3][2]=9; ten[4][2]=6;
	ten[0][3]=7; ten[1][3]=6; ten[2][3]=4; ten[3][3]=2; ten[4][3]=1;
	
	sixs = a.rowSums(ten);
	for(int i=0; i<4; i++)
	{
	    System.out.println(sixs[i]);
	}
	System.out.println();
	
	mat1[0][0]=1; mat1[1][0]=3; mat1[2][0]=2; mat1[3][0]=7; mat1[4][0]=3;
	mat1[0][1]=10; mat1[1][1]=10; mat1[2][1]=4; mat1[3][1]=6; mat1[4][1]=2;
	mat1[0][2]=5; mat1[1][2]=3; mat1[2][2]=5; mat1[3][2]=9; mat1[4][2]=6; 
	mat1[0][3]=7; mat1[1][3]=6; mat1[2][3]=4; mat1[3][3]=2; mat1[4][3]=1;
	
	System.out.println(a.isDiverse(mat1));
	System.out.println();
	
	mat1[0][0]=1; mat1[1][0]=1; mat1[2][0]=5; mat1[3][0]=3; mat1[4][0]=4;
	mat1[0][1]=12; mat1[1][1]=7; mat1[2][1]=6; mat1[3][1]=1; mat1[4][1]=9;
	mat1[0][2]=8; mat1[1][2]=11; mat1[2][2]=10; mat1[3][2]=2; mat1[4][2]=5; 
	mat1[0][3]=3; mat1[1][3]=2; mat1[2][3]=3; mat1[3][3]=0; mat1[4][3]=6;
	System.out.println(a.isDiverse(mat1));
	System.out.println();
	
	}
}
