
public class Ninja extends Warrior{
	private String warriorSound;
	
	public Ninja(String name) {
		super(name);
		this.setJumpingHeight(2);
		this.specialCharacter = "Ninja";
	}
	
	@Override
	public void setWarriorSound() {this.warriorSound = "Ninja Chop!";}
	public String getWarriorSound() {return warriorSound;}
	public void secretMessage() {if(this.getDefensivePower() > 100)this.warriorSound = "Super Sayan!";}
	public void increaseAttackingPower(int power) {
		int currentPower = this.getAttackingPower();
		if(currentPower < MAX_ATTACKING_POWER) {
			this.setAttackingPower(currentPower + power + 40);
			this.secretMessage();
			System.out.println("A ninja doesn't lose defensive power!" );
			System.out.println(this.getName() + ": Attacking power upgraded to " + this.getAttackingPower()  + "(+" + power + ")");
			this.checkDefensivePower();
		}
		else {
			System.out.println(this.getName() + ": Attacking power is maxed out.Resetting to 50");
			this.setAttackingPower(50);
		}
		findMaxAttackingPower();
	}
	public void increaseDefensivePower(int power) {
		int currentPower = this.getDefensivePower();
		int rand = (int)(Math.random()*21);
		if(currentPower < MAX_DEFENSIVE_POWER) {
			this.setDefensivePower(currentPower + power + rand);
			this.secretMessage();
			System.out.println(this.getName() + ": Defensive power upgraded to:" + this.getDefensivePower() + "(+" + (power+rand) + ")");
		}
		else {
			System.out.println(this.getName() + ": Defensive power is maxed out.Resetting to 50");
			this.setDefensivePower(50);
		}
	}
	
}
