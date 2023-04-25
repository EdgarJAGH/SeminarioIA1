
public class QLR {
	private float beta0;
	private float beta1;
	private float beta2;
	private int n;
	private DataSet data;
	private DiscreteMaths maths;
	public QLR() {
		data = new DataSet();
		maths = new DiscreteMaths();
		n = data.getX().length;
		beta2 = toComputeBeta2();
		beta1 = toComputeBeta1();
		beta0 = toComputeBeta0();
	}
	public void printRegEquation(){
		System.out.println("Reg Equation= " + beta2 + "x^2 + " + beta1 + "x + " + beta0);
	}
	
	public float toComputeBeta0() {
		return maths.sumY(data.getY())/n-beta1*(maths.sumX(data.getX())/n)
				- beta2*(maths.sumX2(data.getX())/n);
	}
	
	public float toComputeBeta1() {
		float dive = maths.EXY(maths.sumXY(data.getX(), data.getY()), maths.sumX(data.getX()), maths.sumY(data.getY()), n)
				*maths.EX2X2(maths.sumX4(data.getX()), maths.sumX2(data.getX()), n)
				-maths.EX2Y(maths.sumX2Y(data.getX(), data.getY()), maths.sumX2(data.getX()), maths.sumY(data.getY()), n)
				*maths.EXX2(maths.sumX3(data.getX()), maths.sumX2(data.getX()), maths.sumX(data.getX()), n);
		float div = maths.EXX(maths.sumX2(data.getX()), maths.sumX(data.getX()), n)
				*maths.EX2X2(maths.sumX4(data.getX()), maths.sumX2(data.getX()), n)
				-maths.EXX2(maths.sumX3(data.getX()), maths.sumX2(data.getX()), maths.sumX(data.getX()), n)
				*maths.EXX2(maths.sumX3(data.getX()), maths.sumX2(data.getX()), maths.sumX(data.getX()), n);
		return dive/div;
	}
	public float toComputeBeta2() {
		float dive = maths.EX2Y(maths.sumX2Y(data.getX(), data.getY()), maths.sumX2(data.getX()), maths.sumY(data.getY()), n)
				*maths.EXX(maths.sumX2(data.getX()), maths.sumX(data.getX()), n)
				-maths.EXY(maths.sumXY(data.getX(), data.getY()), maths.sumX(data.getX()), maths.sumY(data.getY()), n)
				*maths.EXX2(maths.sumX3(data.getX()), maths.sumX2(data.getX()), maths.sumX(data.getX()), n);
		float div =maths.EXX(maths.sumX2(data.getX()), maths.sumX(data.getX()), n)
				*maths.EX2X2(maths.sumX4(data.getX()), maths.sumX2(data.getX()), n)
				-maths.EXX2(maths.sumX3(data.getX()), maths.sumX2(data.getX()), maths.sumX(data.getX()), n)
				*maths.EXX2(maths.sumX3(data.getX()), maths.sumX2(data.getX()), maths.sumX(data.getX()), n);
		return dive/div;
	}
	
	public float toPredict(float x) {
		return beta2*(x*x) + beta1*x + beta0;
	}
	public float RSquared () {
		float SSR= 0;
		float SST= 0;
		float tempSSR= 0;
		float tempSST= 0;
		float yavg= 0;
		for(int i=0; i < data.getY().length; i++) {
			yavg = yavg + data.getY()[i];
		}
		yavg = yavg/n;
		for(int i=0; i < data.getY().length; i++) {
			tempSSR = data.getY()[i] - toPredict(data.getX()[i]);
			SSR = SSR + tempSSR*tempSSR;
			tempSST = data.getY()[i] - yavg;
			SST = SST + tempSST*tempSST;
		}
		return 1 - (SSR/SST);
	}
}
