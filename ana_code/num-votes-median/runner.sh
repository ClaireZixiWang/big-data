NETID=sl5450

HDFS_INPUT_PATH=hw7/title.ratings.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw9/output/num-votes-median

OUTPUT_FNAME=num-votes-median.txt

javac -classpath `yarn classpath` -d . NumVotesMedianMapper.java &&
javac -classpath `yarn classpath` -d . NumVotesMedianReducer.java && 
javac -classpath `yarn classpath`:. -d . NumVotesMedian.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar NumVotesMedian $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME