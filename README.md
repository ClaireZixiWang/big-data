# big-data

## Analytics

There are multiple sub-directories in teh `/ana_code` folder. Each subfolder contains a mapreduce job to generate a analytic.

Each mapreduce job has a companion `runner.sh` file. To run this, you must `cd` to the directory containing to a specific mapreduce job, e.g. `cd ana_code/rating-average`.

The output of each mapreduce job -- the analytic -- can be found in the `output.txt` file in each directory.

## Data cleaning

`/etl_code` contains two folders corresponding to each team member's contribution. 

### Mapreduce

Similar to analytics, each team member has written a mapreduce job for data-cleaning.

Each mapreduce job has a corresponding `runner.sh` file. You will need to `cd` to the mapreduce job's directory to run this script.

The `runner.sh` file contains a `OUTPUT_FNAME` variable, describing the cleaned data's file name.


### Hive

Hive was also used to clean and join datasets together. All the commands for hive are included in the file `etl_code/vic_li/hive-clean-join.txt`.

## Profiling

`/profiling_code` contains two folders corresponding to each team member's contribution.

A mapreduce job here may have multiple `runner-*.sh` files. This is because the same mapreduce profiling procedure can be applied to multiple input data files.

The `runner.sh` file contains a `OUTPUT_FNAME` variable, describing the cleaned data's file name.
