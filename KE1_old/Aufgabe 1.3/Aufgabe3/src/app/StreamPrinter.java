package app;

class StreamPrinter { 
  public static void printStream( Stream stream ) { 
    char ch = stream.readChar(); 

    while ( ch != 0 ) { 
      System.out.print( ch ); 
      ch = stream.readChar(); 
   } 
  } 
} 