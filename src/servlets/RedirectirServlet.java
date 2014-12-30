package servlets;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import classes.Trie;
public class RedirectirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Trie trie = null;
    public RedirectirServlet() {
        super();
    }
    public void init(){
    	this.trie = new Trie();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String param = request.getParameter("param");
	String inputstring = request.getParameter("input");
	if(param.equalsIgnoreCase("add") && !(inputstring.equals(""))){
		trie.insert(inputstring);
		trie.view();
	}
	else if(param.equalsIgnoreCase("searchword")){
		boolean result = trie.searchword(inputstring);
		if(result == true)
			System.out.println("Word is present in Trie!!!");
		else
			System.out.println("Word is not present in Trie!!!");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}else if(param.equalsIgnoreCase("search")){
		StringBuilder result = trie.search(inputstring);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	}

}
