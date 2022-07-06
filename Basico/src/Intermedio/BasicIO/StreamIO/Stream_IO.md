# Byte Streams
Ejecutamos **entradas** y **salidas** de 8bit. Todas las clases del **byte Stream** son heredados de `InputStream` and `OuputStream`.

Para demostrar como los bytes trabaja en el Stream, Lo haremos enfocando en el File I/O , `FileInputStream` and `FileOutputStream`.

```java
public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
```
CopyBytes spends most of its time in a simple loop that reads the input stream and writes the output stream, one byte at a time, as shown in the following figure.

![One Byte at a time](https://docs.oracle.com/javase/tutorial/figures/essential/byteStream.gif)

#### Always Close Streams
Closing a stream when it's no longer needed is very important. This practice helps avoid serious resource leaks.

One possible error is that CopyBytes was unable to open one or both files. When that happens, the stream variable corresponding to the file never changes from its initial null value. That's why CopyBytes makes sure that each stream variable contains an object reference before invoking close.

#### When Not to Use Byte Streams
CopyBytes seems like a normal program, but it actually represents a kind of low-level I/O that you should avoid. Since archivo.txt contains character data, the best approach is to use character streams,
**So why talk about byte streams?** Because all other stream types are built on byte streams.


# Character Streams
The Java platform stores character values using Unicode conventions. Character stream I/O automatically translates this internal format to and from the local character set.

For most applications, I/O with character streams is no more complicated than I/O with byte streams. Input and output done with stream classes automatically translates to and from the local character set.

All character stream classes are descended from Reader and Writer. As with byte streams, there are character stream classes that specialize in file I/O: FileReader and FileWriter.
```Java
public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
```
CopyCharacters is very similar to CopyBytes. The most important difference is that CopyCharacters uses FileReader and FileWriter for input and output in place of FileInputStream and FileOutputStream. Notice that both CopyBytes and CopyCharacters use an int variable to read to and write from. However, in CopyCharacters, the int variable holds a character value in its last 16 bits; in CopyBytes, the int variable holds a byte value in its last 8 bits.

#### Character Streams that Use Byte Streams
Character streams are often "wrappers" for byte streams. The character stream uses the byte stream to perform the physical I/O, while the character stream handles translation between characters and bytes. FileReader, for example, uses FileInputStream, while FileWriter uses FileOutputStream.



## Line Oriented IO
Character I/O usually occurs in bigger units than single characters. One common unit is the line: a string of characters with a line terminator at the end. A line terminator can be a carriage-return/line-feed sequence ("\r\n"), a single carriage-return ("\r"), or a single line-feed ("\n").

Let's modify the CopyCharacters example to use line-oriented I/O. To do this, we have to use two classes we haven't seen before, BufferedReader and PrintWriter.
```java
public class CopyLines {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
```
Invoking readLine returns a line of text with the line. CopyLines outputs each line using println, which appends the line terminator for the current operating system.

# Buffered Streams
Most of the examples we've seen so far use unbuffered I/O. This can make a program much less efficient, since each such request often triggers disk access, network activity, or some other operation that is relatively expensive.

To reduce this kind of overhead, the Java platform implements buffered I/O streams. Buffered input streams read data from a memory area known as a buffer; the native input API is called only when the buffer is empty. Similarly, buffered output streams write data to a buffer, and the native output API is called only when the buffer is full.

There are four buffered stream classes used to wrap unbuffered streams: BufferedInputStream and BufferedOutputStream create buffered byte streams, while BufferedReader and BufferedWriter create buffered character streams.

# Scanning
Objects of type Scanner are useful for breaking down formatted input into tokens and translating individual tokens according to their data type.

a scanner uses white space to separate tokens. (White space characters include blanks, tabs, and line terminators. For the full list, refer to the documentation for Character.isWhitespace.)
```java
public class ScanXan {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
```
Even though a scanner is not a stream, you need to close it to indicate that you're done with its underlying stream.

### Translating Individual Tokens
The ScanXan example treats all input tokens as simple String values. Scanner also supports tokens for all of the Java language's primitive types (except for char), as well as BigInteger and BigDecimal. Also, numeric values can use thousands separators. Thus, in a US locale, Scanner correctly reads the string "32,767" as representing an integer value.

```java
public class ScanSum {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        } finally {
            s.close();
        }

        System.out.println(sum);
    }
}
```

# Data Stream
Data streams support binary I/O of primitive data type values (boolean, char, byte, short, int, long, float, and double) as well as String values
All data streams implement either the DataInput interface or the DataOutput interface. This section focuses on the most widely-used implementations of these interfaces, DataInputStream and DataOutputStream.
```java
public class DataStreams {
    static final String dataFile = "invoicedata";
 
    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = { "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain" };
 
    public static void main(String[] args) throws IOException {
 
  
        DataOutputStream out = null;
         
        try {
            out = new DataOutputStream(new
                    BufferedOutputStream(new FileOutputStream(dataFile)));
 
            for (int i = 0; i < prices.length; i ++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } finally {
            out.close();
        }
 
        DataInputStream in = null;
        double total = 0.0;
        try {
            in = new DataInputStream(new
                    BufferedInputStream(new FileInputStream(dataFile)));
 
            double price;
            int unit;
            String desc;
 
            try {
                while (true) {
                    price = in.readDouble();
                    unit = in.readInt();
                    desc = in.readUTF();
                    System.out.format("You ordered %d units of %s at $%.2f%n",
                            unit, desc, price);
                    total += unit * price;
                }
            } catch (EOFException e) { }
            System.out.format("For a TOTAL of: $%.2f%n", total);
        }
        finally {
            in.close();
        }
    }
}
```
The **writeUTF** method writes out String values in a modified form of UTF-8. 
This is a variable-width character encoding that only needs a single byte for common Western characters.
Notice that DataStreams detects an end-of-file condition by catching EOFException,
instead of testing for an invalid return value. All implementations of DataInput methods use EOFException instead of return values.
Also notice that each specialized write in DataStreams is exactly matched by the corresponding specialized read.
DataStreams uses one very bad programming technique: it uses floating point numbers to represent monetary values. 
In general, floating point is bad for precise values. It's particularly bad for decimal fractions, 
because common values (such as 0.1) do not have a binary representation.

# Object Streams
Just as data streams support I/O of primitive data types, object streams support I/O of objects. 
Most, but not all, standard classes support serialization of their objects. 
Those that do implement the marker interface Serializable.

The object stream classes are ObjectInputStream and ObjectOutputStream. 
These classes implement ObjectInput and ObjectOutput, which are subinterfaces of DataInput and DataOutput.
That means that all the primitive data I/O methods covered in Data Streams are also implemented in object streams. 
So an object stream can contain a mixture of primitive and object values.
If readObject() doesn't return the object type expected, attempting to cast it to the correct type may throw a ClassNotFoundException.
```java
public class ObjectStreams {
    static final String dataFile = "invoicedata";
 
    static final BigDecimal[] prices = { 
        new BigDecimal("19.99"), 
        new BigDecimal("9.99"),
        new BigDecimal("15.99"),
        new BigDecimal("3.99"),
        new BigDecimal("4.99") };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = { "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain" };
 
    public static void main(String[] args) 
        throws IOException, ClassNotFoundException {
 
  
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new
                    BufferedOutputStream(new FileOutputStream(dataFile)));
 
            out.writeObject(Calendar.getInstance());
            for (int i = 0; i < prices.length; i ++) {
                out.writeObject(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } finally {
            out.close();
        }
 
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new
                    BufferedInputStream(new FileInputStream(dataFile)));
 
            Calendar date = null;
            BigDecimal price;
            int unit;
            String desc;
            BigDecimal total = new BigDecimal(0);
 
            date = (Calendar) in.readObject();
 
            System.out.format ("On %tA, %<tB %<te, %<tY:%n", date);
 
            try {
                while (true) {
                    price = (BigDecimal) in.readObject();
                    unit = in.readInt();
                    desc = in.readUTF();
                    System.out.format("You ordered %d units of %s at $%.2f%n",
                            unit, desc, price);
                    total = total.add(price.multiply(new BigDecimal(unit)));
                }
            } catch (EOFException e) {}
            System.out.format("For a TOTAL of: $%.2f%n", total);
        } finally {
            in.close();
        }
    }
}
```
if a single object is written to two different streams, it is effectively duplicated — a single program reading both streams back will see two distinct objects.

Source: https://docs.oracle.com/javase/tutorial/essential/io/index.html