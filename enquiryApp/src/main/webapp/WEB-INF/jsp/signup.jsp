<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enquiry Sign Up Page</title>
 <script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h2>Enquiry Sign Up Page With ReCaptch V3</h2>
<form action="">
<input type="text" name="uname"/> <br/>
<button class="g-recaptcha" 
        data-sitekey="6LfapjkaAAAAAF7X8bMTUbFnkxgmwc8Jb9aJYIXp" 
        data-callback='onSubmit' 
        data-action='submit'>Submit</button>
</form>
 <script>
   function onSubmit(token) {
     document.getElementById("demo-form").submit();
   }
 </script>
</body>
</html>