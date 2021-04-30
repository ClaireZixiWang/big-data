import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class CountRecsMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
            throws IOException {
        // int idealColCount = 16;

        String line = value.toString();
        String[] rowEntries = line.split(",");

        output.collect(
            new Text("Total number of records:"),
            new IntWritable(1)
            // new IntWritable(rowEntries.length == idealColCount ? 1 : 0)
        );
    }
}