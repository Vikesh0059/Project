class Min {                      // this is java project

	private static final int NO_PARENT = -1;
	private static void MinDIS(int[][] adjMatrix,int sV)        //sV is start node
	{
		int nV = adjMatrix[0].length;                           // number of node
		System.out.println("From Source to destination total number of Road Side Unit is:-"+nV);
		int[] shortestDis = new int[nV];
	
		boolean[] added = new boolean[nV];

		for (int Index = 0; Index < nV; Index++)
		{
			shortestDis[Index] = Integer.MAX_VALUE;
			added[Index] = false;
		}
		shortestDis[sV] = 0;
		int[] parents = new int[nV];
		parents[sV] = NO_PARENT;

		
		for (int i = 1; i < nV; i++)
		{

			
			int nearestVertex = -1;
			int shortestDist = Integer.MAX_VALUE;
			for (int Index = 0; Index < nV; Index++)
			{
				if (!added[Index] && shortestDis[Index] < shortestDist) 
				{
					nearestVertex = Index;
					shortestDist = shortestDis[Index];
				}
			}

			added[nearestVertex] = true;

			for (int Index = 0; Index < nV; Index++) 
			{
				int edgeDis = adjMatrix[nearestVertex][Index];
				
				if (edgeDis > 0
					&& ((shortestDist + edgeDis) < 
						shortestDis[Index])) 
				{
					parents[Index] = nearestVertex;
					shortestDis[Index] = shortestDist + edgeDis;
				}
			}
		}

		print(sV, shortestDis, parents);
	}

	private static void print(int sV,int[] dis,int[] parents)
	{
		int nV = dis.length;
		System.out.print("Source to Destination\t\t MinimumDistance\t\tPathTraversing");
		
		for (int Index = 0; Index < nV; Index++) 
		{
			if (Index != sV) 
			{
				System.out.print("\n From " + sV + " to  ");
				System.out.print(Index + " \t\t\t\t");
				System.out.print(dis[Index] + "\t\t\t");
				printPath(Index, parents);
			}
		}
	}

	private static void printPath(int currentV,
									int[] parents)
	{
		
		if (currentV == NO_PARENT)
		{
			return;
		}
		printPath(parents[currentV], parents);
		System.out.print(""+currentV + " ->");
	}

	public static void main(String[] args)
	{
		int[][] adjMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 , 0, 0 },
				             { 4, 0, 8, 0, 0, 0, 0, 11 , 0, 0, 0 },
				              { 0, 8, 0, 7, 0, 4, 0, 0, 2 , 0, 0 },
				             { 0, 0, 7, 0, 9, 14, 0, 0, 0, 10, 0 },
				             { 0, 0, 0, 9, 0, 10, 0, 0, 0, 3, 0 },
				             { 0, 0, 4, 0, 10, 0, 2, 0, 0, 0, 3 },
				             { 0, 0, 0, 14, 0, 2, 0, 1, 6, 0, 0 },
				             { 8, 11, 0, 0, 0, 0, 1, 0, 7, 0, 0 },
				             { 0, 0, 2, 0, 0, 0, 6, 7, 0 , 0, 0 },
                            { 0, 0,  0 ,10, 3, 0, 0, 0, 0, 0, 16 }, 
				               { 0, 0, 0, 0, 0, 3, 0, 0, 0, 9, 0 }};
		MinDIS(adjMatrix, 0);
	}
}

