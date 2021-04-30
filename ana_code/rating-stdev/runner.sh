NETID=sl5450

HDFS_INPUT_PATH=hw7/title.ratings.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw9/output/ratings-stdev

OUTPUT_FNAME=rating-stdev.txt

javac -classpath `yarn classpath` -d . RatingStdevMapper.java &&
javac -classpath `yarn classpath` -d . RatingStdevReducer.java && 
javac -classpath `yarn classpath`:. -d . RatingStdev.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar RatingStdev $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME