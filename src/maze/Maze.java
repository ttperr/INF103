package maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public final class Maze implements GraphInterface {
	// create the object boxes
	private ArrayList<ArrayList<MBox>> boxes = new ArrayList<ArrayList<MBox>>();
	
	// MBox getter
	public MBox getBox(int i, int j) {
		return boxes.get(i).get(j);
	}
	
	// return all vertex of the maze
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();
		
		for (ArrayList<MBox> listMBox : boxes) {
			for(MBox box : listMBox) {
				vertices.add(box);
			}
		}
		
		return vertices;
	}
	
	// return the successors of the ArrayList of the successors of the vertex vertex
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex;
		int row = box.getRow();
		
		for(MBox succBox: boxes.get(row)) {
			VertexInterface succVertex = (VertexInterface)succBox;
			Double weight = getWeight(vertex, succVertex);
			Double posInf = Double.POSITIVE_INFINITY ;
			if (weight < posInf) {
				successors.add(succVertex);
			}
		}
		
		return successors;
	}

	// return 1 if src and dst are neighbors, infinity if not
	public Double getWeight(VertexInterface src, VertexInterface dst) {
		MBox srcBox = (MBox)src;
		MBox dstBox = (MBox)dst;
		return (srcBox.getLabel().equals("W") || dstBox.getLabel().equals("W")) ? Double.POSITIVE_INFINITY : 1;
	}
	
	// initialize maze from filename
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		try
	    {    
	      BufferedReader br = new BufferedReader(new FileReader(fileName));
	        String line;
	        int row = 0;
	        while((line = br.readLine()) != null) {
	    	    ArrayList<MBox> boxesLine = new ArrayList<MBox>();
	    	    for(int column = 0; column < line.length(); column++) {
	    		    switch(line.charAt(column)) {
	    		    case 'E':
	    			    boxesLine.add(new EBox(row,column));
	    			    break;
						
	    		    case 'W':
	    			    boxesLine.add(new WBox(row,column));
	    			    break;

	    		    case 'A':
	    			    boxesLine.add(new ABox(row,column));
	    			    break;

	    		    case 'D':
	    			    boxesLine.add(new DBox(row,column));
	    			    break;

	    		    default:
	    				throw new MazeReadingException(fileName, row, column, "Unknown character readed");
	    		    }
	    	    }
	    	    boxes.add(boxesLine);  
	    	    row++;
	        }
	        br.close();
	    }
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
	
	} 
	
	// save the path solution for the maze
	public final void saveToTextFile(String fileName) {
		try {
			PrintWriter textF = new PrintWriter(fileName);
			for (ArrayList<MBox> listMBox : boxes) {
				for(MBox box : listMBox) {
					if (box != null) { textF.print(box.getLabel()); }
					else textF.print(" ");
				}
				textF.print("\n");
			}
			textF.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
