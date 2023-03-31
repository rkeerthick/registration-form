<%@ page import="com.util.ConnectionUtil" import="java.sql.*" import="com.service.registerService" import="java.util.*" import="com.model.User" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration Records</title>
 <link rel="stylesheet" href="table.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"  referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body>
	  <main>
        <div class="container">
          <h1 style="text-align: center">####Registered Records####</h1>
          <div class="table-display">
              <table class="table table-striped">
                <thead>
                  <tr>
                  	<th scope="col">ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Password</th>
                  </tr>
                </thead>
                <tbody>
                <%
                	Connection con = ConnectionUtil.getConnection();
                	registerService service = new registerService(con);
                	List<User> list = service.getUsers();
                	int i=1;
                	for(User u :list){
                		%>
                		<tr>
                		<th scope="row"><%= i++ %></td>
                        <td><%=u.getFirstName() %></td>
                        <td><%=u.getLastName() %></td>
                        <td><%=u.getEmail() %></td>
                        <td><%=u.getPassword() %></td>
                        <td><span style="display:flex;justify-content:space-between;">
                        	<form action="editServlet" method="post">
                       		<input type="hidden" name="id" value="<%=u.getId()%>">
                       		<input type="submit"  class="btn btn-primary" value="Edit">
                       		</form > 
                       		<form action="deleteServlet" method="post">
                       		<input type="hidden" name="id" value="<%=u.getId()%>">
                       		<input type="submit"  class="btn btn-danger" value="DELETE">
                       		</form>
                        </span> 
                       	</td>
                      </tr>
                		<%
                	}
                %>
                  
                </tbody>
              </table>
            </div>
            <a href="index.html"><button>Add New Records</button></a>
        </div>
    </main>
      <script src="index.js"></script>
</body>
</html>