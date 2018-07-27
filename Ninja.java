
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
	
}
