package maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Interface.GraphInterface;
import Interface.VertexInterface;

public final class Maze implements GraphInterface {
	private ArrayList<ArrayList<MBox>> boxes; // create the object boxes
	
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
	
	
	public final void initFromTextFile(String fileName) {
		try
	    {    
	      BufferedReader br = new BufferedReader(new FileReader(fileName));  
	      StringBuffer sb = new StringBuffer();    
	      String line;
	      while((line = br.readLine()) != null)
	      {
	        sb.append(line);      
	        sb.append("\n");     
	      }
	      br.close();
	      System.out.println(sb.toString());  
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
}
