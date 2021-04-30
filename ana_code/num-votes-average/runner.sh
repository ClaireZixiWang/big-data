NETID=sl5450

HDFS_INPUT_PATH=hw7/title.ratings.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw9/output/num-votes-average

OUTPUT_FNAME=num-votes-average.txt

javac -classpath `yarn classpath` -d . NumVotesAverageMapper.java &&
javac -classpath `yarn classpath` -d . NumVotesAverageReducer.java && 
javac -classpath `yarn classpath`:. -d . NumVotesAverage.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar NumVotesAverage $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME