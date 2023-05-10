<!-- userDetails.jsp -->
<html>
<head>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>User Details</h1>
        <table class="table mt-4">
            <tr>
                <th>ID</th>
                <td>${customer.customerId}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <th>Full Name</th>
                <td>${customer.fullName}</td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>${customer.phone}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${customer.address}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${customer.gender}</td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td>${customer.dob}</td>
            </tr>
            <!-- Add more table rows for other fields -->
        </table>

        <div class="mt-4">
            <a href="/raise-complaint" class="btn btn-primary">Raise Complaint</a>
            <a href="/logout" class="btn btn-danger">Logout</a>
        </div>
    </div>
</body>
</html>
