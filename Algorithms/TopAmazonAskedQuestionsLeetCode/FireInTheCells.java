package Algorithms.TopAmazonAskedQuestionsLeetCode;

/**Given a grid mat[][] of size M * N, consisting of only 0s, 1s, and 2s, where 0 represents 
 * empty place, 1 represents a person and 2 represents the fire, the task is to count the 
 * minimum number of moves required such that the person comes out from the grid safely. 
 * In each step, the fire will burn its side-adjacent cells and the person will move from the 
 * current cell to one of its side-adjacent cells. If it is not possible to come out from the
 *  grid, then print -1.

Note: A person will come out from the grid if the person reaches one of the border sides of the
 grid.

Examples:

Input: mat[][] = { { 0, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 1, 0, 0 }, { 2, 2, 0, 0 } } 
Output: 2 
Explanation: 
Possible moves of the person are (2, 1) → (2, 2) → (2, 3). 
The person reaches one of the border sides of the grid(last row) in 2 moves and also it is the
 minimum possible count. 
Therefore, the required output is 2.

Input: mat[][] = { { 0, 2, 0, 0 }, { 2, 1, 0, 2 }, { 2, 0, 0, 0 }, { 2, 0, 2, 0 }} 
Output: -1 */
// Java program to implement
// the above approach
import java.util.*;
import java.lang.*;
class FireInTheCells
{

	// Structure of cell
	// of the grid
	static class pair
	{
		int x, y;
		pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	// Stores size of the grid
	static int m, n;

	// Function to find shortest distance
	// between two cells of the grid
	static int minStep(int[][] mat)
	{

		// Rows of the grid
		m = mat.length;

		// Column of the grid
		n = mat[0].length;

		// Stores possible move
		// of the person
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		// Store possible cells visited
		// by the person
		Queue<pair> pQ = new LinkedList<>();

		// Store possible cells which
		// are burning
		Queue<pair> fQ = new LinkedList<>();

		// Traverse the grid
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{

				// If current cell is
				// burning
				if (mat[i][j] == 2)
					fQ.add(new pair(i, j));

				// If person is in
				// the current cell
				else if (mat[i][j] == 1)
				{
					if (border(i, j))
						return 0;
					pQ.add(new pair(i, j));
				}
			}

		// Stores shortest distance
		// between two cells
		int depth = 0;

		// Check if a cell is visited
		// by the person or not
		boolean[][] visited
			= new boolean[n][m];

		// While pQ is not empty
		while (!pQ.isEmpty())
		{

			// Update depth
			depth++;

			// Popped all the cells from
			// pQ and mark all adjacent cells
			// of as visited
			for (int i = pQ.size(); i > 0; i--)
			{

				// Front element of
				// the queue pQ
				pair pos = pQ.peek();

				// Remove front element of
				// the queue pQ
				pQ.remove();

				// If current cell is burning
				if (mat[pos.x][pos.y] == 2)
					continue;

				// Find all adjacent cells
				for (int j = 0; j < 4; j++)
				{

					// Stores row number of
					// adjacent cell
					int x = pos.x + dx[j];

					// Stores column number
					// of adjacent cell
					int y = pos.y + dy[j];

					// Checks if current cell
					// is valid
					if (valid(x, y) && mat[x][y] != 2
						&& !visited[x][y])
					{

						// Mark the cell as visited
						visited[x][y] = true;

						// Enqueue the cell
						pQ.add(new pair(x, y));

						// Checks the escape condition
						if (border(x, y))
							return depth;
					}
				}
			}

			// Burn all the adjacent cells
			// of burning cells
			for (int i = fQ.size(); i > 0; i--)
			{

				// Front element of
				// the queue fQ
				pair pos = fQ.peek();

				// Delete front element of
				// the queue fQ
				fQ.remove();

				// Find adjacent cells of
				// burning cell
				for (int j = 0; j < 4; j++)
				{

					// Stores row number of
					// adjacent cell
					int x = pos.x + dx[j];

					// Stores column number
					// of adjacent cell
					int y = pos.y + dy[j];

					// Checks if current
					// cell is valid
					if (valid(x, y) && mat[x][y] != 2)
					{

						mat[x][y] = 2;

						// Burn all the adjacent
						// cells of current cell
						fQ.add(new pair(x, y));
					}
				}
			}
		}
		return -1;
	}

	// Function to check valid
	// cells of the grid
	static boolean valid(int x, int y)
	{
		return (x >= 0 && x < m
				&& y >= 0 && y < n);
	}

	// Checks for the border sides
	static boolean border(int x, int y)
	{
		return (x == 0 || x == m - 1
				|| y == 0 || y == n - 1);
	}

	// Driver Code
	public static void main(String[] args)
	{

		// Given grid
		int[][] grid = { { 0, 0, 0, 0 },
						{ 2, 0, 0, 0 },
						{ 2, 1, 0, 0 },
						{ 2, 2, 0, 0 } };

		System.out.println(minStep(grid));
	}
}

// This code is contributed by mohit kumar 29.

