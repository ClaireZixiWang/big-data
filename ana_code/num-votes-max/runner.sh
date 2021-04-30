NETID=sl5450

HDFS_INPUT_PATH=hw7/title.ratings.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw9/output/num-votes-max

OUTPUT_FNAME=num-votes-max.txt

javac -classpath `yarn classpath` -d . NumVotesMaxMapper.java &&
javac -classpath `yarn classpath` -d . NumVotesMaxReducer.java && 
javac -classpath `yarn classpath`:. -d . NumVotesMax.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar NumVotesMax $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME