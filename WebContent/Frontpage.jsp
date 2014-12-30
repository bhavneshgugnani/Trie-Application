<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT type="text/javascript" language="javascript">
var request;

try {
	  request = new XMLHttpRequest();
	} catch (trymicrosoft) {
	  try {
	    request = new ActiveXObject("Msxml2.XMLHTTP");
	  } catch (othermicrosoft) {
	    try {
	      request = new ActiveXObject("Microsoft.XMLHTTP");
	    } catch (failed) {
	      request = false;
	    }  
	  }
	}


function call(){
	var tempstr = document.getElementById("input").value;
	alert(tempstr);
}

function search(){
	var tempstr = document.getElementById("search").value;
	alert(tempstr);
	
}
</SCRIPT>
<title>Insert title here</title>
</head>
<body>

<h1>Main Page</h1>
<br>
<h2>Enter Word</h2>
<br>
Enter the Word to be added : <input type="text" id="input">
<input type="button" id="button" value="Add To List" onclick="javascript:call()">
<br>
<br>
<h2>Search Word</h2>
<br>
Enter the word to searched : <input type="text" onkeyup="javascript:search()" id="search">

</body>
</html>