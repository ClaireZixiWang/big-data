NETID=sl5450

HDFS_INPUT_PATH=hw7/title.ratings.tsv
HDFS_OUTPUT_PATH=/user/$NETID/hw9/output/ratings-average

OUTPUT_FNAME=rating-average.txt

javac -classpath `yarn classpath` -d . RatingAverageMapper.java &&
javac -classpath `yarn classpath` -d . RatingAverageReducer.java && 
javac -classpath `yarn classpath`:. -d . RatingAverage.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar RatingAverage $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME