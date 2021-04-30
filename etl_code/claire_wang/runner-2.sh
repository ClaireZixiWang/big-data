NETID=zw1511

HDFS_INPUT_PATH=hw/hw7/netflix_titles.csv
HDFS_OUTPUT_PATH=/user/$NETID/hw/hw7/output/p2

OUTPUT_FNAME=hw7-output-2.txt

javac -classpath `yarn classpath` -d . CleanMapper.java &&
javac -classpath `yarn classpath` -d . CleanReducer.java && 
javac -classpath `yarn classpath`:. -d . Clean.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar Clean $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME