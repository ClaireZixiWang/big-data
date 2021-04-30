NETID=zw1511

HDFS_INPUT_PATH=hw/hw7/hw7-output-2.txt
HDFS_OUTPUT_PATH=/user/$NETID/hw/hw7/output/p1/afterClean

OUTPUT_FNAME=hw7-output-1b.txt

javac -classpath `yarn classpath` -d . CountRecsMapper.java &&
javac -classpath `yarn classpath` -d . CountRecsReducer.java && 
javac -classpath `yarn classpath`:. -d . CountRecs.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar CountRecs $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME