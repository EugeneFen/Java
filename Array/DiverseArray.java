public class DiverseArray
{
	public static int arraySum(int[] arr) //вычисляет и возвращает сумму элементов в указанном одномерном массиве
	{
		int summ=0;
		
		for(int i=0; i < arr.length; i++)
		{
			summ+=arr[i];
		}		
		return summ;
	}
	
	public static int[] rowSums(int[][] arr) //вычисляет суммы каждой из строк в заданном двумерном массиве и возвращает эти суммы в одномерном массиве
	{
		//arr2D[r][c] — это запись в строке r и столбце c. 
		int[] mat = new int[arr[0].length]; //должен быть размер столбца иначе arr.length
		int summ;
		
		for(int i=0; i < arr[0].length; i++)
		{
			summ=0;
			for(int j=0; j < arr.length; j++)
			{
				summ+=arr[j][i];
			}
			mat[i] = summ;
		}
		
		return mat;
	}
	
	public static boolean isDiverse(int[][] arr) //определяет, является ли данный двумерный массив разнообразным
	{
		boolean check = true;
		int[] mat2 = new int[arr[0].length];
		mat2 = rowSums(arr);
		
		for(int i=0; i < mat2.length; i++)
			for(int j=0; j < mat2.length; j++)
			{
				if(mat2[i] == mat2[j] && (i != j)) check = false;
			}
		
		return check;
	}
}
