uva
===

My solutions to ACM contest problems. I competed in my area's ACM regionals twice while I was an undergrad. I'd like to spend some time getting better at these problems since I think they're pretty fun.

This is not the only repository of such solutions, nor is it the most complete. I'm doing these for myself. However, I've tried to keep the code organized and well-documented. If you are looking for a solution to a problem you haven't solved yet, I would advise you to look [here](http://uvatoolkit.com/problemssolve.php) or in the Online Judge forums first for a strategy hint rather than a full solution.

Often a larger input/output set is enough. In my opinion the problems which force one to guess what to do with edge cases, or purposely introduce red herrings, are perhaps good puzzles but not good *programming challenges*. (Sure, the real world is full of ambiguity that engineers must deal with, but by their nature those cases lack a specific set of outputs that one must conform to.)

### I/O
Most of the problems have a list of integers as input, and in Java, Scanner is the simplest way to read them. However, some problems require reading millions of inputs very quickly, and in those cases faster methods like DataInputStream.readLine() (deprecated) or BufferedReader.readLine() are required for staying under the time limit. Some of my solutions use DataInputStreams, and I haven't bothered to update those to BufferedReaders, but I expect the performance to be similar.

If there's an even faster way that's also reasonably simple, I'd love to hear it. My brief experiments with "slurping" the input didn't outperform processing it line by line.

I'd also love to know how people are solving problems in 0 seconds -- metaprogramming perhaps?

AFAIK the fastest way to do output is to keep it in memory until the end and then dump it to the console at once using a BufferedOutputStream. I tend to do this even for problems which don't technically require it.

### Code Quality
In all cases I've tried to keep methods compact, obvious, and well-documented. However, these are not intended to be exercises in software engineering. For instance, I've kept a pretty high tolerance for global state -- for most of these problems the only data structure is an array or two, so making extra references to it would at best be busywork and at worst obscure the solution. However, I've been more disciplined (by introducing new classes and occasionally unit tests) where I thought it was warranted.

Often the problems allow you to make simplifying assumptions about the input, and I implicitly assume these as they're already stated in the problem description. Special assumptions I've tended to assert explicitly (as opposed to guarding against violations).

On earlier solutions (actually my first 50 or so) I made the mistaken assumption that util.Arrays and the Containers were not allowed -- I don't know why I thought this. All of the problems in that difficulty class can be done with arrays and insertion sort, but the code would likely have been more elegant with some nice data structures to hide things behind.

### DACU
"DACU" is a measure of problem difficulty used on [uHunt](http://uhunt.felix-halim.net). It is the number of distinct users with an accepted solution for a particular problem. I have mostly been solving the problems in order of DACU. Thus far they've mostly been "ad hoc" problems, with a couple featuring very simple examples of graph searching, state machines, or general recursion skills.

### Building
Java solutions submitted to UVa Online Judge must be in a public class called Main, and in the default package. Rather than rename my classes, I just remove them from the build path. This means that only one solution folder can be on the build path at a time. Util can always be on the build path.

### Misc
My solution to *The Blocks Problem* (and possibly one other) used a stack implementation that wasn't generic and which I later ripped out in favor of a generic one. Building it requires recreating that int-stack.
