NETID=sl5450

HDFS_INPUT_PATH=hw7/title.akas.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw7/output/p1/akas

OUTPUT_FNAME=hw7-output-part1-file2.txt

javac -classpath `yarn classpath` -d . CountRecsMapper.java &&
javac -classpath `yarn classpath` -d . CountRecsReducer.java && 
javac -classpath `yarn classpath`:. -d . CountRecs.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar CountRecs $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME