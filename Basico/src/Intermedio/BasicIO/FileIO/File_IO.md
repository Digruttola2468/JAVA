# PATH Class
The Path class is a programmatic representation of a path in the file system. 
A Path object contains the file name and directory list used to construct the path, and is used to examine, locate, and manipulate files.
A Path instance reflects the underlying platform.
A Path is not system independent. 
You cannot compare a Path from a Solaris file system and expect it to match a Path from a Windows file system, 
even if the directory structure is identical and both instances locate the same relative file.
The file or directory corresponding to the Path might not exist. 
You can create a Path instance and manipulate it in various ways: you can append to it, extract pieces of it, compare it to another path

# PathOperations
The Path class includes various methods that can be used to obtain information about the path,
access elements of the path, convert the path to other forms, or extract portions of a path. 
There are also methods for matching the path string and methods for removing redundancies in a path.

#### Retrieving Information about a Path
You can think of the Path as storing these name elements as a sequence.

# What Is a Glob?
You can use glob syntax to specify pattern-matching behavior.
A glob pattern is specified as a string and is matched against other strings, such as directory or file names. 

Glob syntax follows several simple rules:

- An asterisk, *, matches any number of characters (including none).
- Two asterisks, **, works like * but crosses directory boundaries. This syntax is generally used for matching complete paths.
- A question mark, ?, matches exactly one character.
- Braces specify a collection of subpatterns. For example:
  - {sun,moon,stars} matches "sun", "moon", or "stars".
  - {temp*,tmp*} matches all strings beginning with "temp" or "tmp".
- Square brackets convey a set of single characters or, when the hyphen character (-) is used, a range of characters. For example:
  - [aeiou] matches any lowercase vowel.
  - [0-9] matches any digit.
  - [A-Z] matches any uppercase letter.
  - [a-z,A-Z] matches any uppercase or lowercase letter.
Within the square brackets, *, ?, and \ match themselves.
- All other characters match themselves.
- To match *, ?, or the other special characters, you can escape them by using the backslash character, \. For example: \\ matches a single backslash, and \? matches the question mark.

Here are some examples of glob syntax:
- *.html – Matches all strings that end in .html
- ??? – Matches all strings with exactly three letters or digits
- *[0-9]* – Matches all strings containing a numeric value
- *.{htm,html,pdf} – Matches any string ending with .htm, .html or .pdf
- a?*.java – Matches any string beginning with a, followed by at least one letter or digit, and ending with .java
- {foo*,*[0-9]*} – Matches any string beginning with foo or any string containing a numeric value

Note: If you are typing the glob pattern at the keyboard and it contains one of the special characters, you must put the pattern in quotes ("*"), use the backslash (\*), or use whatever escape mechanism is supported at the command line.
The glob syntax is powerful and easy to use. However, if it is not sufficient for your needs, you can also use a regular expression.

Example Find.java