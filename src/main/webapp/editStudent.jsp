<%@ page import="model.Student" %>
<html>
<head>
<title>Edit Student</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #f8f9fa;
    }
    .form-container {
        margin-top: 80px;
        padding: 40px;
        background: white;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }
    h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #007bff;
    }
</style>

</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 form-container">
            <h2>Edit Student</h2>
            
            <form action="updatestudent" method="post">
                <%
                    Student s = (Student) request.getAttribute("student");
                %>
                <input type="hidden" name="id" value="<%=s.getId()%>" />

                <div class="mb-3">
                    <label class="form-label">Name:</label>
                    <input type="text" name="name" class="form-control" value="<%=s.getName()%>" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="email" name="email" class="form-control" value="<%=s.getEmail()%>" required />
                </div>

                <div class="d-grid">
                    <input type="submit" value="Update Student" class="btn btn-success" />
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap 5 Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
