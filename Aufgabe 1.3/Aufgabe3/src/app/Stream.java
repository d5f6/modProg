package app;

class Stream {
  private String content = "";
  int index = 0;
 
  public char readChar() {
    if ( index < content.length() )
     return content.charAt( index++ );
    else
     return 0;
  }

  public void writeString( String str ) {
    content += str;
  }
}
  