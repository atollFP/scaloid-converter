# Scaloid Converter

This project aim to convert automatically an android scala project to [Scaloid](https://github.com/pocorall/scaloid/).

##Quickstart:

1. Create a folder "sc" in the parent folder of this directory.
2. Place the source code you want to convert inside a folder of the name of your choice (call it "x") inside "..\sc"
3. call "sbt" then "run x y" in this folder  where y is the folder inside "..\sc" that is the recursive copy of x with all scala files recursively converted to Scaloid.

```
git clone https://github.com/atollFP/scaloid-converter.git
cd scaloid/converter
mkdir ../sc
cp -r /<YOUR_PROJECT>/ ../sc/<X>
sbt
> run <X> <Y>
```

y is destroyed and regenerated each time.
The sc folder is a protection against misuse because the script can be dangerous (it's recursive !)

## Rules used for the conversion so far:

- add "import org.scaloid.common._"
- convert "Activity" to "SActivity"
- convert "protected void onCreate(...)" to "onCreate"
- convert "protected void onResume(...)" to "onResume"

## version

- scaloid-converter: 0.1
- sbt: 0.13
- Scala version: 2.11.5
