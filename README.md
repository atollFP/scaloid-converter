# scaloid-converter

##Quickstart:

1. Create a folder "sc" in the parent folder of this directory.
2. Place the source code you want to convert inside a folder of the name of your choice (call it "x" inside "sc)
3. call "sbt run x y" where y is the folder inside sc that is the recursive copy of x with all scala files recursively converted.

y is destroyed and regenerated each time.

## Rules used for the conversion so far:

- add "import org.scaloid.common._"
- convert "Activity" to "SActivity"
- convert "protected void onCreate(...)" to "onCreate"
- convert "protected void onResume(...)" to "onResume"
