NETID=zw1511

HDFS_INPUT_PATH=hw/hw9/netflix_titles.csv
HDFS_OUTPUT_PATH=/user/$NETID/hw/hw9/genre/output

OUTPUT_FNAME=hw9-output-genre.txt

javac -classpath `yarn classpath` -d . GenreCountMapper.java &&
javac -classpath `yarn classpath` -d . GenreCountReducer.java && 
javac -classpath `yarn classpath`:. -d . GenreCount.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar GenreCount $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME