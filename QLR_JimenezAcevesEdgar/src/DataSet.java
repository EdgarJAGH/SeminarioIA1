
public class DataSet {
	private float x[];
    private float y[];

    public DataSet() {
        x = new float[] {-3, -2, -1, 0, 1, 2, 3};
        y = new float[] {7.5f, 3, 0.5f, 1, 3, 6, 14};
    }

    public float[] getX() {
        return x;
    }

    public float[] getY() {
        return y;
    }
}
