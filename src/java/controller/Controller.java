package controller;

import business.Person;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/display.jsp";
        String action = request.getParameter("action");
        if (action == null) action = "first";

        HttpSession session = request.getSession();
        LinkedHashMap<Integer, Person> linkMap =
                (LinkedHashMap<Integer, Person>) session.getAttribute("linkMap");

        if (linkMap == null) {
            linkMap = new LinkedHashMap<>();
            linkMap.put(731, new Person(731, "Pris", "", "Stratton",
                    LocalDate.of(2016, Month.FEBRUARY, 14),
                    LocalDate.of(2016, Month.FEBRUARY, 14)));
            linkMap.put(734, new Person(734, "Roy", "B", "Batty",
                    LocalDate.of(2016, Month.JANUARY, 8),
                    LocalDate.of(2016, Month.JANUARY, 9)));
        }

        session.setAttribute("linkMap", linkMap);
        request.setAttribute("linkMap", linkMap);

        String error = "";
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String employeeIDString = request.getParameter("employeeID");
        String birthDateString = request.getParameter("birthDate");
        String hireDateString = request.getParameter("hireDate");

        int employeeID = 0;
        LocalDate birthDate = null;
        LocalDate hireDate = null;

        switch (action) {
            case "first":
                break;
                
            case "add":

                if (firstName == null || firstName.equals("")) {
                    error += "Must enter first name.<br>";
                }

                if (lastName == null || lastName.equals("")) {
                    error += "Must enter last name.<br>";
                }          
                
                String addKeyString = request.getParameter("key");
                int addKey = 0;
                try {
                    addKey = Integer.parseInt(addKeyString);
                    if (addKey <= 0) error += "Key must be greater than zero.<br>";
                } catch (Exception e) {
                    error += "Must enter Key number.<br>";
                }

                try {
                    employeeID = Integer.parseInt(employeeIDString);
                    if (employeeID <= 0) error += "Employee ID must be greater than zero.<br>";
                } catch (Exception e) {
                    error += "Must enter Employee ID number.<br>";
                }

                try {
                    birthDate = LocalDate.parse(birthDateString);
                } catch (Exception e) {
                    error += "Must enter birth date.<br>";
                }

                try {
                    hireDate = LocalDate.parse(hireDateString);
                } catch (Exception e) {
                    error += "Must enter hire date.<br>";
                }

                if (error.isEmpty()) {
                    Person person = new Person(employeeID, firstName, middleName, lastName, birthDate, hireDate);
                    linkMap.put(addKey, person);
                }
                break;

            case "edit":
                String originalKeyString = request.getParameter("originalKey");
                if (originalKeyString != null && originalKeyString.isEmpty()) {
                }
                else {
                    int originalKey = Integer.parseInt(originalKeyString);
                    Person person = linkMap.get(originalKey);
                    request.setAttribute("person", person);
                    request.setAttribute("originalKey", originalKey);
                    url = "/Edit.jsp";
                }
                break;

    
      case "SaveChanges":
    String originalKeyString2 = request.getParameter("originalKey");

    if (originalKeyString2 != null && !originalKeyString2.isEmpty()) {
        int originalKey = Integer.parseInt(originalKeyString2);

  
        if (firstName == null || firstName.equals("")) {
            error += "Must enter first name.<br>";
        }

        if (lastName == null || lastName.equals("")) {
            error += "Must enter last name.<br>";
        }

        try {
            employeeID = Integer.parseInt(employeeIDString);
            if (employeeID <= 0)
                error += "Employee ID must be greater than zero.<br>";
        } catch (Exception e) {
            error += "Must enter Employee ID number.<br>";
        }

        try {
            birthDate = LocalDate.parse(birthDateString);
        } catch (Exception e) {
            error += "Must enter birth date.<br>";
        }

        try {
            hireDate = LocalDate.parse(hireDateString);
        } catch (Exception e) {
            error += "Must enter hire date.<br>";
        }

        if (error.isEmpty()) {
            Person person = new Person(employeeID, firstName, middleName, lastName, birthDate, hireDate);
            linkMap.put(originalKey, person);
        }

    } 

    break;





            case "delete":
                int deleteKey = Integer.parseInt(request.getParameter("key"));
                linkMap.remove(deleteKey);
                break;

            case "reset":
                linkMap = new LinkedHashMap<>();
                linkMap.put(731, new Person(731, "Pris", "", "Stratton",
                        LocalDate.of(2016, Month.FEBRUARY, 14),
                        LocalDate.of(2016, Month.FEBRUARY, 14)));
                linkMap.put(734, new Person(734, "Roy", "B", "Batty",
                        LocalDate.of(2016, Month.JANUARY, 8),
                        LocalDate.of(2016, Month.JANUARY, 9)));
                session.setAttribute("linkMap", linkMap);
                break;
        }

        request.setAttribute("error", error);
        request.setAttribute("linkMap", linkMap);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
