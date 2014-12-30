package classes;

public class Node {
	private char ch;
	private Node adjacentNode;
	private Node nextLevelNode;
	
	public Node(){
		this.ch = Character.UNASSIGNED;
		this.adjacentNode = null;
		this.nextLevelNode = null;
	}
	
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public Node getAdjacentNode() {
		return adjacentNode;
	}
	public void setAdjacentNode(Node adjacentNode) {
		this.adjacentNode = adjacentNode;
	}
	public Node getNextLevelNode() {
		return nextLevelNode;
	}
	public void setNextLevelNode(Node nextLevelNode) {
		this.nextLevelNode = nextLevelNode;
	}
	
}
