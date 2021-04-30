import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        
        //tringBuilder sb = new StringBuilder();
        int[] indexList = new int[11];
        String line = value.toString();
        int quotNum = 0;
        int col = 0;
        boolean addflag = true;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '\"') {
                quotNum++;
            }
            if(line.charAt(i) == ',' && (quotNum%2 == 0)) {
                indexList[col++] = i;
            }
        }
        String cleanedString = line.substring(0,indexList[3]) + line.substring(indexList[4],indexList[10]);
        if(cleanedString.length()>0){
            context.write(new Text(cleanedString), new Text("")); 
        }
    }
}