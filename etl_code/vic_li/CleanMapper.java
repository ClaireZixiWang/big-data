import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import java.util.ArrayList;

public class CleanMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter)
            throws IOException {
        int idealColCount = 8;

        String line = value.toString();
        String[] rowEntries = line.split("\t");

        // Columns to drop:
        // index 4: language
        // index 6: attributes
        
        ArrayList<String> filteredRowEntries = new ArrayList<String>();
        for (int i = 0; i < rowEntries.length; i++) {
            if (i == 4 || i == 6) {
                continue;
            }

            filteredRowEntries.add(rowEntries[i]);
        }

        output.collect(
            new Text(String.join("\t", filteredRowEntries)),
            new Text("")
        );
    }
}