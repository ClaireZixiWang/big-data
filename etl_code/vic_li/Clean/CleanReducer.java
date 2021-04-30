import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.util.ArrayList;

public class CleanReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output,
            Reporter reporter) throws IOException {
        
        // ArrayList<String> rows = new ArrayList<String>();
        // while (values.hasNext()) {
        //     rows.add(values.next().toString());
        // }

        output.collect(key, new Text(""));
    }
}