NETID=sl5450

HDFS_INPUT_PATH=hw7/title.ratings.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw9/output/num-votes-min

OUTPUT_FNAME=output.txt

javac -classpath `yarn classpath` -d . NumVotesMinMapper.java &&
javac -classpath `yarn classpath` -d . NumVotesMinReducer.java && 
javac -classpath `yarn classpath`:. -d . NumVotesMin.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar NumVotesMin $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME