NETID=zw1511

HDFS_INPUT_PATH=hw/hw9/netflix_titles.csv
HDFS_OUTPUT_PATH=/user/$NETID/hw/hw9/output

OUTPUT_FNAME=output.txt

javac -classpath `yarn classpath` -d . TypeCountMapper.java &&
javac -classpath `yarn classpath` -d . TypeCountReducer.java && 
javac -classpath `yarn classpath`:. -d . TypeCount.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar TypeCount $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME