<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<html>
<head>
<title>Student List</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #f8f9fa;
    }
    .container {
        margin-top: 50px;
    }
    .table thead {
        background-color: #007bff;
        color: white;
    }
    .btn-link {
        text-decoration: none;
    }
</style>

</head>
<body>

<div class="container">
    <h2 class="text-center mb-4">Student List</h2>

    <div class="mb-3 text-end">
        <a href="addStudent.jsp" class="btn btn-primary">Add New Student</a>
    </div>

    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Student> list = (List<Student>) request.getAttribute("students");
            if (list != null) {
                for (Student s : list) {
        %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getEmail()%></td>
                <td>
                    <a href="editstudent?id=<%=s.getId()%>" class="btn btn-sm btn-warning">Edit</a>
                    <a href="deletestudent?id=<%=s.getId()%>" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        <% 
                }
            }
        %>        
        </tbody>
    </table>
</div>

<!-- Bootstrap 5 JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
