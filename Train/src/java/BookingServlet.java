import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response type
        response.setContentType("application/json");
        
        // Read JSON data from request
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Booking booking = gson.fromJson(reader, Booking.class);
        
        // Logic to process booking (e.g., save to database)
        // For simplicity, let's assume the booking is always successful
        
        String message = "Booking successful for " + booking.getPassengerName() + " on " + booking.getDate();
        
        // Create JSON response
        String jsonResponse = gson.toJson(new ResponseMessage(message));
        
        // Send response back to client
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
    
    // Inner class for booking data
    class Booking {
        private String trainName;
        private String passengerName;
        private String date;

        // Getters
        public String getTrainName() { return trainName; }
        public String getPassengerName() { return passengerName; }
        public String getDate() { return date; }
    }
    
    // Inner class for response message
    class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }
    }
}
