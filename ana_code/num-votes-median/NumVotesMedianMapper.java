import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class NumVotesMedianMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
            throws IOException {
        String line = value.toString();
        String[] rowEntries = line.split("\t");

        if (rowEntries.length != 3) {
            return;
        }

        try {
            output.collect(
                new Text("Median"),
                new IntWritable(Integer.parseInt(rowEntries[2]))
            );
        }
        catch (Exception e) {
            return;
        }
    }
}