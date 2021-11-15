package snakeandadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Board {
	
	private int size;
    private List<Snake> snakes = new ArrayList<Snake>(); 
    private List<Ladder> ladders = new ArrayList<Ladder>();
    
    public Board() {}
    
    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
		super();
		this.size = size;
		this.snakes = snakes;
		this.ladders = ladders;
	}
    
	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
    
    public void addSnake(int start, int end) {
    	this.snakes.add(new Snake(start, end));
    }
    
    public void addLadder(int start, int end) {
    	this.ladders.add(new Ladder(start, end));
    }
    
    
    static class qentry
    {
        int v;// Vertex number
        int dist;// Distance of this vertex from source
    }
 
    static int getMinDiceThrows(int move[], int n)
    {
        int visited[] = new int[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;
 
        visited[0] = 1;
        q.add(qe);
 
        while (!q.isEmpty())
        {
            qe = q.remove();
            int v = qe.v;
 
            if (v == n - 1)
                break;
 
            for (int j = v + 1; j <= (v + 6) && j < n; ++j)
            {
                // If cell is visited -> ignore
                if (visited[j] == 0)
                {
                    qentry a = new qentry();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;
 
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }
 
        return qe.dist;
    }
    
    public int getMinimumDiceThrow() {
        int moves[] = new int[this.size];
        for (int i = 0; i < this.size; i++)
            moves[i] = -1;
 
        // Ladders
        for(Ladder ladder : this.ladders) {
        	moves[ladder.getStart()] = ladder.getEnd();
        }
        
        // Snakes
        for(Snake snake : this.snakes) {
        	moves[snake.getStart()] = snake.getEnd();
        }
 
        return getMinDiceThrows(moves, this.size);
    }

}
