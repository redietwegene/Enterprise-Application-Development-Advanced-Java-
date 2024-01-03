<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Bank</title>
</head>
<body>
<%
  String subject = request.getParameter("subject");
%>

	<h1>Create  <%=subject %> Multiple Choice Question</h1>

<form action="createQuestion" method="post">
    <label for="question">Enter your question:</label>
    <input type="text" id="question" name="question" required>
    <br>

    <label for="optionA">
       A. <input type="text" name="optionA" required>
    </label><br>

    <label for="optionB">
       B. <input type="text" name="optionB" required>
    </label><br>

    <label for="optionC">
       C. <input type="text" name="optionC" required>
    </label><br>

    <label for="optionD">
        D. <input type="text" name="optionD" required>
    </label><br>
    <label for ="answer"> Enter the answer</label>
    <input type="text" id="answer" name="answer" required>
    

    <br>

    <input type="submit" value="create">
</form>

</body>
</html>