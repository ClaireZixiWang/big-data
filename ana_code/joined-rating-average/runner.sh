NETID=sl5450

HDFS_INPUT_PATH=hw10/netflix_imdb_joined.csv
HDFS_OUTPUT_PATH=/user/$NETID/hw10/output/joined-ratings-average

OUTPUT_FNAME=output.txt

javac -classpath `yarn classpath` -d . JoinedRatingAverageMapper.java &&
javac -classpath `yarn classpath` -d . JoinedRatingAverageReducer.java && 
javac -classpath `yarn classpath`:. -d . JoinedRatingAverage.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar JoinedRatingAverage $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME