
public class Population {
	private int geneSize;
	private int populationSize;
	private int[][] population;
	private float totalFitness;
	private float[] populationFitness;
	private RandomNumber rando;
	public Population() {
		geneSize = 7;
		populationSize = 10;
		population = new int[populationSize][geneSize];
		totalFitness = 0;
		populationFitness = new float[populationSize];
		rando = new RandomNumber();
	}
	
	public int[][] getPopulation(){
		return population;
	}
	public int getGeneSize() {
		return geneSize;
	}
	public int getpopulationSize() {
		return populationSize;
	}
	public float getTotalFitness() {
		return totalFitness;
	}
	public float[] getPopulationFitness() {
		return populationFitness;
	}
	
	public void setPopulation (int[][] newPopulation) {
		population = newPopulation;
	}
	
	public void evaluatePopulation() {
		int coincidence = 0;
		totalFitness = 0;
		for(int i = 0; i < populationSize; i++) {
			for (int j = 0; j < geneSize; j++) {
				if(population[i][j] == 1)
					coincidence++;
			}
			//Fitness equation
			populationFitness[i] = fitnessEquation(coincidence);
			totalFitness += populationFitness[i];
			coincidence = 0;
		}
	}
	
	public int fitnessEquation(int x) {
		return 100 - ((x*10)-70);
	}
	public void initializePopulation() {
		for(int i = 0; i < populationSize; i++) {
			for (int j = 0; j < geneSize; j++) {
				population[i][j] = rando.randomBinary();
			}
		}
	}
	public void printPopulation(){
		for(int i = 0; i < populationSize; i++) {
			for (int j = 0; j < geneSize; j++) {
				 System.out.print(population[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
