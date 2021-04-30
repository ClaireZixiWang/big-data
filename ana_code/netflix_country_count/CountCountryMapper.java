import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class CountCountryMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        
        try {
            String[] line = splitCSV(value, 11);
            String[] country = line[5].split(",");
            for(String c: country){
                String trimmed = c.trim();
                context.write(new Text(trimmed), new IntWritable(1));
            }
        }
        catch (Exception err) {
            return;
        }
        
    }

    public static String[] splitCSV(Text value, int colNum){
        int[] indexList = new int[colNum+1];
        String line = value.toString();
        String[] entries = new String[colNum];

        indexList[0] = -1;
        int quotNum = 0;
        int col = 1;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '\"') {
                quotNum++;
            }
            if(line.charAt(i) == ',' && (quotNum%2 == 0)) {
                indexList[col++] = i;
            }
        }

        indexList[colNum] = line.length();

        for(int i = 0; i<colNum; i++){
            entries[i] = line.substring(indexList[i]+1, indexList[i+1]);
            if(entries[i].charAt(0) == '\"'){
                entries[i] = entries[i].substring(1, entries[i].length()-1);
            }
        }

        return entries;



    }

}