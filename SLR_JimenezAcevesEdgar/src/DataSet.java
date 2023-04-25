
public class DataSet {
	private float x[];
    private float y[];

    public DataSet() {
        x = new float[] {23, 26, 30, 34, 43, 48, 52,57,58};
        y = new float[] {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
        //x = new float[] {1, 2, 3, 4, 5, 6, 7,8,9};
        //y = new float[] {2, 4, 6, 8, 10, 12, 14, 16, 18};
    }

    public float[] getX() {
        return x;
    }

    public float[] getY() {
        return y;
    }
}
