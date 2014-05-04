uva
===

My solutions to ACM contest problems. This is not the only repository of such solutions, nor is it most complete. I'm doing these for myself. However, I've tried to keep the code organized and well-documented.

### I/O
Most of the problems have a list of integers as input, and Scanner is the simplest way to read them. However, some problems require reading millions of inputs very quickly, and in those cases faster methods like DataInputStream.readLine() (deprecated) or BufferedReader.readLine() are required for staying under the time limit. Some of my solutions use DataInputStreams, and I haven't bothered to update those to BufferedReaders, but I expect the performance to be similar.

If there's an even faster way that's also reasonably simple, I'd love to hear it. My brief experiments with "slurping" the input didn't outperform processing it line by line.

AFAIK the fastest way to do output is to keep it in memory until the end and then dump it to the console at once using a BufferedOutputStream. I tend to do this even for problems which don't technically require it.

### Code Quality
In all cases I've tried to keep methods compact, obvious, and well-documented. However, these are not intended to be exercises in software engineering. For instance, I've kept a pretty high tolerance for global state -- for most of these problems the only data structure is an array or two, so making extra references to it would at best be busywork and at worst obscure the solution. However, I've been more disciplined (by introducing new classes and occasionally unit tests) where I thought it was warranted.

Often the problems allow you to make simplifying assumptions about the input, and I implicitly assume these as they're already stated in the problem description. Special assumptions I've tended to assert explicitly (as opposed to guarding against violations).

### DACU
"DACU" means accepted for distinct user and is a way of measuring problem difficulty on uHunt. I have mostly been solving the problems in order of DACU.

### Building
Submitted solutions must be in a public class called Main, in the default package. Rather than rename my classes, I just remove them from the build path. This means that only one solution folder can be on the build path at a time. Util can always be on the build path.

### Misc
"The Blocks Problem" and maybe one or two others, used a stack implementation which was not generic and which I later removed in favor of a generic one as later problems called for stacks of things other than ints.
