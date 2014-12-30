<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT type="text/javascript" language="javascript">
var request;
var url;
var responsetext;

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


function add(){
	var inputstr = document.getElementById("input").value;
	url = "http://localhost:8080/TrieApplication/RedirectirServlet?input=" + inputstr + "&param=add";
	request.open("post",url,false);
	request.send(null);
	document.getElementById("input").value = "";
}


function search(){
	var inputstr = document.getElementById("search").value;
	if(inputstr!=""){
	url = "http://localhost:8080/TrieApplication/RedirectirServlet?input=" + inputstr + "&param=search";
	request.open("post",url,false);
	request.onReadyStateChange = displaydata();
	request.send(null);
	}
}

function displaydata(){
	if(request.readyState==4){
		if(request.status==200){
			var responsetext = request.responseText;
			alert(responsetext);
			//responsetext.split(",");
		}
	}
}

function searchword(){
	var inputstr = document.getElementById("searchword").value;
	if(inputstr!=""){
	url = "http://localhost:8080/TrieApplication/RedirectirServlet?input=" + inputstr + "&param=searchword";
	request.open("post",url,false);
	request.onReadyStateChange = displayresult();
	request.send(null);
	}
}

function displayresult(){
	if(request.readyState==4){
		if(request.status==200){
			var responsetext = request.responseText;
			if(responsetext == true || responsetext == 1)
				alert("Word present in the Trie");
			else
				alert("Word not present in the Trie");
		}
	}
}

</SCRIPT>
<title>Insert title here</title>
</head>
<body>

<h2>Main Page</h2>
<h3>Enter Word</h3>
Enter the Word to be added : <input type="text" id="input">
<input type="button" id="button" value="Add To List" onclick="javascript:add()">
<br>

<h3>Search Word</h3>
Enter the word to searched : <input type="text" id="searchword">
<input type="button" id="button" value="Search Word" onclick="javascript:searchword()">
<br>
<h3>Search</h3>
Enter Word or a part of Word : <input type="text" onkeyup="javascript:search()" id="search">
<div id="displaydata">
</div>
</body>
</html>