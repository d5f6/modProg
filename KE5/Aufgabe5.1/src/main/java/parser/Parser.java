package parser;

import interfaces.AST;
import interfaces.InputStream;
import statements.BarStatement;
import statements.FooStatement;

public class Parser {
  private boolean success;

  public AST parse(InputStream stream) {
    String content = stream.read();

    if (content.startsWith("foo"))
      return parseFooStatement(content);
    else if (content.startsWith("bar"))
      return parseBarStatement(content);
    else
      return null;
  }

  private AST parseFooStatement(String content) {
    FooStatement fooStatement = new FooStatement();

    content = content.substring(3);

    // further processing of foo statement
    return fooStatement;
  }

  private AST parseBarStatement(String content) {
    BarStatement barStatement = new BarStatement();

    content = content.substring(3);

    // further processing of bar statement
    return barStatement;
  }
}
