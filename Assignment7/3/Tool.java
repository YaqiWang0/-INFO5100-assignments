package Assignment7;

class Tool {
	protected int strength;
	protected char type;
	
	public void setStrength(int strength) {
		this.strength=strength;
	}

}

class Paper extends Tool {

	public Paper(int strength) {
		// TODO Auto-generated constructor stub
		this.strength=strength;
		this.type='p';
	}
	
	public boolean fight(Tool compare) {
		float cur=strength;
		if(compare.type=='r') {
			cur=cur*2;
		}
		if(compare.type=='s')
			cur=cur/2;
		if(cur>compare.strength)
			return true;
		return false;
	}
	
}

class Rock extends Tool {

	public Rock(int strength) {
		// TODO Auto-generated constructor stub
		this.strength=strength;
		this.type='r';
	}
	public boolean fight(Tool compare) {
		float cur=strength;
		if(compare.type=='s') {
			cur=cur*2;
		}
		if(compare.type=='p')
			cur=cur/2;
		if(cur>compare.strength)
			return true;
		return false;
	}

	

}

class Scissors extends Tool {

	public Scissors(int strength) {
		// TODO Auto-generated constructor stub
		this.strength=strength;
		this.type='s';
	}
	
	public boolean fight(Tool compare) {
		float cur=strength;
		if(compare.type=='r') {
			cur=cur/2;
		}
		if(compare.type=='p')
			cur=cur*2;
		if(cur>compare.strength)
			return true;
		return false;
	}

}

class RockPaperScissorsGame{
    public static void main(String args){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}


