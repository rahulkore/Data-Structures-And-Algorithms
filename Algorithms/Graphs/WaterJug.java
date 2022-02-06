package Algorithms.Graphs;

//Java program for water jug problem
//using BFS
//Code by: Sparsh_CBS

import java.util.*;

class Pair{
	int j1, j2;
	List<Pair> path;

	Pair(int j1, int j2){
		this.j1 = j1;
		this.j2 = j2;
		path = new ArrayList<>();
	}

	Pair(int j1, int j2, List<Pair> _path){
		this.j1 = j1;
		this.j2 = j2;

		path = new ArrayList<>();
		path.addAll(_path);
		path.add(new Pair(this.j1,this.j2));
	}
}

public class WaterJug{
	public static void main(String[] args) throws java.lang.Exception{
		int jug1 = 4;
		int jug2 = 3;
		int target = 2;

		getPathIfPossible(jug1, jug2, target);
	}

	private static void getPathIfPossible(int jug1, int jug2, int target){
		boolean[][] visited = new boolean[jug1+1][jug2+1];
		Queue<Pair> queue = new LinkedList<>();

		//Initial State: Both Jugs are empty so,
		//initialise j1 j2 as 0 and put it in the path list
		Pair initialState = new Pair(0,0);
		initialState.path.add(new Pair(0,0));
		queue.offer(initialState);

		while(!queue.isEmpty()){
			Pair curr = queue.poll();

			//Skip already visited states and overflowing water states
			if(curr.j1 > jug1 || curr.j2 > jug2 || visited[curr.j1][curr.j2])
				continue;
			//mark current jugs state as visited
			visited[curr.j1][curr.j2] = true;

			//Check if current state has already reached
			//the target amount of water or not
			if(curr.j1 == target || curr.j2 == target){
				if(curr.j1 == target){
					//If in our current state, jug1 holds the
					//required amount of water, then we empty the jug2
					//and push it into our path.
					curr.path.add(new Pair(curr.j1,0));
				}
				else{
					//else, If in our current state, jug2 holds the
					//required amount of water, then we empty the jug1
					//and push it into our path.
					curr.path.add(new Pair(0,curr.j2));
				}
				int n = curr.path.size();
				System.out.println("Path of states of jugs followed is :");
				for(int i = 0; i < n; i++)
					System.out.println(curr.path.get(i).j1+" , "+curr.path.get(i).j2);
				return;
			}

			//If we have not yet found the target, then we have three cases left
			//I. Fill the jug and Empty the other
			//II. Fill the jug and let the other remain untouched
			//III. Empty the jug and let the other remain untouched
			//IV. Transfer amounts from one jug to another

			//Please refer to the table attached above to understand
			//the cases that we are taking into consideration

			//Now,
			//I. Fill the jug and Empty the other
			queue.offer(new Pair(jug1, 0, curr.path));
			queue.offer(new Pair(0, jug2, curr.path));

			//II. Fill the jug and let the other remain untouched
			queue.offer(new Pair(jug1, curr.j2, curr.path));
			queue.offer(new Pair(curr.j1, jug2, curr.path));
			
			//III. Empty the jug and let the other remain untouched
			queue.offer(new Pair(0, curr.j2, curr.path));
			queue.offer(new Pair(curr.j1, 0, curr.path));
		
			//IV. Transfer water from one to another until one jug becomes empty
			//or until one jug becomes full in this process
		
			//Transferring water form jug1 to jug2
			int emptyJug = jug2-curr.j2;
			int amountTransferred = Math.min(curr.j1, emptyJug);
			int j2 = curr.j2+amountTransferred;
			int j1 = curr.j1-amountTransferred;
			queue.offer(new Pair(j1, j2,curr.path));
			
			//Tranferring water form jug2 to jug1
			emptyJug = jug1-curr.j1;
			amountTransferred = Math.min(curr.j2, emptyJug);
			j2 = curr.j2-amountTransferred;
			j1 = curr.j1+amountTransferred;
			queue.offer(new Pair(j1, j2,curr.path));
		}

		System.out.println("Not Possible to obtain target");
	}
}
