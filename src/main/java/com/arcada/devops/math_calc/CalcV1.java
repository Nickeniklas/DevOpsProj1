package com.arcada.devops.math_calc;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

/**
 * HTTP VERSION HAS HAD ALOT OF HELP FROM CHATGPT!!!
 */
public class CalcV1 {
	public static void main(String[] args) {
		// Create an HTTP server on port 8080
        HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(8080), 0);
			
			  
	        // Define a context that listens at the root URL ("/")
	        server.createContext("/", new CalcHandler());
	        
	        // Set a default executor
	        server.setExecutor(null);
	        
	        // Start the server
	        System.out.println("Server started at http://localhost:8080");
	        server.start();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    }

    // Define a handler to process requests and send responses
	static class CalcHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                // Serve HTML form to get input from the user
                String form = """
                    <html>
                    <body>
                        <h1>Calculator</h1>
                        <form method="POST">
                            <label>First Number:</label>
                            <input type="text" name="userN1"><br><br>
                            <label>Second Number:</label>
                            <input type="text" name="userN2"><br><br>
                            <label>Operation:</label>
                            <select name="operation">
                                <option value="1">Addition</option>
                                <option value="2">Subtraction</option>
                                <option value="3">Multiplication</option>
                                <option value="4">Division</option>
                            </select><br><br>
                            <input type="submit" value="Calculate">
                        </form>
                    </body>
                    </html>
                """;

                // Set HTTP response headers and status code
                exchange.sendResponseHeaders(200, form.getBytes().length);
                
                // Write the response body
                OutputStream os = exchange.getResponseBody();
                os.write(form.getBytes());
                os.close();
                
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Read form data
                InputStream is = exchange.getRequestBody();
                String formData = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                Map<String, String> params = parseFormData(formData);
                
                int userN1 = Integer.parseInt(params.get("userN1"));
                int userN2 = Integer.parseInt(params.get("userN2"));
                int operation = Integer.parseInt(params.get("operation"));
                
                // Perform calculation based on user choice
                String result;
                switch (operation) {
                    case 1 -> result = "Result: " + (userN1 + userN2);
                    case 2 -> result = "Result: " + (userN1 - userN2);
                    case 3 -> result = "Result: " + (userN1 * userN2);
                    case 4 -> result = userN2 != 0 ? "Result: " + (userN1 / userN2) : "Cannot divide by zero";
                    default -> result = "Invalid operation";
                }
                
                // Display result back to the user
                String response = "<html><body><h1>" + result + "</h1><a href='/'>Go back</a></body></html>";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }	
        
     	// Helper method to parse form data from "key=value" pairs
        private Map<String, String> parseFormData(String formData) {
            Map<String, String> params = new HashMap<>();
            for (String pair : formData.split("&")) {
                String[] keyValue = pair.split("=");
                params.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
            }
            return params;
        }
        
	}
}
