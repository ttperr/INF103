package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface {
	
	private final int row, column;
	protected String label;
	
	// build MBox(i,j)
	public MBox(int i, int j) { 
		row = i;
		column = j;
		label = "M";
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Boolean isEqualTo(VertexInterface vertex) { 
		MBox box = (MBox)vertex;
		return row == box.getRow() && column == box.getColumn();
	}
	
}
