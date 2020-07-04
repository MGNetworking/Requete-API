package com.servlet;

import bean.OpenWeatherMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OpenWeatherMap coordonner= new OpenWeatherMap("","0","0");

        req.setAttribute("coordonner", coordonner);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ville = req.getParameter("ville");
        System.out.println("la ville : " + ville);
        String lon = req.getParameter("longitude-hidden");
        String lat = req.getParameter("latitude-hidden");

        OpenWeatherMap coordonner= new OpenWeatherMap(ville,lat,lon);

        System.out.println(coordonner.toString());

        req.setAttribute("cod", coordonner);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);

    }


}
