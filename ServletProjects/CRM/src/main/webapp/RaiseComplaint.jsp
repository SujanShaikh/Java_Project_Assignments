<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Unenroll Facilities</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Unenroll Facilities</h1>
        <form action="UnenrollFacilitiesServ" method="post">
            <table class="table table-striped mt-4">
                <thead>
                    <tr>
                        <th>Facility ID</th>
                        <th>Facility Name</th>
                        <th>Status</th>
                        <th>Unenroll</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Facility facility : facilities) { %>
                        <tr>
                            <td><%= facility.getFacilityId() %></td>
                            <td><%= facility.getFacilityName() %></td>
                            <td><%= facility.getStatus() %></td>
                            <td><input type="checkbox" name="unenrollFacilities" value="<%= facility.getFacilityId() %>"></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
            <input type="submit" value="Unenroll Selected Facilities" class="btn btn-primary">
        </form>

        <!-- Display the complaint form below the facility list -->
        <h2 class="mt-4">Complaint Form</h2>
        <form action="SubmitComplaintServ" method="post">
            <div class="form-group">
                <label for="complaintSelect">Complaint:</label>
                <select id="complaintSelect" name="complaint" class="form-control">
                    <option value="Facility is not well-maintained">Facility is not well-maintained</option>
                    <option value="Facility is unavailable when needed">Facility is unavailable when needed</option>
                    <option value="Facility is not clean">Facility is not clean</option>
                    <option value="Facility has safety concerns">Facility has safety concerns</option>
                    <option value="Facility is not meeting my needs">Facility is not meeting my needs</option>
                </select>
            </div>
            <input type="submit" value="Submit Complaint" class="btn btn-primary">
        </form>
    </div>

    <!-- Include Bootstrap and jQuery JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
