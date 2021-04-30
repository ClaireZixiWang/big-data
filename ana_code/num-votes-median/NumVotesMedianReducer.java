import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.util.*;

public class NumVotesMedianReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
            Reporter reporter) throws IOException {
    	List<Integer> valuesList = new ArrayList<Integer>();

        // accumulate all values
        while (values.hasNext()) {
            int nextValue = values.next().get();
            valuesList.add(nextValue);
        }

        // calculate median
        Collections.sort(valuesList);
        int middleIndex = valuesList.size() / 2;
        int median = valuesList.get(middleIndex);

        output.collect(
            new Text("num votes median"),
            new IntWritable(median)
        );
    }
}