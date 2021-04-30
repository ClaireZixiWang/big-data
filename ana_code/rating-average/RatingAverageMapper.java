import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class RatingAverageMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {
        String line = value.toString();
        String[] rowEntries = line.split("\t");

        if (rowEntries.length != 3) {
            return;
        }

        try {
            output.collect(
                new Text("average"),
                new DoubleWritable(Double.parseDouble(rowEntries[1]))
            );
        }
        catch (Exception e) {
            return;
        }
    }
}