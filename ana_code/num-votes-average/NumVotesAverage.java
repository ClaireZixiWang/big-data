import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class NumVotesAverage {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: NumVotesAverage <input path> <output path>");
            System.exit(-1);
        }
        JobConf conf = new JobConf(NumVotesAverage.class);
        conf.setJobName("num votes average");
        FileInputFormat.addInputPath(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        conf.setMapperClass(NumVotesAverageMapper.class);
        conf.setReducerClass(NumVotesAverageReducer.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(DoubleWritable.class);
        JobClient.runJob(conf);
    }
}
