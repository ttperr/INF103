package maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Interface.GraphInterface;
import Interface.VertexInterface;

public final class Maze implements GraphInterface {
	private ArrayList<ArrayList<MBox>> boxes = new ArrayList<ArrayList<MBox>>(); // create the object boxes
	
	public MBox getBox(int i, int j) {
		return boxes.get(i).get(j);
	}
	
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();
		
		for (ArrayList<MBox> listMBox : boxes) {
			for(MBox box : listMBox) {
				vertices.add(box);
			}
		}
		
		return vertices;
	}
	
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
	} // return the successors of the ArrayList of the successors of the vertex vertex

	public Double getWeight(VertexInterface src, VertexInterface dst) { 
		MBox srcBox = (MBox)src;
		MBox dstBox = (MBox)dst;
		return (srcBox.getLabel().equals("W") || dstBox.getLabel().equals("W")) ? Double.POSITIVE_INFINITY : 1;
	} // return 1 if src and dst are neighbors, infinity if not
	
	
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		try
	    {    
	      BufferedReader br = new BufferedReader(new FileReader(fileName));  
	      // StringBuffer sb = new StringBuffer();    
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
	        // sb.append(line);      
	        // sb.append("\n");
	    	  boxes.add(boxesLine);  
	    	  row++;
	      }
	      br.close();
	      // System.out.println(sb.toString());  
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
	
	}
	
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
