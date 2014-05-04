uva
===

My solutions to ACM contest problems.

### I/O
Most of the problems have a list of integers as input, and Scanner is the simplest way to read them. However, some problems require reading millions of inputs very quickly, and faster methods like DataInputStream.readLine() (now deprecated) or BufferedReader.readLine() are required for staying under the time limit. Some of my solutions use DataInputStreams, I just haven't gone back and replaced those with BufferedReaders yet.

The fastest way I've found to do output is to keep everything in memory and dump it all to the console at the end using a BufferedOutputStream. I tend to do this even for problems which don't technically require it.

### DACU
"DACU" means accepted for distinct user and is a way of measuring problem difficulty on uHunt. I have mostly been solving the problems in order of DACU.

### Building
Submitted solutions must be in a public class called Main, in the default package. Rather than rename my classes, I just remove them from the build path. This means that only one solution folder can be on the build path at a time. Util can always be on the build path.
