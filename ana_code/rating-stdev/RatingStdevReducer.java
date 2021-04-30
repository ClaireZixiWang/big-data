import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.util.List;
import java.util.ArrayList;

public class RatingStdevReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output,
            Reporter reporter) throws IOException {
        double sumValue = 0;
        int count = 0;
        double sqErrSum = 0;
    	List<Double> valuesList = new ArrayList<Double>();

        // accumulate all values
        while (values.hasNext()) {
            double nextValue = values.next().get();
            sumValue += nextValue;
            valuesList.add(nextValue);
            count++;
        }

        // calculate average
        double avg = sumValue / count;

        // calculate std dev
        for (int i = 0; i < valuesList.size(); i++) {
            sqErrSum += Math.pow(valuesList.get(i) - avg, 2);
        }
        double stdev = Math.sqrt(sqErrSum / count);

        output.collect(
            new Text("Ratings standard deviation"),
            new DoubleWritable(stdev)
        );
    }
}