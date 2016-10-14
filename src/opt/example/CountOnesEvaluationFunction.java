package opt.example;

import util.linalg.Vector;
import opt.EvaluationFunction;
import shared.Instance;

/**
 * A function that counts the ones in the data
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class CountOnesEvaluationFunction implements EvaluationFunction {
    /**
     * @see opt.EvaluationFunction#value(opt.OptimizationData)
     */
    public double value(Instance d) {
        incrementEvalCount();
        Vector data = d.getData();
        double val = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == 1) {
                val++;
            }
        }
        return val;
    }
    private long evalCount = 0;
    private long evalTime = 0;
    private long evalStart = 0;
    @Override
    public void incrementEvalCount() {
        evalCount++;
        evalTime = System.nanoTime();
    }
    @Override
    public long getEvalCount(){return evalCount;}
    @Override
    public void resetEvalCount(){
        evalCount = 0;
        evalStart = System.nanoTime();
    }
    @Override
    public long getLastEvalTime(){return evalTime - evalStart;}
}