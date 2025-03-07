package com.learning.spring_boot.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet", urlPatterns = "/health-check/*")
public class DemoServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestPathInfo = request.getPathInfo();
        if (requestPathInfo == null){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello From null requestPathInfo </h1>");
        }else if (requestPathInfo.equals("/firstendpoint")){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello From firstendpoint requestPathInfo </h1>");
        }else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello From unknow requestPathInfo </h1>");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response){
        // do something
    }
}
