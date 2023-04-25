
public class SLR {
	private float beta0;
	private float beta1;
	private int n;
	private DataSet data;
	private DiscreteMaths maths;
	public SLR() {
		data = new DataSet();
		maths = new DiscreteMaths();
		n = data.getX().length;
		beta1 = toComputeBeta1();
		beta0 = toComputeBeta0();
	}
	
	public void printRegEquation(){
		System.out.println("Reg Equation= " + beta1 + "x + " + beta0);
	}
	
	public float toComputeBeta0() {
		return (maths.sumY(data.getY())-beta1*maths.sumX(data.getX()))/n;
	}
	
	public float toComputeBeta1() {
		return (n*maths.sumXY(data.getX(), data.getY())-maths.sumX(data.getX())*maths.sumY(data.getY()))
				/(n*maths.sumX2(data.getX())-maths.sumX(data.getX())*maths.sumX(data.getX()));
	}
	
	public float toPredict(float x) {
		return beta1*x + beta0;
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
