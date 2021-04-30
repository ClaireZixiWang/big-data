NETID=zw1511

HDFS_INPUT_PATH=hw/hw9/netflix_titles.csv
HDFS_OUTPUT_PATH=/user/$NETID/hw/hw9/country/output

OUTPUT_FNAME=hw9-output-country.txt

javac -classpath `yarn classpath` -d . CountCountryMapper.java &&
javac -classpath `yarn classpath` -d . CountCountryReducer.java && 
javac -classpath `yarn classpath`:. -d . CountCountry.java &&
jar -cvf hadoopJob.jar *.class &&

hadoop jar hadoopJob.jar CountCountry $HDFS_INPUT_PATH $HDFS_OUTPUT_PATH

hdfs dfs -getmerge $HDFS_OUTPUT_PATH $OUTPUT_FNAME