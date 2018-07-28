import java.util.ArrayList;

public class Main extends Warrior{
	 public Main(String name) {
		super(name);
	}
	private static void printWarriors(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i) {
			printWarrior(warriors.get(i));
		}
	}
	private static void enrollMaxDefensiveValuesMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).enrollMaxDefensiveValues();
	}
	private static void enrollMinDefensiveValuesMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).enrollMinDefensiveValues();
	}
	private static void enrollMinAttackingValuesMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).enrollMinAttackingValues();
	}
	private static void enrollMinJumpingValuesMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).enrollMinJumpingValues();
	}
	private static void calculateSumAttackingPowerMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).calculateSumAttackingPower();
	}
	private static void calculateSumDefensivePowerMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).calculateSumDefensivePower();
	}
	private static void calculateSumJumpingPowerMain(ArrayList<Warrior> warriors) {
		for(int i = 0; i < warriors.size(); ++i)
			warriors.get(i).calculateSumJumpingPower();
	}
	public static void main(String[] args) throws Exception{
		ArrayList<Warrior> warriorList = new ArrayList<Warrior>();
		
		Warrior w1 = new Warrior("Frank");
		Warrior w2 = new Warrior("Jon");
		
		Ninja n1 = new Ninja("Bob");
		
		warriorList.add(w1);
		warriorList.add(w2);
		warriorList.add(n1);
		
		w1.increaseDefensivePower(51);
		w1.increaseAttackingPower(1);
		w1.increaseAttackingPower(2);
		w1.increaseJumpingHeight(3.2);
		
		w2.increaseAttackingPower(10);
		w2.increaseJumpingHeight(3.6);
		w2.increaseJumpingHeight(0.1);
		w2.increaseDefensivePower(60);
		w2.increaseAttackingPower(10);
		w2.increaseAttackingPower(10);
		w2.increaseAttackingPower(10);
		
		n1.increaseDefensivePower(30);
		n1.increaseAttackingPower(5);
		n1.increaseJumpingHeight(1.6);
		
		Warrior.compareAttackingPower(w1, w2);
		Warrior.compareDefensivePower(w1, w2);
		Warrior.compareJumpingPower(w1, w2);
		
		Warrior.checkId(w1, 14);
		Warrior.checkId(w1);
		
		// Printing stats //
		System.out.println("--------------------Stats-----------------------");
		printWarriors(warriorList);
		
		enrollMaxDefensiveValuesMain(warriorList);
		enrollMinDefensiveValuesMain(warriorList);
		enrollMinAttackingValuesMain(warriorList);
		enrollMinJumpingValuesMain(warriorList);

		calculateSumAttackingPowerMain(warriorList);
		calculateSumDefensivePowerMain(warriorList);
		calculateSumJumpingPowerMain(warriorList);
		
		Warrior.findAverageAttackingPower();
		Warrior.findAverageDefensivePower();
		Warrior.findAverageJumpingPower();
		
		Warrior.printMinMaxValues();
		Warrior.printAverageValues();
		System.out.println("Total number of warriors:" + Warrior.warriorsCounter);

	}

}
