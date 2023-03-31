<%@page import="com.util.ConnectionUtil" import ="com.model.User" import ="java.sql.*" import ="java.util.*"  import ="com.service.registerService" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE RECORDS</title>
	<link rel="stylesheet" href="styles.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"  referrerpolicy="no-referrer" />
</head>
<body>
	<%User user = (User)session.getAttribute("user"); %>
	
<div class="form">
      
      
      
      <div class="tab-content">   
          <h1>Update Here</h1>
          
          <form id="form-details" action="updateServlet" method="post" onsubmit="submit()">
          
          <div class="top-row">
            <div class="field-wrap">
              <input type="hidden" name="id" value="<%= user.getId()%>">
              <input id="first-name" type="text" name="firstName" placeholder="first name" required autocomplete="off" value="<%=user.getFirstName()%>" />
            </div>
        
            <div class="field-wrap">
              <input id="last-name" type="text" name="lastName" placeholder="last name" required autocomplete="off" value="<%=user.getLastName()%>"/>
            </div>
          </div>

          <div class="field-wrap">
            <input id="email" type="email" name="email" placeholder="a@mail.com" required autocomplete="off" value="<%= user.getEmail() %>"/>
          </div>
          
          <div class="field-wrap">
            <input id="password" type="text" name="password" placeholder="password" required autocomplete="off" value="<%= user.getPassword() %>"/>
          </div>
          
          <button type="submit" class="button button-block"/>Update</button>
          
          </form>

        </div>
        
        
      
</div> <!-- /form -->

<script src="index.js"></script>

</body>
</html>