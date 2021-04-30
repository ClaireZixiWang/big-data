import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class JoinedRatingAverageMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {
        String line = value.toString();
        String[] rowEntries = line.split(",");

        if (rowEntries.length != 4) {
            return;
        }

        try {
        double parsedRating = Double.parseDouble(rowEntries[1]);
        
        if (parsedRating > 10) return;

            output.collect(
                new Text("average"),
                new DoubleWritable(parsedRating)
            );
        }
        catch (Exception e) {
            return;
        }
    }
}