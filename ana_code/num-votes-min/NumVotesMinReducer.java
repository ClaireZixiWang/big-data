import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.util.*;

public class NumVotesMinReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
            Reporter reporter) throws IOException {
        int minValue = Integer.MAX_VALUE;

        while (values.hasNext()) {
            int nextValue = values.next().get();
            if (nextValue < minValue) {
                minValue = nextValue;
            }
        }

        output.collect(
            new Text("num votes min"),
            new IntWritable(minValue)
        );
    }
}