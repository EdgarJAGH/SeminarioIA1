import java.util.Random;
public class RandomNumber {
	private Random rand;
	public RandomNumber() {
		rand = new Random();
	}
	
	public int randomBinary() {
		return rand.nextInt(2);
	}
	public int randomIntInRange (int x) {
		return rand.nextInt(x);
	}
	public float randomFloat() {
		return rand.nextFloat();
	}
	public double randomDouble() {
		return rand.nextDouble();
	}
}
