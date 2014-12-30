package classes;

public class Trie {
	private Node start;

	public Trie(){
		this.start = new Node();
	}
	
	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}	
		
	public void insert(String tempstr){
		Node start = this.start,parentnode = null;
		char strarray[] = tempstr.toCharArray();
		for(int i=0;i<strarray.length;i++){
			if(start==null || start.getCh()==Character.UNASSIGNED){
				if(start==null)
					start = new Node();
				start.setCh(strarray[i]);
				start.setAdjacentNode(null);
				start.setNextLevelNode(null);
				if(parentnode!=null)
					parentnode.setNextLevelNode(start);
				parentnode = start;
				start = parentnode.getNextLevelNode();
			}else if((int)strarray[i] < (int)start.getCh()){
				Node tempnode = new Node();
				tempnode.setCh(strarray[i]);
				tempnode.setAdjacentNode(start);
				tempnode.setNextLevelNode(null);
				if(parentnode!=null)
					parentnode.setNextLevelNode(tempnode);
				if(this.start==start)
					this.start = tempnode;
				parentnode = tempnode;
				start = parentnode.getNextLevelNode();
			}else if((int)strarray[i] == (int)start.getCh()){
				parentnode = start;
				start = parentnode.getNextLevelNode();
			}else if((int)strarray[i] > (int)start.getCh()){
				Node tempnode1 = start;
				Node tempnode2 = tempnode1.getAdjacentNode();
				int j=0;
				while((tempnode2!=null) && ((int)tempnode2.getCh() < (int)strarray[i])){
					if((int)tempnode2.getCh() == (int)strarray[i]){
						j=1;
						parentnode = tempnode2;
						start = parentnode.getNextLevelNode();
					}
					tempnode1 = tempnode2;
					tempnode2 = tempnode2.getAdjacentNode();
				}
				if(j==0){
					if(tempnode2==null){
						Node tempnode = new Node();
						tempnode.setCh(strarray[i]);
						tempnode.setAdjacentNode(null);
						tempnode.setNextLevelNode(null);
						tempnode1.setAdjacentNode(tempnode);
						parentnode = tempnode;
						start = parentnode.getNextLevelNode();
						j=1;
					}else  if((int)strarray[i] < (int)tempnode2.getCh()){
						Node tempnode = new Node();
						tempnode.setCh(strarray[i]);
						tempnode.setAdjacentNode(tempnode2);
						tempnode.setNextLevelNode(null);
						tempnode1.setAdjacentNode(tempnode);
						parentnode = tempnode;
						start = parentnode.getNextLevelNode();
						j=1;
					}		
				}
			}
		}
		System.out.println(tempstr + " word added Successfully!!!");
	}		
	
	public void view(){
		Node tempnode = this.start;
		while(tempnode!=null){
			System.out.print(tempnode.getCh() + ",");
			tempnode = tempnode.getAdjacentNode(); 
		}
		System.out.println();
	}
	
	
	public boolean searchword(String tempstr){
		Node start = this.start,tempnode;
		boolean present = false;
		char strarray[] = tempstr.toCharArray();
		for(int i=0;i<strarray.length;i++){
			present = false;
			tempnode = start;
			while(tempnode!=null){
				if(tempnode.getCh() == strarray[i]){
					start = tempnode.getNextLevelNode();
					present = true;
					break;
				}
				tempnode = tempnode.getAdjacentNode();
			}
			if(present == false)
				return present;
		}
	return present;
	}

	public StringBuilder search(String tempstr){
		return new StringBuilder();
	}
	
	
}
