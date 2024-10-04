document.getElementById('bookingForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent default form submission

    const trainName = document.getElementById('trainName').value;
    const passengerName = document.getElementById('passengerName').value;
    const date = document.getElementById('date').value;

    // Create a JSON object to send to the servlet
    const bookingData = {
        trainName,
        passengerName,
        date
    };

    fetch('BookingServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bookingData)
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('responseMessage').innerText = data.message;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('responseMessage').innerText = 'Error booking ticket!';
    });
});
