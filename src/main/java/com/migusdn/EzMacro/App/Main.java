package com.migusdn.EzMacro.App;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.migusdn.EzMacro.Protocol.NativeRequest;
import com.migusdn.EzMacro.Protocol.NativeResponse;



public class Main {
    public static void main(String[] args) throws Exception{
        Window win = new Window();
        win.run();
        // Read message
        for(;;) {
            String requestJson = readMessage(System.in);
//            gui.test(requestJson);
            ObjectMapper mapper = new ObjectMapper();
            NativeRequest request = mapper.readValue(requestJson, NativeRequest.class);
            win.test(requestJson);
            // Process request...
            NativeResponse response = new NativeResponse();
            response.setMessage("Hello, " + request.getMessage() + "!");

            // Send response message back
            String responseJson = mapper.writeValueAsString(response);
            sendMessage(responseJson);
        }

    }

    private static String readMessage(InputStream in) throws IOException {
        byte[] b = new byte[4];
        in.read(b); // Read the size of message

        int size = getInt(b);

        if (size == 0) {
            throw new InterruptedIOException("Blocked communication");
        }

        b = new byte[size];
        in.read(b);

        return new String(b, "UTF-8");
    }

    private static void sendMessage(String message) throws IOException {
        System.out.write(getBytes(message.length()));
        System.out.write(message.getBytes("UTF-8"));
        System.out.flush();
    }

    public static int getInt(byte[] bytes) {
        return (bytes[3] << 24) & 0xff000000 | (bytes[2] << 16) & 0x00ff0000 | (bytes[1] << 8) & 0x0000ff00
                | (bytes[0] << 0) & 0x000000ff;
    }

    public static byte[] getBytes(int length) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (length & 0xFF);
        bytes[1] = (byte) ((length >> 8) & 0xFF);
        bytes[2] = (byte) ((length >> 16) & 0xFF);
        bytes[3] = (byte) ((length >> 24) & 0xFF);
        return bytes;
    }
}

