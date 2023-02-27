package com.eddicorp.http;

import java.io.IOException;
import java.io.InputStream;

public class HttpRequest {
    private final String uri;
    private final String method;

    public String getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }

    public HttpRequest(InputStream inputStream) throws IOException {
        final String rawRequestLine = readLine(inputStream);
        final String[] partsOfRequestLine = rawRequestLine.split(" ");
        this.method = partsOfRequestLine[0];
        this.uri = partsOfRequestLine[1];
    }

    private static String readLine(InputStream inputStream) throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();
        int readCharacter;
        while ((readCharacter = inputStream.read()) != -1) {
            final char currentChar = (char) readCharacter;
            if (currentChar == '\r') {
                if (((char) inputStream.read()) == '\n') {
                    return stringBuilder.toString();
                } else {
                    throw new IllegalStateException("Invalid HTTP request.");
                }
            }
            stringBuilder.append(currentChar);
        }
        throw new IllegalStateException("Unable to find CRLF");
    }
}
