public class Stream implements InputStream, OutputStream {
    private String content = "";
    int index = 0;

    @Override
    public char readChar() {
        if (index < content.length()) {
            return content.charAt(index++);
        } else {
            return 0;
        }
    }

    @Override
    public void apply(Applicator app) {
        for (char ch: content.toCharArray()) {
            app.apply(ch);
        }
    }

    @Override
    public void writeStream(String str) {
        content += str;
    }
}
