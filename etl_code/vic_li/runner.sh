NETID=sl5450

HDFS_INPUT_PATH=hw7/title.akas.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw7/output/p2/akas

OUTPUT_FNAME=titles-akas-cleaned.txt

javac -classpath `yarn classpath` -d . CleanMapper.java &&
javac -classpath `yarn classpath` -d . CleanReducer.java && 
javac -classpath `yarn classpath`:. -d . Clean.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar Clean $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME