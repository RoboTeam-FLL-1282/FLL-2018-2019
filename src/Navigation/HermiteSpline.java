package Navigation;
import java.util.ArrayList;
import java.util.Collections;

public class HermiteSpline{

    private ArrayList<Point> controlPoints;
    
    public HermiteSpline(Point... controlPoints) throws Exception {
        this.controlPoints = new ArrayList<>();
        if(controlPoints.length < 4){
            throw new Exception("Hermite Cubic spline must have at least 4 points");
        }
        Collections.addAll(this.controlPoints, controlPoints);
    }


    public HermiteSpline(ArrayList<Point> controlPoints) throws Exception {
        if(controlPoints.size() < 4){
            throw new Exception("Hermite Cubic spline must have at least 4 points");
        }
        this.controlPoints = controlPoints;
    }

    private double solveCubicHermite(double p0, double p1, double p2, double p3, double t){
        double a = -p0/2.0f + (3.0f*p1)/2.0f - (3.0f*p2)/2.0f + p3/2.0f;
        double b = p0 - (5.0f*p1)/2.0f + 2.0f*p2 - p3 / 2.0f;
        double c = -p0/2.0f + p2/2.0f;
        double d = p1;

        return a*t*t*t + b*t*t + c*t + d;
    }

    public double interpolate_X(double percent) throws Exception{
        if(percent > 1){
            throw  new Exception("interpolation is out of bounds");
        }
        double[] interpolation_values = get_t_and_jump_for_percent(percent);
        Point p0, p1, p2, p3;
        p0 = controlPoints.get((int)interpolation_values[1]);
        p1 = controlPoints.get((int)interpolation_values[1] + 1);
        p2 = controlPoints.get((int)interpolation_values[1] + 2);
        p3 = controlPoints.get((int)interpolation_values[1] + 3);

        return solveCubicHermite(p0.x, p1.x, p2.x, p3.x, interpolation_values[0]);
    }

    public double interpolate_Y(double percent) throws Exception {
        if(percent > 1){
            throw  new Exception("interpolation is out of bounds");
        }
        double[] interpolation_values = get_t_and_jump_for_percent(percent);
        Point p0, p1, p2, p3;
        p0 = controlPoints.get((int)interpolation_values[1]);
        p1 = controlPoints.get((int)interpolation_values[1] + 1);
        p2 = controlPoints.get((int)interpolation_values[1] + 2);
        p3 = controlPoints.get((int)interpolation_values[1] + 3);

        return solveCubicHermite(p0.y, p1.y, p2.y, p3.y, interpolation_values[0]);
    }

    public double get_length(int num_of_samples) throws Exception {
        return 0;
    }

    public boolean is_valid() {
        return true;
    }

    private double[] get_t_and_jump_for_percent(double percent){
        double jump = (int)(percent*(controlPoints.size() - 3)/1);
        double t = (controlPoints.size() - 3)*percent - jump;
        if(jump > controlPoints.size() - 4){
            jump = controlPoints.size() - 4;
            t = 1;
        }
        return new double[]{t,jump};
    }
}