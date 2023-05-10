
public class GA {
	Population currentPopulation;
	Population newPopulation;
	int maxIteration;
	float crossoverRate;
	float mutationRate;
	int generation;
	RandomNumber rand;
	public GA() {
		currentPopulation = new Population();
		currentPopulation.initializePopulation();
		newPopulation = new Population();
		maxIteration = 30;
		crossoverRate = 0.6f;
		mutationRate = 0.85f;
		rand = new RandomNumber();
		generation= 0;
	}
	
	public void startGA() {
		int currentIteration = 0;
		currentPopulation.evaluatePopulation();
		while (!isCriterionSatisfied() && currentIteration < maxIteration) {
			newPopulation = new Population();
			newPopulation.setPopulation(crossover());
			mutation();
			currentPopulation = newPopulation;
			newPopulation = new Population();
			currentPopulation.evaluatePopulation();
			currentIteration++;
		}
		generation= currentIteration;
	}
	
	public Boolean isCriterionSatisfied() {
		int coincidence = 0;
		int [][] population = currentPopulation.getPopulation();
		for(int i = 0; i < currentPopulation.getpopulationSize(); i++) {
			for (int j = 0; j < currentPopulation.getGeneSize(); j++) {
				if (population[i][j] == 1) 
					coincidence++;
			}
			if (coincidence == currentPopulation.getGeneSize())
				return true;
			coincidence =0;
		}
		return false;
	}
	public int[][] crossover() {
		int nextArray [][] = new int[currentPopulation.getpopulationSize()][currentPopulation.getGeneSize()];
		for (int individual = 0; individual < currentPopulation.getpopulationSize(); individual++) {
			if (crossoverRate > rand.randomFloat()) {
				//Choose second parent
				int secondParent = selectParent();
				if (secondParent == individual)
					nextArray[individual] = CopyArray(currentPopulation.getPopulation()[individual]);
				else {
					//crossover happens
					int [][] offspring = new int [2][currentPopulation.getGeneSize()];
					int crossingPoint = rand.randomIntInRange(currentPopulation.getGeneSize()-1);
					offspring = doCrossover(currentPopulation.getPopulation()[individual],
							currentPopulation.getPopulation()[secondParent],crossingPoint);
					nextArray[individual] = offspring[0];
					individual++;
					if (individual < currentPopulation.getpopulationSize())
						nextArray[individual] = offspring[1];
				}
			}
			else {
				nextArray[individual] = CopyArray(currentPopulation.getPopulation()[individual]);
			}
		}
		return nextArray;
	}
	public int [] CopyArray(int [] array) {
		int [] newArray = new int [array.length];
		for (int i = 0; i< array.length; i++)
		{
			newArray[i] = array[i];
		}		
		return newArray;
	}
	
	public int selectParent() {
		float currentPercentage = 0;
		float totalFitness = currentPopulation.getTotalFitness();
		float[] populationFitness = currentPopulation.getPopulationFitness();
		float [] percentages = new float[currentPopulation.getpopulationSize()];
		float chance = rand.randomFloat();
		for (int i = 0; i< populationFitness.length; i++) {
			percentages[i] = populationFitness[i]/totalFitness + currentPercentage;
			currentPercentage += percentages[i];
		}
		if (chance <= percentages[0]) {
			return 0;
		}
		for (int i =1; i< percentages.length; i++) {
			if (chance > percentages[i-1] && chance <= percentages[i])
				return i;
		}
		return 0;
	}
	public int [][] doCrossover(int[] parent1, int[] parent2, int crossingPoint){
		int[][] offspring = new int [2][currentPopulation.getGeneSize()];
		int [] aux = new int [currentPopulation.getGeneSize()];
		offspring[0] = CopyArray(parent1);
		offspring[1] = CopyArray(parent2);
		for (int i = crossingPoint; i< currentPopulation.getGeneSize(); i++) {
			aux[i] = offspring[1][i];
			offspring[1][i] = offspring[0][i];
			offspring[0][i] = aux[i];
		}
		return offspring;
	}
	
	public void mutation () {
		for (int i = 0; i < newPopulation.getpopulationSize(); i++) {
			if (mutationRate > rand.randomFloat()) {
				int gene = rand.randomIntInRange(newPopulation.getGeneSize());
				if (newPopulation.getPopulation()[i][gene] == 0)
					newPopulation.getPopulation()[i][gene] = 1;
				else
					newPopulation.getPopulation()[i][gene] = 0;
			}
		}
	}
	
	public void printCurrentPopulation(){
		currentPopulation.printPopulation();
	}
}
