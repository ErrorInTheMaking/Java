import java.util.*;

public class Warrior {
	private String name;
	private int attackingPower;
	private int defensivePower;
	private double jumpingHeight;
	private String warriorSound;
	private long id;
	protected String specialCharacter = "Warrior";
	
	protected static int warriorsCounter = 0;
	private static int maxAttackingPower = 50;
	private static double maxJumpingHeight = 1; //in meters
	private static int sumAttackingPower = 0;
	private static int sumDefensivePower = 0;
	private static int sumJumpingPower = 0;
	protected static final int MAX_ATTACKING_POWER = 300;
	protected static final int MIN_ATTACKING_POWER = 0;
	protected static final int MAX_DEFENSIVE_POWER = 400;
	protected static final double MAX_JUMPING_HEIGHT = 5;  // meters 
    private static ArrayList<Integer> arrayMaxDefensivePower = new ArrayList<Integer>();
    private static ArrayList<Integer> arrayMinAttackingPower = new ArrayList<Integer>();
    private static ArrayList<Integer> arrayMinDefensivePower = new ArrayList<Integer>();
    private static ArrayList<Double> arrayMinJumpingPower = new ArrayList<Double>();
	static Scanner in  = new Scanner(System.in);
	
	public Warrior(String name) {
		Warrior.warriorsCounter++;
		this.name = name;
		this.setAttackingPower(50);
		this.setDefensivePower(50);
		this.setJumpingHeight(1);
		this.setWarriorSound();
		this.setId();
	}
	private static void newline(){
		System.out.println("------------------------------");
	}
	public void enrollMaxDefensiveValues() {
		arrayMaxDefensivePower.add(this.defensivePower);
	}
	public void enrollMinDefensiveValues() {
		arrayMinDefensivePower.add(this.defensivePower);
	}
	public void enrollMinAttackingValues() {
		arrayMinAttackingPower.add(this.attackingPower);
	}
	public void enrollMinJumpingValues() {
		arrayMinJumpingPower.add(this.jumpingHeight);
	}
	public static int calculateMaxDefensiveValues() {
		return Collections.max(arrayMaxDefensivePower);
	}
	public static int calculateMinAttackingValues() {
		return Collections.min(arrayMinAttackingPower);
	}
	public static int calculateMinDefensiveValues() {
		return Collections.min(arrayMinDefensivePower);
	}
	public static double calculateMinJumpingValues() {
		return Collections.min(arrayMinJumpingPower);
	}
	private void setId() {
		this.id = (long)(Math.random()*100 + 1);
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackingPower() {
		return attackingPower;
	}

	public void setAttackingPower(int attackingPower) {
		this.attackingPower = attackingPower;
	}

	public int getDefensivePower() {
		return defensivePower;
	}

	public void setDefensivePower(int defensivePower) {
		this.defensivePower = defensivePower;
	}

	public double getJumpingHeight() {
		return jumpingHeight;
	}

	public void setJumpingHeight(double jumpingHeight) {
		this.jumpingHeight = jumpingHeight;
	}
	
	public void setWarriorSound() {
		this.warriorSound = "Gooooooooooo";
	}
	public String getWarriorSound() {
		return warriorSound;
	}
	public void setWarriorSound(String warriorSound) {
		this.warriorSound = warriorSound;
	}
	public void increaseAttackingPower(int power) {
		if(this.getAttackingPower() < MAX_ATTACKING_POWER) {
			this.attackingPower += power;
			int defensivePowerLost = (int)(Math.random()*power);
			this.setDefensivePower((this.defensivePower) - defensivePowerLost);
			this.secretMessage();
			System.out.println(this.name + ": Attacking power upgraded to " + this.getAttackingPower()  + "(+" + power + ")" + " and lost " + defensivePowerLost + " defensive strength.Current Defensive strength is "
					+ this.getDefensivePower());
			this.checkDefensivePower();
		}
		else {
			System.out.println(this.name + ": Attacking power is maxed out.Resetting to 50");
			this.setAttackingPower(50);
		}
		findMaxAttackingPower();
	}
	public void increaseDefensivePower(int power) {
		if(this.getDefensivePower() < MAX_DEFENSIVE_POWER) {
			this.defensivePower += power;
			this.secretMessage();
			System.out.println(this.name + ": Defensive power upgraded to:" + this.getDefensivePower() + "(+" + power + ")");
		}
		else {
			System.out.println(this.name + ": Defensive power is maxed out.Resetting to 50");
			this.setDefensivePower(50);
		}
	}
	public void increaseJumpingHeight(double height) {
		if(this.getJumpingHeight() + height >= MAX_JUMPING_HEIGHT) {
			System.out.println(this.name + ": Height maxed out.Resetting....");
			this.setJumpingHeight(1);	
		}
		else {
			this.jumpingHeight += height;
			System.out.printf("%s: Upgraded height to %.3g from %.3g\n", this.name , this.jumpingHeight,  this.jumpingHeight-height);
		}
		findMaxJumpingPower();
	}
	public void checkDefensivePower() {
		if(this.getDefensivePower() < 10)
			this.gameOver();
		else
			return;
	}
	public void gameOver() {
		System.out.printf("%s: Defensive power is too low(%d).Resetting everything to 50\n", this.name,this.getDefensivePower());
		this.resetAll();
	}
	public void resetAll() {
		this.attackingPower = 50;
		this.jumpingHeight = 1;
		this.defensivePower = 50;
	}
	protected static void compareAttackingPower(Warrior w1, Warrior w2) {
		if (w1.attackingPower > w2.attackingPower) {
			System.out.printf("%s has more attacking power<%d> than %s<%d>\n", w1.name, w1.attackingPower, w2.name, w2.attackingPower);
		}
		else if (w1.attackingPower == w2.attackingPower) {
			System.out.printf("%s has the same attacking power<%d> as %s<%d>\n", w1.name, w1.attackingPower, w2.name, w2.attackingPower);
		}
		else {
			System.out.printf("%s has more attacking power<%d> than %s<%d>\n", w2.name, w2.attackingPower, w1.name, w1.attackingPower);
		}
	}
	protected static void compareDefensivePower(Warrior w1, Warrior w2) {
		if (w1.defensivePower > w2.defensivePower) {
			System.out.printf("%s has more defensive power<%d> than %s<%d>\n", w1.name, w1.defensivePower, w2.name, w2.defensivePower);
		}
		else if (w1.defensivePower == w2.defensivePower) {
			System.out.printf("%s has the same defensive power<%d> as %s<%d>\n", w1.name, w1.defensivePower, w2.name, w2.defensivePower);
		}
		else {
			System.out.printf("%s has more defensive power<%d> than %s<%d>\n", w2.name, w2.defensivePower, w1.name, w1.defensivePower);
		}
	}
	protected static void compareJumpingPower(Warrior w1, Warrior w2) {
		if (w1.jumpingHeight > w2.jumpingHeight) {
			System.out.printf("%s has more jumping power<%.2g> than %s<%.2g>\n", w1.name, w1.jumpingHeight, w2.name, w2.jumpingHeight);
		}
		else if (w1.jumpingHeight == w2.jumpingHeight) {
			System.out.printf("%s has the same jumping power<%.2g> as %s<%.2g>\n", w1.name, w1.jumpingHeight, w2.name, w2.jumpingHeight);
		}
		else {
			System.out.printf("%s has more jumping power<%.2g> than %s<%.2g>\n", w2.name, w2.jumpingHeight, w1.name, w1.jumpingHeight);
		}
	}
	public void secretMessage() {
		if(this.defensivePower > 100)
			this.setWarriorSound("Grooooww");
		else
			this.setWarriorSound();
	}
	public void findMaxAttackingPower() {
		if(this.attackingPower > maxAttackingPower)
			maxAttackingPower = this.attackingPower;
		else
			return;
	}
	
	public void findMaxJumpingPower() {
		if(this.jumpingHeight > maxJumpingHeight)
			maxJumpingHeight = this.jumpingHeight;
		else
			return;
	}
	public static void printWarrior(Warrior warrior) {
		System.out.println("Character:" + warrior.specialCharacter);
		System.out.println("Name:" + warrior.getName());
		System.out.println("Attacking power:" + warrior.getAttackingPower());
		System.out.println("Defensive strength:" + warrior.getDefensivePower());
		System.out.printf("Jump:%.3g\n", warrior.getJumpingHeight());
		System.out.println("Sound:" + warrior.getWarriorSound());
		System.out.println("ID:" + warrior.getId());
		newline();
	}
	
	public static void printMinMaxValues() {
		System.out.println("Max attacking power " + maxAttackingPower);
		System.out.println("Max defensive power " + Warrior.calculateMaxDefensiveValues());
		System.out.printf("Max jumping height %.2g\n", maxJumpingHeight);
		newline();
		System.out.println("Min attacking power " + Warrior.calculateMinAttackingValues());
		System.out.println("Min defensive power " + Warrior.calculateMinDefensiveValues());
		System.out.printf("Min jumping height %.2g\n", Warrior.calculateMinJumpingValues());
	}
	public static void printAverageValues() {
		newline();
		System.out.println("Average attacking power " + Warrior.findAverageAttackingPower());
		System.out.println("Average defensive power " + Warrior.findAverageDefensivePower());
		System.out.printf("Average jumping height %.2g\n", Warrior.findAverageJumpingPower());
		newline();

	}
	public static void checkId(Warrior warrior, long id) {
		if(id == warrior.id) {
			System.out.println("You guessed the id!\nBonus +50 attacking power");
			warrior.attackingPower += 50;
			warrior.findMaxAttackingPower();
		}
		else
			System.out.println(warrior.name +": You guessed the wrong id (" + id + ").ID:" + warrior.id);
	}
	public static void checkId(Warrior warrior) throws Exception{
		long guess;
		System.out.print("Enter an id:");
		if(in.hasNextLong()){
			guess = in.nextLong();
			if(guess == warrior.id){
				System.out.println("You guessed the id!\nBonus +50 attacking power");
				warrior.attackingPower += 50;
				warrior.findMaxAttackingPower();
				in.close(); //Close Scanner
			}
			else
				System.out.println(warrior.name +": You guessed the wrong id (" + guess + ").ID:" + warrior.id);
		}
		else
			throw new Exception("Enter Long number");
	}	
	protected void calculateSumAttackingPower() {
		sumAttackingPower += attackingPower;
	}
	protected void calculateSumDefensivePower() {
		sumDefensivePower += defensivePower;
	}
	protected void calculateSumJumpingPower() {
		sumJumpingPower += jumpingHeight;
	}
	public static double findAverageAttackingPower() {
		return Warrior.sumAttackingPower/Warrior.warriorsCounter;
	}
	public static double findAverageDefensivePower() {
		return Warrior.sumDefensivePower/Warrior.warriorsCounter;
	}
	public static double findAverageJumpingPower() {
		return Warrior.sumJumpingPower/Warrior.warriorsCounter;
	}
}
